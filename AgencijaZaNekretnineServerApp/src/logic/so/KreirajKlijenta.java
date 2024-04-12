/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Klijent;
import domain.Ugovor;

/**
 *
 * @author Korisnik
 */
public class KreirajKlijenta extends AbstractSO{

    public KreirajKlijenta() throws Exception {
        super();
    }
    
    private boolean resultSignal;

    public boolean isResultSignal() {
        return resultSignal;
    }
    
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
        Klijent klijent = (Klijent)argument;
      
        if (klijent == null){
            throw new Exception("Klijent je null!");
        }
        if(klijent.getUgovori().size()<1){
            throw new Exception("Klijent mora da ima bar jedan ugovor!");
        }
        if(klijent.getImeKlijenta().isEmpty() || klijent.getPrezimeKlijenta().isEmpty()){
            throw new Exception("Ime i prezime klijenta ne smeju biti prazni stringovi!");
        }
        if(klijent.getJmbgKlijenta().length()!=13){
            throw new Exception("JMBG klijenta mora biti duzine 13!");
        }
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        Klijent klijent = (Klijent)argument;
        dbbr.addObject(klijent); //1. dodat je klijent
        for(Ugovor u: klijent.getUgovori()){
            dbbr.addObject(u);     //2. dodavanje svih ugovora pojedinacno, a ne preko addBatch()
        }
        
        //result = dbbr.addKlijent(klijent,klijent.getUgovori());
        //dbbr.add(klijent);
        resultSignal = true;
        
        
        
    }
    
    
    
}
