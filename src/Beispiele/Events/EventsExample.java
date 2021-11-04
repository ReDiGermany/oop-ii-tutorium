package Beispiele.Events;

import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.EventListener;

public class EventsExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        HBox hbox = new HBox();
        root.getChildren().add(hbox);

        Button button = new Button("*click*");
        hbox.getChildren().add(button);

        button.setOnAction(e->{
            System.out.println("setOnAction");
        });
        button.setOnMouseClicked(e->{
            System.out.println("setOnMouseClicked");
        });

        button.addEventFilter(MouseEvent.MOUSE_CLICKED,e-> {
            System.out.println("Event Filter @button");
        });
        button.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> {
            System.out.println("Event Handler @button");
        });

        hbox.addEventFilter(MouseEvent.MOUSE_CLICKED,e-> {
            System.out.println("Event Filter @hbox");
        });
        hbox.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> {
            System.out.println("Event Handler @hbox");
        });

        root.addEventFilter(MouseEvent.MOUSE_CLICKED,e-> {
            System.out.println("Event Filter @root");
        });
        root.addEventHandler(MouseEvent.MOUSE_CLICKED,e-> {
            System.out.println("Event Handler @root");
        });

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("Events Example");
        stage.show();
    }
}
