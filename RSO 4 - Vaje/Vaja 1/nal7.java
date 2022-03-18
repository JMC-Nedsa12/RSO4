class nal7{
    public static void main(String [] args){
        nal7 obj = new nal7();
        int st = 7355608;
        String niz = "Racecar";        
        
        
        System.out.println(obj.obrni(st, 0));
        System.out.println(obj.obrni(niz, niz.length() - 1));
    }    
    String obrni(String niz, int a){
        if (a >= 0)
            return  niz.charAt(a) + obrni(niz, a - 1);
        else
            return "";
    }    
    int obrni(int st, int obrnjen){
        if (st == 0){
            return obrnjen;
        }
        if (st > 0){
            obrnjen = obrnjen * 10 + (st % 10);
            obrnjen = obrni(st / 10, obrnjen);
        }
        return obrnjen;
    }
}