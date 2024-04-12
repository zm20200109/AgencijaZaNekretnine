/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server.thread;

import forms.ModelTabeleMenadzer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import server.Server;

/**
 *
 * @author Korisnik
 */
public class MenadzeriThread extends Thread{

    List<ClientThread> klijenti = new ArrayList<>();
    JTable tabelaForme;
    Server server;
    
    public MenadzeriThread(JTable tabela, Server server) {
        tabelaForme = tabela;
        this.server = server;
    }

    
    
    @Override
    public void run() {
        while(true){
            try {
                sleep(3000);
                klijenti = server.getClientThreads();
                ModelTabeleMenadzer mtm = new ModelTabeleMenadzer(klijenti);
                tabelaForme.setModel(mtm);
            } catch (InterruptedException ex) {
                Logger.getLogger(MenadzeriThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }
    
    
    
}
