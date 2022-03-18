public class testNal3{
    public static void test(){
        KroEnPovSez sez = new KroEnPovSez();

        sez.dodaj(3);
        sez.dodaj(5);
        sez.dodaj(6);
        sez.dodaj(2);
        
        System.out.println(sez.prestejElemente());
    }
}