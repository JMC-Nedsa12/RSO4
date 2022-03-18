public class nal1{
    public static void main(String [] a){
        nal1 object= new nal1();
        object.rekurzija(20,200);
    }
    void rekurzija(int a, int b){
        if (a<b){
            int temp = b;
            b=a;
            a=temp;
        }
        if (a>b+1){
            a--;
            System.out.println(a);
            rekurzija(a,b);
        }
      
    }
}