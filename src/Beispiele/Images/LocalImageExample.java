package Beispiele.Images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class LocalImageExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        InputStream stream = getClass().getResourceAsStream("markus-spiske-iar-afB0QQw-unsplash.jpg");
        Image img = new Image(stream);
        ImageView image = new ImageView(img);

        root.getChildren().add(image);

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Local Image Example");
        stage.show();
    }
}
