package Beispiele.Observer;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InvalidationListenerExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Invalidation Listener Beispiel");
        stage.show();

        stage.heightProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("Height: "+stage.getHeight());
            }
        });
        stage.widthProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println("Width: "+stage.getWidth());
            }
        });
    }
}
