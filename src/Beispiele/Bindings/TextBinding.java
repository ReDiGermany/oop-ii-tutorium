package Beispiele.Bindings;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextBinding extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        TextField leftField = new TextField();
        TextField rightField = new TextField();
        leftField.textProperty().bind(rightField.textProperty());
        HBox root = new HBox(leftField,rightField);

        stage.setScene(new Scene(root,300,50));
        stage.setTitle("Text Binding");
        stage.show();
    }
}
