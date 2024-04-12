/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public class Angazovanje extends DomainObject implements Serializable{
    private long rbAngazivanja;
    private double provizija;
    private boolean realizovano;
    private Ugovor ugovor;
    private Agent agent;
    private Menadzer menadzer;

    public Angazovanje() {
    }

    public Angazovanje(long rbAngazivanja, double provizija, boolean realizovano, Ugovor ugovor, Agent agent, Menadzer menadzer) {
        this.rbAngazivanja = rbAngazivanja;
        this.provizija = provizija;
        this.realizovano = realizovano;
        this.ugovor = ugovor;
        this.agent = agent;
        this.menadzer = menadzer;
    }

    public long getRbAngazivanja() {
        return rbAngazivanja;
    }

    public void setRbAngazivanja(long rbAngazivanja) {
        this.rbAngazivanja = rbAngazivanja;
    }

    public double getProvizija() {
        return provizija;
    }

    public void setProvizija(double provizija) {
        this.provizija = provizija;
    }

    public boolean isRealizovano() {
        return realizovano;
    }

    public void setRealizovano(boolean realizovano) {
        this.realizovano = realizovano;
    }

    public Ugovor getUgovor() {
        return ugovor;
    }

    public void setUgovor(Ugovor ugovor) {
        this.ugovor = ugovor;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public Menadzer getMenadzer() {
        return menadzer;
    }

    public void setMenadzer(Menadzer menadzer) {
        this.menadzer = menadzer;
    }

    @Override
    public String toString() {
        return "Angazovanje{" + "rbAngazivanja=" + rbAngazivanja + ", provizija=" + provizija + ", realizovano=" + realizovano + ", ugovor=" + ugovor + ", agent=" + agent + ", menadzer=" + menadzer + '}';
    }

    @Override
    public String getTableName() {
        return "angazovanje";
    }

    @Override
    public String getColumnsForInsert() {
        return "redniBrojAngazovanja, provizija, realizovano, redniBrojURegistruPosrednika, jmbgKlijenta, brUgovora, menadzerId";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        //i jos svasta nesto...
        Angazovanje a = (Angazovanje)domainObject;
        statement.setLong(1, a.getRbAngazivanja());
        statement.setDouble(2,a.getProvizija());
        if(a.isRealizovano()){
            System.out.println("Dodato je realizovano angažovanje.");
            statement.setInt(3,1);
        }
        else
            statement.setInt(3,0);
        
        statement.setLong(4,a.getAgent().getRedniBrojURegistruPosrednika());
        statement.setString(5, a.getUgovor().getKlijent().getJmbgKlijenta());
        statement.setLong(6,a.getUgovor().getBrojUgovora());
        statement.setLong(7, a.getMenadzer().getMenadzerId());
        
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getColumnsForSelect() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getSelectCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getTableNameJoin() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject oldDObject, DomainObject newDObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDeleteCondition() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    
}
