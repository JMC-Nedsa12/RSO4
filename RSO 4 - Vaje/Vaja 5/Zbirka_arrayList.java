
import java.util.*;
/**
 * Write a description of class Zbirka_arrayList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Zbirka_arrayList{
    private ArrayList  tt;

    public Zbirka_arrayList(){
        tt = new ArrayList<Zapis>();
        tt.add(0,new Zapis ("joco",3,1));
        tt.add(1,new Zapis ("pero",300,1));
    }

    public void vstaviZapisVZbirko(Zapis z){
        Zapis l;
        if((l=vrniZapis(z.getUpor()))!=null){
            if(z.getRez()>l.getRez())
                l.setZapis(z.getUpor(),z.getRez(),l.getSt()+1);
            else
                l.setZapis(z.getUpor(),l.getRez(),l.getSt()+1);
        }else{l=(Zapis)tt.get(tt.size()-1);
            if(z.getRez()>l.getRez())
                tt.add(z);

        }
        sort();
    }

    public Zapis vrniZapis(String ime){
        Zapis t=null;
        for(int i=0;i<tt.size();i++){
            Zapis a=(Zapis)tt.get(i);
            if(a.getUpor().equals(ime)){
                t=(Zapis)tt.get(i);
            }
        }
        return t;
    }

    public void sort(){
        for(int i=0;i<tt.size();i++){
            for(int j=0;j<tt.size();j++){
                try{
                    Zapis a = (Zapis)tt.get(j);
                    Zapis b = (Zapis)tt.get(j+1);
                if(a.getRez()<b.getRez()){
                    Zapis tmp=(Zapis)tt.get(j);
                    tt.set(j,b);
                    tt.set(j+1,tmp);
                }
                }catch(IndexOutOfBoundsException e){break;}
            }
        }
    }

    public ArrayList getZbirka(){
        return tt;
    }

    public String toString(){
        String out="";
        for ( int i = 0; i< tt.size();i++) {
            out += (Zapis)tt.get(i) + "\n";
        }

        return out;
    }

}
