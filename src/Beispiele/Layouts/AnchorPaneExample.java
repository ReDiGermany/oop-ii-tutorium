package Beispiele.Layouts;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AnchorPaneExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AnchorPane root = new AnchorPane();
        Label label = new Label("AnchorPane Layout");

        AnchorPane.setBottomAnchor(label,10.0);
        AnchorPane.setRightAnchor(label,80.0);
//        AnchorPane.setLeftAnchor(label,10.0);
//        AnchorPane.setTopAnchor(label,10.0);

        root.getChildren().add(label);

        stage.setScene(new Scene(root,300,100));
        stage.setTitle("AnchorPane Beispiel");
        stage.show();
    }
}
