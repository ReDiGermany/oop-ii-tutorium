package Beispiele.Components;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ButtonComponent extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        Button btn = new Button("Button");
        btn.setOnAction(e->{
            System.out.println("Button geklickt.");
        });

        ButtonBar btnBar = new ButtonBar();
        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 1");
        btnBar.getButtons().addAll(btn1,btn2);
        ButtonBar.setButtonData(btn1, ButtonBar.ButtonData.LEFT);


        root.getChildren().addAll(btn,btnBar);

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("Button Component");
        stage.show();
    }
}
