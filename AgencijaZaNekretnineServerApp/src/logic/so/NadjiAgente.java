/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Agent;
import domain.DomainObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class NadjiAgente extends AbstractSO{

    public NadjiAgente() throws Exception {
        super();
    }

    private List<Agent> agenti=new ArrayList<>();

    public List<Agent> getAgenti() {
        return agenti;
    }

   
    
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
        if (!(argument instanceof String)){
            throw new Exception("Kriterijum pretrage nije string!");
        }        
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
      //  result = dbbr.pretraziAgente(String.valueOf(argument));
        Agent a = new Agent();
        a.setImeAgenta(String.valueOf(argument));
        List<DomainObject> agentiDomain= dbbr.getAllWithCondition(a);
        for(DomainObject agentD:agentiDomain){
            Agent ag = (Agent)agentD;
            this.agenti.add(ag);
        }
        
    }
    
    
    
}
