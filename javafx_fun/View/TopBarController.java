package javafx_fun.View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx_fun.JavaFx_fun;

/**
 * FXML Controller class
 *
 * @author mw5
 */
public class TopBarController implements Initializable {
    @FXML
    Label pointVal;
    private JavaFx_fun main;
    
    public void setMain(JavaFx_fun main) {
        this.main = main;
    }
    public void showPoints(int points) {
        pointVal.setText(String.valueOf(points));
    }
    
    @FXML
    public void handleExitBtn(ActionEvent action) {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
