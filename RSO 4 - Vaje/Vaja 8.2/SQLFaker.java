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
 * Faker za vnos 1500 strank v remote SQL database
 *
 * @author JanTrsan
 * @version 1.0
 */
public class SQLFaker{
    public static void main (String [] args){
        Connection con=null;
        Faker[] fakers = {
                new Faker(new Locale("it")),
                new Faker(new Locale("es")),
                new Faker(new Locale("fr")),
                new Faker(new Locale("en-GB")),
                new Faker(new Locale("en-US"))};
        int j=0;
        try{
            String url = "jdbc:mysql://193.2.190.23/g4ab";
            // String url = "jdbc:mysql://localhost/test";
            con = DriverManager.getConnection(url,"g4ab","g4ab_remo22");
            // con = DriverManager.getConnection(url,"root","");
            String ime="Jan";
            String priimek = "Trsan";
            String quer= "insert into STRANKE_jan_trsan values (?,?,?,?,?,?,?,?,?,?);";
                PreparedStatement stmt = con.prepareStatement(quer);
                stmt.setInt(1,0);//id
                stmt.setString(2,ime);//ime
                stmt.setString(3,priimek);//priimek
                stmt.setString(4,"Neka ulica 38");//naslov
                stmt.setString(5,"031 222 111");//telefon
                stmt.setString(6,fakers[3].internet().avatar());//avatar
                stmt.setString(7,java.time.LocalDate.now().toString());//datum
                stmt.setInt(8,0);//st dostopov
                 stmt.setString(9,ime.substring(0,1).toLowerCase()+priimek+rng(6));//username
                stmt.setString(10,encrypt(ime+priimek));// geslo
                System.out.println(stmt);
                stmt.execute();
            for (int i = 0;i<1500;i++){
                String name=fakers[j].name().firstName();
                String lastName=fakers[j].name().lastName();

                quer= "insert into STRANKE_jan_trsan values (?,?,?,?,?,?,?,?,?,?);";
                stmt = con.prepareStatement(quer);
                
                stmt.setInt(1,i+1);//id
                stmt.setString(2,name);//ime
                stmt.setString(3,lastName);//priimek
                stmt.setString(4,fakers[j].address().streetAddress());//naslov
                stmt.setString(5,fakers[j].phoneNumber().phoneNumber());//telefon
                stmt.setString(6,fakers[j].internet().avatar());//avatar
                stmt.setString(7,java.time.LocalDate.now().toString());//datum
                stmt.setInt(8,0);//st dostopov
                 stmt.setString(9,name.substring(0,1).toLowerCase()+lastName+rng(6));//username
                stmt.setString(10,encrypt(name+lastName));// geslo
                // System.out.println(stmt);
                stmt.execute();
                if (j==fakers.length-1){
                    j=-1;
                }
                j++;
            }
        } catch (SQLException e) {
            throw new Error("Problem", e);
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

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