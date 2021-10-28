package Uebung1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aufgabe11 extends Application {
    private int clickCounter = 0;
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Root Element erstellen
        HBox root = new HBox();

//        UI Elemente erstellen und notwendige logik hinzufügen
        Text text = new Text("Klick #"+clickCounter);
        Button button = new Button("Lösung");
        button.setOnAction(e->{
            clickCounter++;
            text.setText("Klick #"+clickCounter);
            primaryStage.sizeToScene();
        });

//        UI Elemente ins root Element hinzufügen
        root.getChildren().add(button);
        root.getChildren().add(text);
//        root.getChildren().addAll(button,text); // Alternative

//        Basic Fenster blabla
        Scene scene = new Scene(root);
        primaryStage.setTitle("Aufgabe 1.1");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
