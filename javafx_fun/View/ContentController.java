package javafx_fun.View;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ThreadLocalRandom;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
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
    @FXML
    public Button beginBtn;
    private GraphicsContext gc;
    private Circle target1;
    private Circle target2;
    private Circle target3;
    private Circle target4;
    private ArrayList<Circle> targetList = new ArrayList<Circle>();
    private JavaFx_fun main;
    
    public void setMain(JavaFx_fun main) {
        this.main = main;
    }
    
    public void begin() {
        beginBtn.setDisable(true);
        beginBtn.setVisible(false);
        prepareGraphicsContext();
        handleMouse();
        prepareTargets();
    }
    
    private void prepareGraphicsContext() {
        gc = canvas.getGraphicsContext2D();
    }
    
    private boolean collChecker(MouseEvent me, Circle target) {
        if (me.getX()>=target.getCenterX()-target.getRadius()/2 &&
                me.getX()<=target.getCenterX()+target.getRadius()/2 &&
                me.getY()>=target.getCenterY()-target.getRadius()/2 &&
                me.getY()<=target.getCenterY()+target.getRadius()/2) {
            return true;
        } else {
            return false;
        }
    }
    
    private void handleMouse() {
        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle (MouseEvent me) {
                if (collChecker(me,target1)) {
                    gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    System.out.println("hit");
                    for (Circle target : targetList) {
                        updateTarget(target);
                    }
                    main.setPoints(main.getPoints()+1);
                }
            }
        });
    }
    private int randVal(String orientation) {
        int rand;
        if (orientation.equals("x")) {
            rand = ThreadLocalRandom.current().nextInt((int)target1.getRadius()/2, (int)(800-target1.getRadius()) + 1);
            while(rand>=target1.getCenterX()-target1.getRadius()/2 && rand<=target1.getCenterX()+target1.getRadius()/2) {
                rand = ThreadLocalRandom.current().nextInt((int)target1.getRadius()/2, (int)(800-target1.getRadius()) + 1);
                
            }
        } else {
            rand = ThreadLocalRandom.current().nextInt((int)target1.getRadius()/2, (int)(550-target1.getRadius()) + 1);
            while(rand>=target1.getCenterY()-target1.getRadius()/2 && rand<=target1.getCenterY()+target1.getRadius()/2) {
                rand = ThreadLocalRandom.current().nextInt((int)target1.getRadius()/2, (int)(550-target1.getRadius()) + 1);
            }
        }
        
        return rand;
    }
    
    private void prepareTargets() {
        target1 = new Circle();
        target1.setRadius(100);
        targetList.add(target1);
        
        target2 = new Circle();
        target2.setRadius(75);
        targetList.add(target2);
        
        target3 = new Circle();
        target3.setRadius(50);
        targetList.add(target3);
        
        target4 = new Circle();
        target4.setRadius(25);
        targetList.add(target4);
        
        for (Circle target : targetList) {
            updateTarget(target);
        }
    }
    
    private void updateTarget(Circle target) {
        if (target.equals(target1)) {
            target.setCenterX(randVal("x"));
            target.setCenterY(randVal("y"));;
        } else {
            target.setCenterX(target1.getCenterX());
            target.setCenterY(target1.getCenterY());;
        }
        drawTarget(target);
    }
    private void drawTarget(Circle target) {
        if (target.equals(target1)) {
            gc.setFill(Color.BLUE);
        } else if (target.equals(target2)) {
            gc.setFill(Color.GREEN);
        } else if (target.equals(target3)) {
            gc.setFill(Color.RED);
        } else if (target.equals(target4)) {
            gc.setFill(Color.YELLOW);
        }
        gc.fillOval(target.getCenterX()-target.getRadius()/2, target.getCenterY()-target.getRadius()/2
            , target.getRadius(), target.getRadius());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
