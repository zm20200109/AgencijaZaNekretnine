/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Agent;
import domain.UpdateAgent;

/**
 *
 * @author Korisnik
 */
public class IzmeniAgenta extends AbstractSO{
    
    private boolean resultSignal;
    
    public IzmeniAgenta() throws Exception {
        super();
    }

    public boolean isResultSignal() {
        return resultSignal;
    }

    
    
    @Override
    protected void validate(Object argument) throws Exception {
        UpdateAgent updateAgent = (UpdateAgent)argument;
        Agent newAgent = updateAgent.getAgent();
        if(newAgent == null){
            throw new Exception("Agent kojeg ste izmenili ne sme biti null!");
        }
        if(newAgent.getImeAgenta().isEmpty() || newAgent.getPrezimeAgenta().isEmpty() || newAgent.getAdresaAgenta().isEmpty()){
            throw new Exception("Adresa agenta, ime ili prezime ne smeju biti prazni!");
        }
        if(newAgent.getBrojDodeljenihKlijenata()<0){
            throw new Exception("Broj dodeljenih klijenata ne sme biti manji od 0!");
        }
        if(newAgent.getUspesnostRealizacije()<0 || newAgent.getUspesnostRealizacije()>1){
            throw new Exception("Uspešnost realizacije mora biti izmedju 0 i 1!");
        }
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        //domain.UpdateAgent updAgent = (domain.UpdateAgent)(argument);
        //result = dbbr.updateAgent(updAgent.getAgent(), updAgent.getStariRB());
        
        //postoji klasa koja prima novog agenta i stari rb.
        domain.UpdateAgent updateAgent = (domain.UpdateAgent)(argument);
        Agent newAgent = updateAgent.getAgent();
        Agent oldAgent = new Agent();
        long oldRB = updateAgent.getStariRB();
        oldAgent.setRedniBrojURegistruPosrednika(oldRB);
        resultSignal = dbbr.edit(newAgent, oldAgent);
        
    }
    
    
}
