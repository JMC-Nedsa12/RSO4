import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;

/**
 * Write a description of JavaFX class fxml here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Segment7 extends Application
{
   
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root=FXMLLoader.load(getClass().getResource("/7segment.fxml"));

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root);
        stage.setTitle("7-segmentni prikazovalnik");
        stage.setScene(scene);
       // neki

        // Show the Stage (window)
        stage.show();
    }
    public static void main(String [] args){launch(args);}
   
}
