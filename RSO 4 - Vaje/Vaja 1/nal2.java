public class nal2{
    public static void main(String [] args){
        int [] a = new int [41];
        a[0]=1;
        nal2 obj=new nal2();
        System.out.println(obj.rekurzija(a,0));
    }
    boolean rekurzija(int[] tab,int a1){
        if (tab.length/2>a1){
            if(tab[a1]==tab[tab.length-1-a1]){
                rekurzija(tab,a1+1);
            }
            else{return false;}            
        }       
        return true;
    }
}
