package Uebung1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Aufgabe13 extends Application {
    private final BorderPane root = new BorderPane();

    private final VBox inputs = new VBox();

    private final String[] fieldNames = new String[]{"vorname","name","alter","geschlecht","strasse","ort","plz"};
    private final TextField[] fields = new TextField[fieldNames.length];

    private Stage primaryStage;

    private void addFields(){
        for (int i=0;i<fieldNames.length;i++) {
//            Label erstellen und positionieren
            Label label = new Label(fieldNames[i].toUpperCase());
            label.setMinSize(100,25);
            label.setAlignment(Pos.CENTER_RIGHT);
            label.setPadding(new Insets(0,10,0,0));

//            Eingabefeld erstellen
            TextField input = new TextField();

//            Label und Eingabefeld hinzufügen
            HBox box = new HBox(label,input);
            inputs.getChildren().add(box);

//            Eingabefeld in Array speichern (für später)
            fields[i] = input;
        }
    }
    private void addButtons(){
//        Box erstellen und positionieren
        BorderPane buttonBox = new BorderPane();
        buttonBox.setPadding(new Insets(10,0,0,0));

//        Buttons erstellen
        Button okButton = new Button("OK");
        Button cancelButton = new Button("Abbrechen");

//        Buttons hinzufügen
        buttonBox.setLeft(okButton);
        buttonBox.setRight(cancelButton);

//        Box hinzufügen
        inputs.getChildren().add(buttonBox);

//        Button funktionen
        okButton.setOnAction(e->{
//            StringBuilder Objekt erstellen
            StringBuilder stringBuilder = new StringBuilder();

//            Durch alle Felder iterieren
            for(int i=0;i< fieldNames.length;i++){
                String str = fieldNames[i]+": "+fields[i].getText();
                stringBuilder.append(str).append("\n");
            }
//            Consolen ausgabe
            System.out.println(stringBuilder);

//            FileChooser öffnen
            FileChooser fileChooser = new FileChooser();
            File ret = fileChooser.showSaveDialog(primaryStage);
            if(ret!=null){
                try (FileWriter fileWriter = new FileWriter(ret)){ // try with
                    fileWriter.write(stringBuilder.toString());
                }catch (IOException ignored){
                    System.out.println("Error saving the file!");
                }
                System.out.println("saved");
            }
        });

//        Cancel = felder leeren
        cancelButton.setOnAction(e->{
            for (TextField field : fields) {
                field.setText("");
            }
        });
    }

    private void readFile(){
//        FileChooser öffnen
        FileChooser fileChooser = new FileChooser();
        File ret = fileChooser.showOpenDialog(primaryStage);
        if(ret!=null){
            try(BufferedReader reader = new BufferedReader(new FileReader(ret))){ // try with
                String line;
                int n = 0;
                while((line = reader.readLine())!=null && !line.equals("")){ // jede Zeile lesen
                    try {
//                        line.split(": ") liefert ein String-Array. Elemente = Sub Strings ohne ": " (z.B. "vorname: asd" = {"vorname","asd"})
                        fields[n++].setText(line.split(": ")[1]);
                    }catch(Exception ignored){}
                }
            } catch (IOException ignored){

            }
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        inputs.setPadding(new Insets(20));
        root.setCenter(inputs);

        addFields();
        addButtons();

        readFile();


//        Basic Fenster blabla
        Scene scene = new Scene(root);
        primaryStage.setTitle("Aufgabe 1.3");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
