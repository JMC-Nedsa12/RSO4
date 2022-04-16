import java.io.*;
import java.util.*;
import java.security.*;
/**
 * Program lahko preveri ali se podan hash v datoteki
 * ali kot string argument ujema s katerim od hashov znotraj
 * datoteke. Program zmore generirati hash poljubne datoteke
 * z metodo hashGen.
 * 
 * @author JanTrsan
 * @version 1.0
 */
public class Nal4{
    public static void main(String [] args) throws Exception{
        ArrayList list = new ArrayList<DDatot>();
        if (args.length!=0){
            if (args[0] == "npp.8.3.3.checksums.sha256"){
                File file = new File ("npp.8.3.3.checksums.sha256");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String hash="";
                if (args.length>1){try{
                    BufferedReader bf = new BufferedReader(new FileReader (new File(args[1])));
                    hash=bf.readLine();}
                    catch(FileNotFoundException e){hash=args[1];}}
                while (line!=null){
                    String diggest = line.substring(0,64);
                    String fileName = line.substring (66);
                    if(diggest.equals(hash)){
                        System.out.println("hash "+hash+" ustreza programu "+fileName);
                        System.out.println();
                    }
                    list.add(new DDatot(fileName,diggest));  
                    line = br.readLine();
                }
            }
            else if (args[0] == "CHECKSUM.SHA256-FreeBSD-13.0-RELEASE-amd64"){
                File file = new File ("CHECKSUM.SHA256-FreeBSD-13.0-RELEASE-amd64");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String hash="";
                if (args.length>1){try{
                    BufferedReader bf = new BufferedReader(new FileReader (new File(args[1])));
                    hash=bf.readLine();}
                    catch(FileNotFoundException e){hash=args[1];}}
                while (line!=null){
                    String fileName=line.substring(8,line.indexOf(")"));
                    String diggest = line.substring(line.indexOf(")")+4);
                    if(diggest.equals(hash)){
                        System.out.println("hash "+hash+" ustreza programu "+fileName);
                        System.out.println();
                    }
                    list.add(new DDatot(fileName,diggest));  
                    line = br.readLine();
                }
            }
            list.forEach((n) -> System.out.println(n));
            System.out.println("Kolekcija vsebuje podatke o "+list.size()+" datotekah.");
        }
        else{System.out.println("blob");}
    }
    
    public static void hashGen(String [] args) throws Exception{
         MessageDigest md = MessageDigest.getInstance("SHA-256");
        // String hex = checksum("testFile.txt", md);
        String hex = checksum(args[0], md);
        System.out.println(hex);
    }

    private static String checksum(String filepath, MessageDigest md) throws IOException {

        try (InputStream fis = new FileInputStream(filepath)) {
            byte[] buffer = new byte[1024];
            int nread;
            while ((nread = fis.read(buffer)) != -1) {
                md.update(buffer, 0, nread);
            }
        }

        // pretvorba v hex
        StringBuilder result = new StringBuilder();
        for (byte b : md.digest()) {
            result.append(String.format("%02x", b));
        }
        return result.toString();

     }
}