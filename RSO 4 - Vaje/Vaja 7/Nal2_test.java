import java.util.*;
public class Nal2_test{
    void testing(){
        Scanner x = new Scanner(System.in);
        String beseda= x.next();
        for(int i =0; i< beseda.length();i++){
            Thread t = new Thread ( new Nit_ascii (beseda.charAt(i)));
            t.start();
            try{
                t.join();
            }catch(InterruptedException e){}
        }
        for (int i = 0; i<100; i++){
            System.out.println(beseda);
        }
        System.out.println("... in konec");
    }
}
