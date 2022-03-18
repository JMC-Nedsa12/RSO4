public class Naloga2{
    public static void main(String [] args){
        Naloga2 obj=new Naloga2();
        int n=8;
        int i=7;
        double a7=7;
        double a6=3;
        double a5=2;
        double a4=1;
        double a3=0;
        
        obj.rekurzija(n,i,a7,a6,a5,a4,a3);
    }
    void rekurzija(int n, int i, double a7, double a6, double a5, double a4, double a3){
        switch(n){
            case 1:
                System.out.println(1);return;
            case 2:
                System.out.println(0);return;
            case 3:
                System.out.println(0);return;
            case 4:
                System.out.println(1);return;
            case 5:
                System.out.println(2);return;
            case 6:
                System.out.println(3);return;        
        }
        if (i<=n){
            a7=a6+a5+2*a4+a3;
            a3=a4;
            a4=a5;
            a5=a6;
            a6=a7;
            i++;
            rekurzija(n,i,a7,a6,a5,a4,a3);
        }
        else {
        System.out.println(a7);
        return;}
        return;
    }
}