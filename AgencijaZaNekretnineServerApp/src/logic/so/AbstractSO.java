/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import database.DatabaseBroker;
import database.DatabaseConnection;
import java.sql.SQLException;

/**
 *
 * @author Korisnik
 */
public abstract class AbstractSO {
    
    protected DatabaseBroker dbbr;
    //protected Object result;

    public AbstractSO() throws Exception {
        dbbr = new DatabaseBroker(DatabaseConnection.getInstance().pop());  //ON OVDE UZIMA JEDNU KONEKCIJU IZ CONNECTION POOL -A!!!
    }
    
    //svaka so se izvrsava tako sto se prvo validiraju podaci, pa se izvrsava operacija, komituje se, pa ukoliko nije dobra, rollbackuje
    public void execute(Object argument) throws Exception{
        
        try{
            System.out.println("Usao u so.execute()");
            validate(argument);
            executeOperation(argument);
            commit();
        
        }catch (Exception ex){
            rollback();
            throw ex;
        }
    
    
    }


    protected abstract void validate(Object argument) throws Exception;
    
    protected abstract void executeOperation(Object argument) throws Exception;
    
    protected void commit() throws SQLException{
        dbbr.getConnection().commit();
    }
    
    protected void rollback() throws SQLException{
        dbbr.getConnection().rollback();
    }
    /*
    public Object getResult(){
        return result;
    }*/
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
