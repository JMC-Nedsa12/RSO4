import java.io.*;
import java.util.*;
/**
 * Najde zapis, ki ustreza podani zaporedni številki
 *
 * @author JanTrsan
 * @version 1.0
 */
public class EnaC{
    public static void main(String [] args) throws Exception{
        File file = new File (args[0]);
        FileInputStream fis = new FileInputStream(file);
        int n = Integer.valueOf(args[1]);
        find(file,n);
        
    }
    
    public static String find (File file, int n){
        return "";
    }
}
