/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import forms.ServerForm;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import server.Server;
/**
 *
 * @author Korisnik
 */
public class Main {
    public static void main(String[] args) {
        //Server server = new Server();
        //server.startServer();
        JDialog dialog = new JDialog((JFrame)null, "Serverska forma", true); //na dijalog dodacu panel
        JPanel panel = new ServerForm();
        dialog.add(panel); // dodajem panel na dijalog
        dialog.pack(); //napakovati panel na dijalog 
        dialog.setLocationRelativeTo(null); // bice na sredini
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dialog.setVisible(true);
        
    }
}
