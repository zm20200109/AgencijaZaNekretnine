/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.forms.tables;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.StatistikaAgenata;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleStatistikaAgenata extends AbstractTableModel {

    List<StatistikaAgenata> listaA = new ArrayList<>();
    String[] kolone = {"Ime agenta", "Prezime agenta", "Ukupna provizija", "Uspešnost realizacije[%]","Ukupan broj ugovora", "Broj realizovanih ugovora"};

    public ModelTabeleStatistikaAgenata(List<domain.StatistikaAgenata> lista) {
        this.listaA = lista;
    }
    
    
    
    
    @Override
    public int getRowCount() {
        return listaA.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StatistikaAgenata statA = listaA.get(rowIndex);
        switch(columnIndex){
            case 0:
                return statA.getImeAgenta();
            case 1:
                return statA.getPrezimeAgenta();
            case 2:
                return statA.getUkupnaProvizija();
            case 3:
                return statA.getUspesnostRealizacije();
            case 4:
                return statA.getBrojKlijenata();
            case 5:
                return statA.getBrojRealizovanihKlijenata();
            default:
                return "N/A";
        }
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }
    
    
    
}
