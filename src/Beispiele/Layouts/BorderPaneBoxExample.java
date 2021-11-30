package Beispiele.Layouts;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPaneBoxExample extends Application {
    Label labelCenter = new Label("Center");
    Label labelLeft = new Label("Left");
    Label labelTop = new Label("Top");
    Label labelRight = new Label("Right");
    Label labelBottom = new Label("Bottom");

    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();
        HBox row = new HBox();
        row.getChildren().addAll(labelLeft,labelCenter,labelRight);
        root.getChildren().addAll(labelTop,row,labelBottom);

        labelLeft.setEllipsisString(labelLeft.getText());
        labelRight.setEllipsisString(labelRight.getText());
        labelCenter.setAlignment(Pos.CENTER);
        labelTop.setAlignment(Pos.CENTER);
        labelBottom.setAlignment(Pos.CENTER);

        stage.setScene(new Scene(root,200,100));
        stage.setTitle("BorderPane Box Beispiel");
        stage.show();

        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                setWidth(number.doubleValue());
            }
        });
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                setHeight(number.doubleValue());
            }
        });
        setWidth(stage.getWidth());
        setHeight(stage.getHeight());
    }

    public void setWidth(double num) {
        labelCenter.setPrefWidth(
            num -
            labelLeft.getLayoutBounds().getWidth() -
            labelRight.getLayoutBounds().getWidth()
        );
        labelTop.setPrefWidth(num);
        labelBottom.setPrefWidth(num);
    }

    public void setHeight(double num){
        double height = num -
            labelTop.getLayoutBounds().getHeight()-
            labelBottom.getLayoutBounds().getHeight();
        labelLeft.setPrefHeight(height);
        labelCenter.setPrefHeight(height);
        labelRight.setPrefHeight(height);
    }
}
