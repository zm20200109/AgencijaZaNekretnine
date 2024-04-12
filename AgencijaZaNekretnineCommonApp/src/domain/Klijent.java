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
public class Klijent extends DomainObject implements Serializable{
    private String jmbgKlijenta;
    private String imeKlijenta;
    private String prezimeKlijenta;
    private TipKlijenta tipKlijenta;
    private List<Ugovor> ugovori;

    public Klijent() {
        this.ugovori = new ArrayList<>();
    }

    public Klijent(String jmbgKlijenta, String imeKlijenta, String prezimeKlijenta, TipKlijenta tipKlijenta, List<Ugovor> ugovori) {
        this.jmbgKlijenta = jmbgKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.tipKlijenta = tipKlijenta;
        this.ugovori = ugovori;
    }

        public Klijent(String jmbgKlijenta, String imeKlijenta, String prezimeKlijenta, TipKlijenta tipKlijenta) {
        this.jmbgKlijenta = jmbgKlijenta;
        this.imeKlijenta = imeKlijenta;
        this.prezimeKlijenta = prezimeKlijenta;
        this.tipKlijenta = tipKlijenta;
        this.ugovori = new ArrayList<>();
        
    }

    public void addUgovor(Ugovor u){
        ugovori.add(u);
    }
    
    
    public String getJmbgKlijenta() {
        return jmbgKlijenta;
    }

    public void setJmbgKlijenta(String jmbgKlijenta) {
        this.jmbgKlijenta = jmbgKlijenta;
    }

    public String getImeKlijenta() {
        return imeKlijenta;
    }

    public void setImeKlijenta(String imeKlijenta) {
        this.imeKlijenta = imeKlijenta;
    }

    public String getPrezimeKlijenta() {
        return prezimeKlijenta;
    }

    public void setPrezimeKlijenta(String prezimeKlijenta) {
        this.prezimeKlijenta = prezimeKlijenta;
    }

    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }

    public void setTipKlijenta(TipKlijenta tipKlijenta) {
        this.tipKlijenta = tipKlijenta;
    }

    public List<Ugovor> getUgovori() {
        return ugovori;
    }

    public void setUgovori(List<Ugovor> ugovori) {
        this.ugovori = ugovori;
    }

    @Override
    public String toString() {
        return "Klijent{" + "jmbgKlijenta=" + jmbgKlijenta + ", imeKlijenta=" + imeKlijenta + ", prezimeKlijenta=" + prezimeKlijenta + ", tipKlijenta=" + tipKlijenta+"";
    }
    
    public void dodajUgovor(Ugovor u ){
        this.ugovori.add(u);
    }

    @Override
    public String getTableName() {
        return "klijent";
    }
    //"INSERT INTO klijent(jmbgKlijenta, imeKlijenta, prezimeKlijenta, sifraTipaKlijenta) VALUES (?,?,?,?)"
    @Override
    public String getColumnsForInsert() {
        return "jmbgKlijenta, imeKlijenta, prezimeKlijenta, sifraTipaKlijenta";
    }

    @Override
    public String getParamsForInsert() {
        return " (?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Klijent klijent = (Klijent)domainObject;
        statement.setString(1, klijent.getJmbgKlijenta());
        statement.setString(2, klijent.getImeKlijenta());
        statement.setString(3, klijent.getPrezimeKlijenta());
        statement.setLong(4, klijent.getTipKlijenta().getSifraTipa());
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet resultSet) {
        List<DomainObject> klijenti = new ArrayList<>();
        try {
            while(resultSet.next()){
                Klijent klijent = new Klijent();
                String jmbgKlijenta = resultSet.getString("k.jmbgKlijenta");
                klijent.setJmbgKlijenta(resultSet.getString("k.jmbgKlijenta"));
                klijent.setImeKlijenta(resultSet.getString("k.imeKlijenta"));
                klijent.setPrezimeKlijenta(resultSet.getString("k.prezimeKlijenta"));
                TipKlijenta tipKlijenta = new TipKlijenta();
                tipKlijenta.setSifraTipa(resultSet.getLong("tk.sifraTipaKlijenta"));
                tipKlijenta.setNazivTipa(resultSet.getString("tk.nazivTipaKlijenta"));
                klijent.setTipKlijenta(tipKlijenta);

                
                klijenti.add(klijent);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Klijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return klijenti;
    }

    //"INSERT INTO klijent(jmbgKlijenta, imeKlijenta, prezimeKlijenta, sifraTipaKlijenta) VALUES (?,?,?,?)"
    @Override
    public String getColumnsForSelect() {
        return "k.jmbgKlijenta, k.imeKlijenta, k.prezimeKlijenta, tk.sifraTipaKlijenta, tk.nazivTipaKlijenta";
    }

    @Override
    public String getSelectCondition() {
     
                return "k.imeKlijenta=?";

    }

    @Override
    public String getTableNameJoin() {
        return getTableName()+" k JOIN tipklijenta tk ON (k.sifraTipaKlijenta=tk.sifraTipaKlijenta)";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Klijent k = (Klijent)domainObject;
        System.out.println(k.getImeKlijenta());
        statement.setString(1, k.getImeKlijenta());
    }

    @Override
    public String getUpdateCondition() {
        return " jmbgKlijenta=?";
    }

    @Override
    public String getUpdateValues() {
        return " jmbgKlijenta=?, imeKlijenta=?, prezimeKlijenta=?, sifraTipaKlijenta=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject oldDObject, DomainObject newDObject) throws SQLException {
        Klijent oldKl = (Klijent)oldDObject;
        Klijent newKl = (Klijent) newDObject;
        statement.setString(1, newKl.getJmbgKlijenta());
        statement.setString(2, newKl.getImeKlijenta());
        statement.setString(3, newKl.getPrezimeKlijenta());
        statement.setLong(4, newKl.getTipKlijenta().getSifraTipa());
        statement.setString(5,oldKl.getJmbgKlijenta());
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
