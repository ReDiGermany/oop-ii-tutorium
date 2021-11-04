package Beispiele.Window;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowExample extends Application {

    private Stage primaryStage;
    public Stage openWindow(){
        Stage stage = new Stage();

        stage.initOwner(primaryStage);
        stage.initModality(Modality.WINDOW_MODAL);

        Pane root = new Pane(new Label("huehuehue"));
        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Zweites Fenster");
        return stage;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Label label = new Label("Hallo Welt");
        Button button = new Button("Öffne Fenster");

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage s = openWindow();
                s.showAndWait();
                // Platform.exit(); beendet Programm
            }
        });
//        button.setOnAction(e->openWindow()); // später

        VBox root = new VBox(label,button);

        primaryStage.setScene(new Scene(root,300,200));
        primaryStage.setTitle("Hauptfenster");
        primaryStage.show();
    }
}
