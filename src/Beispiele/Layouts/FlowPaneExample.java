package Beispiele.Layouts;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane root = new FlowPane();
        int n=0;
        Label[] labels = new Label[] {
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n++)),
                new Label("Label "+(n)),
        };
        root.getChildren().addAll(labels);
        root.setOrientation(Orientation.VERTICAL);

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("FlowPane Beispiel");
        stage.show();
    }
}
