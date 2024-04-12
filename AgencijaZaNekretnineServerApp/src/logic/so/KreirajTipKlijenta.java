/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.TipKlijenta;

/**
 *
 * @author Korisnik
 */
public class KreirajTipKlijenta extends AbstractSO{

    public KreirajTipKlijenta() throws Exception {
        super();
    }

    private boolean resultSignal;

    public boolean isResultSignal() {
        return resultSignal;
    }
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        //result = dbbr.addTipKlijenta((TipKlijenta)(argument));
        resultSignal = dbbr.addObject((TipKlijenta)argument);
        //dbbr.add((TipKlijenta)argument);
        //result = true;
    }
    
    
}
