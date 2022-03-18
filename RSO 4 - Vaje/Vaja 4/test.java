public class test{
    public static void test(){
        LinEnPovSez sez = new LinEnPovSez();
        sez.dodaj('ž');
        sez.showSezFirst2Last(sez.getPrvi());
        sez.dodaj("municipacija");
        System.out.println();
        sez.showSezFirst2Last(sez.getPrvi());
        System.out.println();
        sez.showSezLast2First(sez.getPrvi());
        System.out.println();
        System.out.println(sez.soDuplikati());
        System.out.println(sez.preštejDuplicirane());
        System.out.println(sez.preštejDuplikate());
        sez.normaliziraj();
        sez.showSezFirst2Last(sez.getPrvi());
        System.out.println(); 

        System.out.println("------------------------------------------");
    }
}