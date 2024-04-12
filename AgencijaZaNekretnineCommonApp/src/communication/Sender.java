/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package communication;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Korisnik
 */
public class Sender implements Serializable {
    
    private Socket socket; // Socket sa kojeg se salje poruka nekom drugome

    public Sender(Socket socket) {
        this.socket = socket;
    }
    
    
    public void send(Object object)throws Exception{
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(object);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new Exception("Nastala je greška prilikom slanja objekta!\n"+ex.getMessage());
        }
        
    }
    
    
    
}
