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
public class Menadzer extends DomainObject implements Serializable{
    private long menadzerId;
    private String imeMenadzera;
    private String prezimeMenadzera;
    private String korisnickoIme;
    private String lozinka;

    public Menadzer() {
    }

    public Menadzer(long menadzerId, String imeMenadzera, String prezimeMenadzera, String korisnickoIme, String lozinka) {
        this.menadzerId = menadzerId;
        this.imeMenadzera = imeMenadzera;
        this.prezimeMenadzera = prezimeMenadzera;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public long getMenadzerId() {
        return menadzerId;
    }

    public void setMenadzerId(long menadzerId) {
        this.menadzerId = menadzerId;
    }

    public String getImeMenadzera() {
        return imeMenadzera;
    }

    public void setImeMenadzera(String imeMenadzera) {
        this.imeMenadzera = imeMenadzera;
    }

    public String getPrezimeMenadzera() {
        return prezimeMenadzera;
    }

    public void setPrezimeMenadzera(String prezimeMenadzera) {
        this.prezimeMenadzera = prezimeMenadzera;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Menadzer{" + "menadzerId=" + menadzerId + ", imeMenadzera=" + imeMenadzera + ", prezimeMenadzera=" + prezimeMenadzera + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + '}';
    }

    @Override
    public String getTableName() {
        return "menadzer";
    }

    @Override
    public String getColumnsForInsert() {
        return "menadzerId, imeMenadzera, prezimeMenadzera, korisnickoIme, lozinka";
    }

    @Override
    public String getParamsForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
