/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class Agent extends DomainObject implements Serializable{
    private long redniBrojURegistruPosrednika;
    private String imeAgenta;
    private String prezimeAgenta;
    private String adresaAgenta;
    private double uspesnostRealizacije;
    private int brojDodeljenihKlijenata;

    public Agent() {
    }

    public Agent(long redniBrojURegistruPosrednika, String imeAgenta, String prezimeAgenta, String adresaAgenta, double uspesnostRealizacije, int brojDodeljenihKlijenata) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
        this.imeAgenta = imeAgenta;
        this.prezimeAgenta = prezimeAgenta;
        this.adresaAgenta = adresaAgenta;
        this.uspesnostRealizacije = uspesnostRealizacije;
        this.brojDodeljenihKlijenata = brojDodeljenihKlijenata;
    }

    public long getRedniBrojURegistruPosrednika() {
        return redniBrojURegistruPosrednika;
    }

    public void setRedniBrojURegistruPosrednika(long redniBrojURegistruPosrednika) {
        this.redniBrojURegistruPosrednika = redniBrojURegistruPosrednika;
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

    public String getAdresaAgenta() {
        return adresaAgenta;
    }

    public void setAdresaAgenta(String adresaAgenta) {
        this.adresaAgenta = adresaAgenta;
    }

    public double getUspesnostRealizacije() {
        return uspesnostRealizacije;
    }

    public void setUspesnostRealizacije(double uspesnostRealizacije) {
        this.uspesnostRealizacije = uspesnostRealizacije;
    }

    public int getBrojDodeljenihKlijenata() {
        return brojDodeljenihKlijenata;
    }

    public void setBrojDodeljenihKlijenata(int brojDodeljenihKlijenata) {
        this.brojDodeljenihKlijenata = brojDodeljenihKlijenata;
    }

    @Override
    public String toString() {
        return " Ime: "+imeAgenta+" Prezime:"+prezimeAgenta+" "+" Broj klijenata: "+brojDodeljenihKlijenata;
    }

    @Override
    public String getTableName() {
        return "agent";
    }

    @Override
    public String getColumnsForInsert() {
        return "redniBrojURegistruPosrednika, imeAgenta, prezimeAgenta, adresaAgenta, uspesnostRealizacije,brojDodeljenihKlijenata";
    }

    @Override
    public String getParamsForInsert() {
        return "(?,?,?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Agent agent = (Agent)domainObject;
        statement.setLong(1, agent.getRedniBrojURegistruPosrednika());
        statement.setString(2, agent.getImeAgenta());
        statement.setString(3, agent.getPrezimeAgenta());
        statement.setString(4, agent.getAdresaAgenta());
        statement.setDouble(5, agent.getUspesnostRealizacije());
        statement.setInt(6, agent.getBrojDodeljenihKlijenata());
    
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
      
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet rSet){
        try {
            List<DomainObject> resultList = new ArrayList<>();
            while(rSet.next()){
                long rbroj = rSet.getLong("redniBrojURegistruPosrednika");
                String ime = rSet.getString("imeAgenta");
                String prezime = rSet.getString("prezimeAgenta");
                String adresa = rSet.getString("adresaAgenta");
                double uspesnost = rSet.getDouble("uspesnostRealizacije");
                int brKl = rSet.getInt("brojDodeljenihKlijenata");
                Agent a = new Agent(rbroj, ime,prezime,adresa, uspesnost,brKl);
                resultList.add(a);
            }
            
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnsForSelect() {
        return "redniBrojURegistruPosrednika, imeAgenta, prezimeAgenta, adresaAgenta, uspesnostRealizacije, brojDodeljenihKlijenata";
    }

    @Override
    public String getSelectCondition() {
         return "imeAgenta=?";
    }

    @Override
    public String getTableNameJoin() {
        return "agent";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Agent agent = (Agent)domainObject;
        statement.setString(1, agent.getImeAgenta());
    }

    @Override
    public String getUpdateCondition() {
        return " redniBrojURegistruPosrednika=?";
    }

    @Override
    public String getUpdateValues() {
        return " redniBrojURegistruPosrednika=?, imeAgenta=?, prezimeAgenta=?, adresaAgenta=?, uspesnostRealizacije=?, brojDodeljenihKlijenata=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject oldDObject, DomainObject newDObject) throws SQLException {
        Agent stariAgent = (Agent)oldDObject;
        Agent noviAgent = (Agent)newDObject;
        
        statement.setLong(1,noviAgent.getRedniBrojURegistruPosrednika());
        statement.setString(2, noviAgent.getImeAgenta());
        statement.setString(3, noviAgent.getPrezimeAgenta());
        statement.setString(4, noviAgent.getAdresaAgenta());
        statement.setDouble(5, noviAgent.getUspesnostRealizacije());
        statement.setInt(6, noviAgent.getBrojDodeljenihKlijenata());
        statement.setLong(7,stariAgent.getRedniBrojURegistruPosrednika());
    
    }

    @Override
    public String getDeleteCondition() {
        return " redniBrojURegistruPosrednika=?";
    }

    @Override
    public void setParamsForDelete(PreparedStatement statement, DomainObject domainObject) {
        Agent agent = (Agent)domainObject;
        try {
            statement.setLong(1, agent.getRedniBrojURegistruPosrednika());
        } catch (SQLException ex) {
            Logger.getLogger(Agent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
