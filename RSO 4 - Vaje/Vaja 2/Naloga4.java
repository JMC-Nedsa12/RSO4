import java.util.*;
public class Naloga4{
    public static void main(String [] args){
        Naloga4 obj = new Naloga4();
        Scanner x = new Scanner (System.in);
        double a1=1;
        double a2=3;
        double i=3;
        double an=0;
        obj.rekurzija(x.nextInt(),1,3,i,an);
        //i=1;
        System.out.print("1 2");
        obj.rekurzija2(30,1,3,3,0);
    }
    double rekurzija(double n, double a1, double a2, double i, double an){
        switch((int )n){
            case 1: {System.out.println("1");return n;}
            case 2: {System.out.println("3");return n;}
        }
        double tmp=0;
        if(i<=n){   
            if(i%2==0){
                tmp=an;
                an=2*(a1+a2)-an;
                if(i==n){
                    System.out.println(an);
                }
                a2=an;
                a1=tmp;
                i++;
                rekurzija(n,a1,a2,i,an);
                return an;
            }
            else{
                an=2*a2-a1;
                if(i==n){
                    System.out.println(an);
                }
                tmp=a1;
                a1=a2;
                a2=an;
                i++;
                rekurzija(n,tmp,a1,i,a2);
                return an;
            }
        }
        return an;
    }
    double rekurzija2(double n, double a1, double a2, double i, double an){
        
        double tmp=0;
        if(i<=n){   
            if(i%2==0){
                tmp=an;
                an=2*(a1+a2)-an;                
                System.out.print(" "+ an + " ");                
                a2=an;
                a1=tmp;
                i=i+1;
                rekurzija2(n,a1,a2,i,an);
                return an;
            }
            else{
                an=2*a2-a1;        
                System.out.print(" "+ an + " ");
                tmp=a1;
                a1=a2;
                a2=an;
                i=i+1;
                rekurzija2(n,tmp,a1,i,a2);
                return an;
            }
        }
        return an;
    }
}