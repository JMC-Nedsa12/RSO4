import java.util.Comparator;
/**
 * class Zapis__
 *
 *  realizira kontejner za pripadajoče podatke o uporabniku in njegovem igranju (id, rezultat, steviloPoskusov)
 *  zagotavlja vpis zapisa in vračanje posameznih vrednosti
 *  zagotavlja izpis zapisa v human-readable obliki
 *  
 *  naredi zapise primerljive, da jih lahko razvrščamo naraščajoče            Comparable-->compareTo
 *  naredi zapisa primerljive preko komparatorja za razvrščanje padajoče      + Comparator dol
 *  
 *  
 *  
 *  
 *  v uporabo s poljubno kolekcijo (pri nas ArrayList):
 *  
 *         private ArrayList<Zapis__> al;
 *                                  al.add(zapis);
 *                                  Collections.sort(al);     //min-max razvrščanje (privzeto) 
 *                                  Collection.sort(al,Zapis__.dol);  //max-min razvrščanje - uporabi Comparator z imenom dol
 *
 *  v uporabo s tabelo Zapis__-ov:
 *  
 *         private Zapis__ tt[];
 *                                  tt.vstaviZapis__VZbirko(zapis)
 *                                  Arrays.sort(tt,Zapis__.dol);
 *
 *
 * @author G4AB 
 * @version nov.2013
 */
public class Zapis__ implements Comparable<Zapis__>
{
      
    /**
     * konstruktor za objekte razreda Zapis__
     * kreira zapis in ga napolni z privzetimi (dummy) vrednostmi
     */
    public Zapis__()
    {
        // initialise instance variables
      upor="";
      rez=0;
      st=0;
    }
    
    /**
     *     zgolj za test, števila poskusov ne pošiljamo (ga določa lista sama)
     *  konstruktor za kreiranje zapisa z znanimi podatki
     *  
     *  @param upor - identifikacija uporabnika
     *  @param rez  - rezulta uporabnika
     *  @param st   - stevilo poskusov  
     */
    public Zapis__(String upor,int rez,int st)
    {
        setZapis__(upor,rez,st);
    }
    
    /**
     *  konstruktor za kreiranje zapisa z znanimi podatki
     *  
     *  @param upor - identifikacija uporabnika
     *  @param rez  - rezulta uporabnika
     */
    public Zapis__(String upor,int rez)
    {
        setZapis__(upor,rez,1);
    }
    
    /**
     *  setZapis__
     *  vpiše s parametrom podane vrednosti v zapis
     *  
     *  @param upor - identifikacija uporabnika
     *  @param rez  - rezulta uporabnika
     *  @param st   - stevilo poskusov
     */
    public void setZapis__(String upor,int rez,int st){
      this.upor=upor;
      this.rez=rez;
      this.st=st;   
    }
    
    /** geter za uporabnikovo identifikacijo
     *  @return upor
     */
    public String getUpor(){return upor;}
    
    /** geter za rezultat
     *  @return rez
     */
    public int getRez(){return rez;}
    
    /** geter za število poskusov
     *  @return st
     */
    public int getSt () {return st;}
    
    /**
     *  implementira metodo, ki jo zahteva interface Comparable
     *  vrača -1,0,1 : -1 v primeru, da je tekoči zapis 'manjši', 1 v primeru, da je primerjan (s parametrom podan) zapis 'manjši'
     *  in 0 v primeru, da sta enaka
     *  kriterij primerjave je polje 'zap' znotraj zapisa
     *  primerjava garantira izvedbo razvrščnaja strukture takih zapisov v naraščajočem redu (naravno)
     *  
     *  @param zapis za primerjavo
     *  @return rezultat_primerjave
     */
    public int compareTo(Zapis__ z){
        
        if ( this.rez == z.getRez() )
           return 0;
           
        if ( this.rez < z.getRez()   )
           return -1;
           
        return 1;   
    }
    
    /**
     *  preobložitev metode toString, da je izpis v humen-readable obliki
     *  uporabimo tudi za zapis v besedilno datoteko
     *  
     *  @return oblikovan niz (upor-rez-steviloPoskusov)
     */
    @Override
    public String toString(){
        return upor+"-"+rez+"-"+st;
    }
    
    /**
     *  komparator, ki omogoča razvrščanje v padajočem vrstnem redu, kot ga zahteva top10 realizacija
     *  realiziramo kot notranji (gnezden, inner) razred. V implementaciji realiziramo metodo compare
     *  kot negacijo metode compareTo
     *  mora biti javen, ker ga bomo uporabili iz Arrays.sort ali Collections.sort
     *  mora biti razreden, ker ga kličejo razredne metode Arrays.sort oz. Collections.sort
     *  pazi: notranji razred se obnaša kot lastnost objekta ! (glej dokumentacijo)
     */
    public static Comparator<Zapis__> dol = new Comparator<Zapis__>() {
 
        public int compare(Zapis__ z1, Zapis__ z2) {
          
          return z1.compareTo(z2)*-1;
 
        }
 
    };
    
    /** polje uporabnikove identifikacije */
    private String upor;
    /** rezultat uporabnika */
    private int rez;
    /** število poskusov za uporabnika */
    private int st;
}
