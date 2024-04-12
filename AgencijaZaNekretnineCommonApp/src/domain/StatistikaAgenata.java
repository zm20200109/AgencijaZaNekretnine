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
public class StatistikaAgenata implements Serializable{
    
    String imeAgenta;
    String prezimeAgenta;
    double ukupnaProvizija;
    double uspesnostRealizacije;
    int brojKlijenata;
    int brojRealizovanihKlijenata;

    public StatistikaAgenata() {
    }

    public StatistikaAgenata(String imeAgenta, String prezimeAgenta, double ukupnaProvizija, double uspesnostRealizacije, int brojKlijenata, int brojRealizovanihKlijenata) {
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.ukupnaProvizija = ukupnaProvizija;
        this.uspesnostRealizacije = uspesnostRealizacije;
        this.brojKlijenata = brojKlijenata;
        this.brojRealizovanihKlijenata = brojRealizovanihKlijenata;
    }

    @Override
    public String toString() {
        return "StatistikaAgenata{" + "imeAgenta=" + imeAgenta + ", prezimeAgenta=" + prezimeAgenta + ", ukupnaProvizija=" + ukupnaProvizija + ", uspesnostRealizacije=" + uspesnostRealizacije + ", brojKlijenata=" + brojKlijenata + ", brojRealizovanihKlijenata=" + brojRealizovanihKlijenata + '}';
    }

    public String getImeAgenta() {
        return imeAgenta;
    }

    public void setImeAgenta(String imeAgenta) {
        this.imeAgenta = imeAgenta;
    }

    public String getPrezimeAgenta() {
        return prezimeAgenta;
    }

    public void setPrezimeAgenta(String prezimeAgenta) {
        this.prezimeAgenta = prezimeAgenta;
    }

    public double getUkupnaProvizija() {
        return ukupnaProvizija;
    }

    public void setUkupnaProvizija(double ukupnaProvizija) {
        this.ukupnaProvizija = ukupnaProvizija;
    }

    public double getUspesnostRealizacije() {
        return uspesnostRealizacije;
    }

    public void setUspesnostRealizacije(double uspesnostRealizacije) {
        this.uspesnostRealizacije = uspesnostRealizacije;
    }

    public int getBrojKlijenata() {
        return brojKlijenata;
    }

    public void setBrojKlijenata(int brojKlijenata) {
        this.brojKlijenata = brojKlijenata;
    }

    public int getBrojRealizovanihKlijenata() {
        return brojRealizovanihKlijenata;
    }

    public void setBrojRealizovanihKlijenata(int brojRealizovanihKlijenata) {
        this.brojRealizovanihKlijenata = brojRealizovanihKlijenata;
    }
    
    
    
}
