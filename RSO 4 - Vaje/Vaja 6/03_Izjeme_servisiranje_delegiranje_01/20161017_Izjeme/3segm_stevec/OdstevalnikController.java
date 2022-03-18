import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.*;
import javafx.animation.*;
import javafx.util.*;

public class OdstevalnikController {

    @FXML
    private TextField inputField;

    @FXML
    private Button pauseButton;

    @FXML
    private Button resetButton;

    @FXML
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

    @FXML
    private Label s7;

    @FXML
    private Button setButton;

    @FXML
    private Button startButton;

    Segment sg1= new Segment();
    Segment sg2= new Segment(sg1);
    Segment sg3= new Segment(sg2);
    Segment sg4= new Segment(sg3);
    Segment sg5= new Segment(sg4);
    Segment sg6= new Segment(sg5);
    Segment sg7= new Segment(sg6);
    PauseTransition timer = new PauseTransition(Duration.seconds(1));
    int čas;
    
    Media alert;
    MediaPlayer mp;
    public  void initialize(){
        sg1.nasl=sg2;
        sg2.nasl=sg3;
        sg3.nasl=sg4;
        sg4.nasl=sg5;
        sg5.nasl=sg6;
        sg6.nasl=sg7;
        s1.setText(Integer.toString(sg1.getStanje()));
        s2.setText(Integer.toString(sg2.getStanje()));
        s3.setText(Integer.toString(sg3.getStanje()));
        s4.setText(Integer.toString(sg4.getStanje()));
        s5.setText(Integer.toString(sg5.getStanje()));
        s6.setText(Integer.toString(sg6.getStanje()));
        s7.setText(Integer.toString(sg7.getStanje()));
    }

    @FXML
    void pause(ActionEvent event) {
        timer.stop();
    }

    @FXML
    void reset(ActionEvent event) {
        timer.stop();
        sg1.overflow();
        sg2.overflow();
        sg3.overflow();
        sg4.overflow();
        sg5.overflow();
        sg6.overflow();
        sg7.overflow();
        update();
    }

    @FXML
    void setTime(ActionEvent event) {
        timer.stop();
        čas=Integer.parseInt(inputField.getText());
        //System.out.println(čas);
        sg1.overflow();
        sg2.overflow();
        sg3.overflow();
        sg4.overflow();
        sg5.overflow();
        sg6.overflow();
        sg7.overflow();
        for(int i=0;i<čas;i++){
            try{sg1.up();}catch(MOverFlowException e){sg1.overflow();}
        }
        update();
    }

    @FXML
    void startTime(ActionEvent ev) {
        if (čas!=0){
            timer.setOnFinished(event ->{
                try{
                    sg1.down();
                }catch(MUnderFlowException f){
                    sg1.underflow();
                }
                čas--;
                update();
                if(čas>0){
                    timer.play();} else{timer.stop();alarm();}});
        timer.play();
        }
        update();
    }

    public void update() {
        s1.setText(Integer.toString(sg1.getStanje()));
        s2.setText(Integer.toString(sg2.getStanje()));
        s3.setText(Integer.toString(sg3.getStanje()));
        s4.setText(Integer.toString(sg4.getStanje()));
        s5.setText(Integer.toString(sg5.getStanje()));
        s6.setText(Integer.toString(sg6.getStanje()));
        s7.setText(Integer.toString(sg7.getStanje()));
    }
    public void alarm(){
        System.out.println("Beep Beep");
        try{
            alert = new Media(getClass().getResource("alert.mp3").toString());}
            catch(Exception exc){return;}
        mp = new MediaPlayer(alert);
        mp.play();
    }
}
