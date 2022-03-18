public class Naloga1{
    
    public static void main (String [] args){
        Naloga1 obj=new Naloga1();
        int i=1;
        double st=1;
        obj.rekurzija(i,st);
    }
    void rekurzija(int i, double st){
        if (i<=64){
            System.out.println("polje: "+ i + " št zrn: " + st);
            st=2*st;
            i++;
            rekurzija(i,st);
        }        
        return;
    }
}