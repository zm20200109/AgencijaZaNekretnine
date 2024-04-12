/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

/**
 *
 * @author Korisnik
 */
//import configs.Configs;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    
    private static Connection connection;
    private static DatabaseConnection instance;
    private List<Connection> connectionPool;
    
    
    
    private DatabaseConnection() throws SQLException {
        
        connectionPool = new ArrayList<>();
        //Configs.SaveProperty();
        for(int i=0;i<100;i++){
            try{
                String url = "jdbc:mysql://localhost:3306/agencija_za_nekretnine_3";
                String username = "root";
                String password = "";
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Konekcija sa bazom podataka je uspostavljena!");
                connection.setAutoCommit(false);
                connectionPool.add(connection); //dodaje ovde 7 konekcija odmah cim se jedanput pozove konstruktor DatabaseConnection()
            }catch(SQLException ex){
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!"+ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }
    }
    
    public synchronized void push(Connection connection){
        connectionPool.add(connection); // 
    }
    
    
    public synchronized Connection pop() throws Exception{ //U klasi AbstractSO se radi push(), a pop() cemo na logout operaciji
        if(connectionPool.isEmpty()){
            throw new Exception("Connection pool je prazan.");
        }
        Connection connection = connectionPool.get(0);
        connectionPool.remove(connection);
        return connection;
    
    }
    
    
    /*
    public void commit() throws SQLException {
        try {
            connection.commit();
            System.out.println("Transakcija uspesno potvrdjena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije potvrdjena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
    
        public void rollback() throws SQLException {
        try {
            connection.rollback();
            System.out.println("Transakcija uspesno ponistena!");
        } catch (SQLException ex) {
            System.out.println("Transakcija nije ponistena!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }
    
    public void disconnect() throws SQLException {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Konekcija sa bazom uspesno raskinuta!");
            }
        } catch (SQLException ex) {
            System.out.println("Greska! Konekcija sa bazom nije uspesno raskinuta!\n" + ex.getMessage());
            ex.printStackTrace();
            throw ex;
        }
    }*/

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null){
            System.out.println("Instanca DbKonekcije je null, pa cemo krwirati novu konekciju"); //evo ovde konekcija ne postoji, ali postoji instanca dbConnection. zato je ona metoda, a ne konstruktpor
            instance = new DatabaseConnection();
        //ovde se desava problem da je konekcija zatvorena, ali mi vec imamo instancu db brokera. kako pristupiti konekciji, pa treba mi metoda connect
        }
        System.out.println("KREIRANA JE NOVA KONEKCIJA I VRACA SE INSTANVCA KONEKCIJE");
        return instance;
    }

    public static Connection getConnection() {
        return connection;
    }
        
    
    

 
    
    
    
    
}
