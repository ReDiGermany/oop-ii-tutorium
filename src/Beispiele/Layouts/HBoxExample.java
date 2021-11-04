package Beispiele.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class HBoxExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox root = new HBox();

        root.getChildren().add(new Label("HBox Layout"));
        root.getChildren().add(new Label("HBox Layout"));

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("HBox Beispiel");
        stage.show();
    }
}
