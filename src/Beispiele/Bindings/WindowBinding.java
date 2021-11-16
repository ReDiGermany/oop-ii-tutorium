package Beispiele.Bindings;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowBinding extends Application {
    Label label = new Label("Waiting...");
    TextField text = new TextField();

    private void openWindow() {
        Stage stage = new Stage();

        label.textProperty().bind(text.textProperty());

        VBox root = new VBox(text);

        stage.setScene(new Scene(root,300,50));
        stage.setTitle("Window Binding");
        stage.show();
    }
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("Open");
        button.setOnAction(e->{
            openWindow();
        });

        VBox root = new VBox(button,label);

        stage.setScene(new Scene(root,300,300));
        stage.setTitle("Window Binding");
        stage.show();
    }
}
