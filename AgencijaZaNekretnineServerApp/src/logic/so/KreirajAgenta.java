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
public class KreirajAgenta extends AbstractSO{

    public KreirajAgenta() throws Exception {
        super(); // on ovde instancira dbbr da bi radi commit i rollback
    }
    
    private boolean resultSignal;

    public boolean isResultSignal() {
        return resultSignal;
    }
    
    
    
    
    @Override
    protected void validate(Object agent) throws Exception {
        
        Agent newAgent = (Agent)agent;
         if(newAgent == null){
            throw new Exception("Agent kojeg ste uneli ne sme biti null!");
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
    protected void executeOperation(Object agent) throws Exception {
        //boolean signal = dbbr.addAgent((Agent) agent);
        dbbr.add((Agent)agent);
        resultSignal = true; // ovom atributu mozemo pristupiti jer je protected
     
        
    
    }
    
    
    
}
