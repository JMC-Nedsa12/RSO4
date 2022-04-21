import java.io.*;
import java.util.*;
/**
 * Pretvori csv v binarno tipizirano datoteko.
 *
 * @author JanTrsan
 * @version 1.0
 */
public class EnaB{
    public static void main(String [] args) throws Exception{
        // File input = new File (args[0]);
        File input = new File ("podatki.csv");
        BufferedReader br = new BufferedReader(new FileReader(input));
        FileOutputStream fos = new FileOutputStream("Podatki.bin");
        long i=1;
        String[] values;
        String csv="";
        String ime="";
        String priim="";
        String ulica = "";
        int st=0;
        String mesto = "";
        int posta =0;
        String opomba="";
        
        int imeLen=20;
        int priimLen=30;
        int ulicaLen=30;
        int mestoLen=25;
        int opombaLen=150;
        
        br.readLine();
        
        values = br.readLine().split(",");
        
        ulica=values[2];
        st=Integer.valueOf(values[3]);
        ime=values[0];
        priim=values[1];
        mesto=values[4];
        posta=Integer.valueOf(values[5]);
        for (int j=6; j<values.length;j++){
            opomba+=values[j]+",";
        }
        
        
        for (String c : values)
            System.out.println(opomba);
        
        
    }
    
    public static String find (File file, int n){
        return "";
    }
}
