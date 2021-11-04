package Beispiele.Events;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class EventsDragExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Rectangle rect = new Rectangle(200,100, Color.DARKSEAGREEN);

        rect.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {
            private double x;
            private double y;

            private double offx=0;
            private double offy=0;
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(MouseEvent.MOUSE_ENTERED.equals(mouseEvent.getEventType())){
                    rect.setCursor(Cursor.OPEN_HAND);
                }else if(MouseEvent.MOUSE_PRESSED.equals(mouseEvent.getEventType())){
                    x = mouseEvent.getSceneX()-offx;
                    y = mouseEvent.getSceneY()-offy;
                    rect.setCursor(Cursor.CLOSED_HAND);
                }else if(MouseEvent.MOUSE_RELEASED.equals(mouseEvent.getEventType())){
                    offx = rect.getTranslateX();
                    offy = rect.getTranslateY();
                    rect.setCursor(Cursor.OPEN_HAND);
                }else if(MouseEvent.MOUSE_DRAGGED.equals(mouseEvent.getEventType())){
                    double x = mouseEvent.getSceneX()-this.x;
                    double y = mouseEvent.getSceneY()-this.y;

                    if(x<0) x=0;
                    if(y<0) y=0;
                    if(x+rect.getWidth()>root.getWidth()) x=root.getWidth()-rect.getWidth();
                    if(y+rect.getHeight()>root.getHeight()) y=root.getHeight()-rect.getHeight();

                    rect.setTranslateX(x);
                    rect.setTranslateY(y);
                }
            }
        });

        root.getChildren().add(rect);

        stage.setScene(new Scene(root,500,400));
        stage.setTitle("Drag & Drop");
        stage.show();
    }
}
