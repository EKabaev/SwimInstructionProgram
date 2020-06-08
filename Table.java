import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.converter.IntegerStringConverter;

public class Table {
    
    
    private TableView<Set> TABLE = new TableView<>();
    
    public Table(TableView<Set> table) {
        table.setPrefSize(1350, 400);
        table.setEditable(true);
        String[] columnNames = new String[] {"Set","Rounds","Reps","Distance",
            "Description","Type","Minutes","Seconds", "Intensity"};
        
        TableColumn<Set, String> setNum = new TableColumn<>(columnNames[0]);
        setNum.setPrefWidth(67.5);    //TODO move background 5% of table
        setNum.setMinWidth(67.5);
        setNum.setMaxWidth(67.5);   //Total the three stops from resizing
        setNum.setCellValueFactory(new PropertyValueFactory<Set, String>("setCol"));
        setNum.setCellFactory(TextFieldTableCell.forTableColumn());
        setNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setSetCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        setNum.addEventHandler(KeyEvent.KEY_TYPED, Background.addRow);
        
        TableColumn<Set, String> roundNum = new TableColumn<>(columnNames[1]);
        roundNum.setPrefWidth(67.5);    //TODO move background 5% of table
        roundNum.setMaxWidth(67.5);
        roundNum.setMinWidth(67.5);
        roundNum.setCellValueFactory(new PropertyValueFactory<Set, String>("roundsCol"));
        roundNum.setCellFactory(TextFieldTableCell.forTableColumn());
        roundNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setRoundsCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        
        TableColumn<Set, String> repNum = new TableColumn<>(columnNames[2]);
        repNum.setPrefWidth(67.5);    //TODO move background 5% of table
        repNum.setMaxWidth(67.5);
        repNum.setMinWidth(67.5);
        repNum.setCellValueFactory(new PropertyValueFactory<Set, String>("repsCol"));
        repNum.setCellFactory(TextFieldTableCell.forTableColumn());
        repNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setRepsCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        
        TableColumn<Set, String> distanceNum = new TableColumn<>(columnNames[3]);
        distanceNum.setPrefWidth(202.5);    //TODO move background 15% of table
        distanceNum.setMinWidth(202.5);
        distanceNum.setMaxWidth(202.5);
        distanceNum.setCellValueFactory(new PropertyValueFactory<Set, String>("distanceCol"));
        distanceNum.setCellFactory(TextFieldTableCell.forTableColumn());
        distanceNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setDistanceCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        
        TableColumn<Set, String> description = new TableColumn<>(columnNames[4]);
        description.setPrefWidth(405);    //TODO move background 30% of table
        description.setMaxWidth(405);
        description.setMinWidth(405);
        description.setCellValueFactory(new PropertyValueFactory<Set, String>("descriptionCol"));
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    ((Set) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setDescriptionCol(t.getNewValue());
                }
            }
        );
        
        TableColumn<Set, String> type = new TableColumn<>(columnNames[5]);
        type.setPrefWidth(135);    //TODO move background 10% of table
        type.setMaxWidth(135);
        type.setMinWidth(135);
        type.setCellValueFactory(new PropertyValueFactory<Set, String>("typeCol"));
        type.setCellFactory(TextFieldTableCell.forTableColumn());
        type.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setTypeCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        
        
        TableColumn<Set, String> minNum = new TableColumn<>(columnNames[6]);
        minNum.setPrefWidth(135);    //TODO move background 10% of table
        minNum.setMaxWidth(135);
        minNum.setMinWidth(135);
        minNum.setCellValueFactory(new PropertyValueFactory<Set, String>("minCol"));
        minNum.setCellFactory(TextFieldTableCell.forTableColumn());
        minNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setMinCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        
        TableColumn<Set, String> secNum = new TableColumn<>(columnNames[7]);
        secNum.setPrefWidth(135);    //TODO move background 10% of table
        secNum.setMaxWidth(135);
        secNum.setMinWidth(135);
        secNum.setCellValueFactory(new PropertyValueFactory<Set, String>("secCol"));
        secNum.setCellFactory(TextFieldTableCell.forTableColumn());
        secNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setSecCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );
        
        TableColumn<Set, String> IntensityNum = new TableColumn<>(columnNames[8]);
        IntensityNum.setPrefWidth(130);    //TODO move background 10% of table
        IntensityNum.setMaxWidth(130);
        IntensityNum.setMinWidth(130);
        IntensityNum.setCellValueFactory(new PropertyValueFactory<Set, String>("intensityCol"));
        IntensityNum.setCellFactory(TextFieldTableCell.forTableColumn());
        IntensityNum.setOnEditCommit(
            new EventHandler<CellEditEvent<Set, String>>() {
                @Override
                public void handle(CellEditEvent<Set, String> t) {
                    // Checks to see if the input is a number
                    if (Background.isNumeric(t.getNewValue())) {    
                        //if true then the value is accepted
                        ((Set) t.getTableView().getItems().get(
                            t.getTablePosition().getRow())
                            ).setIntensityCol(t.getNewValue());
                    } else {
                        //if false, the old value remains    
                        table.refresh();
                    }
                }
            }
        );       
        
        TableColumn<Set, Integer> time = new TableColumn<>("Time");
        time.getColumns().addAll(minNum, secNum);
        
        table.setItems(Storage.data);
        table.getColumns().addAll(setNum, roundNum, repNum, distanceNum, 
            description, type, time, IntensityNum);
        this.TABLE = table;
    }
    public TableView<Set> getTable() {
        return TABLE;
    }
    
    public void addTable(Pane tablePane) {
        tablePane.getChildren().add(TABLE);
    }
}
