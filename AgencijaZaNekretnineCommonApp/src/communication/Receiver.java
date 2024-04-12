/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class Receiver implements Serializable{
    
    private Socket socket;

    public Receiver(Socket socket) {
        this.socket = socket; // soket preko kog on prima neku poruku, objekat
    }
    
    
    public Object receive() throws Exception{
        ObjectInputStream ois; 
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            return ois.readObject();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Nastala je greška prilikom primanja objekta!\n"+ex.getMessage());
        }
       // ovde ne mora da postoji return statement zato sto smo u catch bloku bacili exception koji omogucujue zavrsetak metode
    }
    
    
    
    
    
}
