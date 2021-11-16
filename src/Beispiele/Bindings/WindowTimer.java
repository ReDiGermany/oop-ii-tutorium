package Beispiele.Bindings;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WindowTimer extends Application {
    Label label = new Label("Waiting...");
    TextField text = new TextField();
    Timer timer = new Timer();

    private void openWindow() {
        Stage stage = new Stage();

        VBox root = new VBox(text);

        stage.setScene(new Scene(root,300,50));
        stage.setTitle("Window Timer");
        stage.show();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("Open");
        button.setOnAction(e->{
            openWindow();
        });
        timer.start();

        VBox root = new VBox(button,label);

        stage.setScene(new Scene(root,300,300));
        stage.setTitle("Window Timer");
        stage.show();
    }

    class Timer extends Thread {
        @Override
        public void run() {
            Platform.runLater(()->{
                label.setText(text.getText());
            });
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }
    }
}
