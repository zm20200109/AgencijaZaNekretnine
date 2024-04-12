/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;



import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import ui.forms.FrmLogIn;

/**
 *
 * @author Korisnik
 */
public class Main {
  
     public static void main(String[] args) {
          JDialog dialog = new JDialog((JFrame)null, "Login", true); //na dijalog dodacu panel
          JPanel panel = new FrmLogIn();
          dialog.add(panel); // dodajem panel na dijalog
          dialog.pack(); //napakovati panel na dijalog 
          dialog.setLocationRelativeTo(null); // bice na sredini
          dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
          dialog.setVisible(true);
     }
   
     
    
}
