/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import communication.Receiver;
import communication.Request;
import communication.Response;
import communication.Sender;
import domain.Agent;
import domain.Klijent;
import domain.Menadzer;
import domain.TipKlijenta;
import domain.UpdateAgent;
import domain.UpdateKlijent;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Controller;
import server.thread.ClientThread;

/**
 *
 * @author Korisnik
 */
public class Server extends Thread{
  
    
    //private Controller controller;

    List<ClientThread> clientThreads=new ArrayList<>();
    boolean kraj = false;
    
    
    public Server(){
        //this.controller = Controller.getInstance();
        //clientThreads = new ArrayList<>();
        System.out.println("Lista klijenata je sada instancirana i prazna.");
     
        
    }

    @Override
    public void run() {
      
        startServer();
    }
    
    
    
    
    
    public void startServer(){ 
        
        try {
            ServerSocket serverSocket = new ServerSocket(9000); // otvaranje serverskog soketa za osluskivanje zahteva na porutu 9000
            
            while(!isInterrupted() && kraj == false){
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept(); // blokirajuca metoda - kod se ne nastavlja dok ne dodje do ovde
                System.out.println("Connected!");
            
            
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                clientThreads.add(clientThread);
                System.out.println("Klijent zeli da se poveze sa serverom i dodaje se klijent u listu niti vezanu za tog klijenta. Ja sam ovde dodao nit za klijenta. Ovde je nepoznato koji je menadzer povezan za ovu nit.");
                
                //ovde vise nema while petlje sa obradom zahteva
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public boolean isLoggedMenadzer(Menadzer menadzer){
        for(ClientThread client: clientThreads){
           
            if(client.getMenadzer()!=null){
                if(menadzer.getKorisnickoIme().equals(client.getMenadzer().getKorisnickoIme()) 
                       && menadzer.getLozinka().equals(client.getMenadzer().getLozinka())){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean removeFromListOfClients(Menadzer menadzer){
        for(ClientThread client: clientThreads){
            if(menadzer.getKorisnickoIme().equals(client.getMenadzer().getKorisnickoIme()) 
                       && menadzer.getLozinka().equals(client.getMenadzer().getLozinka())){
                System.out.println("MENADZER JE U LISTI I SAD CEMO GA IZBRISATI");
                clientThreads.remove(client);
                return true;
            }
        }
        System.out.println("MENADZER NIJE BIO U LISTI");
        return false;
    }
    
    public void stopServer(){
        interrupt();
        kraj = true;
        System.out.println("Nit je prekinuta.");
    }

    public void stopServerThread(){
        for(ClientThread client: clientThreads){
            client.stopClientThread();
        }
        stopServer();
        clientThreads.removeAll(clientThreads);
        System.out.println("Serverska nit je prekinuta!");
    }

    public List<ClientThread> getClientThreads() {
        return clientThreads;
    }
    
    
    
}
