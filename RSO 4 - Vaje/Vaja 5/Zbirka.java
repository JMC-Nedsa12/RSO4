
/**
 * Write a description of class Zbirka here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zbirka
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Zbirka
     */
    public Zbirka()
    {
        // initialise instance variables
        tt=new Zapis[10];
        //?branje zapisov datoteke
        for(int i=1;i<10;i++){
            tt[i]=new Zapis();
        }
        tt[0]=new Zapis("joco",3,1); 
        tt[7]=new Zapis("pero",300,1); 
    }

    public void vstaviZapisvzbirko(Zapis z){
        Zapis l;
        if((l=vrniZapis(z.getUpor()))!=null){
            if(z.getRez()>l.getRez())
                l.setZapis(z.getUpor(),z.getRez(),l.getSt()+1);
            else
                l.setZapis(z.getUpor(),l.getRez(),l.getSt()+1);
        }else{l=tt[9];
            if(z.getRez()>l.getRez())
                tt[9]=z;

        }
        sort();
    }

    public Zapis vrniZapis(String ime){
        Zapis t=null;
        for(int i=0;i<9;i++){
            if(tt[i].getUpor().equals(ime)){
                t=tt[i];
            }
        }
        return t;
    }

    public void sort(){
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++){
                if(tt[j].getRez()<tt[j+1].getRez()){
                    Zapis tmp=tt[j];
                    tt[j]=tt[j+1];
                    tt[j+1]=tmp;
                }
            }
    }

    public Zapis[] getZbirka(){
        return tt;
    }

    public String toString(){
        String out="";
        for ( Zapis el : tt) {
            out += el + "\n";
        }

        return out;
    }

    private Zapis tt[];
}
