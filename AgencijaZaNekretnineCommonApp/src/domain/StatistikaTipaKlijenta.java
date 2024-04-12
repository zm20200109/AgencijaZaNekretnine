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
public class StatistikaTipaKlijenta implements Serializable{
    private TipKlijenta tipKlijenta;
    private Agent agent;
    private int brojDodeljenihKlijenataTipa;

    public StatistikaTipaKlijenta() {
    }

    public StatistikaTipaKlijenta(TipKlijenta tipKlijenta, Agent agent, int brojDodeljenihKlijenataTipa) {
        this.tipKlijenta = tipKlijenta;
        this.agent = agent;
        this.brojDodeljenihKlijenataTipa = brojDodeljenihKlijenataTipa;
    }

    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }

    public void setTipKlijenta(TipKlijenta tipKlijenta) {
        this.tipKlijenta = tipKlijenta;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getBrojDodeljenihKlijenataTipa() {
        return brojDodeljenihKlijenataTipa;
    }

    public void setBrojDodeljenihKlijenataTipa(int brojDodeljenihKlijenataTipa) {
        this.brojDodeljenihKlijenataTipa = brojDodeljenihKlijenataTipa;
    }

    @Override
    public String toString() {
        return "StatistikaTipaKlijenta{" + "tipKlijenta=" + tipKlijenta + ", agent=" + agent + ", brojDodeljenihKlijenataTipa=" + brojDodeljenihKlijenataTipa + '}';
    }
    
    
}
