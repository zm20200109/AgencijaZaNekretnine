/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configs;

import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author Korisnik
 */
public class Configs {
    
    public static Properties prop = new Properties();
    
    public static void SaveProperty(){
        try{
            //fajl u koji je potrebno upisati ove vrednosti:
            FileOutputStream output = new FileOutputStream("config.properties");
            
            
            //setovanje propety vrednosti:
            prop.setProperty("db.url","jdbc:mysql://localhost:3306/agencija_za_nekretnine_3");
            prop.setProperty("db.user","root");
            prop.setProperty("db.password", "");
        
            //čuvanje vrednosti u jedan config.properties fajl
            prop.store(output,"Database Configuration");
            System.out.println("config.properties file is created successfully.");
        }
        catch(IOException e){
        
            e.printStackTrace();
        }
    
    }
    
    
}
