/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.forms.tables;

import domain.Klijent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleKlijent extends AbstractTableModel{
    List<Klijent> klijenti = new ArrayList<>();
    String[] kolone = {"JMBG klijenta", "Ime klijenta", "Prezime klijenta", "Tip klijenta"};

    public ModelTabeleKlijent(List<Klijent> klijenti) {
        this.klijenti = klijenti;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return klijenti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Klijent klijent = klijenti.get(rowIndex);
        switch(columnIndex){
            case 0:
                return klijent.getJmbgKlijenta();
            case 1:
                return klijent.getImeKlijenta();
            case 2:
                return klijent.getPrezimeKlijenta();
            case 3:
                return klijent.getTipKlijenta().getNazivTipa();
            default:
                return "N/A";
        
        }
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    public List<Klijent> getKlijenti() {
        return klijenti;
    }
    
    
    
    
    
    
    
}
