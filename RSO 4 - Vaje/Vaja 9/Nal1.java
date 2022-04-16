import java.io.*;
import java.util.*;
/**
 * Implementacija prve in tretje naloge. Ustvari kolekcijo
 * zapisov DDatot in jo izpiše. Ob dodanem drugem arguentu, ki je hash
 * lahko porgram izvede primerjavo, če se hash nahaja znotraj
 * dane datoteke.
 *
 * @author JanTrsan
 * @version 1,0
 */
public class Nal1{
    public static void main(String [] args) throws Exception{
        ArrayList list = new ArrayList<DDatot>();
        if (args.length!=0){
            if (args[0] == "npp.8.3.3.checksums.sha256"){
                File file = new File ("npp.8.3.3.checksums.sha256");
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                String hash="";
                if (args.length>1){hash=args[1];}
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
                if (args.length>1){hash=args[1];}
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
}