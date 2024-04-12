/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.thread;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Agent;
import domain.Klijent;
import domain.Menadzer;
import domain.StatistikaAgenata;
import domain.TipKlijenta;
import domain.Ugovor;
import domain.UpdateAgent;
import domain.UpdateKlijent;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import logic.Controller;
import server.Server;
/**
 *
 * @author Korisnik
 */
public class ClientThread extends Thread{
    
    //1 nit = 1 klijent. Za svakog klijenta, treba mi:
    //1. Socket, 2. Sender, 3. Receiver, Menadzer na kojeg se odnosi
    //
    private Socket socket;
    private Sender sender;
    private Receiver receiver;
    private Controller controller;
    private Server server;
    private Menadzer menadzer;
    private boolean kraj = false;

    public ClientThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        this.sender = new Sender(socket);
        this.receiver = new Receiver(socket);
        this.controller = new Controller();
    }

    @Override
    public void run() {
        while(kraj == false && !isInterrupted()){
            
            try{
            Request request =(Request) receiver.receive(); //metoda koja osluskuje port otvoren za primanje zahteva od klijenta
            Response response = new Response();
            
            
            try{
                switch(request.getOperation()){
                    case PRIJAVA_MENADZERA_NA_SISTEM:
                        Menadzer menadzer = (Menadzer)request.getArgument(); // ovo je novi Menadzer 
                        if(!server.isLoggedMenadzer(menadzer)){ //ako nije ulogovan, uloguj ga
                            Menadzer menadzerNew = controller.login(menadzer);
                            response.setResult(menadzerNew);
                            this.menadzer = menadzerNew;
                            System.out.println("Setovan je menadzer na klijentsku nit. ");
                            
                        }else{
                            throw new Exception("User je uveliko ulogovan.");
                        }
                        break;
                    case KREIRAJ_AGENTA:
                        boolean signalNoviAgent = controller.createAgent((Agent)request.getArgument());
                        response.setResult(signalNoviAgent);
                        break;
                    case KREIRAJ_KLIJENTA:
                        Klijent k = (Klijent)request.getArgument();
                        boolean signalNoviKlijent = controller.createKlijent(k);
                        response.setResult(signalNoviKlijent);
                        break;
                    case GET_ALL_TIP_KLIJENTA:
                        List<TipKlijenta> tipoviKlijenata = controller.popuniCbTipKlijenta();
                        response.setResult(tipoviKlijenata);
                        break;
                    case GET_ALL_KLIJENTI:
                        List<Klijent> klijenti = controller.getKlijenti(String.valueOf(request.getArgument()));
                        response.setResult(klijenti);
                        break;
                    case KREIRAJ_TIP_KLIJENTA:
                        boolean signal = controller.createTipKlijenta((TipKlijenta)request.getArgument());
                        response.setResult(signal);
                        break;
                    case IZMENI_KLIJENTA:
                        UpdateKlijent updKlijent = (UpdateKlijent)request.getArgument();
                        boolean signalUpdKlijent = controller.updateKlijent(updKlijent);
                        response.setResult(signalUpdKlijent);
                        break;
                    case IZMENI_AGENTA:
                        UpdateAgent updAgent = (UpdateAgent) request.getArgument();
                        boolean signalUpdAgent = controller.updateAgent(updAgent);
                        response.setResult(signalUpdAgent);
                        break;
                    case PRETRAZI_AGENTA:
                        List<Agent> agenti = controller.pretraziAgente(String.valueOf(request.getArgument()));
                        response.setResult(agenti);
                        break;
                    case OBRISI_AGENTA:
                        boolean signalObrisi = controller.deleteAgent((Agent)request.getArgument());
                        response.setResult(signalObrisi);
                        break;
                    case GET_ALL_AGENTI:
                        List<Agent> agentiAll = controller.getAllAgenti(request.getArgument());
                        response.setResult(agentiAll);
                        break;
                    case GET_ALL_UGOVORI:
                        //System.out.println("SERVER JE PRIMIO ZAHTEV ZA SVIM UGOVORIMA");
                        List<Ugovor> ugovori = controller.getAllUgovori(request.getArgument());
                        response.setResult(ugovori);
                        break;
                    case KREIRAJ_ANGAZOVANJE:
                        boolean signalKreirajAngazovanje = controller.createAngazovanje(request.getArgument());
                        response.setResult(signalKreirajAngazovanje);
                        break;
                    case STATISTIKA_AGENATA:
                        List<StatistikaAgenata> agentiStat = controller.statistikaAgenata();
                        response.setResult(agentiStat);
                        break;
                    case LOG_OUT:
                        Menadzer logOutMenadzer = (Menadzer)request.getArgument();
                        boolean signalLogOut = server.removeFromListOfClients(logOutMenadzer);
                        response.setResult(signalLogOut);
                        break;
                        
                }
            }catch(Exception e){
                e.printStackTrace();
                response.setException(e); // ukoliko nastaje exception, njega setujemo na response i saljemo
            }
            sender.send(response);
            
            } catch(Exception ex){
                ex.printStackTrace(); // za receiver.receive() ukoliko dodje do Exception-as
            }
            
        
        
        } 
     
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }
    
    public void stopClientThread(){
        interrupt();
        this.kraj = true;
        System.out.println("Klijentska nit je prekinuta!");
    }
    
}   