
/*
   Kochov fraktal na layerj-u  - zgolj za občutek

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

public class KochTest extends Application {
    
    private Group root;
    private BorderPane borderPane;
    private Canvas layer1;
    //private Canvas layer2;
    private GraphicsContext gc1;
    //private GraphicsContext gc2;
    private ChoiceBox cb;
    private Button btn;
    
    private void createLayers(){
        
        // Layers 1&2 are the same size
        layer1 = new Canvas(300,250);
        
        // Obtain Graphics Contexts
        gc1 = layer1.getGraphicsContext2D();
        gc1.setFill(Color.GREEN);
        
    }
    
    private void handleLayers(){
        // Handler for Layer 1
       
        layer1.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {          
                // koda za handle : click on layer
                gc1.clearRect(0, 0, 300, 250);
            }
        });
      
        
    }
    
    private void createButton(){
        btn = new Button("klikn");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    // tule lahko startas
                    drawFractal(10,100,290,100);
                }
        });
        
    }
    
    
    
    
    public void drawFractal (int x1, int y1, int x5, int y5)
{
        int deltaX, deltaY, x2, y2, x3, y3, x4, y4;
        
        gc1.setStroke(Color.BLUE);
        gc1.setLineWidth(1);
        //gc1.strokeLine(40, 10, 10, 40);
        
        
        if ( java.lang.Math.abs(x5 - x1)<300 )
                gc1.strokeLine (x1, y1, x5, y5);
            else
            {
                deltaX = x5 - x1;
                deltaY = y5 - y1;
                x2 = x1 + deltaX / 3;
                y2 = y1 + deltaY / 3;
                double SQ = java.lang.Math.sqrt(3.0) / 6; // višina
                x3 = (int) ((x1+x5)/2 + SQ * (y1-y5));
                y3 = (int) ((y1+y5)/2 + SQ * (x5-x1));
                x4 = x1 + deltaX * 2/3;
                y4 = y1 + deltaY * 2/3;
                
            drawFractal (x1, y1, x2, y2);
            drawFractal (x2, y2, x3, y3);
            drawFractal (x3, y3, x4, y4);
            drawFractal (x4, y4, x5, y5);
            }
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
    
    
   