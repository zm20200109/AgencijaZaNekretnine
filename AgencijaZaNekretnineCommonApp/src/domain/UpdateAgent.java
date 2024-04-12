/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class UpdateAgent implements Serializable{
    
    Agent agent;
    private long stariRB;

    public UpdateAgent() {
    }

    public UpdateAgent(Agent agent, long stariRB) {
        this.agent = agent;
        this.stariRB = stariRB;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public long getStariRB() {
        return stariRB;
    }

    public void setStariJMBG(long stariRB) {
        this.stariRB = stariRB;
    }
    
    
    
}
