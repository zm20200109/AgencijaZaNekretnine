/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Klijent;
import domain.Ugovor;
import domain.UpdateKlijent;

/**
 *
 * @author Korisnik
 */
public class IzmeniKlijenta extends AbstractSO {

    public IzmeniKlijenta() throws Exception {
        super();
    }

    private boolean resultSignal;

    public boolean isResultSignal() {
        return resultSignal;
    }
    
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
        UpdateKlijent klijentUpd = (UpdateKlijent)argument;
        Klijent klijent = klijentUpd.getKlijent();
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
        //domain.UpdateKlijent updKlijent = (domain.UpdateKlijent)argument;
        //result = dbbr.updateKlijent(updKlijent.getKlijent(), updKlijent.getStariJMBG());
        
        UpdateKlijent updateKlijent = (UpdateKlijent)argument;
        
        String oldKlijentJMBG = updateKlijent.getStariJMBG();
        Klijent oldKlijent = new Klijent();
        oldKlijent.setJmbgKlijenta(oldKlijentJMBG);
        
        Klijent newKlijent = updateKlijent.getKlijent();
        
        dbbr.edit(newKlijent, oldKlijent);
        for(Ugovor u: newKlijent.getUgovori()){
            
            Ugovor ugovor = new Ugovor();
            ugovor.setKlijent(oldKlijent);
            dbbr.edit(u, ugovor);
        }
        
        resultSignal = true;
        
    }
    
}
