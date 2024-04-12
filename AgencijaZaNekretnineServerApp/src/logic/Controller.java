/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import database.DatabaseBroker;
import database.DatabaseConnection;
import domain.Agent;
import domain.Angazovanje;
import domain.Klijent;
import domain.Menadzer;
import domain.StatistikaAgenata;
import domain.TipKlijenta;
import domain.Ugovor;
import java.util.ArrayList;
import java.util.List;
import logic.so.KreirajAgenta;
import logic.so.KreirajAngazovanje;
import logic.so.KreirajKlijenta;
import logic.so.KreirajTipKlijenta;
import logic.so.ObrisiAgenta;
import logic.so.UcitajListuAgenata;
import logic.so.UcitajListuUgovora;
import logic.so.PronadjiNalog;
import logic.so.UcitajListuTipovaKlijenata;
import logic.so.NadjiAgente;
import logic.so.NadjiKlijente;
import logic.so.IzmeniAgenta;
import logic.so.IzmeniKlijenta;

/**
 *
 * @author Korisnik
 */
public class Controller {
     private static DatabaseBroker dbbr;
    
    private static Controller instance;
    /*
    private Controller() {
        dbbr = new DatabaseBroker();
    }*/
/*
    public static DatabaseBroker getDbbr() {
        return dbbr;
    }

    public static Controller getInstance() {
        if (instance == null){
            instance = new Controller();
        }
        return instance;
    }
    
   */ 
    //private List<Menadzer> ulogovaniMenadzeri = new ArrayList<>(); 
    /*
    public void addUlogovani(Menadzer menadzer){
        for(Menadzer m:ulogovaniMenadzeri){
            if(!ulogovaniMenadzeri.contains(m)){
                ulogovaniMenadzeri.add(m);
            }
        }
    }*/
    
   
    public Menadzer login(Menadzer menadzer) throws Exception{
      /*  try {
            DatabaseConnection.getInstance(); // kreira se konekcija kad se loguje menadzer
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            Menadzer dbMenadzer=dbbr.getMenadzer(menadzer); //vraca menadzera iz baze
            DatabaseConnection.getInstance().commit(); // komituje transakciju
            return dbMenadzer;
        } catch (Exception ex) {
            DatabaseConnection.getInstance().rollback(); //ako naleti na exception, on rollbackuje transakciju
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); // diskonektuje se 
        }*/
        PronadjiNalog so = new PronadjiNalog();
        so.execute(menadzer);
        return so.getMenadzerResult();
      
    }
    
    
    public boolean createAgent(Agent agent) throws Exception{ //logika svake operacije u COntroleru jeste da: 1. dobije instancu konekcije, dobije rezultat DbBRokera i ukoliko se ne desi exceptio izvrsi commit, a ukoliko se desi exception onda ide rollback
        
        /*
        
        try {
            DatabaseConnection.getInstance();
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            boolean signal = dbbr.addAgent(agent);
            DatabaseConnection.getInstance().commit();
            return signal;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }
    
        */
        KreirajAgenta so = new KreirajAgenta();
        so.execute(agent);
        return so.isResultSignal();

    }
    
    public boolean createTipKlijenta(TipKlijenta tipKlijenta) throws Exception{
        /*
        try {
            DatabaseConnection.getInstance();
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            tipKlijenta = dbbr.addTipKlijenta(tipKlijenta);
            DatabaseConnection.getInstance().commit();
            return tipKlijenta;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }*/
        
        KreirajTipKlijenta so = new KreirajTipKlijenta();
        so.execute(tipKlijenta);
        return so.isResultSignal();
    }

    public List<TipKlijenta> popuniCbTipKlijenta() throws Exception {
       /*
        try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            List<TipKlijenta> tipovi = dbbr.popuniListuTipovaKlijenata();
            DatabaseConnection.getInstance().commit();
            return tipovi;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }*/
       UcitajListuTipovaKlijenata so = new UcitajListuTipovaKlijenata();
       so.execute(null);
       return so.getTipovi();
    }

    public boolean createKlijent(Klijent klijent) throws Exception {
        /*
        try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            boolean signal = dbbr.addKlijent(klijent,ugovori);
            DatabaseConnection.getInstance().commit();
            return signal;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }
    */
        KreirajKlijenta so = new KreirajKlijenta();
        so.execute(klijent);
        return so.isResultSignal();
    }

