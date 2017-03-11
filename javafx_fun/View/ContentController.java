package javafx_fun.View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;


/**
 * FXML Controller class
 *
 * @author mw5
 */
public class ContentController implements Initializable {
    @FXML
    private Canvas canvas;

    public void draw() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawCircle(gc);
    }
    
    private void drawCircle(GraphicsContext gc) {
        gc.fillOval(canvas.getWidth()/2, canvas.getHeight()/2, 30, 30);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
}
