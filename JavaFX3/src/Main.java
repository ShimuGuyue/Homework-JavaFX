import javafx.application.Application;
import javafx.scene.Scene;
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
