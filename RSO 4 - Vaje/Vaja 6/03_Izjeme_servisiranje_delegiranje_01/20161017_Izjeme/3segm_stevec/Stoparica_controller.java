import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.animation.*;
import javafx.util.*;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;

public class Stoparica_controller {
    
    boolean Running;
    @FXML
    private Button resetButton;
    
    @FXML
    private ListView<String> laps;
    
    @FXML
    private Button startButton;

    @FXML
    private Button stopButton;
    
    public Label s1;
    
    @FXML
    private Label s2;

    @FXML
    private Label s3;

    @FXML
    private Label s4;

    @FXML
    private Label s5;

    @FXML
    private Label s6;
    
    Segment sg1= new Segment();
    Segment sg2= new Segment(sg1);
    Segment sg3= new Segment(sg2);
    Segment sg4= new Segment(sg3);
    Segment sg5= new Segment(sg4);
    Segment sg6= new Segment(sg5);
    
    PauseTransition timer = new PauseTransition(Duration.millis(5.3));

    public  void initialize(){
        sg1.nasl=sg2;
        sg2.nasl=sg3;
        sg3.nasl=sg4;
        sg4.nasl=sg5;
        sg5.nasl=sg6;
        s1.setText(Integer.toString(sg1.getStanje()));
        s2.setText(Integer.toString(sg2.getStanje()));
        s3.setText(Integer.toString(sg3.getStanje()));
        s4.setText(Integer.toString(sg4.getStanje()));
        s5.setText(Integer.toString(sg5.getStanje()));
        s6.setText(Integer.toString(sg6.getStanje()));
        Running=false;
    }
    
    @FXML
    void beginLap(ActionEvent e) {
        if (Running==false){
            Running=true;
            timer.setOnFinished(event ->{
                try{
                    sg1.up();
                }catch(MOverFlowException exc){
                    sg1.overflow();
                }
                update();
                timer.play();});
        timer.play();
        }
        
        else{
            laps.getItems().add(segmentsToString());
        }

    }
    
    public void update() {
        s1.setText(Integer.toString(sg1.getStanje()));
        s2.setText(Integer.toString(sg2.getStanje()));
        s3.setText(Integer.toString(sg3.getStanje()));
        s4.setText(Integer.toString(sg4.getStanje()));
        s5.setText(Integer.toString(sg5.getStanje()));
        s6.setText(Integer.toString(sg6.getStanje()));
    }

    public void reset(ActionEvent e){
        Running=false;
        timer.stop();
        sg1.overflow();
        sg2.overflow();
        sg3.overflow();
        sg4.overflow();
        sg5.overflow();
        sg6.overflow();
        update();
        laps.getItems().clear();
    }

    @FXML
    public void pause(ActionEvent e){
        Running=false;
        timer.stop();
    }
    
    public String segmentsToString(){
        return  (""+Integer.toString(sg6.getStanje())+Integer.toString(sg5.getStanje())+Integer.toString(sg4.getStanje())+Integer.toString(sg3.getStanje())+"."+Integer.toString(sg2.getStanje())+Integer.toString(sg1.getStanje()));
    }
}
