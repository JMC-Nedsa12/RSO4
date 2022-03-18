public class LinEnPovSez{
    private Vozlisce prvi = null;   

    public Vozlisce getPrvi(){
        return prvi;
    }

    public LinEnPovSez() {}

    public void ZadnjiDoPrvi( Vozlisce first ){       
        if ( first != null){
            ZadnjiDoPrvi(first.getNasl());
            System.out.print(first.getVrednost());
        }
    }
    
    public void dodaj(String s){
        if (prvi==null){
            prvi = new Vozlisce(s);
            prvi.setNasl(null);
            return;
        }
        Vozlisce v = new Vozlisce(s);
        v.setNasl(prvi);
        prvi=v;
    }
}