class nal9{
    public static void main(String [] args){
        nal9 obj = new nal9();
        System.out.println(obj.rekurzija(5));
    }   
    long rekurzija(long n){
        if (n > 0)
            return rekurzija(n - 1) * n;
        else
            return 1;       
    }
}