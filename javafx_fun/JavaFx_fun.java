package javafx_fun;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx_fun.View.ContentController;
import javafx_fun.View.TopBarController;

/**
 *
 * @author mw5
 */
public class JavaFx_fun extends Application {
    public Stage primaryStage;
    public BorderPane rootLayout;
    public AnchorPane topBar;
    public AnchorPane content;
    private int points;
    
    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;
        points = 0;
        stage.setTitle("JavaFX fun");
        initRootLayout();
        initTopBar();
        initContent();
    }
    public void setPoints(int points) {
        this.points = points;
        initTopBar();
    }
    public int getPoints() {
        return points;
    }
    
    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("View/RootLayout.fxml")); //can also be JavaFx_fun.class.getRes...
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public void initTopBar() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("View/TopBar.fxml"));
            topBar = (AnchorPane) loader.load();
            TopBarController controller = loader.getController();
            rootLayout.setTop(topBar);
            controller.setMain(this);
            controller.showPoints(points);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    public void initContent() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("View/Content.fxml"));
            content = (AnchorPane) loader.load();
            ContentController controller = loader.getController();
            rootLayout.setCenter(content);
            controller.setMain(this);
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
