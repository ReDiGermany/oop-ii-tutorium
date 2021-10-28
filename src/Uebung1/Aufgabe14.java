package Uebung1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Aufgabe14 extends Application {
    private final Stage subStage = new Stage();
    private Stage primaryStage;
    private boolean close = false;

    public void createSubWindow(){
        subStage.initOwner(primaryStage);
        subStage.initModality(Modality.APPLICATION_MODAL);

        VBox subStageRoot = new VBox();
        subStageRoot.setPadding(new Insets(10));

        Label label = new Label("Wollen Sie wirklich beenden?");
        label.setPadding(new Insets(0,0,10,0));

        Button okButton = new Button("OK");
        Button cancelButton = new Button("Abbrechen");
        cancelButton.setOnAction(e->subStage.hide());
//        okButton.setOnAction(e->Platform.exit());
        okButton.setOnAction(e->{
            close = true;
            subStage.hide();
        });
        cancelButton.setAlignment(Pos.CENTER_RIGHT);
        AnchorPane buttonPane = new AnchorPane();
        AnchorPane.setBottomAnchor(okButton,0.0);
        AnchorPane.setBottomAnchor(cancelButton,0.0);
        AnchorPane.setRightAnchor(cancelButton,0.0);
        buttonPane.getChildren().addAll(okButton,cancelButton);
//        cancelButton.setAlignment(Pos.BOTTOM_RIGHT);
        subStageRoot.getChildren().addAll(label,buttonPane);

        Scene subStageScene = new Scene(subStageRoot);
        subStage.setTitle("Aufgabe 1.4 - Exit?");
        subStage.setScene(subStageScene);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        createSubWindow();

//        Root Element erstellen
        BorderPane root = new BorderPane();

        Button button = new Button("Schließen");
        button.setOnAction(e->{
//            Platform.exit();
//            subStage.show();
            subStage.showAndWait();
            if(close) Platform.exit();
        });

        root.setCenter(button);

//        Basic Fenster blabla
        Scene scene = new Scene(root,300,200);
        primaryStage.setTitle("Aufgabe 1.4");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
