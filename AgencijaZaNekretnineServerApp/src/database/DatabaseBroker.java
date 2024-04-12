/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import domain.Agent;
import domain.Angazovanje;
import domain.DomainObject;
import domain.Klijent;
import domain.Menadzer;
import domain.StatistikaAgenata;
import domain.TipKlijenta;
import domain.Ugovor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class DatabaseBroker {
     private final Connection connection;
    
    public DatabaseBroker(Connection connection) {
        this.connection = connection;
    }
    
    
    //metode za izvlacenje podataka iz baze..
    
    public Menadzer getMenadzer(Menadzer menadzer) throws SQLException {
        try {
            String query = "SELECT menadzerId, imeMenadzera, prezimeMenadzera, korisnickoIme, lozinka FROM menadzer WHERE korisnickoIme=? AND lozinka=?";
            System.out.println("Upit: " + query);

            //Pravljenje objekta koji je odgovoran za izvrsavanje upita
            //System.out.println("PRE LINIJE STATEMENT");
            PreparedStatement statement = connection.prepareStatement(query);
            //System.out.println("POSLE LINIJE STATEMENT"); //on nije doziveo ovu liniju koda 
            statement.setString(1, menadzer.getKorisnickoIme());
            statement.setString(2, menadzer.getLozinka());
            //izvsi upit
            ResultSet rs = statement.executeQuery();

            //pristup rezultatima upita
            if (rs.next()) {
                menadzer.setMenadzerId(rs.getLong("menadzerId"));
                menadzer.setImeMenadzera(rs.getString("imeMenadzera"));
                menadzer.setPrezimeMenadzera(rs.getString("prezimeMenadzera"));            
            }else{
                statement.close();
                System.out.println("Ne postoji mendazer sa zadatim kredencijalima.");
                return null;
            }
            //oslobadjanje resursa
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje objekta User iz baze!");
            System.out.println("OVO JE VRACENO IZ BAZE:"+menadzer);
            return menadzer;
        } catch (SQLException ex) {
            System.out.println("Objekat User nije uspesno ucitan iz baze!");
            ex.printStackTrace();
            throw ex;
        }
    }
    /*
    public boolean addAgent(Agent agent) throws SQLException{
        
        try{
        
            String query = "INSERT INTO agent(redniBrojURegistruPosrednika, imeAgenta, prezimeAgenta, adresaAgenta, uspesnostRealizacije, brojDodeljenihKlijenata) VALUES(?,?,?,?,?,?)"; 
            System.out.println("Upit: "+ query);
            PreparedStatement statement = connection.prepareStatement(query);
        
            statement.setLong(1, agent.getRedniBrojURegistruPosrednika());
            statement.setString(2, agent.getImeAgenta());
            statement.setString(3, agent.getPrezimeAgenta());
            statement.setString(4, agent.getAdresaAgenta());
            statement.setDouble(5, agent.getUspesnostRealizacije());
            statement.setInt(6, agent.getBrojDodeljenihKlijenata());
        
            int affectedRows = statement.executeUpdate();
            if(affectedRows>0){
                statement.close();
                System.out.println("Sistem je zapamtio agenta.");
                return true;
            }else{
                statement.close();
                System.out.println("Agent nije unet u bazu!");
                return false;
            }
    
        }catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta Agent u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }*/
    /*
    public TipKlijenta addTipKlijenta(TipKlijenta tipKlijenta) throws SQLException{
        //domenski objekat kastuje se u klijenta u KreirajTipKlijenta klasi sistemske operacije
        
        try{
            //String query = "INSERT INTO "+tipKlijenta.getTableName()+" VALUES "+tipKlijenta.getParamsForInsert();
            String query = "INSERT INTO tipklijenta(nazivTipaKlijenta) VALUES (?)";

            System.out.println("ISPIS Upita: "+query);
            PreparedStatement statement = connection.prepareStatement(query,PreparedStatement.RETURN_GENERATED_KEYS);
            //tipKlijenta.setParamsForInsert(statement, tipKlijenta);
            statement.setString(1, tipKlijenta.getNazivTipa());
            int affectedRows = statement.executeUpdate();
             //pristup generisanom kljucu
            ResultSet rsID = statement.getGeneratedKeys();
            //TipKlijenta noviTip = new TipKlijenta();
            if (rsID.next()) {
                //noviTip.setNazivTipa(query);
                tipKlijenta.setSifraTipa(rsID.getLong(1));
            }
            rsID.close();
            statement.close();
            System.out.println("Vrednost generisanog primarnog kljuca je: " + tipKlijenta.getSifraTipa());
            return tipKlijenta;
        }catch (SQLException ex) {
            System.out.println("Neuspesno dodavanje objekta Tipa Klijenta u bazu!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    
    }*/
/*
    public List<TipKlijenta> popuniListuTipovaKlijenata() throws SQLException {
        String query = "SELECT * FROM tipklijenta";
        System.out.println("Upit:"+query);
        Statement statement = connection.createStatement();
        ResultSet rSet = statement.executeQuery(query);
        List<TipKlijenta> tipoviKlijenata = new ArrayList<>();
        while(rSet.next()){
            long sifra = rSet.getLong("sifraTipaKlijenta");
            String naziv = rSet.getString("nazivTipaKlijenta");
            TipKlijenta tipKlijenta = new TipKlijenta(sifra, naziv);
            tipoviKlijenata.add(tipKlijenta);
        }
        return tipoviKlijenata;
    }
*/
    /*
    public boolean addKlijent(Klijent klijent, List<Ugovor> ugovori) throws SQLException {
        //ovde prvo dodajes klijenta, pa dodajes ugvoor, pa dodajes taj spoljnji kljuc koji je generisan.
        String query = "INSERT INTO klijent(jmbgKlijenta, imeKlijenta, prezimeKlijenta, sifraTipaKlijenta) VALUES (?,?,?,?)";
        System.out.println("Upit:"+query);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, klijent.getJmbgKlijenta());
        statement.setString(2, klijent.getImeKlijenta());
        statement.setString(3, klijent.getPrezimeKlijenta());
        statement.setLong(4, klijent.getTipKlijenta().getSifraTipa());
        int affectedRows = statement.executeUpdate();
        
        //sada dodajemo ugovore:
           String queryUgovor = "INSERT INTO ugovor(jmbgKlijenta, brUgovora, adresaNekretnine, povrsinaNepokretnosti, sprat, datumZakljucenja) VALUES(?,?,?,?,?,?)";
           System.out.println("Upit:"+query);
           PreparedStatement statementUgovori = connection.prepareStatement(queryUgovor);        
        
        
        
        for (Ugovor ugovor:ugovori){
           statementUgovori.setString(1, klijent.getJmbgKlijenta());
           statementUgovori.setLong(2, ugovor.getBrojUgovora());
           statementUgovori.setString(3, ugovor.getAdresaNekretnine());
           statementUgovori.setDouble(4, ugovor.getPovrsinaNepokretnosti());
           statementUgovori.setInt(5, ugovor.getSprat());
           statementUgovori.setDate(6, new java.sql.Date(ugovor.getDatumZakljucenja().getTime()));
           statementUgovori.addBatch();
        }
        int[] rows = statementUgovori.executeBatch();
        if (rows.length>0){
            return true;
        }
       return false;
    }
    */
    /*
    public List<Agent> pretraziAgente(String ime) throws SQLException {
        String query = "SELECT * FROM agent WHERE imeAgenta=?";
        System.out.println("Upit:"+query);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,ime);
        ResultSet rs = statement.executeQuery();
        List<Agent> agenti = new ArrayList<>();
        while(rs.next()){
            long redBroj = rs.getLong("redniBrojURegistruPosrednika");
            String imeA = rs.getString("imeAgenta");
            String prezimeA = rs.getString("prezimeAgenta");
            String adresaA = rs.getString("adresaAgenta");
            double uspesnostRealizacije = rs.getDouble("uspesnostRealizacije");
            int brojKlijenata = rs.getInt("brojDodeljenihKlijenata");
            Agent agent = new Agent(redBroj,imeA,prezimeA,adresaA,uspesnostRealizacije,brojKlijenata);
            agenti.add(agent);
        }
        return agenti;
    }
*/
    /*
    public List<Klijent> pretraziKlijente(String imeKlijenta) throws SQLException {
        System.out.println("Stigao je u metodu za pretragu klijenata");
        List<Klijent> klijenti = new ArrayList<>();
        //SELECT * FROM klijent k JOIN tipklijenta tk ON (k.sifraTipaKlijenta=tk.sifraTipaKlijenta) WHERE imeKlijenta='Zoran' 
        //SELECT * FROM klijent k JOIN tipklijenta tk ON (k.sifraTipaKlijenta=tk.sifraTipaKlijenta) 
        //JOIN ugovor u ON(u.jmbgKlijenta = k.jmbgKlijenta) WHERE imeKlijenta='Zoran' 
        
        String query = "SELECT * FROM klijent k JOIN tipKlijenta tk ON (k.sifraTipaKlijenta=tk.sifraTipaKlijenta) WHERE imeKlijenta=?";
        System.out.println("Upit:"+query);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, imeKlijenta);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            //vise ntorki - result set ima npr. 3 reda koja se odnose na 2 klijenta - prva dva reda su prvi klijent Zoran, a treci red je 
            // drugi klijent Zoran, Kako to razlikovati? 
            
            
            //procita klijenta, procita ugovor - ako je jmbg klijenta jedna jmbgu na ugvoru onda dodajemo tom kljijentzu u njegovu listu taj ugovor
            
            
            //1. citanje klijenta - setovati sve sem liste ugovora. 
            Klijent klijent = new Klijent();
            //List<Ugovor> ugovori = new ArrayList<>();
            
            String jmbgKlijenta = resultSet.getString("k.jmbgKlijenta");
            klijent.setJmbgKlijenta(resultSet.getString("k.jmbgKlijenta"));
            klijent.setImeKlijenta(resultSet.getString("k.imeKlijenta"));
            klijent.setPrezimeKlijenta(resultSet.getString("k.prezimeKlijenta"));
            
            TipKlijenta tipKlijenta = new TipKlijenta();
            
            tipKlijenta.setSifraTipa(resultSet.getLong("tk.sifraTipaKlijenta"));
            tipKlijenta.setNazivTipa(resultSet.getString("tk.nazivTipaKlijenta"));
            klijent.setTipKlijenta(tipKlijenta);
            
            //2. za ucitanog klijenta pronaci sve ugovore koje ima. U metodi je setovan i klijent na svakog ugovora
            
            List<Ugovor> ugovori = getUgovori(klijent);
            klijent.setUgovori(ugovori);
            klijenti.add(klijent);
            
            //3. da li su iscitani ugovori za tog klijneta
            System.out.println("UGOVORI MOG KLIJENTA");
            for(Ugovor u : ugovori){
                System.out.println(u.getBrojUgovora());
            }
        }
        return klijenti;
    }
*/
    /*
    public List<Ugovor> getUgovori(Klijent k) throws SQLException {
        String query = "SELECT * FROM ugovor WHERE jmbgKlijenta=?";
        System.out.println("Upit:"+query);
        List<Ugovor> ugovori = new ArrayList<>();
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,k.getJmbgKlijenta());
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
            String jmbgUgovor = rs.getString("jmbgKlijenta");
            long brojU =rs.getLong("brUgovora");
            String adresaN = rs.getString("adresaNekretnine");
            double povrsina = rs.getDouble("povrsinaNepokretnosti");
            java.util.Date datumZakljucenja = new java.util.Date(rs.getDate("datumZakljucenja").getTime());
            int sprat = rs.getInt("sprat");
            Ugovor ugovor = new Ugovor(k, brojU, adresaN,povrsina, sprat, datumZakljucenja);
            ugovori.add(ugovor);
        }
    
        return ugovori;
    }
       */  
    public boolean updateKlijent(Klijent klijent, String stariJMBG) throws SQLException{
        String query = "UPDATE klijent SET jmbgKlijenta=?, imeKlijenta=?, prezimeKlijenta=?, sifraTipaKlijenta=? WHERE jmbgKlijenta=?";
        System.out.println("Upit:"+query);
        System.out.println("NOVI JMBG:"+klijent.getJmbgKlijenta()+" STARI JMBG: "+stariJMBG);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, klijent.getJmbgKlijenta());
        statement.setString(2, klijent.getImeKlijenta());
        statement.setString(3, klijent.getPrezimeKlijenta());
        statement.setLong(4, klijent.getTipKlijenta().getSifraTipa());
        statement.setString(5,stariJMBG);
        System.out.println("SETOVANI SU SVI UPITNICI");
        System.out.println("Pre linije kod affected rows");
        int affectedRows =0;                                                //dodat je jedan upit za update primarnog kljuca tog Klijent objekta
        try{
            affectedRows = statement.executeUpdate();  
        
        }catch(Exception ex){
            System.out.println("CATCH BLOK OD AFFECTED ROWS.");
            ex.printStackTrace();
        }
        //statement.close();
        System.out.println("RED JE AFFEKTOVAN ZA KLIJENTA, OK - ova poruka mi se ne ispisuje.");
        //sada dodajemo ugovore:
       /*
       if(affectedRows>0){
           return true;
       }
       return false;
        */
       
       //SADA JE ON ZAMENIO I ZA TE UGOVORE JMBG KLIJENTA, HAJDE DA SE POZABAVIMO PODACIMA O UGOVORIMA.
       
       //PreparedStatement statementUgovori = DatabaseConnection.getInstance().getConnection().prepareStatement(queryUgovor);        
        
    
       String queryUgovor = "UPDATE ugovor SET jmbgKlijenta=?, brUgovora=?, adresaNekretnine=?,povrsinaNepokretnosti=?, sprat=?, datumZakljucenja=? WHERE jmbgKlijenta=? AND brUgovora=?";
       PreparedStatement statementUgovori = connection.prepareStatement(queryUgovor);
        for (Ugovor ugovor:klijent.getUgovori()){ // proci kroz ugovore tog klijenta
            
            
            System.out.println("UGOVOR NAD KOJIM SE RADI: -----------------------------------------------------------------");
            System.out.println(ugovor);
            
            
           //String queryUgovor = "UPDATE ugovor SET jmbgKlijenta=?, brUgovora=?, adresaNekretnine=?,povrsinaNepokretnosti=?, sprat=?, datumZakljucenja=? WHERE jmbgKlijenta=? AND brUgovora=?";
           //ja ovakvu vrstu update-a u  svojoj bazi ne mogu da uradim.
            try{
          // statementUgovori = DatabaseConnection.getInstance().getConnection().prepareStatement(queryUgovor);    
            System.out.println("Usao je u for petlju ugovora za tog klijenta.");
           statementUgovori.setString(1, klijent.getJmbgKlijenta());
            System.out.println("Setovan jmbg klijenta u ugovoru");
           statementUgovori.setLong(2, ugovor.getBrojUgovora());
            System.out.println("Setovan br ugovora klijenta u ugovoru");
           statementUgovori.setString(3, ugovor.getAdresaNekretnine());
            System.out.println("Setovan adresa nekr klijenta u ugovoru");
           statementUgovori.setDouble(4, ugovor.getPovrsinaNepokretnosti());
            System.out.println("Setovan povrsina nepokretnosti ugovora klijenta u ugovoru");
           statementUgovori.setInt(5, ugovor.getSprat());
            System.out.println("Setovan sprat klijenta u ugovoru");
           
            statementUgovori.setDate(6, new java.sql.Date(ugovor.getDatumZakljucenja().getTime()));
           
            System.out.println("Setovan date klijenta u ugovoru");
           statementUgovori.setString(7, stariJMBG);
           statementUgovori.setLong(8, ugovor.getBrojUgovora());
            System.out.println("Setovao je sve atribute za ugovor");
           System.out.println("Upit:"+queryUgovor); 
           
           statementUgovori.addBatch(); // dodaje se jedan ugovor na gomilu upita
           
            }catch(Exception ex){ex.printStackTrace();}
        }
        int[] rows=null;
        try{
            rows = statementUgovori.executeBatch();
        }catch(Exception ex){System.out.println("EXECUTE BATCH"); ex.printStackTrace();}
        
        if (rows.length>0){
            System.out.println("Broj updateovanih redova - rows:" + rows.length);
            return true;
        }
       return false;
        
    
    
    } 
