import java.sql.*;
import java.time.*;
import java.util.*;
public class ToSQL{
    public static void main(){
        Connection con=null;
        try{
            String url = "jdbc:mysql://localhost/ucenci";
            con = DriverManager.getConnection(url,"root","");

            String quer= "insert into imena values(?,?,?,?,?,?,?,?);";
            PreparedStatement stmt = con.prepareStatement(quer);
            stmt.setString(1,"Jan");
            stmt.setString(2,"Tršan");
            stmt.setString(3,java.time.LocalDate.now().toString());
            stmt.setString(4,java.time.LocalTime.now().toString());
            stmt.setString(5,"Nika");
            stmt.setString(6,"Niknik");
            stmt.setString(7,"Komentar 1, dodano iz jave");
            stmt.setString(8,"We did it!");
            stmt.execute();

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
}