package Beispiele.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        root.getChildren().add(
            new Label("Pane Layout")
        );

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Pane Beispiel");
        stage.show();
    }
}
