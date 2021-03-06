package table;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import general.Storage;

public class Table {
    
    
    private TableView<Set> TABLE = new TableView<>();
    private Label header = new Label();
    private int IDnum;
    ObservableList<Set> datagroup = FXCollections.observableArrayList();
    //Empty constructor
    public Table() {
        
    }
    
    @SuppressWarnings("unchecked")
    public Table(TableView<Set> table, ObservableList<Set> data, int ID) {
        this.IDnum = ID;
        table.setPrefSize(1000, 400);
        table.setEditable(true);
        table.setPlaceholder(new Label("Table is empty"));  //TODO IMAGE
        String[] columnNames = new String[] {"Set","Rounds","Reps","Distance",
            "Description","Type","Minutes","Seconds", "Intensity"};
        TableEvents e = new TableEvents(ID);
        
        TableColumn<Set, String> setNum = new TableColumn<>(columnNames[0]);
        setNum.setPrefWidth(50);    //TODO move background 5% of table
        setNum.setMinWidth(50);
        setNum.setMaxWidth(50);   //Total the three stops from resizing
        setNum.setCellValueFactory(new PropertyValueFactory<Set, String>("setCol"));
        setNum.setCellFactory(TextFieldTableCell.forTableColumn());
        setNum.setOnEditCommit(e.getSet());
        
        TableColumn<Set, String> roundNum = new TableColumn<>(columnNames[1]);
        roundNum.setPrefWidth(50);    //TODO move background 5% of table
        roundNum.setMaxWidth(50);
        roundNum.setMinWidth(50);
        roundNum.setCellValueFactory(new PropertyValueFactory<Set, String>("roundsCol"));
        roundNum.setCellFactory(TextFieldTableCell.forTableColumn());
        roundNum.setOnEditCommit(e.getRound());
        
        TableColumn<Set, String> repNum = new TableColumn<>(columnNames[2]);
        repNum.setPrefWidth(50);    //TODO move background 5% of table
        repNum.setMaxWidth(50);
        repNum.setMinWidth(50);
        repNum.setCellValueFactory(new PropertyValueFactory<Set, String>("repsCol"));
        repNum.setCellFactory(TextFieldTableCell.forTableColumn());
        repNum.setOnEditCommit(e.getRep());
        
        TableColumn<Set, String> distanceNum = new TableColumn<>(columnNames[3]);
        distanceNum.setPrefWidth(150);    //TODO move background 15% of table
        distanceNum.setMinWidth(150);
        distanceNum.setMaxWidth(150);
        distanceNum.setCellValueFactory(new PropertyValueFactory<Set, String>("distanceCol"));
        distanceNum.setCellFactory(TextFieldTableCell.forTableColumn());
        distanceNum.setOnEditCommit(e.getDistance());
        
        TableColumn<Set, String> description = new TableColumn<>(columnNames[4]);
        description.setPrefWidth(300);    //TODO move background 30% of table
        description.setMaxWidth(300);
        description.setMinWidth(300);
        description.setCellValueFactory(new PropertyValueFactory<Set, String>("descriptionCol"));
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setOnEditCommit(e.getDescription());
        
        TableColumn<Set, String> type = new TableColumn<>(columnNames[5]);
        type.setPrefWidth(100);    //TODO move background 10% of table
        type.setMaxWidth(100);
        type.setMinWidth(100);
        type.setCellValueFactory(cellData -> cellData.getValue().typeProperty());
        type.setCellFactory(ComboBoxTableCell.forTableColumn(Storage.typeSelector));
        type.setOnEditCommit(e.getType());

        
        TableColumn<Set, String> minNum = new TableColumn<>(columnNames[6]);
        minNum.setPrefWidth(100);    //TODO move background 10% of table
        minNum.setMaxWidth(100);
        minNum.setMinWidth(100);
        minNum.setCellValueFactory(new PropertyValueFactory<Set, String>("minCol"));
        minNum.setCellFactory(TextFieldTableCell.forTableColumn());
        minNum.setOnEditCommit(e.getMin());
        
        TableColumn<Set, String> secNum = new TableColumn<>(columnNames[7]);
        secNum.setPrefWidth(100);    //TODO move background 10% of table
        secNum.setMaxWidth(100);
        secNum.setMinWidth(100);
        secNum.setCellValueFactory(new PropertyValueFactory<Set, String>("secCol"));
        secNum.setCellFactory(TextFieldTableCell.forTableColumn());
        secNum.setOnEditCommit(e.getSec());
        
        TableColumn<Set, String> IntensityNum = new TableColumn<>(columnNames[8]);
        IntensityNum.setPrefWidth(95);    //TODO move background 10% of table
        IntensityNum.setMaxWidth(95);
        IntensityNum.setMinWidth(95);
        IntensityNum.setCellValueFactory(new PropertyValueFactory<Set, String>("intensityCol"));
        IntensityNum.setCellFactory(TextFieldTableCell.forTableColumn());
        IntensityNum.setOnEditCommit(e.getIntensity());   
        
        TableColumn<Set, Integer> time = new TableColumn<>("Time");
        time.getColumns().addAll(minNum, secNum); 
        table.getColumns().addAll(setNum, roundNum, repNum, distanceNum, 
            description, type, time, IntensityNum);
        TABLE = table;
        table.setItems(data); 
        TableUtils.installCopyPasteHandler(table);
        this.datagroup = data;
        //Set Up Labels
        Label tableHeader = new Label(Storage.TABLE_HEADERS[ID - 1]);
        tableHeader.setPrefSize(1000, 50);
        tableHeader.setTextAlignment(TextAlignment.CENTER);
        tableHeader.setAlignment(Pos.CENTER);
        tableHeader.setFont(Font.font("Arial", 32));
        tableHeader.setTextFill(Color.RED);
        this.header = tableHeader;
    }
   
    public TableView<Set> getTableView() {
        return this.TABLE;
    }
    
    public void addTable(Pane tablePane) {
        tablePane.getChildren().addAll(header, TABLE);
    }
    
    public void remTable(Pane tablePane) {
        tablePane.getChildren().removeAll(header, TABLE);
    }
    
    public int getID() {
        return IDnum;
    }
    
    public void setData(ObservableList<Set> data) {
        TABLE.setItems(data);
    }
    
    public ObservableList<Set> getData(){
        return datagroup;
    }
    
    public Set getCell(int index) {
        return datagroup.get(index);
    }
    
}

