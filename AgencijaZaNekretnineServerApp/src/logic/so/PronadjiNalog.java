/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic.so;

import domain.Menadzer;

/**
 *
 * @author Korisnik
 */
public class PronadjiNalog extends AbstractSO{

    public PronadjiNalog() throws Exception {
        super();
    }

    private Menadzer menadzerResult;

    public Menadzer getMenadzerResult() {
        return menadzerResult;
    }
    
    
    
    @Override
    protected void validate(Object menadzer) throws Exception {
        if (menadzer == null){
            throw new Exception("Menadzer ne sme biti null!");
        }
        Menadzer mgr = (Menadzer) menadzer;
        String korisnickoIme = mgr.getKorisnickoIme();
        String lozinka = mgr.getLozinka();
        if(lozinka.isEmpty() || korisnickoIme.isEmpty()){
            throw new Exception("Korisničko ime i lozinka ne smeju biti prazan string!");
        }
        if(lozinka.matches(".*[0-9]+.*") == false){
            throw new Exception("Lozinka mora da ima bar jednu cifru 0-9!");
        }
        if(lozinka.matches(".*[!?@#$]+.*") == false){
            throw new Exception("Lozinka mora imati bar jedan specijalni karakter!");
        }
        if(lozinka.matches("^.{8,}$") == false){
            throw new Exception("Lozinka mora imati bar osam karaktera!");
        }
        if(lozinka.matches(".*[A-Z].*") == false){
            throw new Exception("Lozinka mora imati bar 1 veliko slovo!");
        }
        
    }

    @Override
    protected void executeOperation(Object menadzer) throws Exception {
        this.menadzerResult=dbbr. getMenadzer((Menadzer)menadzer);
    }
    
    
}
