package Uebung2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Aufgabe22 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Root Element erstellen
        Pane root = new Pane();

        Rectangle rect = new Rectangle(100,50);
        rect.setStyle("-fx-background: #f00");

        root.getChildren().addAll(rect);

//        Basic Fenster blabla
        Scene scene = new Scene(root,500,400);
        primaryStage.setTitle("Aufgabe 1.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