    public List<Agent> pretraziAgente(String ime) throws Exception {
        /* try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            List<Agent> agenti = dbbr.pretraziAgente(ime);
            DatabaseConnection.getInstance().commit();
            return agenti;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }*/
        NadjiAgente so = new NadjiAgente();
        so.execute(ime);
        return so.getAgenti();
    }

    public List<Klijent> getKlijenti(String imeKlijenta) throws Exception {
        
        /*
        
        try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            System.out.println("Stigao je u try blok u controlleru");
            List<Klijent> klijenti = dbbr.pretraziKlijente(imeKlijenta);
            System.out.println("Vratio je listu klijenata iz baze");
            DatabaseConnection.getInstance().commit();
            return klijenti;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno pretraživanje klijenata!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }*/
        
        NadjiKlijente so = new NadjiKlijente();
        so.execute(imeKlijenta);
        return so.getKlijenti();
    }
    
    public boolean updateKlijent(domain.UpdateKlijent updKlijent) throws Exception{
     
        /*
        try {
            DatabaseConnection.getInstance(); // kreira se konekcija kad se loguje menadzer
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            boolean signal = dbbr.updateKlijent(klijent, stariJMBG); //vraca menadzera iz baze
            System.out.println("SIGNAL"+signal);
            DatabaseConnection.getInstance().commit(); // komituje transakciju
            return signal;
        } catch (Exception ex) {
            DatabaseConnection.getInstance().rollback(); //ako naleti na exception, on rollbackuje transakciju
            throw new Exception("Neuspesno updateovanje klijenta!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); // diskonektuje se 
        }
    */
        IzmeniKlijenta so = new IzmeniKlijenta();
        so.execute(updKlijent);
        return so.isResultSignal();
        
    }

    public List<Agent> getAgenti(String ime) throws Exception {
       /*
        try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            List<Agent> agenti = dbbr.pretraziAgente(ime);
            DatabaseConnection.getInstance().commit();
            return agenti;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesno prijavljivanje na sistem!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }*/
       NadjiAgente so = new NadjiAgente();
       so.execute(ime);
       return so.getAgenti();
       
    
    }

    public boolean updateAgent(domain.UpdateAgent updateAgent) throws Exception {
        
        /*
        try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            boolean signal = dbbr.updateAgent(noviAgent, redniBrojURegistruPosrednika);
            DatabaseConnection.getInstance().commit();
            return signal;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesna izmena agenta!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }*/
        IzmeniAgenta so = new IzmeniAgenta();
        so.execute(updateAgent);
        return so.isResultSignal();
        
    }

    public boolean deleteAgent(Agent agent) throws Exception {
        /*
        
        try {
            DatabaseConnection.getInstance(); // konekcija sa bazom
        } catch (Exception ex) {
            throw new Exception("Neuspesno povezivanje sa bazom!");
        }
        try {
            boolean signal = dbbr.deleteAgent(agent);
            DatabaseConnection.getInstance().commit();
            return signal;
        } catch (Exception ex) {
            DatabaseConnection.getConnection().rollback();
            throw new Exception("Neuspesna izmena agenta!");
        }finally{
            //DatabaseConnection.getInstance().disconnect(); //diskonekcija ne 
        }
    
    */
        
        ObrisiAgenta so = new ObrisiAgenta();
        so.execute(agent);
        return so.isResultSignal();
    }

    public List<Agent> getAllAgenti(Object argument) throws Exception {
        UcitajListuAgenata so = new UcitajListuAgenata();
        so.execute(argument);
        return so.getAgenti();
    }

    public List<Ugovor> getAllUgovori(Object argument) throws Exception {
        System.out.println("Metoda get all ugovori controllera servera");
        UcitajListuUgovora so = new UcitajListuUgovora();
        System.out.println("Sistemska opracija pocinje sa execute");
        so.execute(argument);
        return so.getUgovori();
    }

    public boolean createAngazovanje(Object argument) throws Exception {
        KreirajAngazovanje so = new KreirajAngazovanje();
        so.execute(argument);
        return so.isResultSignal();
    
    
    }

    public List<StatistikaAgenata> statistikaAgenata() throws Exception {
        logic.so.StatistikaAgenata so = new logic.so.StatistikaAgenata();
        so.execute(null);
        return so.getStatistikaResult();
    
    }
    
    
}
