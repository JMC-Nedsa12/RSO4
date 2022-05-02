
/**
 * Write a description of class tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester{
    public static void main()throws Exception{
        for (int i=1;i<46;i++){
            String[] a={"podatki.bin",String.valueOf(i)};
            EnaC.main(a);
            System.out.println("----------------------------");
        }
    }
}
