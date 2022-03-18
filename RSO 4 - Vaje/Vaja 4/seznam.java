import java.util.*;
public class seznam{
    class Vozlisce{
        private String vrednost;
        private Vozlisce nasl;
        
        public Vozlisce(String vrednost){
            this.vrednost=vrednost;
        }
        
        public Vozlisce getNasl(){
            return this.nasl;
        }
        
        public String getVrednost(){
            return this.vrednost;
        }
        
        public void setNasl(Vozlisce v){
            this.nasl=v;
        }
        
        public void setVrednost(){
            this.vrednost=vrednost;
        }
    }
    private Vozlisce sez=null;
    public void dodajZacetek(String a){
        if (sez==null){
            sez=new Vozlisce(a);
            return;
        }
        Vozlisce v=new Vozlisce(a);
        v.nasl=sez;
        sez=v;
        
    }
    public void dodajKonec(String a){
        if (sez==null){
            sez=new Vozlisce(a);
            return;
        }
        if (sez.nasl!=null){
            sez=sez.nasl;
            dodajKonec(a);
        }
    }
    public void izpisiReversed(Vozlisce v){
        if (v.nasl!=null){
            izpisiReversed(v.nasl);
            System.out.println(v.vrednost);
        }
        else{
             System.out.println(v.vrednost);
        }
        return;
    }
    public void izpisiInOrder(Vozlisce v){
        if(v.vrednost!=null){
            System.out.println(v.vrednost);
            if(v.nasl!=null){
                izpisiInOrder(v.nasl);
            }
            return;
        }
    }
    public void test(){
        for (int i=0; i<=10;i++){
            dodajZacetek("1"+i);
        }
        izpisiReversed(sez);
        System.out.println();
        izpisiInOrder(sez);
    }
}
