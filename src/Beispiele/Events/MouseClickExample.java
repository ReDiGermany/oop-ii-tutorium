package Beispiele.Events;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MouseClickExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Button button = new Button("*click*");
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,e->{
            if(1==e.getClickCount()){
                System.out.println("Single Click");
            }else if(2==e.getClickCount()){
                System.out.println("Double Click");
            }else {
                System.out.println("Multi Click ("+e.getClickCount()+")");
            }
        });

        root.getChildren().add(button);

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("Mouse Klick Beispiel");
        stage.show();
    }
}
