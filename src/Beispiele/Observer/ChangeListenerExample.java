package Beispiele.Observer;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ChangeListenerExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("Change Listener Beispiel");
        stage.show();

        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("Height gone from "+number.doubleValue()+" to "+t1.doubleValue());
            }
        });
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println("Width gone from "+number.doubleValue()+" to "+t1.doubleValue());
            }
        });
    }
}