/*
    public boolean updateAgent(Agent noviAgent, long redniBrojURegistruPosrednika) throws SQLException {
        String query = "UPDATE agent SET redniBrojURegistruPosrednika=?, imeAgenta=?, prezimeAgenta=?, adresaAgenta=?, uspesnostRealizacije=?, brojDodeljenihKlijenata=? WHERE redniBrojURegistruPosrednika=?";
        System.out.println("Upit: " + query);
        
        PreparedStatement statement=null;
        System.out.println("Pre setovanja upitnika");
        try{
        statement = connection.prepareStatement(query);
        statement.setLong(1,noviAgent.getRedniBrojURegistruPosrednika());
        statement.setString(2, noviAgent.getImeAgenta());
        statement.setString(3, noviAgent.getPrezimeAgenta());
        statement.setString(4, noviAgent.getAdresaAgenta());
        statement.setDouble(5, noviAgent.getUspesnostRealizacije());
        statement.setInt(6, noviAgent.getBrojDodeljenihKlijenata());
        statement.setLong(7,redniBrojURegistruPosrednika);
        }catch(Exception ex){ex.printStackTrace();}
        System.out.println("Presao je setovanje upitnikas");
        int affectedRows=0;
        try{
        affectedRows = statement.executeUpdate();
        
        }catch(Exception ec){ec.printStackTrace();}
        return affectedRows>0;
    
    }
*/
    /*
    public boolean deleteAgent(Agent agent) throws SQLException {
        String query = "DELETE FROM agent WHERE redniBrojURegistruPosrednika=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1,agent.getRedniBrojURegistruPosrednika());
        int affectedRows = statement.executeUpdate();
        return affectedRows>0;
    }
*/
    public Connection getConnection() {
        return connection;
    }
