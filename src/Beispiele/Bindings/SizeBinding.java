package Beispiele.Bindings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SizeBinding extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField leftField = new TextField();
        TextField rightField = new TextField();


        leftField.textProperty().bind(stage.widthProperty().asString());
        rightField.textProperty().bind(stage.heightProperty().asString());
        HBox root = new HBox(leftField,rightField);

        stage.setScene(new Scene(root,300,50));
        stage.setTitle("Size Binding");
        stage.show();
    }
}
