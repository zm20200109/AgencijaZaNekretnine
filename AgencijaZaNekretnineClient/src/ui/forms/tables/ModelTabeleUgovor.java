/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.forms.tables;

import domain.Ugovor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleUgovor extends AbstractTableModel{
    
    List<Ugovor> ugovori;
    String[] kolone = {"Broj ugovora", "Adresa nekretnine", "Površina nepokretnosti", "Sprat", "Datum zaključenja"};
    
    public ModelTabeleUgovor(List<Ugovor> ugovori) {
        this.ugovori = ugovori;
    }
    
    
    
    @Override
    public int getRowCount() {
        return ugovori.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ugovor u = ugovori.get(rowIndex);
        switch(columnIndex){
            case 0:
                return u.getBrojUgovora();
            case 1:
                return u.getAdresaNekretnine();
            case 2:
                return u.getPovrsinaNepokretnosti();
            case 3:
                return u.getSprat();
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
                return sdf.format(u.getDatumZakljucenja());
            default:
                return "N/A";
        
        }
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        Ugovor ugovor = this.ugovori.get(rowIndex);
        switch(columnIndex){
            case 0:
                long brojUgovora = Long.parseLong(String.valueOf(aValue));
                ugovori.get(rowIndex).setBrojUgovora(brojUgovora);
                break;
            case 1:
                String adresa = String.valueOf(aValue);
                ugovori.get(rowIndex).setAdresaNekretnine(adresa);
                break;
            case 2:
                double povrsina = Double.parseDouble(String.valueOf(aValue));
                System.out.println("POVRSINA NEPOKRETNOSTI KOJA JE UNETA: " + povrsina);
                ugovori.get(rowIndex).setPovrsinaNepokretnosti(povrsina);
                double pov = ugovori.get(rowIndex).getPovrsinaNepokretnosti();
                System.out.println("-----------------------POVRSINA--------------------------:"+pov);
                break;
            case 3:
                int sprat = Integer.parseInt(String.valueOf(aValue));
                ugovori.get(rowIndex).setSprat(sprat);
                break;
            case 4:
                SimpleDateFormat sdf = new SimpleDateFormat("d.M.yyyy");
                java.util.Date datumD=null;
            try {
                datumD = sdf.parse(String.valueOf(aValue));
            } catch (ParseException ex) {
                Logger.getLogger(ModelTabeleUgovor.class.getName()).log(Level.SEVERE, null, ex);
            }
                ugovori.get(rowIndex).setDatumZakljucenja(datumD);
                break;
          
        }
        fireTableCellUpdated(rowIndex, columnIndex);
        System.out.println("----------------------------------------ELement koji je azuriran" + ugovori.get(rowIndex).getPovrsinaNepokretnosti());
        
    }

    public List<Ugovor> getUgovori() {
        return ugovori;
    }
    
    public void removeUgovor(Ugovor u){
        this.ugovori.remove(u);
    }

    public void osvežiTabelu() {
        fireTableDataChanged();
    }
    
    
}