/*
    public List<Agent> getAllAgenti() throws SQLException {
        String query = "SELECT * FROM agent";
        Statement statement = connection.createStatement();
        ResultSet rSet = statement.executeQuery(query);
        List<Agent> agenti = new ArrayList<>();
        while(rSet.next()){
            long rbroj = rSet.getLong("redniBrojURegistruPosrednika");
            String ime = rSet.getString("imeAgenta");
            String prezime = rSet.getString("prezimeAgenta");
            String adresa = rSet.getString("adresaAgenta");
            double uspesnost = rSet.getDouble("uspesnostRealizacije");
            int brKl = rSet.getInt("brojDodeljenihKlijenata");
            Agent a = new Agent(rbroj, ime,prezime,adresa, uspesnost,brKl);
            agenti.add(a);
        }
        return agenti;
    }
*/
    public List<Ugovor> getAllUgovori() throws SQLException, SQLException, SQLException {
        System.out.println("POCETAK GET ALL UGOVORI"); 
        String query = "SELECT * FROM ugovor u JOIN klijent k ON (u.jmbgKlijenta = k.jmbgKlijenta) JOIN tipklijenta t ON (t.sifraTipaKlijenta=k.sifraTipaKlijenta)";
        Statement statement = connection.createStatement();
        ResultSet rSet = statement.executeQuery(query);
        List<Ugovor> ugovori = new ArrayList<>();
        while(rSet.next()){
            String jmbg = rSet.getString("k.jmbgKlijenta");
            long brUgovora = rSet.getLong("u.brUgovora");
            String adresaNek = rSet.getString("u.adresaNekretnine");
            double povrsina = rSet.getDouble("u.povrsinaNepokretnosti");
            java.util.Date datum = new java.util.Date(rSet.getDate("datumZakljucenja").getTime());
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
            System.out.println("VRATIO JE UGOVORE IZ BAZE.");
        return ugovori;
  
    }
    
    //1. dodaje angazovanje

    public boolean createAngazovanje(Angazovanje a) throws SQLException {
        String query = "INSERT INTO angazovanje(redniBrojAngazovanja, provizija, realizovano, redniBrojURegistruPosrednika, jmbgKlijenta, brUgovora, menadzerId) VALUES(?,?,?,?,?,?,?)";
        System.out.println("Upit:"+query);
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setLong(1, a.getRbAngazivanja());
        statement.setDouble(2,a.getProvizija());
        if(a.isRealizovano())
            statement.setInt(3,1);
        else
            statement.setInt(3,0);
        
        statement.setLong(4,a.getAgent().getRedniBrojURegistruPosrednika());
        statement.setString(5, a.getUgovor().getKlijent().getJmbgKlijenta());
        statement.setLong(6,a.getUgovor().getBrojUgovora());
        statement.setLong(7, a.getMenadzer().getMenadzerId());
        
        int affectedRows = statement.executeUpdate();
        System.out.println("SISTEM UNEO NOVO ANGAZOVANJE");
        if(affectedRows<=0){
            return false;
        }
       
        
    //2. sad ovde za ovog agenta moramo da povecamo broj dodeljenih klijenata
        
        String queryBrojDodeljenihKlijenata= "SELECT brojDodeljenihKlijenata+1 AS broj FROM agent WHERE redniBrojURegistruPosrednika=?";
        PreparedStatement statement2 = connection.prepareStatement(queryBrojDodeljenihKlijenata);
        statement2.setLong(1, a.getAgent().getRedniBrojURegistruPosrednika());
        ResultSet rs = statement2.executeQuery();
        long brojKlijenata=0;
        while(rs.next()){
            brojKlijenata = rs.getLong("broj");
        }
        
        
        System.out.println("SISTEM JE VRATIO BROJ DODELJENIH KL + 1"+brojKlijenata);
        
        //return affectedRows>0; 
        
        
        String queryUpdateBrDodeljenih = "UPDATE agent SET brojDodeljenihKlijenata=? WHERE redniBrojURegistruPosrednika=?";
        PreparedStatement statement3 = connection.prepareStatement(queryUpdateBrDodeljenih);
        statement3.setLong(1, brojKlijenata);
        statement3.setLong(2, a.getAgent().getRedniBrojURegistruPosrednika()); 
        int ar = statement3.executeUpdate();
        System.out.println("USPESNO JE POVECAO BR DODELJENIH KLIJENATA I UNEO ZA JEDAN VISE");
        
        //return ar>0;
           
        
    //3. racuna novu uspesnost realizacije 
    
        String queryRealizacija = "SELECT an.realizovano FROM agent a JOIN angazovanje an ON (a.redniBrojURegistruPosrednika = an.redniBrojURegistruPosrednika) WHERE a.redniBrojURegistruPosrednika=?";
        PreparedStatement statement4 = connection.prepareStatement(queryRealizacija);
        statement4.setLong(1, a.getAgent().getRedniBrojURegistruPosrednika());
        ResultSet rsRealizovano = statement4.executeQuery();
        
        int[] nizRealizovano = new int[100];
        int brojac = 0;
        while(rsRealizovano.next()){
            int element = rsRealizovano.getInt(1);
            nizRealizovano[brojac] = element;
            brojac++;
        }
        System.out.println("PRVA PETLJA JE OK");
    
        int suma = 0;
        double prosek = 0;
        
        for (int i=0;i<nizRealizovano.length;i++){
            if(nizRealizovano[i] == 1){
                suma++;
            }
        }
        prosek = (double)suma / brojac;
        System.out.println("PROSEK " + prosek);
        
        
        String queryUpdateUspesnost = "UPDATE agent SET uspesnostRealizacije=? WHERE redniBrojURegistruPosrednika=?";
        PreparedStatement statement5 = connection.prepareStatement(queryUpdateUspesnost);
        statement5.setDouble(1,prosek);
        statement5.setLong(2, a.getAgent().getRedniBrojURegistruPosrednika());
        int afR = statement5.executeUpdate();
        //ugovor ne sme biti vec dodeljen        
        return afR>0;
        
        
    }    
  /*  
    public long getBrojKlijenata(Angazovanje a){
        try {
            String queryBrojDodeljenihKlijenata= "SELECT brojDodeljenihKlijenata+1 AS broj FROM agent WHERE redniBrojURegistruPosrednika=?";
            PreparedStatement statement2 = connection.prepareStatement(queryBrojDodeljenihKlijenata);
            statement2.setLong(1, a.getAgent().getRedniBrojURegistruPosrednika());
            ResultSet rs = statement2.executeQuery();
            long brojKlijenata=0;
            while(rs.next()){
                brojKlijenata = rs.getLong("broj");
            }
            System.out.println("SISTEM JE VRATIO BROJ DODELJENIH KL + 1"+brojKlijenata);
            return brojKlijenata;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    */
    public List<StatistikaAgenata> vratiStatistikuAgenata() throws SQLException{
        List<StatistikaAgenata> lista = new ArrayList<>();
        String query = "SELECT ag.imeAgenta, ag.prezimeAgenta, SUM(an.provizija) AS provizija, ag.uspesnostRealizacije, ag.brojDodeljenihKlijenata, SUM(an.realizovano)\n" +
                       "FROM agent ag JOIN angazovanje an ON (an.redniBrojURegistruPosrednika = ag.redniBrojURegistruPosrednika) JOIN ugovor u ON(u.brUgovora=an.brUgovora)\n" +
                    
                       "GROUP BY ag.redniBrojURegistruPosrednika\n" +
                       "ORDER BY SUM(an.provizija) DESC";
        
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        while(rs.next()){
            String imeA = rs.getString("ag.imeAgenta");
            String prezimeA = rs.getString("ag.prezimeAgenta");
            double ukupnaProvizija = rs.getDouble("provizija");
            double uspesnostR = rs.getDouble("ag.uspesnostRealizacije");
            int brojDodeljenihKlijenata = rs.getInt("ag.brojDodeljenihKlijenata");
            int realizovanihKlijenata = rs.getInt("sum(an.realizovano)");
            
            StatistikaAgenata stA = new StatistikaAgenata(imeA, prezimeA, ukupnaProvizija, uspesnostR, brojDodeljenihKlijenata,realizovanihKlijenata);
            lista.add(stA);
        
        }
        
        
        
        return lista;
    }
    
    public void add(DomainObject domainObject) throws SQLException{
        String query = "INSERT INTO "+domainObject.getTableName() +" ("+domainObject.getColumnsForInsert()+") VALUES"+domainObject.getParamsForInsert();
            
        System.out.println(query);
        //pravljenje objekta odgovornog za izvrsenje upita.
        PreparedStatement statement = connection.prepareStatement(query);
        //postavljanje vrednosti parametra - DomainObject prima statement instancu i domenski objekat
        domainObject.setParamsForInsert(statement, domainObject);
        
        //izvrsavanje upita 
        int result = statement.executeUpdate();
        System.out.println(result);
        
    }
    
    public boolean addObject(DomainObject domainObject) throws SQLException{
        String query = "INSERT INTO "+domainObject.getTableName() +" ("+domainObject.getColumnsForInsert()+") VALUES"+domainObject.getParamsForInsert();
            
        System.out.println(query);
        //pravljenje objekta odgovornog za izvrsenje upita.
        PreparedStatement statement = connection.prepareStatement(query);
        //postavljanje vrednosti parametra - DomainObject prima statement instancu i domenski objekat
        domainObject.setParamsForInsert(statement, domainObject);
        
        //izvrsavanje upita 
        int result = statement.executeUpdate();
        System.out.println(result);
        if(result<=0)
            return false;
        return true;
    }
    
    public List<DomainObject> getAll(DomainObject domainObject){

        String query = "SELECT "+ domainObject.getColumnsForSelect()+" FROM "+domainObject.getTableName();
        List<DomainObject> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rSet = statement.executeQuery(query);
            resultList = domainObject.getListOfAllObjects(rSet);
            return resultList;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public List<DomainObject> getAllWithCondition(DomainObject domainObject){ // ovaj obj mora da primi ime klijenta
        String query = "SELECT "+domainObject.getColumnsForSelect()+" FROM "+domainObject.getTableNameJoin()+" WHERE "+domainObject.getSelectCondition();
        System.out.println(query);
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            domainObject.setParamsForSelect(statement, domainObject);
            ResultSet rSet = statement.executeQuery();
            List<DomainObject> resList = domainObject.getListOfAllObjects(rSet);
            return resList;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
            return null;
           
    }
    
    public boolean edit(DomainObject newDObject, DomainObject oldDObject){
        String query = "UPDATE "+newDObject.getTableName()+" SET "+newDObject.getUpdateValues()+" WHERE"+oldDObject.getUpdateCondition();
        System.out.println(query);
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            newDObject.setParamsForUpdate(statement, oldDObject, newDObject);
            int affectedRows = statement.executeUpdate();
            return affectedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        //return false;
    }
    
    public boolean delete(DomainObject domainObject){
        String query = "DELETE FROM "+domainObject.getTableName()+" WHERE"+domainObject.getDeleteCondition();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            domainObject.setParamsForDelete(statement, domainObject);
            int affectedRows = statement.executeUpdate();
            return affectedRows>0;
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

      //  return false;
    }
    
    
    
}
