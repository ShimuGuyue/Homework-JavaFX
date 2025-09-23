import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    static public void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
//      start1(stage)
//      start2(stage);
        start3(stage);
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
}
