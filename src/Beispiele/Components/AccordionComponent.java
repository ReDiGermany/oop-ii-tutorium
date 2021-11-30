package Beispiele.Components;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AccordionComponent extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        Accordion accordion = new Accordion();
        TitledPane pane1 = new TitledPane("Boats" , new Label("Show all boats available"));
        TitledPane pane2 = new TitledPane("Cars"  , new Label("Show all cars available"));
        TitledPane pane3 = new TitledPane("Planes", new Label("Show all planes available"));
        accordion.getPanes().addAll(pane1,pane2,pane3);
        accordion.expandedPaneProperty().addListener(new ChangeListener<TitledPane>() {
            @Override
            public void changed(ObservableValue<? extends TitledPane> observableValue, TitledPane titledPane, TitledPane t1) {
                System.out.println(titledPane+" -> "+t1);
            }
        });

        root.getChildren().add(accordion);

        stage.setScene(new Scene(root,300,200));
        stage.setTitle("Accordion Component");
        stage.show();
    }
}
