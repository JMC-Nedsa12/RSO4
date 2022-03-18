/*
   Kochov fraktal na layerj-u  - zgolj za ob�?utek

   na hitro predelana demostracija iz Oraclove demostracije
        Working with Canvas : 
         http://docs.oracle.com/javafx/2/canvas/jfxpub-canvas.htm, sept. 2016

        uporabljen demo :  LayerTest.java

   narise kochov fraktal iz premice:
      gumb ga nariše
      klik na layer ga pobriše


*/

 

import javafx.application.Application;
import javafx.scene.Group;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import java.util.*;

public class Nal5 extends Application {
    
    private Group root;
    private BorderPane borderPane;
    private Canvas layer1;
    //private Canvas layer2;
    private GraphicsContext gc1;
    //private GraphicsContext gc2;
    private ChoiceBox cb;
    private Button btn;
    boolean flag=false;
    int count=0;
    double angle=0;
    double angle2;
    Tocka t0=new Tocka (200,200);
    double razdalja=50;
    
    private void createLayers(){
        
        // Layers 1&2 are the same size
        layer1 = new Canvas(900,900);
        
        // Obtain Graphics Contexts
        gc1 = layer1.getGraphicsContext2D();
        gc1.setFill(Color.GREEN);
        gc1.setStroke(Color.BLUE);
        gc1.setLineWidth(1);
        
    }
    
    private void handleLayers(){
        // Handler for Layer 1
       
        layer1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {          
                // koda za handle : click on layer
                gc1.clearRect(0, 0, 900, 900);
            }
        });
      
        
    }
    
    private void createButton(){
        btn = new Button("klikn");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    // tule lahko startas
                    drawTree(t0,100,5);
                    
                }
        });
        
    }
    
    
    
    
    public void drawTree (Tocka t0, double dolzina, double razdalja){
        
        double x0, y0, x2, y2, rad, y3, x3, y4;
        
        if (flag==false){
            gc1.strokeLine(t0.getX(),t0.getY(),t0.getX(),t0.getY()-dolzina);
            gc1.strokeLine(t0.getX(),t0.getY()-dolzina+dolzina*0.66,t0.getX()+50,t0.getY()-dolzina);
            //gc1.strokeLine(t0.getX(),t0.getY()-dolzina,t0.getX(),t0.getY()-dolzina*0.66);
            //gc1.strokeLine(dolzina+x1,y1,x2,y2);
            t0.setX(0.33*razdalja);
            t0.setY(t0.getY()-dolzina+dolzina*0.66);
            flag=true;
            drawTree(t0,dolzina*0.66,razdalja/2);
            return;
        }
        
        /*
         * angle+=kot;
        x0=t0.getX(); 
        y0=t0.getY();
        x2=t0.getX()+dolzina*Math.cos(Math.toRadians(angle));
        y2=t0.getY()+dolzina*Math.sin(Math.toRadians(angle));
        */
        gc1.strokeLine(t0.getX(),t0.getY(),t0.getX()+razdalja,t0.getY()-dolzina);
        t0.setX(0.33*razdalja);
        t0.setY(t0.getY()-dolzina+dolzina*0.66);
        
        //t0.setX(x2);
        //t0.setY(y2);
        count++;
        if(count<=3){
            drawTree(t0,dolzina*0.66,razdalja/2);
            drawTree(t0,dolzina,-30);
        }
        /*
        
       // x2=(t0.getX()+dolzina)+dolzina*Math.cos(rad);
       // y2=3*t0.getY()+dolzina*Math.sin(rad);
        
        if (flag==false){
            gc1.strokeLine(x1,y1,dolzina+x1,y1);
            gc1.strokeLine(dolzina+x1,y1,x2,y2);
            flag=true;
            drawTree(t0,dolzina,kot);
            return;
        }
        
        gc1.strokeLine(x1,y1,x2,y2);
        
        gc1.strokeLine(x1,y1,dolzina+x1,y1);
        //gc1.rotate(45);
        gc1.setStroke(Color.RED);
        gc1.strokeLine(dolzina+x1,y1,x2,y2);
        */
        }
    
    private void addLayers(){
        // Add Layers
       
        borderPane.setTop(btn);
        Pane pane = new Pane();
        pane.getChildren().add(layer1);
        //pane.getChildren().add(layer2);
        layer1.toFront();
        borderPane.setCenter(pane);    
        root.getChildren().add(borderPane);
    }
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        
        // Build GUI
        borderPane = new BorderPane();  
        primaryStage.setTitle("Layer Test");
        root = new Group();
        createLayers();
        handleLayers();
        //createChoiceBox();
        createButton();
        addLayers();  
      
        // Show Scene
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
} 
    
    
   
