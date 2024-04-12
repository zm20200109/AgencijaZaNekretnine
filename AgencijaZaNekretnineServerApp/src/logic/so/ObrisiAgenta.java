/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Agent;

/**
 *
 * @author Korisnik
 */
public class ObrisiAgenta extends AbstractSO{

    public ObrisiAgenta() throws Exception {
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
    //    result = dbbr.deleteAgent((Agent)argument);
        Agent agent = (Agent)argument;
        resultSignal = dbbr.delete(agent);
    }
    
    
    
}
