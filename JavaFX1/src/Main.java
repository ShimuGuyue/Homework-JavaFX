import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    /**
     *  编写一个简单的图形化界面的Java应用程序
     */
    public void start(javafx.stage.Stage stage) {
        stage.setTitle("JavaFX程序");

        Label label = new Label("这是我的第一个JavaFX程序");

        StackPane pane = new StackPane();
        pane.getChildren().add(label);

        Scene scene = new Scene(pane, 500, 200);
        stage.setScene(scene);

        stage.show();
    }
}
