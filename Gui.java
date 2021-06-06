package pack;

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.concurrent.atomic.AtomicReference;

//import java.awt.*;

public class Gui {
    //      Stage stage;
    VBox layout;
    private Scene scene;
    TextArea textField, output;
    Button button;
    String[] outString;

    public VBox getLayout() {
        return layout;
    }

    public Gui() {
//        textField = new TextField();
//        textField.setMinSize(1200, 300);
//        output = new TextField();
//        output.setMinSize(1200, 300);
//        output.setPromptText("a7aaaaaaaaaaa");
//        button.setOnAction(e -> {
//            output.setText(Scanner.getToken2(textField.getText()));
//            System.out.println("a7aaaaaaaa");
//        });
////        output.setText(Scanner.getToken2("int int Then int Then := = + - / * > < ( ) ; ** "));
//        layout.getChildren().addAll(textField, output, button);
//        scene = new Scene(layout, 1400, 800);
    }

    public void run() {
        button.setOnAction(e -> {
            output.setText(Scanner.getToken2(textField.getText()));
        });
    }

    public void setLayout(VBox layout) {
        this.layout = layout;
    }
    //    layout.getChildren().addAll();

    public Scene getScene() {
        textField = new TextArea();
        textField.setMinSize(1200, 100);
//        textField.setScaleX(1200);
//        textField.setScaleY(150);
        textField.setFont(Font.font("verdana", FontWeight.MEDIUM, 20));
//        textField.setSc

        output = new TextArea();
        output.setMinSize(1200, 100);
//        output.setScaleX(1200);
//        output.setScaleY(150);
//        output.setPromptText("a7aaaaaaaaaaa");
        output.setFont(Font.font("verdana", FontWeight.MEDIUM, 20));
        output.setScrollLeft(100);

        button = new Button("Scan");
        button.setFont(Font.font("verdana", FontWeight.MEDIUM, 30));
        button.setOnAction((ActionEvent event) -> {
            output.clear();
            outString = Scanner.getToken2(textField.getText()).split(",");
            System.out.println(outString);
            for (int i = 0; i < outString.length; i += 2) {
                output.appendText(outString[i]);
                output.appendText("                             ");
                output.appendText(outString[i + 1]);
                output.appendText("\n");
            }
//            output.setText();
//            System.out.println("input: " + textField.getText());
//            output.setText("kosom hayaty");
//            System.out.println("out: " + Scanner.getToken2(textField.getText()));
        });
        button.setMinSize(100, 100);
//        output.setText(Scanner.getToken2("int int Then int Then := = + - / * > < ( ) ; ** "));

        Text in = new Text("Input: ");
        in.setFont(Font.font("verdana", FontWeight.MEDIUM, 30));

        Text out = new Text("Output: ");
        out.setFont(Font.font("verdana", FontWeight.MEDIUM, 30));

        layout = new VBox();
        layout.setSpacing(5);
        layout.getChildren().addAll(in, textField, out, output, button);
        layout.setAlignment(Pos.CENTER);
        layout.setBackground(new Background(new BackgroundFill(Color.ROYALBLUE, CornerRadii.EMPTY, javafx.geometry.Insets.EMPTY)));
        scene = new Scene(layout, 1400, 800, Color.ROYALBLUE);
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }


    public TextArea getTextField() {
        return textField;
    }
}
