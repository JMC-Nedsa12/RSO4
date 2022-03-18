public class Naloga3{
    public static void main(String [] args){
        Naloga3 obj=new Naloga3();
        int n=60;
        int i=1;
        double a7=7;
        double a6=3;
        double a5=2;
        double a4=1;
        double a3=0;
        System.out.print("1,0,"+a3+","+a4+","+a5+","+a6+",");
        obj.rekurzija(n,i,a7,a6,a5,a4,a3);
    }
    void rekurzija(int n, int i, double a7, double a6, double a5, double a4, double a3){
        if (i<=n){
            a7=a6+a5+2*a4+a3;
            a3=a4;
            a4=a5;
            a5=a6;
            a6=a7;
            i++;
            System.out.print(a7+",");
            rekurzija(n,i,a7,a6,a5,a4,a3);
        }
        else {
        System.out.println(a7);
        return;}
        return;
    }
}
