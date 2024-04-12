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
public class UcitajListuAgenata extends AbstractSO{

    public UcitajListuAgenata() throws Exception {
        super();
    }

    List<Agent> agenti=new ArrayList<>();

    public List<Agent> getAgenti() {
        return agenti;
    }
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        //List<Agent> agenti = dbbr.getAllAgenti();
        //result = agenti;
        Agent a = new Agent();
        List<DomainObject> agentiDomain = dbbr.getAll(a);
        for(DomainObject domObj:agentiDomain){
            Agent agentNew = (Agent) domObj;
            agenti.add(agentNew);
        }
        
        
    }
    
    
    
}
