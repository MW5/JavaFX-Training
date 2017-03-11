package javafx_fun.View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx_fun.JavaFx_fun;


/**
 * FXML Controller class
 *
 * @author mw5
 */
public class ContentController implements Initializable {
    @FXML
    private Canvas canvas;
    private GraphicsContext gc;
    private Circle target;
    private JavaFx_fun main;
    
    public void setMain(JavaFx_fun main) {
        this.main = main;
    }
    
    public void begin() {
        prepareGraphicsContext();
        handleMouse();
        prepareTarget();
    }
    
    private void prepareGraphicsContext() {
        gc = canvas.getGraphicsContext2D();
    }
    
    private void handleMouse() {
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent me) {
                gc.fillOval(me.getX(), me.getY(), 5, 5); //draws from top left!
                if( me.getX()>=target.getCenterX()-target.getRadius()/2 &&
                    me.getX()<=target.getCenterX()+target.getRadius()/2 &&
                    me.getY()>=target.getCenterY()-target.getRadius()/2 &&
                    me.getY()<=target.getCenterY()+target.getRadius()/2) {
                    System.out.println("hit");
                    main.setPoints(main.getPoints()+1);
                }
            }
        });
    }
    
    private void prepareTarget() {
        target = new Circle();
        target.setCenterX(100);
        target.setCenterY(100);
        target.setRadius(70);
        gc.strokeOval(target.getCenterX()-target.getRadius()/2, target.getCenterY()-target.getRadius()/2
                , target.getRadius(), target.getRadius());
        gc.drawImage(new Image("file:dancer.gif", true),150,150,150,150); //doesn`t work for some reason
    }
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
