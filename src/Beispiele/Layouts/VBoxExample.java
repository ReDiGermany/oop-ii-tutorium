package Beispiele.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VBoxExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        root.getChildren().add(new Label("VBox Layout"));
        root.getChildren().add(new Label("VBox Layout"));

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("VBox Beispiel");
        stage.show();
    }
}
