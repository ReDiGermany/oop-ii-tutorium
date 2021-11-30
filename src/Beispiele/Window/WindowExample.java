package Beispiele.Window;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowExample extends Application {

    private Stage primaryStage;
    public Stage openSimpleWindow(){
        Stage stage = new Stage();

        Pane root = new Pane(new Label("NONE"));
        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Zweites Fenster");
        return stage;
    }
    public Stage openWindow(){
        Stage stage = new Stage();

        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);
        Button button = new Button("open2");
        button.setOnAction(e->{
            openWindow2().show();
        });

        VBox root = new VBox(new Label("WINDOW_MODAL"),button);
        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Zweites Fenster");
        return stage;
    }
    public Stage openWindow2(){
        Stage stage = new Stage();

        stage.initOwner(primaryStage);
        stage.initModality(Modality.APPLICATION_MODAL);

        Pane root = new Pane(new Label("APPLICATION_MODAL"));
        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Zweites Fenster");
        return stage;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Label label = new Label("Hallo Welt");
        Button button = new Button("Öffne beide Fenster");

        button.setOnAction(e->{
            openWindow().show();
            openSimpleWindow().show();
            // Platform.exit(); beendet Programm
        });

        VBox root = new VBox(label,button);

        primaryStage.setScene(new Scene(root,300,200));
        primaryStage.setTitle("Hauptfenster");
        primaryStage.show();
    }
}
