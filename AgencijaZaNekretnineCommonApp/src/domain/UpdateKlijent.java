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
public class UpdateKlijent implements Serializable{
    
    Klijent klijent;
    String stariJMBG;

    public UpdateKlijent() {
    }

    public UpdateKlijent(Klijent klijent, String stariJMBG) {
        this.klijent = klijent;
        this.stariJMBG = stariJMBG;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public String getStariJMBG() {
        return stariJMBG;
    }

    public void setStariJMBG(String stariJMBG) {
        this.stariJMBG = stariJMBG;
    }
    
    
    
}
