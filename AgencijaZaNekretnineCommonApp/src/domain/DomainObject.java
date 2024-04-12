/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Korisnik
 */
public abstract class DomainObject {
    
    public abstract String getTableName();
    public abstract String getColumnsForInsert();
    public abstract String getParamsForInsert();
    public abstract void setParamsForInsert(PreparedStatement statement,DomainObject domainObject) throws SQLException;
    public boolean containsAutoIncrementPK(){
        return true;
    }
    public abstract void setAutoIncrementPrimaryKey(long primaryKey);
    public abstract List<DomainObject> getListOfAllObjects(ResultSet resultSet);
    public abstract String getColumnsForSelect();
    public abstract String getSelectCondition();
    public abstract String getTableNameJoin();
    public abstract void setParamsForSelect(PreparedStatement statement, DomainObject domainObject) throws SQLException;
    public abstract String getUpdateCondition();
    public abstract String getUpdateValues();
    public abstract void setParamsForUpdate(PreparedStatement statement, DomainObject oldDObject, DomainObject newDObject) throws SQLException;
    public abstract String getDeleteCondition();
    public abstract void setParamsForDelete(PreparedStatement statement, DomainObject domainObject);
}
