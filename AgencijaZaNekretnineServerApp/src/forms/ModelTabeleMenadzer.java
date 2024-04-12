/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forms;

import domain.Menadzer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import server.thread.ClientThread;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleMenadzer extends AbstractTableModel{
    List<ClientThread> clientThreads=new ArrayList<>();
    String[] kolone = {"Korisničko ime", "Lozinka", "Ime menadžera", "Prezime menadžera"};
    
    public ModelTabeleMenadzer(List<ClientThread> lista) {
        clientThreads = lista;
        
    }
    
    
    
    @Override
    public int getRowCount() {
        return clientThreads.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Menadzer menadzer = clientThreads.get(rowIndex).getMenadzer();
        if(menadzer!=null){
            switch(columnIndex){
                case 0:
                    return menadzer.getKorisnickoIme();
                case 1:
                    return menadzer.getLozinka();
                case 2:
                    return menadzer.getImeMenadzera();
                case 3:
                    return menadzer.getPrezimeMenadzera();
                default:
                    return "N/A";
            }
        }else{
            return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
     
    
}
