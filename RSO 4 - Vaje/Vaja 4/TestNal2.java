public class TestNal2{
    public static void TestNal2(){
        LinEnPovSez_Nal2 sez = new LinEnPovSez_Nal2();
        sez.dodaj('ž');
        System.out.println(sez.showSezFirst2Last(sez.getPrvi()));
        sez.dodaj("deeehllzzzz ");
        //System.out.println();
        System.out.println(sez.showSezFirst2Last(sez.getPrvi()));
        //System.out.println();
        System.out.println(sez.showSezLast2First(sez.getPrvi()));
        //System.out.println();
        System.out.println(sez.soDuplikati());
        System.out.println(sez.preštejDuplicirane());
        System.out.println(sez.preštejDuplikate());
        sez.normaliziraj();
        System.out.println(sez.showSezFirst2Last(sez.getPrvi()));
        //System.out.println(); 
        
        System.out.println("------------------------------------------");
    }
}
