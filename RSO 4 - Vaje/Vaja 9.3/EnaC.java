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
        find(file,n,fis);
        
        fis.close();
    }
    
    public static void find (File file, int n,FileInputStream fis) throws Exception{
        DataInputStream dis=new DataInputStream(fis);
        int skip=(n-1)*277;
        String zapis="";
        fis.skip(skip);
        String numb="";;
        String ime="";
        String priim="";
        String ulica = "";
        long st=0;
        String mesto = "";
        long posta =0;
        String opomba="";
        for (int i=0;i<3;i++){
            numb=numb+(char)fis.read();
        }
        for (int i=0;i<20;i++){
            ime=ime+(char)fis.read();
        }
        for (int i=0;i<30;i++){
            priim=priim+(char)fis.read();
        }
        for (int i=0;i<30;i++){
            ulica=ulica+(char)fis.read();
        }
        st=dis.readLong();
        for (int i=0;i<25;i++){
            mesto=mesto+(char)fis.read();
        }
        posta=dis.readLong();
        for (int i=0;i<150;i++){
            opomba=opomba+(char)fis.read();
        }
        System.out.println(numb);
        System.out.println(ime);
        System.out.println(priim);
        System.out.println(ulica);
        System.out.println(st);
        System.out.println(mesto);
        System.out.println(posta);
        System.out.println(opomba);
        
        dis.close();
    }
}
