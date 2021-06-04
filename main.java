package pack;
import java.io.FileNotFoundException;
import java.util.Collection;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main extends Application{

    Gui gui = new Gui();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Scanner");
        stage.setScene(gui.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
//        gui.button.setOnAction(e -> {
//            gui.output.setText(Scanner.getToken2(gui.textField.getText()));
//        });
//        Scanner scanner = new Scanner();
//        scanner.getToken2("int int Then int Then := = + - / * > < ( ) ; ** ");
    }
}
