package Beispiele.Images;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.InputStream;

public class RemoteImageExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        String url = "https://i.imgur.com/EZdt796.jpeg";
        ImageView image = new ImageView(url);

        root.getChildren().add(image);

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Local Image Example");
        stage.show();
    }
}
