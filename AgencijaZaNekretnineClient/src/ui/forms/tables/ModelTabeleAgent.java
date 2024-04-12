/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.forms.tables;

import domain.Agent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleAgent extends AbstractTableModel{
    
    
    List<Agent> agenti = new ArrayList<>();
    String[] kolone = {"Redni broj u registru posrednika", "Ime agenta", "Prezime agenta", "Adresa agenta", "Uspešnost realizacije", "Broj dodeljenih klijenata"};

    public ModelTabeleAgent(List<Agent> agenti) {
        this.agenti = agenti;
    }

    public List<Agent> getAgenti() {
        return agenti;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return agenti.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Agent a = agenti.get(rowIndex);
        switch(columnIndex){
            case 0:
                return a.getRedniBrojURegistruPosrednika();
            case 1:
                return a.getImeAgenta();
            case 2:
                return a.getPrezimeAgenta();
            case 3:
                return a.getAdresaAgenta();
            case 4:
                return a.getUspesnostRealizacije();
            case 5:
                return a.getBrojDodeljenihKlijenata();
            default:
                return "N/A";
        }
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
    
    
    
    
    
    
}
