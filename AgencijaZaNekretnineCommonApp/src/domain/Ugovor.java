/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author Korisnik
 */
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ugovor extends DomainObject implements Serializable{
    private Klijent klijent;
    private long brojUgovora;
    private String adresaNekretnine;
    private double povrsinaNepokretnosti;
    private int sprat;
    private Date datumZakljucenja;
    
    
    public Ugovor() {
    }

    public Ugovor(Klijent klijent, long brojUgovora, String adresaNekretnine, double povrsinaNepokretnosti, int sprat, Date datumZakljucenja) {
        this.klijent = klijent;
        this.brojUgovora = brojUgovora;
        this.adresaNekretnine = adresaNekretnine;
        this.povrsinaNepokretnosti = povrsinaNepokretnosti;
        this.sprat = sprat;
        this.datumZakljucenja = datumZakljucenja;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public long getBrojUgovora() {
        return brojUgovora;
    }

    public void setBrojUgovora(long brojUgovora) {
        this.brojUgovora = brojUgovora;
    }

    public String getAdresaNekretnine() {
        return adresaNekretnine;
    }

    public void setAdresaNekretnine(String adresaNekretnine) {
        this.adresaNekretnine = adresaNekretnine;
    }

    public double getPovrsinaNepokretnosti() {
        return povrsinaNepokretnosti;
    }

    public void setPovrsinaNepokretnosti(double povrsinaNepokretnosti) {
        this.povrsinaNepokretnosti = povrsinaNepokretnosti;
    }

    public int getSprat() {
        return sprat;
    }

    public void setSprat(int sprat) {
        this.sprat = sprat;
    }

    public Date getDatumZakljucenja() {
        return datumZakljucenja;
    }

    public void setDatumZakljucenja(Date datumZakljucenja) {
        this.datumZakljucenja = datumZakljucenja;
    }

    @Override
    public String toString() {
        return "Klijent:" + klijent.getImeKlijenta()+" "+klijent.getPrezimeKlijenta()+" Broj ugovora: "+brojUgovora+ " Adresa:"+adresaNekretnine+" površina:"+povrsinaNepokretnosti+" sprat:"+sprat;
    }

    @Override
    public String getTableName() {
        return "ugovor"; //podacima za ugovor u modelu odgovara ovaj join
    }

    @Override
    public String getColumnsForInsert() {
        return "jmbgKlijenta, brUgovora, adresaNekretnine, povrsinaNepokretnosti, sprat, datumZakljucenja";
    }

    @Override
    public String getParamsForInsert() {
        return " (?,?,?,?,?,?)";
    }

    @Override
    public void setParamsForInsert(PreparedStatement statement, DomainObject domainObject) throws SQLException {
           Ugovor ugovor = (Ugovor)domainObject;
           statement.setString(1, klijent.getJmbgKlijenta());
           statement.setLong(2, ugovor.getBrojUgovora());
           statement.setString(3, ugovor.getAdresaNekretnine());
           statement.setDouble(4, ugovor.getPovrsinaNepokretnosti());
           statement.setInt(5, ugovor.getSprat());
           statement.setDate(6, new java.sql.Date(ugovor.getDatumZakljucenja().getTime()));
    }

    @Override
    public void setAutoIncrementPrimaryKey(long primaryKey) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DomainObject> getListOfAllObjects(ResultSet rSet) {
        try {
            List<DomainObject> ugovori = new ArrayList<>();
            while(rSet.next()){
                String jmbg = rSet.getString("k.jmbgKlijenta"); //k.jmbgKlijenta
                long brUgovora = rSet.getLong("u.brUgovora");
                String adresaNek = rSet.getString("u.adresaNekretnine");
                double povrsina = rSet.getDouble("u.povrsinaNepokretnosti");
                java.util.Date datum = new java.util.Date(rSet.getDate("u.datumZakljucenja").getTime());
                String ime = rSet.getString("k.imeKlijenta");
                String prezime = rSet.getString("k.prezimeKlijenta");
                long sifraTipa = rSet.getLong("t.sifraTipaKlijenta");
                String nazivTipa = rSet.getString("t.nazivTipaKlijenta");
                int sprat = rSet.getInt("u.sprat");
                TipKlijenta tipKlijenta = new TipKlijenta(sifraTipa, nazivTipa);
                Klijent klijent = new Klijent(jmbg,ime,prezime,tipKlijenta);
                Ugovor u = new Ugovor(klijent,brUgovora,adresaNek,povrsina,sprat, datum);
                ugovori.add(u);
                
            }
            return ugovori;
        } catch (SQLException ex) {
            Logger.getLogger(Ugovor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return null;
    }

    @Override
    public String getColumnsForSelect() {
        return "*";
    }

    @Override
    public String getSelectCondition() {

                return "k.jmbgKlijenta=?";
    }

    @Override
    public String getTableNameJoin() {
        return getTableName() + " u JOIN klijent k ON (u.jmbgKlijenta = k.jmbgKlijenta) JOIN tipklijenta t ON (t.sifraTipaKlijenta=k.sifraTipaKlijenta)";
    }

    @Override
    public void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException {
        Ugovor ugovor = (Ugovor)domainObject;
        statement.setString(1, ugovor.getKlijent().getJmbgKlijenta());
        //System.out.println(u.getKlijent().getJmbgKlijenta());
    }

    @Override
    public String getUpdateCondition() {
        return " jmbgKlijenta=? AND brUgovora=?";
    }

    @Override
    public String getUpdateValues() {
        return " jmbgKlijenta=?, brUgovora=?, adresaNekretnine=?,povrsinaNepokretnosti=?, sprat=?, datumZakljucenja=?";
    }

    @Override
    public void setParamsForUpdate(PreparedStatement statement, DomainObject oldDObject, DomainObject newDObject) throws SQLException {
        
            Ugovor oldUgovor = (Ugovor)oldDObject;
            Ugovor newUgovor = (Ugovor)newDObject;
            
           statement.setString(1, newUgovor.getKlijent().getJmbgKlijenta());
           statement.setLong(2, newUgovor.getBrojUgovora());
           statement.setString(3, newUgovor.getAdresaNekretnine());
           statement.setDouble(4, newUgovor.getPovrsinaNepokretnosti());
           statement.setInt(5, newUgovor.getSprat());
           statement.setDate(6, new java.sql.Date(newUgovor.getDatumZakljucenja().getTime()));
           statement.setString(7, oldUgovor.getKlijent().getJmbgKlijenta());
           statement.setLong(8, newUgovor.getBrojUgovora());
            
    
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
