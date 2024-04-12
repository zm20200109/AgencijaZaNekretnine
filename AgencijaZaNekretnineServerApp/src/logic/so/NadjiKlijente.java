/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import database.DatabaseBroker;
import domain.DomainObject;
import domain.Klijent;
import domain.Ugovor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class NadjiKlijente extends AbstractSO{

    public NadjiKlijente() throws Exception {
        super();
    }

    private List<Klijent> klijenti;

    public List<Klijent> getKlijenti() {
        return klijenti;
    }

   
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        //result=dbbr.pretraziKlijente(String.valueOf(argument));
        List<Klijent> listOfKlijents = new ArrayList<>();
        Klijent k = new Klijent();
        k.setImeKlijenta(String.valueOf(argument));
        List<DomainObject> klijenti = dbbr.getAllWithCondition(k); // vraca listu klijenata sa imenom koje je zadato
        for(DomainObject klijent:klijenti){
            Klijent kastovaniKlijent = (Klijent)klijent;
            listOfKlijents.add(kastovaniKlijent);
        }
        //potrebno je sada za svakog od ovih klijenata: vratiti listu ugovora, setovati za klijenta listu ugovora 
       
        for (Klijent klijent: listOfKlijents){ //select * from ugovor where jmbgklijenta=?
            List<Ugovor> ugovoriUgovor = new ArrayList<>();
            Ugovor u = new Ugovor();
            u.setKlijent(klijent);
            List<DomainObject> ugovoriDom = dbbr.getAllWithCondition(u); //on ovde mora da salje ugovor da bi znao na koju se klasu odnosi
            for(DomainObject ugovor:ugovoriDom){
                ugovoriUgovor.add((Ugovor)ugovor);
            }
            
            
            klijent.setUgovori(ugovoriUgovor);
         
            
            //deo u kom dodajem u klijente, nz da li je dodato
        }
        
     
        
        this.klijenti=listOfKlijents;
    }
    
    
    
}
