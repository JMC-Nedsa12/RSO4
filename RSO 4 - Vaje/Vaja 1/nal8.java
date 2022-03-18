import java.util.*;
class nal8{
    public static void main(String [] args){
        Scanner x = new Scanner(System.in);
        nal8 obj = new nal8();
        int a = x.nextInt();
        int b = x.nextInt();
        System.out.println(obj.rekurzija(a, b));
    }
    int rekurzija(int a, int b){
        if (b == 0){
            return a;
        } else {
            return rekurzija(b, a % b);
        }
    }
}