package Uebung1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Aufgabe12 extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
//        Root Element erstellen
        BorderPane root = new BorderPane();

//        UI Elemente erstellen
        Button topButton = new Button("TOP");
        Button leftButton = new Button("LEFT");
        Button bottomButton = new Button("BUTTON");
        Button rightButton = new Button("RIGHT");
        Text centerText = new Text("CENTER");

//        On Click Event handler hinzufügen
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                centerText.setText(((Button)(actionEvent.getTarget())).getText());
            }
        };
        topButton.setOnAction(event);
        leftButton.setOnAction(event);
        bottomButton.setOnAction(event);
        rightButton.setOnAction(event);
//        topButton.setOnAction(e->centerText.setText(topButton.getText())); // Alternativ
//        leftButton.setOnAction(e->centerText.setText(leftButton.getText())); // Alternativ
//        bottomButton.setOnAction(e->centerText.setText(bottomButton.getText())); // Alternativ
//        rightButton.setOnAction(e->centerText.setText(rightButton.getText())); // Alternativ

//        Elemente ins UI hinzufügen
        root.setTop(topButton);
        root.setLeft(leftButton);
        root.setBottom(bottomButton);
        root.setRight(rightButton);
        root.setCenter(centerText);

//        Elemente im UI Positionieren
        BorderPane.setAlignment(topButton, Pos.CENTER);
        BorderPane.setAlignment(leftButton, Pos.CENTER);
        BorderPane.setAlignment(bottomButton, Pos.CENTER);
        BorderPane.setAlignment(rightButton, Pos.CENTER);

//        Basic Fenster blabla
        Scene scene = new Scene(root,300,200);
        primaryStage.setTitle("Aufgabe 1.2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
