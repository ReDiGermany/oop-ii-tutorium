package Beispiele.Layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        Label labelCenter = new Label("Center");
        Label labelLeft = new Label("Left");
        Label labelTop = new Label("Top");
        Label labelRight = new Label("Right");
        Label labelBottom = new Label("Bottom");

        BorderPane.setAlignment(labelTop, Pos.CENTER);
        BorderPane.setAlignment(labelRight, Pos.CENTER);
        BorderPane.setAlignment(labelBottom, Pos.CENTER);
        BorderPane.setAlignment(labelLeft, Pos.CENTER);

        root.setCenter(labelCenter);
        root.setLeft(labelLeft);
        root.setTop(labelTop);
        root.setRight(labelRight);
        root.setBottom(labelBottom);

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("BorderPane Beispiel");
        stage.show();
    }
}
