package Beispiele.Components;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class BoxComponent extends Application {
    class MyLabel extends Label {
        public MyLabel(String text){
            super(text);
            setWidth(100);
            setMinWidth(100);
            setMaxWidth(100);
            setTextAlignment(TextAlignment.CENTER);
        }
    }
    class MyHBox extends HBox {
        public MyHBox(Node ...items){
            super(items);
            setPadding(new Insets(10,10,0,10));
        }
    }
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        // <editor-fold desc="Label">
        {
            Label item = new Label("Label");
            root.getChildren().add(new MyHBox(new MyLabel("Label"), item));
        }
        // </editor-fold>

        // <editor-fold desc="Button">
        {
            Button item = new Button("Button");
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    System.out.println("Button clicked");
                }
            });
            root.getChildren().add(new MyHBox(new MyLabel("Button"), item));
        }
        // </editor-fold>

        // <editor-fold desc="DatePicker">
        {
            String bday = "19.10.1994";
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

            DatePicker item = new DatePicker();
            item.setValue(LocalDate.parse(bday,formatter));
            item.valueProperty().addListener((observableValue,  localDate,  t1) ->{
                System.out.println("Picked Date: "+t1.format(formatter));
            });
            root.getChildren().add(new MyHBox(new MyLabel("DatePicker"), item));
        }
        // </editor-fold>

        // <editor-fold desc="TextField">
        {
            TextField item = new TextField();
            item.textProperty().addListener((observableValue,  s,  t1) -> {
                System.out.println("New Text: "+t1);
            });

            root.getChildren().add(new MyHBox(new MyLabel("TextField"), item));
        }
        // </editor-fold>

        // <editor-fold desc="PasswordField">
        {
            PasswordField item = new PasswordField();
            item.textProperty().addListener((observableValue,  s,  t1) -> {
                System.out.println("New PW: "+t1);
            });

            root.getChildren().add(new MyHBox(new MyLabel("PasswordField"), item));
        }
        // </editor-fold>

        // <editor-fold desc="TextArea">
        {
            TextArea item = new TextArea();
            item.setMaxWidth(200);
            item.setMaxHeight(50);
            item.textProperty().addListener(( observableValue,  s,  t1)-> {
                System.out.println("TextArea text: "+t1);
            });
            root.getChildren().add(new MyHBox(new MyLabel("TextArea"), item));
        }
        // </editor-fold>

        // <editor-fold desc="Checkbox">
        {
            CheckBox item = new CheckBox();
            item.selectedProperty().addListener((observableValue, aBoolean, t1)-> {
                System.out.println("Checkbox " + (t1 ? "selected" : "unselected"));
            });
            root.getChildren().add(new MyHBox(new MyLabel("CheckBox"), item));
        }
        // </editor-fold>

        // <editor-fold desc="RadioButton">
        {
            RadioButton item = new RadioButton();
            item.selectedProperty().addListener((observableValue, aBoolean, t1)-> {
                System.out.println("RadioButton " + (t1 ? "selected" : "unselected"));
            });
            root.getChildren().add(new MyHBox(new MyLabel("RadioButton"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ToggleGroup">
        {
            ToggleGroup toggleGroup = new ToggleGroup();

            RadioButton item = new RadioButton();
            item.setUserData("Item");
            item.setToggleGroup(toggleGroup);

            RadioButton item1 = new RadioButton();
            item1.setUserData("Item 2");
            item1.setToggleGroup(toggleGroup);

            toggleGroup.selectedToggleProperty().addListener(( observableValue,  toggle,  t1) ->{
                System.out.println("Selected group item: "+t1.getUserData());
            });
            root.getChildren().add(new MyHBox(new MyLabel("ToggleGroup"), item,item1));
        }
        // </editor-fold>

        // <editor-fold desc="ChoiceBox">
        {
            ChoiceBox<String> item = new ChoiceBox<>();
            String[] choiceBoxElements = new String[]{"Ich", "Du", "Er", "Sie", "Es", "Bot"};
            item.setItems(FXCollections.observableArrayList(choiceBoxElements));
            item.setValue("Wir");
            // item.getSelectionModel().select(0);
            item.valueProperty().addListener((observableValue,  s, t1)-> {
                System.out.println("Selected: " + t1 + " - " + item.getSelectionModel().getSelectedIndex());
            });
            root.getChildren().add(new MyHBox(new MyLabel("ChoiceBox"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ColorPicker">
        {
            ColorPicker item = new ColorPicker();
            item.setValue(Color.valueOf("#4ae53a"));
            item.valueProperty().addListener((observableValue, color, t1)-> {
                System.out.println("Color: "+t1);
            });
            root.getChildren().add(new MyHBox(new MyLabel("ColorPicker"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ContextMenu">
        {
            ContextMenu item = new ContextMenu();
            MenuItem item1 = new MenuItem("Item1");
            MenuItem item2 = new MenuItem("Item2");
            item1.setOnAction(e->{
                System.out.println("Item1 geklickt.");
            });
            item2.setOnAction(e->{
                System.out.println("Item2 geklickt.");
            });
            item.getItems().addAll(item1,item2);
            Label label = new Label("ContextMenü?");
            label.setContextMenu(item);
            root.getChildren().add(new MyHBox(new MyLabel("ColorPicker"), label));
        }
        // </editor-fold>

        // <editor-fold desc="Hyperlink">
        {
            Hyperlink item = new Hyperlink("Link");
            item.setOnAction(e->{
                System.out.println("Link geklickt.");
            });
            root.getChildren().add(new MyHBox(new MyLabel("Dialog"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ListView">
        {
            ListView<String> item = new ListView<>();
            item.getItems().addAll("Wir","Ihr","Sie","Blah");
            item.setMaxHeight(75);
            item.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            item.getSelectionModel().getSelectedIndices().addListener(new ListChangeListener<Integer>() {
                @Override
                public void onChanged(Change<? extends Integer> change) {
                    System.out.println(item.getSelectionModel().getSelectedItem());
                }
            });
            root.getChildren().add(new MyHBox(new MyLabel("ListView"), item));
        }
        // </editor-fold>

        // <editor-fold desc="MenuBar">
        {
            MenuBar item = new MenuBar();

            MenuItem menu11 = new MenuItem("Item1");
            Menu menu1 = new Menu("Menu1");
            menu1.getItems().setAll(menu11);

            MenuItem menu21 = new MenuItem("Item1");
            MenuItem menu22 = new MenuItem("Item2");
            Menu menu2 = new Menu("Menu2");
            menu2.getItems().setAll(menu21,menu22);

            item.getMenus().addAll(menu1,menu2);
            root.getChildren().add(new MyHBox(new MyLabel("MenuBar"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ToolBar">
        {
            ToolBar item = new ToolBar();
            item.getItems().addAll(new Label("Label"),new Button("Button"));
            root.getChildren().add(new MyHBox(new MyLabel("ToolBar"), item));
        }
        // </editor-fold>

        // <editor-fold desc="Pagination">
        {
            Pagination item = new Pagination();
//            item.setMaxPageIndicatorCount(3);
            item.setPageCount(5);
            item.currentPageIndexProperty().addListener((observableValue,  number,  t1) ->{
                System.out.println("Pagination page "+t1+" (displayed as "+(t1.intValue()+1)+")");
            });

            root.getChildren().add(new MyHBox(new MyLabel("Pagination"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ProgressBar">
        {
            ProgressBar item = new ProgressBar();
            item.setProgress(0.3);
            root.getChildren().add(new MyHBox(new MyLabel("ProgressBar"), item));
        }
        // </editor-fold>

        // <editor-fold desc="ProgressIndicator">
        {
            ProgressIndicator item = new ProgressIndicator();
            item.setProgress(0.3);
            root.getChildren().add(new MyHBox(new MyLabel("ProgressIndicator"), item));
        }
        // </editor-fold>

        // <editor-fold desc="Slider">
        {
            ProgressBar progressBar = new ProgressBar();

            Slider item = new Slider();
            item.setMin(0);
            item.setMax(1);
            item.valueProperty().addListener((observableValue,  number,  t1) ->{
                System.out.println("Slider value: "+t1);
            });

            progressBar.progressProperty().bind(item.valueProperty());
            root.getChildren().add(new MyHBox(new MyLabel("Slider"), item,progressBar));
        }
        // </editor-fold>

        // <editor-fold desc="Spinner">
        {
            Spinner<Integer> item = new Spinner<>(0,15,5);
            item.valueProperty().addListener(( observableValue,  integer,  t1) -> {
                System.out.println("Spinner Value: "+t1);
            });
            root.getChildren().add(new MyHBox(new MyLabel("Spinner"), item));
        }
        // </editor-fold>

        // <editor-fold desc="TabPane">
        {
            TabPane item = new TabPane();
            Tab tab1 = new Tab("Tab",new Label("Content"));
            Tab tab2 = new Tab("Tab 2",new Label("Content2"));
            item.getTabs().addAll(tab1,tab2);
            root.getChildren().add(new MyHBox(new MyLabel("TabPane"), item));
        }
        // </editor-fold>

        // <editor-fold desc="TitledPane">
        {
            TitledPane item = new TitledPane();
            item.setText("text");
            item.setContent(new Label("Titled Pane"));
            root.getChildren().add(new MyHBox(new MyLabel("TitledPane"), item));
        }
        // </editor-fold>

        // <editor-fold desc="Tooltip">
        {
            Label item = new Label("Tooltip?");
            Tooltip tooltip = new Tooltip("Hallo Welt!");
            item.setTooltip(tooltip);
            root.getChildren().add(new MyHBox(new MyLabel("Tooltip"), item));
        }
        // </editor-fold>

        // <editor-fold desc="TreeView">
        {
            TreeItem<String> rootItem = new TreeItem<> ("root");
            rootItem.setExpanded(true);

            rootItem.getChildren().add(new TreeItem<> ("Item 1"));

            TreeItem<String> itm2 = new TreeItem<> ("Item 2");
            itm2.setExpanded(true);
            itm2.getChildren().add(new TreeItem<> ("Sub Item 1"));

            rootItem.getChildren().add(itm2);
            rootItem.getChildren().add(new TreeItem<> ("Item 3"));

            TreeView<String> item = new TreeView<>(rootItem);
            item.setMaxHeight(130);
            root.getChildren().add(new MyHBox(new MyLabel("TreeView"), item));
        }
        // </editor-fold>

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        stage.setScene(new Scene(scrollPane,400,500));
        stage.setTitle("Components");
        stage.show();
    }
}
