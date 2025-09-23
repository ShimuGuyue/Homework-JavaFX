import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application {
    static public void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        start1(stage);
    }

    /**
     *  编写图形化界面并实现ActionEvent时事件处理；
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
}
