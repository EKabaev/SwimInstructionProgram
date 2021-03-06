package mainpage;
//import java.util.ArrayList;
import general.Storage;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
//import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import table.Table;

public class ControlPane {
    
    private Pane controlPane = new Pane();
    private static final Border testBorder = new Border(new BorderStroke(Color.BLACK, 
        BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT));
    //Getter variables 
    private RadioButton[] graphs = new RadioButton[Storage.AMT_GROUPS];
    private FlowPane graphPane = new FlowPane();
    private HBox[] tableControls = new HBox[Storage.AMT_GROUPS];
    private VBox rowPane = new VBox();
    private TextField nameField = new TextField();
    private TextField monthField = new TextField();
    private TextField dayField = new TextField();
    private TextArea descriptionField = new TextArea();
    ToggleGroup toggleRB = new ToggleGroup();
    
    public ControlPane() {
        //Default Constructor
    }
    
    public ControlPane(Pane controlPane) {
        VBox layoutGeneral = new VBox();    //Contains everything vertically
        FlowPane layoutTitle = new FlowPane();  //layout for name, month, day
        VBox layoutRows = new VBox();   //layout for groups 
        FlowPane layoutGraphs = new FlowPane(); //layout for selecting graphs
        FlowPane layoutButton = new FlowPane();
        //ArrayList<Region> spacers = new ArrayList<>();  //TODO
        
        // 1. Set up the Header, added with out a layout. 
        Label header = new Label();
        header.setText("Control Panel");
        header.setFont(Font.font("Arial", 24));
        header.setBorder(testBorder);
        header.setPrefSize(250, 40);
        header.setTextAlignment(TextAlignment.CENTER);
        header.setAlignment(Pos.CENTER);
        
        // 2. Set up Layout for the title 
        Label name = new Label();
        Label month = new Label();
        Label day = new Label();
        TextField nameArea = new TextField();
        TextField monthArea = new TextField();
        TextField dayArea = new TextField();
        
        name.setText("Name: ");
        name.setFont(Font.font("Arial", 20));
        name.setBorder(testBorder);
        name.setPrefSize(80, 40);
        name.setTextAlignment(TextAlignment.CENTER);
        name.setAlignment(Pos.CENTER_RIGHT);
        
        nameArea.setText(Storage.workoutName);
        Storage.nameStyle.setFill(Color.GREEN); //TODO fix Color
        Storage.nameStyle.textProperty().bind(nameArea.textProperty());
        nameArea.setFont(Font.font("Arial", 20));
        nameArea.setBorder(testBorder);
        nameArea.setPrefSize(170,40);
        nameArea.setAlignment(Pos.CENTER);
        nameArea.setOnMouseClicked(CPListeners.clearWorkoutText);
        nameArea.textProperty().addListener(CPListeners.storeWorkoutText);
        nameArea.focusedProperty().addListener(CPListeners.defaultWorkoutText);
        this.nameField = nameArea;
        
        month.setText("Month: ");
        month.setFont(Font.font("Arial", 20));
        month.setBorder(testBorder);
        month.setPrefSize(80, 40);
        month.setTextAlignment(TextAlignment.CENTER);
        month.setAlignment(Pos.CENTER);
        
        monthArea.setText(Storage.monthName);
        monthArea.setFont(Font.font("Arial", 20));
        monthArea.setBorder(testBorder);
        monthArea.setPrefSize(60,40);
        monthArea.setAlignment(Pos.CENTER);
        monthArea.setOnMouseClicked(CPListeners.clearMonthText);
        monthArea.textProperty().addListener(CPListeners.storeMonth);
        monthArea.focusedProperty().addListener(CPListeners.defaultMonthText);
        this.monthField = monthArea;
        
        day.setText("Day: ");
        day.setFont(Font.font("Arial", 20));
        day.setBorder(testBorder);
        day.setPrefSize(50, 40);
        day.setTextAlignment(TextAlignment.CENTER);
        day.setAlignment(Pos.CENTER_LEFT);
        
        dayArea.setText(Storage.dayName);
        dayArea.setFont(Font.font("Arial", 20));
        dayArea.setBorder(testBorder);
        dayArea.setPrefSize(60,40);
        dayArea.setAlignment(Pos.CENTER);
        dayArea.setOnMouseClicked(CPListeners.clearDayText);
        dayArea.textProperty().addListener(CPListeners.storeDay);
        dayArea.focusedProperty().addListener(CPListeners.defaultDayText);
        this.dayField = dayArea;
        
        layoutTitle.setPrefSize(250, 80);
        layoutTitle.setMaxWidth(250);
        layoutTitle.getChildren().addAll(name, nameArea, month, 
            monthArea, day, dayArea);
        
        // 3. Description set up 
        Label description = new Label();
        TextArea descriptionArea = new TextArea();
        description.setText("Description:");
        description.setFont(Font.font("Arial", 20));
        description.setBorder(testBorder);
        description.setPrefSize(250, 40);
        description.setTextAlignment(TextAlignment.CENTER);
        description.setAlignment(Pos.CENTER);
        
        descriptionArea = new TextArea(Storage.descriptionText);
        descriptionArea.setFont(Font.font("Arial", 20));
        descriptionArea.setBorder(testBorder);
        descriptionArea.setPrefSize(250,150);
        descriptionArea.setMaxWidth(250);
        descriptionArea.setWrapText(true);
        descriptionArea.setOnMouseClicked(CPListeners.clearDescription);
        descriptionArea.textProperty().addListener(CPListeners.storeDescription);
        descriptionArea.focusedProperty().addListener(CPListeners.defaultDescription);
        this.descriptionField = descriptionArea;
        
        // 4. Row and Graph set Up 
        HBox[] tableControl = new HBox[Storage.AMT_GROUPS];
        RadioButton[] selectGraph = new RadioButton[Storage.AMT_GROUPS];
        TableModifiers[] controlSet = new TableModifiers[Storage.AMT_GROUPS];
        ToggleGroup toggleRB = new ToggleGroup();
        for (int i = 0; i < Storage.AMT_GROUPS; i++) {
            tableControl[i] = new HBox();
            tableControl[i].setPrefSize(250, 40);
            tableControl[i].setMaxWidth(250);
            tableControl[i].setMaxHeight(50);
            controlSet[i] = new TableModifiers(MainPage.getTable(i + 1));
            tableControl[i].getChildren().addAll(controlSet[i].getAddRow(), 
                controlSet[i].getRemRow(), controlSet[i].getCopyRow()
                , controlSet[i].getPasteRow(), controlSet[i].getClearRow());
            this.tableControls = tableControl;
            
            selectGraph[i] = new RadioButton("Graph " + (i + 1));
            selectGraph[i].setToggleGroup(toggleRB);
            this.graphs[i] = selectGraph[i];
        }
        toggleRB.selectedToggleProperty().addListener(CPListeners.radioButton);
        this.toggleRB = toggleRB;
        selectGraph[0].setSelected(true);

        layoutRows.setPrefSize(250, 150);
        layoutRows.setBorder(testBorder);

        layoutRows.getChildren().add(tableControl[0]);
        this.rowPane = layoutRows;
        
        layoutGraphs.setPrefSize(250, 40);
        layoutGraphs.setMaxWidth(250);
        layoutGraphs.getChildren().add(selectGraph[0]);
        this.graphPane = layoutGraphs;
        
        // 5. Table button set up
        Button addGroup = new Button("Add Group");
        Button remGroup = new Button("Remove Group");
        Button gameDay = new Button("Game Day");
        Button reset = new Button("Reset");
        Button save = new Button("Save");
        
        addGroup.setPrefSize(80, 40);
        addGroup.setAlignment(Pos.CENTER);
        addGroup.setFont(Font.font("Arial", 12));
        addGroup.setOnAction(CPListeners.addControls);
        
        remGroup.setPrefSize(100, 40);
        remGroup.setAlignment(Pos.CENTER);
        remGroup.setFont(Font.font("Arial", 12));
        remGroup.setOnAction(CPListeners.remControls);

        gameDay.setPrefSize(80, 40);
        gameDay.setAlignment(Pos.CENTER);
        gameDay.setFont(Font.font("Arial", 12));
        gameDay.setOnAction(CPListeners.gameDay);
        
        reset.setPrefSize(80, 40);
        reset.setAlignment(Pos.CENTER);
        reset.setFont(Font.font("Arial", 12));
        reset.setOnAction(CPListeners.reset);
        
        save.setPrefSize(80, 40);
        save.setAlignment(Pos.CENTER);
        save.setFont(Font.font("Arial", 12));
        save.setOnAction(CPListeners.save);
        
        layoutButton.setPrefWidth(250);
        layoutButton.setMaxWidth(250);
        layoutButton.setMaxHeight(100);
        layoutButton.setBorder(testBorder);
        layoutButton.getChildren().addAll(addGroup, remGroup, gameDay, reset, save);
        
        layoutGeneral.getChildren().addAll(header, layoutTitle, description, 
            descriptionArea, layoutButton, layoutRows, layoutGraphs);
        controlPane.getChildren().add(layoutGeneral);
        this.controlPane = controlPane;
    }
    //Getters for action events
    // Returns the radio button at the selected index for the graph selector
    public RadioButton getRadioButton(int index) {
      return graphs[index];
    }
    
    public ToggleGroup getToggle() {
        return toggleRB;
    }
    // Returns the layout for the graph selector radio buttons
    public FlowPane getGraphLayout() {
        return graphPane;
    }
    //Returns the entire controlPane 
    public Pane getControlPane() {
        return controlPane;
    }
    //Returns HBox layout for the selected table. Layout has add row, rem row
    //copy row, paste row, and clear row buttons. 
    public HBox getTableController(int index) {
        return tableControls[index];
    }
    // Returns the layout for the tableControls 
    public VBox getRowLayout() {
        return rowPane;
    }
    // Returns the TextField for the workout name
    public TextField getWorkoutName() {
        return nameField;
    }
    // Returns the TextField for the month 
    public TextField getMonth() {
        return monthField;
    }
    //Returns the TextField for the day
    public TextField getDay() {
        return dayField;
    }
    //Returns the TextArea for the description
    public TextArea getDescription() {
        return descriptionField;
    }
}
