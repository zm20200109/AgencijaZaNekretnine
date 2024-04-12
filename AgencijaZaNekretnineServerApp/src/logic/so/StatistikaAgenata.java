/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import java.util.List;

/**
 *
 * @author Korisnik
 */
public class StatistikaAgenata extends AbstractSO{

    public StatistikaAgenata() throws Exception {
        super();
    }

    List<domain.StatistikaAgenata> statistikaResult;

    public List<domain.StatistikaAgenata> getStatistikaResult() {
        return statistikaResult;
    }
    
    
    
    @Override
    protected void validate(Object argument) throws Exception {
    }

    @Override
    protected void executeOperation(Object argument) throws Exception {
        List<domain.StatistikaAgenata> agenti = dbbr.vratiStatistikuAgenata();
        statistikaResult = agenti;
    }
    
}
