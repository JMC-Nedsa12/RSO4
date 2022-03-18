class nal5{
    public static void main(String [] args){
        nal5 obj = new nal5();
        String spremeni = "program";
        int st = obj.ustvariP(8008);
        String a = obj.ustvariP(spremeni);        
        System.out.println(st);
        System.out.println(a);
    }    
    String ustvariP(String niz){
        return niz + obrni(niz, niz.length() - 1);
    }    
    int ustvariP(int st){
        return st * (int)(Math.pow(10, String.valueOf(st).length())) + obrni(st, 0);
    }    
    int obrni(int st, int obrnjen){
        if (st == 0)
            return obrnjen;
        if (st > 0){
            obrnjen = obrnjen * 10 + (st % 10);
            obrnjen = obrni(st / 10, obrnjen);
        }
        return obrnjen;
    }
    String obrni(String niz, int a){
        if (a >= 0)
            return  niz.charAt(a) + obrni(niz, a - 1);
        else 
            return "";
    }    
}