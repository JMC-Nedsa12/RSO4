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
        DataOutputStream dos = new DataOutputStream(fos);

        long i=1;
        String[] values;
        String csv="";
        String ime="";
        String priim="";
        String ulica = "";
        long st=0;
        String mesto = "";
        long posta =0;
        String opomba="";

        int imeLen=20;
        int priimLen=30;
        int ulicaLen=30;
        int mestoLen=25;
        int opombaLen=150;

        br.readLine();

        while (true){
            try{
                values = br.readLine().split(",");}
            catch(NullPointerException e){break;}

            ulica=values[2];
            ulica=ulica.substring(1,ulica.length()-1);
            try{
                st=Integer.valueOf(values[3]);}
            catch(NumberFormatException e){st=0;}
            ime=values[0];
            ime=ime.substring(1,ime.length()-1);
            priim=values[1];
            priim=priim.substring(1,priim.length()-1);
            mesto=values[4];
            mesto=mesto.substring(1,mesto.length()-1);
            try{
                posta=Integer.valueOf(values[5]);}
            catch(NumberFormatException e){posta=0;}

            for (int j=6; j<values.length;j++){
                opomba+=values[j]+",";
            }
            opomba=opomba.substring(1,opomba.length()-2);
            write(String.valueOf(i),3,fos);
            write(ime,imeLen,fos);
            write(priim,priimLen,fos);
            write(ulica,ulicaLen,fos);
            dos.writeLong(st);
            write(mesto,mestoLen,fos);
            dos.writeLong(posta);
            write(opomba,opombaLen,fos);
            dos.writeUTF("\n");
            opomba="";
            i++;
        }
        dos.close();
        fos.close();
        br.close();
    }

    public static void nullWriter(int n, DataOutputStream dos) throws Exception{
        if (n%2!=0)
            n++;
        for (int i=0;i<n/2;i++){
            dos.writeChar(0);
        }
        return;
    }

    public static void write (String data, int size, FileOutputStream fos) throws Exception {     
        byte[] bytes = data.getBytes();
        if (bytes.length<size)
            fos.write(bytes);
        else{
            for(int i=0;i<size;i++){
                fos.write(bytes[i]);
            }
            return;
        }
        size = size - bytes.length;
        for (int i = 0; i < size; i++) {
            fos.write(0); 
        }    
    }

    public static String find (File file, int n){
        return "";
    }

    public static void test() throws Exception{
        File input = new File ("podatki.csv");
        BufferedReader br = new BufferedReader(new FileReader(input));
        FileOutputStream fos = new FileOutputStream("test.txt");
        DataOutputStream dos = new DataOutputStream(fos);
        
        long cif= 21830;
        
        dos.writeLong(2353);
        dos.writeUTF("\n");
        dos.writeInt(3910);
        dos.writeLong(cif);
    }
}
