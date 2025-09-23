import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class Main extends Application {
    static public void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
//      start1(stage);
//      start2(stage);
//      start3(stage);
//      start4(stage);
//      start5(stage);
        start6(stage);
    }

    /**
     *  编写图形化界面并实现ActionEvent时事件处理
     */
    public void start1(Stage stage) {
        String str_normal = "这是一段普通文本";
        String str_bold   = "这是一段加粗文本";

        Font font_normal = Font.font("Microsoft YaHei", FontWeight.NORMAL, FontPosture.REGULAR, 24);
        Font font_bold   = Font.font("Microsoft YaHei", FontWeight.BOLD,   FontPosture.REGULAR, 24);

        Label label = new Label(str_normal);
        label.setFont(font_normal);

        Button button_normal = new Button("普通样式");
        Button button_bold   = new Button("加粗样式");
        button_normal.setOnAction(e -> {
            label.setFont(font_normal);
            label.setText(str_normal);
        });
        button_bold.  setOnAction(e -> {
            label.setFont(font_bold);
            label.setText(str_bold);
        });


        HBox hbox = new HBox(10, button_normal, button_bold);
        hbox.setAlignment(Pos.CENTER);

        BorderPane root = new BorderPane();
        root.setTop(hbox);
        root.setCenter(label);

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);

        stage.show();
    }

    /**
     *  编写图形化界面并实现KeyEvent处理
     */
    public void start2(Stage stage) {
        BorderPane root = new BorderPane();

        Rectangle rect = new Rectangle(50, 50);
        rect.setTranslateX(0);
        rect.setTranslateY(0);
        root.setCenter(rect);

        Scene scene = new Scene(root, 400, 300);

        scene.setOnKeyPressed(e -> {
            int dx = 0, dy = 0;
            switch (e.getCode()) {
                case W: dy = -20; break;
                case S: dy =  20; break;
                case A: dx = -20; break;
                case D: dx =  20; break;
                default: break;
            }
            rect.setTranslateX(rect.getTranslateX() + dx);
            rect.setTranslateY(rect.getTranslateY() + dy);
        });

        stage.setScene(scene);

        stage.show();
    }

    /**
     *  编写图形化界面并实现MouseEvent处理
     */
    public void start3(Stage stage) {
        BorderPane root = new BorderPane();

        Circle circle = new Circle(100, Color.BLACK);
        root.setCenter(circle);

        Random rand = new Random();
        circle.setOnMouseClicked(e -> {
            Color randomColor = Color.color(rand.nextDouble(), rand.nextDouble(), rand.nextDouble());
            circle.setFill(randomColor);
        });

        Scene scene = new Scene(root, 400, 300);

        stage.setScene(scene);

        stage.show();
    }

    /**
     *  编写图形化界面并实现音频及视频处理
     */
    public void start4(Stage stage) {
        BorderPane root = new BorderPane();

        String videoPath = getClass().getResource("/video/以恋结缘.mp4").toExternalForm();
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        root.setCenter(mediaView);

        Scene scene = new Scene(root, 1200, 700);

        stage.setScene(scene);

        stage.show();

        mediaPlayer.play();
    }

    /**
     *  编写图形化界面并实现菜单处理功能
     */
    public void start5(Stage stage) {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();

        Menu fileMenu = new Menu("文件");
        MenuItem exitItem = new MenuItem("退出");
        exitItem.setOnAction(e -> stage.close());
        fileMenu.getItems().add(exitItem);

        Menu helpMenu = new Menu("帮助");
        MenuItem aboutItem = new MenuItem("关于");
        aboutItem.setOnAction(e -> {    // 弹窗显示
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "这是一个菜单示例");
            alert.showAndWait();
        });
        helpMenu.getItems().add(aboutItem);

        menuBar.getMenus().addAll(fileMenu, helpMenu);
        root.setTop(menuBar);

        stage.setScene(new Scene(root, 400, 300));

        stage.show();
    }

    /**
     *  编写图形化界面并实现简单动画
     */
    public void start6(Stage stage) {
        BorderPane root = new BorderPane();

        Circle circle = new Circle(30, Color.BLUE);
        root.setCenter(circle);
        BorderPane.setAlignment(circle, Pos.TOP_LEFT);


        Timeline timeline = new Timeline();
        double step = 8;
        double interval = 1000.0 / 60;  // 每秒帧数
        double duration = 1000;         // 每次水平移动持续时间
        double moveY = 60;              // 每次下移距离
        final double[] elapsed = {0};

        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(interval), e -> {
            circle.setTranslateX(circle.getTranslateX() + step);
            elapsed[0] += interval;

            if (elapsed[0] >= duration) {
                Circle dot = new Circle(30, Color.RED);
                dot.setCenterX(circle.getLayoutX() + circle.getTranslateX());
                dot.setCenterY(circle.getLayoutY() + circle.getTranslateY());
                root.getChildren().add(dot);

                circle.setTranslateX(0);
                circle.setTranslateY(circle.getTranslateY() + moveY);
                elapsed[0] = 0;
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);


        Scene scene = new Scene(root, 800, 500);
        stage.setScene(scene);
        stage.show();

        timeline.play();
    }
}
