import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    Scene scene_main;
    Scene scene_register;
    Scene scene_login;
    Scene scene_book_in;
    Scene scene_book_out;
    Scene scene_bool_details;
    Scene scene_logout;
    Scene scene_exit;

    public static void main(String[] args) {
        launch(args);
    }

    public void init(Stage stage) {
        createMainScene(stage);
        createRegisterScene(stage);
        createLoginScene(stage);
        createBookInScene(stage);
        createBookOutScene(stage);
        createBookDetailsScene(stage);
        createLogoutScene(stage);
        createExitScene(stage);

        stage.setTitle("记账盒子");
        stage.setScene(scene_main);
        stage.show();
    }


    public void start(Stage stage) {
        init(stage);
    }

    public void createMainScene(Stage stage) {
        Label title = new Label("记账盒子");
        title.setFont(javafx.scene.text.Font.font(24));

        Button button_register = new Button("账户注册");
        Button button_login    = new Button("账户登录");
        Button button_exit     = new Button("退出系统");

        button_register.setOnAction(e -> stage.setScene(scene_register));
        button_login   .setOnAction(e -> stage.setScene(scene_login));
        button_exit    .setOnAction(e -> stage.setScene(scene_exit));

        VBox vbox = new VBox(20, title, button_register, button_login, button_exit);
        vbox.setAlignment(Pos.CENTER);

        scene_main = new Scene(vbox, 800, 500);
    }

    public void createRegisterScene(Stage stage) {

    }

    public void createLoginScene(Stage stage) {

    }

    public void createBookInScene(Stage stage) {

    }

    public void createBookOutScene(Stage stage) {

    }

    public void createBookDetailsScene(Stage stage) {

    }

    public void createLogoutScene(Stage stage) {

    }

    public void createExitScene(Stage stage) {

    }
}
