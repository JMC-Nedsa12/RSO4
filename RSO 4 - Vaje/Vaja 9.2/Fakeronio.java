import com.github.javafaker.Faker;
import java.util.Locale;
import java.sql.*;
import java.time.*;
import java.util.*;
import java.util.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.math.*;
/**
 * Faker za izdelavo csv datoteke
 *
 * @author JanTrsan
 * @version 1.0
 */
public class Fakeronio{
    public static void main (String [] args){
        Connection con=null;
        Faker[] fakers = {
                new Faker(new Locale("it")),
                new Faker(new Locale("es")),
                new Faker(new Locale("fr")),
                new Faker(new Locale("en-GB")),
                new Faker(new Locale("en-US"))};
        int j=0;
        
            
            for (int i = 0;i<40;i++){
                System.out.println("\""+fakers[j].name().firstName()+"\",\""+fakers[j].name().lastName()+"\",\""+fakers[j].address().streetAddress()+"\","+rng(2)+",\""+fakers[j].address().city()+"\","+rng(4)+",\"\"");

                if (j==fakers.length-1){
                    j=-1;
                }
                j++;
            }
        
    }

    public static int rng(int n) {
        int m = (int) Math.pow(10, n - 1);
        return m + new Random().nextInt(9 * m);
    }

    public static String encrypt(String input)
    {
        try {
            // getInstance() method is called with algorithm SHA-1
            MessageDigest md = MessageDigest.getInstance("SHA-1");

            // digest() method is called
            // to calculate message digest of the input string
            // returned as array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);

            // Add preceding 0s to make it 32 bit
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            // return the HashText
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}