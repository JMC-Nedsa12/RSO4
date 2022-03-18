public class nal3{
    static int najmanjsi = 0;
    public static void main(String [] args){
        nal3 obj=new nal3();
        int [] tab={34,6,2,8,4,56,9,56,-1,78,35,22};
        System.out.println(obj.rekurzija(tab,0)+1);
    }
    int rekurzija(int [] tab, int a){
        if (tab[najmanjsi]>tab[a]){
            najmanjsi=a;
        }
        a++;
        if(a<tab.length){
            rekurzija(tab,a);
        }
        return najmanjsi;
    }
}