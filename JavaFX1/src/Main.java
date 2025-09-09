import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public Scene scene_main;
    public Scene scene_register;
    public Scene scene_login;
    public Scene scene_program;
    public Scene scene_exit;

    public static void main(String[] args) {
        launch();
    }

    /**
     *  写较复杂的图形化界面的Java应用程序，将“记账盒子”字符界面设计转换为图形化界面
     */

    public void init() {
        scene_main     = null;
        scene_register = null;
        scene_login    = null;
        scene_program  = null;
        scene_exit     = null;
    }

    public void start(Stage stage) {
        stage.setTitle("记账盒子");

        setSceneMain(stage);
        setSceneRegister(stage);
        setSceneLogin(stage);
        setSceneProgram(stage);
        setSceneExit();

        stage.setScene(scene_main);
        stage.show();
    }

    public void setSceneMain(Stage stage) {
        Label label_title = new Label("基于MySQL的“记账盒子”数据库操作");
        label_title.setStyle("-fx-font-size: 22px;");

        Button button_register = new Button("账户注册");
        Button button_login    = new Button("账户登录");
        Button button_exit     = new Button("退出系统");
        button_register.setOnAction(e -> stage.setScene(scene_register));
        button_login.   setOnAction(e -> stage.setScene(scene_login));
        button_exit.    setOnAction(e -> stage.setScene(scene_exit));


        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(
                label_title,
                button_register,
                button_login,
                button_exit
        );

        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);

        scene_main = new Scene(pane, 500, 800);
    }

    public void setSceneRegister(Stage stage) {
        Label label_title = new Label("注册账户");
        label_title.setStyle("-fx-font-size: 22px;");

        Label label_register_username = new Label("请输入用户");
        TextField text1 = new TextField();
        Label label_register_password = new Label("请输入密码");
        TextField text2 = new TextField();

        Button button_register = new Button("注册");
        Button button_back     = new Button("返回");
        button_register.setOnAction(e -> stage.setScene(scene_main));
        button_back.    setOnAction(e -> stage.setScene(scene_main));

        HBox hbox_register = new HBox(15);
        HBox hbox_password = new HBox(15);
        hbox_register.setAlignment(Pos.CENTER);
        hbox_register.getChildren().addAll(
                label_register_username,
                text1
        );
        hbox_password.setAlignment(Pos.CENTER);
        hbox_password.getChildren().addAll(
                label_register_password,
                text2
        );


        HBox hbox_button = new HBox(15);
        hbox_button.setAlignment(Pos.CENTER);
        hbox_button.getChildren().addAll(
                button_back,
                button_register
        );

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(
                label_title,
                hbox_register,
                hbox_password,
                hbox_button
        );

        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);

        scene_register = new Scene(pane, 500, 800);
    }

    public void setSceneLogin(Stage stage) {
        Label label_title = new Label("登录账户");
        label_title.setStyle("-fx-font-size: 22px;");

        Label label_login_username = new Label("请输入用户");
        TextField text1 = new TextField();
        Label label_login_password = new Label("请输入密码");
        TextField text2 = new TextField();

        HBox hbox_username = new HBox(15);
        HBox hbox_password = new HBox(15);
        hbox_username.setAlignment(Pos.CENTER);
        hbox_username.getChildren().addAll(
                label_login_username,
                text1
        );
        hbox_password.setAlignment(Pos.CENTER);
        hbox_password.getChildren().addAll(
                label_login_password,
                text2
        );

        Button button_login = new Button("登录");
        Button button_back  = new Button("返回");
        button_login.setOnAction(e -> stage.setScene(scene_program));
        button_back. setOnAction(e -> stage.setScene(scene_main));

        HBox hbox_button = new HBox(15);
        hbox_button.setAlignment(Pos.CENTER);
        hbox_button.getChildren().addAll(
                button_back,
                button_login
        );

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(
                label_title,
                hbox_username,
                hbox_password,
                hbox_button
        );

        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);

        scene_login = new Scene(pane, 500, 800);
    }

    public void setSceneProgram(Stage stage) {
        Label label_title = new Label("记账盒子");
        label_title.setStyle("-fx-font-size: 22px;");

        Button button_add    = new Button("记账");
        Button button_list   = new Button("查看明细");
        Button button_logout = new Button("退出登录");

        button_add.   setOnAction(e -> stage.setScene(scene_program));
        button_list.  setOnAction(e -> stage.setScene(scene_program));
        button_logout.setOnAction(e -> stage.setScene(scene_main));

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(
                label_title,
                button_add,
                button_list,
                button_logout
        );

        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);

        scene_program = new Scene(pane, 500, 800);
    }

    public void setSceneExit() {
        Label label_title = new Label("退出系统!");
        label_title.setStyle("-fx-font-size: 22px;");
        Label label_exit = new Label("点击任意位置关闭程序");

        VBox vbox = new VBox(15);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(
                label_title,
                label_exit
        );

        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);

        scene_exit = new Scene(pane, 500, 800);

        scene_exit.setOnMouseClicked(e -> System.exit(0));
    }

//    /**
//     *  编写一个简单的图形化界面的Java应用程序
//     */
//    public void start(javafx.stage.Stage stage) {
//        stage.setTitle("JavaFX程序");
//
//        Label label = new Label("这是我的第一个JavaFX程序");
//
//        StackPane pane = new StackPane();
//        pane.getChildren().add(label);
//
//        Scene scene = new Scene(pane, 500, 200);
//        stage.setScene(scene);
//
//        stage.show();
//    }
}
