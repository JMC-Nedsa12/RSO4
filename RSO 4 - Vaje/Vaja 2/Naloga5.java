import java.util.*;
public class Naloga5{
    public static void main(String [] args){
        Naloga5 obj = new Naloga5();
        Scanner x = new Scanner (System.in);
        int a1=1;
        int a2=3;
        int i=3;
        int an=0;
        obj.rekurzija(x.nextInt(),1,3,i,an);
    }
    int rekurzija(int n, int a1, int a2, int i, int an){
        switch(n){
            case 1: {System.out.println("1");return n;}
            case 2: {System.out.println("3");return n;}
        }
        int tmp=0;
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
}