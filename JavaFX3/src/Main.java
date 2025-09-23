import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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
        /* 注册信息 */
        Label label_username = new Label("请输入账号：");
        Label label_password = new Label("请输入密码：");
        Label label_name     = new Label("请输入姓名：");
        Label label_money    = new Label("请输入余额：");
        TextField field_username = new TextField();
        TextField field_password = new TextField();
        TextField field_name     = new TextField();
        TextField field_money    = new TextField();

        HBox row_username = new HBox(10, label_username, field_username);
        HBox row_password = new HBox(10, label_password, field_password);
        HBox row_name     = new HBox(10, label_name,     field_name);
        HBox row_money    = new HBox(10, label_money,    field_money);

        row_username.setAlignment(Pos.CENTER);
        row_password.setAlignment(Pos.CENTER);
        row_name    .setAlignment(Pos.CENTER);
        row_money   .setAlignment(Pos.CENTER);

        /* 按钮 */
        Button button_back     = new Button("返回");
        Button button_register = new Button("注册");
        button_back.    setOnAction(e ->
            stage.setScene(scene_main)
        );
        button_register.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("注册成功");
            alert.setHeaderText(null);
            alert.setContentText("注册成功！");
            alert.showAndWait();
            stage.setScene(scene_main);
        });

        HBox buttonBox = new HBox(30, button_back, button_register);
        buttonBox.setAlignment(Pos.CENTER);



        VBox vbox = new VBox(20, row_username, row_password, row_name, row_money, buttonBox);
        vbox.setAlignment(Pos.CENTER);

        scene_register = new Scene(vbox, 800, 500);
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
