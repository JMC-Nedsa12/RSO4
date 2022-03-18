public class nal4{
    public static void main (String [] args){
        nal4 obj=new nal4();
        int[][] tab = new int[5][5];
        tab = obj.rekurzija(tab, 0, 0);
        for (int i = 0; i < tab.length; i++){
            for (int j = 0; j < tab[0].length; j++){
                System.out.print(tab[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int [][] rekurzija(int[][] tab, int a, int b){
        if (a >= tab.length){
            a = 0;
            b++;
        }
        if (b >= tab.length){
            return null;
        }
        tab[a++][b] = 1;
        rekurzija(tab, a, b);
        return tab;
    }
}