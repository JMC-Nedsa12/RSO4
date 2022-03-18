import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.animation.*;
import javafx.util.*;

public class Controller_7seg {
    @FXML
    private Button reset;
    private Button countUp;
    private Button countDown;
    private Button stop;

    
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

    Segment sg1= new Segment();
    Segment sg2= new Segment(sg1);
    Segment sg3= new Segment(sg2);
    Segment sg4= new Segment(sg3);
    Segment sg5= new Segment(sg4);
    Segment sg6= new Segment(sg5);
    Segment sg7= new Segment(sg6);
    PauseTransition timer = new PauseTransition(Duration.millis(100));

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
    
    
    public void up(ActionEvent f){
        r1();
        timer.setOnFinished(event ->{
                try{
                    sg1.up();
                }catch(MOverFlowException e){
                    sg1.overflow();
                }
                update();
                timer.play();});
        timer.play();
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

    public void reset(ActionEvent e){
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
    public void r1(){
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
    public void r2(){
        timer.stop();
        sg1.underflow();
        sg2.underflow();
        sg3.underflow();
        sg4.underflow();
        sg5.underflow();
        sg6.underflow();
        sg7.underflow();
        update();
    }
    public void pause(ActionEvent e){
        timer.stop();
    }

    public void down(ActionEvent e){
        r2();
        timer.setOnFinished(event ->{
                try{
                    sg1.down();
                }catch(MUnderFlowException f){
                    sg1.underflow();
                }
                update();
                timer.play();});
        timer.play();
    }
}