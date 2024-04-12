/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Angazovanje;

/**
 *
 * @author Korisnik
 */
public class KreirajAngazovanje extends AbstractSO{

    public KreirajAngazovanje() throws Exception {
        super();
    }

    private  boolean resultSignal;

    public boolean isResultSignal() {
        return resultSignal;
    }
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        boolean signal = dbbr.createAngazovanje((Angazovanje)argument);
        resultSignal = signal;
        //Angazovanje angazovanje = (Angazovanje)argument;
        //dbbr.addObject(angazovanje);
        //long brojKlijenata = dbbr.getBrojKlijenata(angazovanje);
        
        
    }
    
    
    
}
