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
        ArrayList list=new ArrayList<Zapis>();

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

            list.add(new Zapis(ime,priim,ulica,st,mesto,posta,opomba));

            opomba="";
            i++;
        }

        try{
            nalC(list);
            nalD(list,"IzbranoIme");
            nalE("IzbranoIme.txt");
            nalD_(list,"IzbranoIme_1");
        }catch(Exception e){}
        dos.close();
        fos.close();
        br.close();
    }

    public static void nalC(ArrayList<Zapis> list){
        list.forEach((n) -> System.out.println(n));

    }

    public static void nalD(ArrayList<Zapis> list, String ime)throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File ((""+ime+".txt"))));
        oos.writeObject(list);
        oos.close();
    }

    public static void nalD_(ArrayList<Zapis> list, String ime)throws Exception{
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File ((""+ime+".txt"))));
        // list.forEach((element) -> oos.writeObject(element));
        for (int i = 0; i<list.size();i++){
            Zapis z = list.get(i);
            oos.writeObject(z);
        }
        oos.close();
    }
    
    public static void nalE_(String fileName)throws Exception{
        File file = new File (fileName);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)); 
        ArrayList<Zapis> list =new ArrayList<Zapis>();
        list.add(ois.readObject());
        ois.close();
    }

    public static void nalE(String fileName)throws Exception{
        File file = new File (fileName);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)); 
        ArrayList<Zapis> list =(ArrayList<Zapis>) ois.readObject();
        ois.close();
    }
}
