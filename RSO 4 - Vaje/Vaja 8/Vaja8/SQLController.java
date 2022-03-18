import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.sql.*;

public class SQLController {

    @FXML
    private TextField baseInput;

    @FXML
    private Button connecButton;

    @FXML
    private Button disconnectButton;

    @FXML
    private TextField passInput;

    @FXML
    private TextField portInput;

    @FXML
    private TextArea queryField;

    @FXML
    private TextArea resultField;

    @FXML
    private Button searchButton;

    @FXML
    private TextField serverInput;

    @FXML
    private TextField userInput;

    private String url;

    private Connection con=null;

    private String query;

    private Statement SQLStatement;

    private ResultSet results;

    private String output="";
    
    private ResultSetMetaData rsmd;

    @FXML
    void connect(ActionEvent event) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        url="jdbc:mysql://"+serverInput.getText()+":"+portInput.getText()+"/"+baseInput.getText();
        //System.out.println(url);
        //resultField.setText(url);

        try{
            con=DriverManager.getConnection(url,userInput.getText(),passInput.getText());
            resultField.setText("Connection established");
        }catch(SQLException e){
            resultField.setText(e.toString());
            throw new Error("Problem",e);}
    }

    @FXML
    void disconnect(ActionEvent event) {
        try {
            if (con != null) {
                con.close();
                resultField.setText("Connection closed");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @FXML
    void submitQuery(ActionEvent event) {
        query=queryField.getText();
        resultField.clear();
        rsmd = null;
        results=null;
        output="";
        try{
            SQLStatement = con.createStatement();
            //SQLStatement.setString(1,queryField.getText());
            results=SQLStatement.executeQuery(query);
            
            
            rsmd = results.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (results.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = results.getString(i);
                    output += rsmd.getColumnName(i) + ": " + columnValue + " " ;
                }
                output+="\n";
            }
            resultField.setText(output);
            //resultField.setText(SQLStatement.toString());
        } catch (SQLException e) {
            resultField.setText(e.toString());
            throw new Error("Problem", e);

        }

        output="";
    }

}
