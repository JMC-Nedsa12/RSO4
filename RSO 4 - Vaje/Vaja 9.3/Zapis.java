import java.io.*;

/**
 * Objekt strukture iz csv
 *
 * @author JanTrsan
 * @version 1.0
 */
public class Zapis implements Serializable{
    private String ime,priim,ulica,mesto,opomba;
    private long st,posta;
    /**
     * Constructor for objects of class Zapis
     */
    public Zapis(String ime,String priim, String ulica, long st, String mesto, long posta, String opomba){
        this.ime=ime;
        this.priim=priim;
        this.ulica=ulica;
        this.st=st;
        this.mesto=mesto;
        this.posta=posta;
        this.opomba=opomba;
    }

    
    public String toString(){
        return (""+this.ime +"\n"+ this.priim+"\n"+this.ulica+"\n"+Long.valueOf(this.st)+"\n"+this.mesto+"\n"+Long.valueOf(this.posta)+"\n"+opomba+"\n"+"--------------------------------------");
    }  
    
    
}
