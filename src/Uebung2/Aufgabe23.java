package Uebung2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Aufgabe23 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Root Element erstellen
        HBox root = new HBox();

//        Basic Fenster blabla
        Scene scene = new Scene(root);
        primaryStage.setTitle("Aufgabe 1.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
