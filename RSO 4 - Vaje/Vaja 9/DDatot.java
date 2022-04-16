
/**
 * Objekt, shranjuje ime datoteke in njen hash diggest
 *
 * @author JanTrsan
 * @version 1.0
 */
public class DDatot{
    private String imeDatoteke, diggest;

    public DDatot(String ime, String hash){
        this.imeDatoteke=ime;
        this.diggest=hash;
    }

    public String getImeDatoteke(){return this.imeDatoteke;}

    public String getDiggest(){return this.diggest;}

    public String toString(){ 
        return ("ime programa: "+this.getImeDatoteke()+"       hash/diggest: "+this.getDiggest());
    }
}
