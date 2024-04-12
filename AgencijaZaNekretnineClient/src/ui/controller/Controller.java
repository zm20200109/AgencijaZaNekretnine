/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.controller;
import communication.Operation;
import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Agent;
import domain.Angazovanje;
import domain.Klijent;
import domain.Menadzer;
import domain.TipKlijenta;
import domain.Ugovor;
import domain.UpdateAgent;
import domain.UpdateKlijent;
import java.net.Socket;
import java.util.List;
import ui.forms.StatistikaAgenata;
/**
 *
 * @author Korisnik
 */
public class Controller {
    
    Socket socket;
    Sender sender; // za port sa kog saljemo poruke
    Receiver receiver; // za port sa kojeg primamo poruke
    private static Controller instance;
    
    private Controller() throws Exception{
        socket = new Socket("127.0.0.1", 9000); //saljem zahtev lokalhostu na portu 9000
        sender = new Sender(socket); // saljem senderu soket za slanje
        receiver = new Receiver(socket); // saljem receiveru soket za primanje
        
    }
   
    
    public static Controller getInstance()throws Exception{
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
    public Menadzer login(Menadzer menadzer) throws Exception{
        Request request = new Request(Operation.PRIJAVA_MENADZERA_NA_SISTEM, menadzer);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
            return (Menadzer)response.getResult();
        }else{
            throw response.getException();
        }
    
    }
    
    public boolean createAgent(Agent agent) throws Exception{
        Request request = new Request(Operation.KREIRAJ_AGENTA, agent);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return (boolean)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    
    public List<Agent> getAgenti(String name) throws Exception{
        Request request = new Request(Operation.PRETRAZI_AGENTA, name);
        sender.send(request);
        Response response = (Response) receiver.receive(); // zato sto vraca object
        if(response.getException() == null){
            return (List<Agent>)response.getResult(); //LISTA agenata koji imaju trazeno ime
        }else{
            throw response.getException();
        }
    }
    
    public boolean deleteAgent(Agent agent) throws Exception{
        Request request = new Request(Operation.OBRISI_AGENTA, agent);
        sender.send(request);
        Response response = (Response)receiver.receive(); // jer on vraca Object
        if(response.getException() == null){
            return ((Boolean)response.getResult()).booleanValue();
        }else{
            throw response.getException();
        }
    }
    
    public boolean updateAgent(UpdateAgent agent) throws Exception{
        Request request = new Request(Operation.IZMENI_AGENTA, agent);
        sender.send(request);
        Response response = (Response)receiver.receive(); // jer on vraca Object
        if(response.getException() == null){
            return (boolean)response.getResult();
        }else{
            throw response.getException();
        }
    }
    
    public List<TipKlijenta> getAllTipKlijenta() throws Exception{
        Request request = new Request(Operation.GET_ALL_TIP_KLIJENTA, null);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return (List<TipKlijenta>)response.getResult();
        }else{
            throw response.getException();
        }
    } 

    public boolean createKlijent(Klijent klijent) throws Exception{
        Request request = new Request(Operation.KREIRAJ_KLIJENTA, klijent);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){ //greska jeste null
            //System.out.println(response.getResult()+"");
            return ((Boolean)response.getResult()).booleanValue();
        }else{
            throw response.getException();
        }
    
    
    
    }

    public List<Klijent> getKlijenti(String imeKlijenta) throws Exception{
        Request request = new Request(Operation.GET_ALL_KLIJENTI, imeKlijenta);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return (List<Klijent>)response.getResult();
        }else{
            throw response.getException();
        }
    
        
    }

    public boolean updateKlijent(UpdateKlijent uKlijent) throws Exception{
        Request request = new Request(Operation.IZMENI_KLIJENTA, uKlijent);
        sender.send(request);
        Response response = (Response)receiver.receive(); // jer on vraca Object
        if(response.getException() == null){
            return (boolean)response.getResult();
        }else{
            throw response.getException();
        }
    
    
    
    }

    public boolean createTipKlijenta(TipKlijenta tipKl) throws Exception{
        Request request = new Request(Operation.KREIRAJ_TIP_KLIJENTA, tipKl);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return ((Boolean)response.getResult()).booleanValue();
        }else{
            throw response.getException();
        }
    }

    public List<Agent> getAllAgenti() throws Exception {
        Request request = new Request(Operation.GET_ALL_AGENTI,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
            return (List<Agent>) response.getResult();
        }else{
            throw new Exception();
        }
    }

    public List<Ugovor> getAllUgovori() throws Exception {
        System.out.println("Klijent je usao u get all ugovori u controlleru");
        Request request = new Request(Operation.GET_ALL_UGOVORI,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
            return (List<Ugovor>) response.getResult();
        }else{
            throw new Exception();
        }
    }

    public boolean createAngazovanje(Angazovanje angažovanje) throws Exception {
        //System.out.println("Klijent je usao u get all ugovori u controlleru");
        Request request = new Request(Operation.KREIRAJ_ANGAZOVANJE,angažovanje);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
            return ((Boolean) response.getResult()).booleanValue();
        }else{
            throw new Exception();
        }
    
    }

    public List<domain.StatistikaAgenata> getStatistikaAgenata() throws Exception {
        Request request = new Request(Operation.STATISTIKA_AGENATA,null);
        sender.send(request);
        Response response = (Response) receiver.receive();
        if(response.getException() == null){
            return (List<domain.StatistikaAgenata>)response.getResult();
        }else{
            throw new Exception();
        }
    
    
    }
    
    public boolean logOutMenadzer(Menadzer menadzer) throws Exception {
        Request request = new Request(Operation.LOG_OUT, menadzer);
        sender.send(request);
        Response response = (Response)receiver.receive();
        if(response.getException() == null){
            return ((Boolean)response.getResult()).booleanValue();
        }else{
            throw new Exception();
        }
    }
    
    
}
