package Beispiele.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        GridPane root = new GridPane();

        Label label1 = new Label("Label 1");
        Label label2 = new Label("Label 2");
        Label label3 = new Label("Label 3");

        GridPane.setConstraints(label1,1,2);

//        GridPane.setColumnIndex(label1,1);
//        GridPane.setRowIndex(label1,2);

        GridPane.setColumnIndex(label3,2);
        GridPane.setRowIndex(label3,2);

        root.getChildren().addAll(label1,label2,label3);

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("GridPane Beispiel");
        stage.show();
    }
}
