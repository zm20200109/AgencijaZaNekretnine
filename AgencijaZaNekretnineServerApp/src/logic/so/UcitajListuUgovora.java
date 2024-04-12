/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.DomainObject;
import domain.Klijent;
import domain.Ugovor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class UcitajListuUgovora extends AbstractSO{

    public UcitajListuUgovora() throws Exception {
        super();
    }

    List<Ugovor> ugovori=new ArrayList<>();

    public List<Ugovor> getUgovori() {
        return ugovori;
    }
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        
       List<Ugovor> allUgovori = dbbr.getAllUgovori();
        //sad imamo listu klijenata, ostalo je da vratimo za sve klijente ugovore
        /*
        for(Klijent k:allClients){
            Ugovor u = new Ugovor();
            u.setKlijent(k);
            List<Ugovor> ugovori = dbbr.getUgovori(k);
            for(Ugovor dobj:ugovori){
                Ugovor ug = (Ugovor)dobj;
                allUgovori.add(ug);
            }
        }*/
        ugovori = allUgovori;
        
        
    }
    
    
    
}
