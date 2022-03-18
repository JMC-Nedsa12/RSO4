
/**
 * Write a description of class Zapis here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Zapis
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Zapis
     */
    public Zapis()
    {
        // initialise instance variables
        upor="";
        rez=0;
        st=0;
    }

    public Zapis(String upor,int rez,int st)
    {
        setZapis(upor,rez,st);

    }
    public Zapis(String upor,int rez)
    {
        setZapis(upor,rez,1);

    }
    public void setZapis(String upor,int rez,int st){
        this.upor=upor;
        this.rez=rez;
        this.st=st;   
    }

    public String getUpor(){return upor;}

    public int getRez(){return rez;}

    public int getSt () {return st;}

    public String toString(){
        return upor+" "+rez+" "+st;
    }

    private String upor;
    private int rez;
    private int st;
}
