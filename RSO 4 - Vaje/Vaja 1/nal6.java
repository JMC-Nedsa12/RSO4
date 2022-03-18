class nal6{
    public static void main(String [] args){
        nal6 obj = new nal6();
        System.out.println(obj.rekurzija("bingobongo","go"));
    }
    
    int rekurzija(String niz, String podniz){
        int i = niz.length();
        int j = podniz.length();
        
        if (i == 0 || i < j){
            return 0;
        }
        
        if (niz.substring(0, j).equals(podniz)){
            return rekurzija(niz.substring(j - 1), podniz) + 1;
        }
        
        return rekurzija(niz.substring(j - 1), podniz);
        
    }
}