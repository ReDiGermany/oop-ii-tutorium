package Beispiele.Lamda;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LamdaExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Button button = new Button("*click*");
        button.setOnAction(e->{
            System.out.println("Clicked");
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Clicked");
            }
        });

        root.getChildren().add(button);

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("Lamda Example");
        stage.show();
    }
}
