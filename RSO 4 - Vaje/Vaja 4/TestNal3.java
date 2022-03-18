public class TestNal3{
    public static void TestNal3(){
        KroEnPovSez sez = new KroEnPovSez();
        sez.dodaj('ž');
        //sez.showSezFirst2Last(sez.getPrvi());
        sez.dodaj("deeehllzzzz");
        sez.dodaj('c');
        //System.out.println();
        
        
        sez.showSezFirst2Last(sez.getPrvi_());
        sez.next();
        
        System.out.println();
        sez.next();
        sez.next();

        sez.showSezLast2First(sez.getPrvi_());
        System.out.println();
        
        sez.showSezFirst2LastOrdered(sez.getPrvi_());
        System.out.println();
        
        sez.showSezLast2First(sez.getPrvi_());
        System.out.println();
        sez.next();
        sez.next();
        
        sez.showSezLast2FirstOrdered(sez.getPrvi_());
        System.out.println();
        sez.showSezLast2First(sez.getPrvi_());
        sez.next();
        
        System.out.println();
        sez.showSezFirst2Last(sez.getPrvi_());
        System.out.println();
        System.out.println(sez.showCurrent());
        System.out.println();
        sez.home(sez.getPrvi_());
        sez.showSezFirst2Last(sez.getPrvi_());
        System.out.println();
        System.out.println(sez.showCurrent());
        System.out.println();
        
        
        // sez.showSezLast2First(sez.getPrvi());
        // System.out.println();
        System.out.println(sez.soDuplikati());
        System.out.println(sez.preštejDuplicirane());
        System.out.println(sez.preštejDuplikate());
        sez.normaliziraj();
        sez.showSezFirst2Last(sez.getPrvi_());
        System.out.println(); 
        
        System.out.println("------------------------------------------");
    }
}
