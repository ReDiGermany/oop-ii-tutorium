package Beispiele.Basis;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class BaseWindowExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        stage.setScene(new Scene(root));
        stage.setTitle("Minimal Beispiel");
        stage.show();
    }
}
