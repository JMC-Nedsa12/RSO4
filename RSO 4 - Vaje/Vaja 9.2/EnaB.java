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
        File input = new File (args[0]);
        FileInputStream fis = new FileInputStream(input);
        FileOutputStream fos = new FileOutputStream("Podatki.bin");
        long i=1;
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
        
        fis.skip(1);
        
        
    }
    
    public static String find (File file, int n){
        return "";
    }
}
