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
public class TipKlijenta extends DomainObject implements Serializable{
    private long sifraTipa;
    private String nazivTipa;

    public TipKlijenta() {
    }
    
    public TipKlijenta(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }
    

    public TipKlijenta(long sifraTipa, String nazivTipa) {
        this.sifraTipa = sifraTipa;
        this.nazivTipa = nazivTipa;
    }

    public long getSifraTipa() {
        return sifraTipa;
    }

    public void setSifraTipa(long sifraTipa) {
        this.sifraTipa = sifraTipa;
    }

    public String getNazivTipa() {
        return nazivTipa;
    }

    public void setNazivTipa(String nazivTipa) {
        this.nazivTipa = nazivTipa;
    }

    @Override
    public String toString() {
        return nazivTipa;
    }

    @Override
    public String getTableName() {
        return "tipklijenta";
    }

    @Override
    public String getColumnsForInsert() {
        return "nazivTipaKlijenta";
    }

    @Override
    public String getParamsForInsert() {
        return "(?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        TipKlijenta tipKlijenta = (TipKlijenta)domainObject;
        statement.setString(1, tipKlijenta.getNazivTipa());

    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet rSet) {
        try {
            List<DomainObject> tipoviKlijenata = new ArrayList<>();
            while(rSet.next()){
                long sifra = rSet.getLong("sifraTipaKlijenta");
                String naziv = rSet.getString("nazivTipaKlijenta");
                TipKlijenta tipKlijenta = new TipKlijenta(sifra, naziv);
                tipoviKlijenata.add(tipKlijenta);
            }
            return tipoviKlijenata;
        } catch (SQLException ex) {
            Logger.getLogger(TipKlijenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public String getColumnsForSelect() {
        return "sifraTipaKlijenta, nazivTipaKlijenta";
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
