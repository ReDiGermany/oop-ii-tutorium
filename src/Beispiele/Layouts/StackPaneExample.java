package Beispiele.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class StackPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane root = new StackPane();

        Rectangle rect1 = new Rectangle(
                200,100, Color.DARKSEAGREEN);
        Rectangle rect2 = new Rectangle(
                100,50, Color.HONEYDEW);
        root.getChildren().addAll(rect1,rect2);

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("StackPane Beispiel");
        stage.show();
    }
}
