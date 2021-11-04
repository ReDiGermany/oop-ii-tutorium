package Uebung2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Aufgabe21 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Root Element erstellen
        Pane root = new Pane();
        root.setOnMouseClicked(e->{
            if(e.getButton().equals(MouseButton.PRIMARY)) { // linke Maustaste

//                Kreis erstellen
                Circle circle = new Circle(5, Color.BLACK);
                circle.setOnMouseClicked(c->{
                    if(c.getButton().equals(MouseButton.SECONDARY)) { // rechte Maustaste
                        root.getChildren().remove(circle);
                    }
                });
                circle.setCenterX(e.getSceneX());
                circle.setCenterY(e.getSceneY());
                root.getChildren().add(circle);
            }
        });

//        Basic Fenster blabla
        Scene scene = new Scene(root,500,500);
        primaryStage.setTitle("Aufgabe 2.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
