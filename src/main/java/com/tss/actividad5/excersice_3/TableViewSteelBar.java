package com.tss.actividad5.excersice_3;

import com.tss.actividad5.common.NumberRandomPair;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.DoubleStringConverter;

import java.util.ArrayList;
import java.util.List;

public class TableViewSteelBar {
    private Utils utils;
    private ObservableList<DataItem> dataSimulate;
    private ObservableList<NumberRandomPair> dataRandomList1;
    private ObservableList<NumberRandomPair> dataRandomList2;
    private ObservableList<NumberRandomPair> dataRandomList3;
    private ObservableList<NumberRandomPair> dataRandomList4;
    private ObservableList<NumberRandomPair> dataRandomList5;


    private TableView<NumberRandomPair> tableRandomView1;
    private TableView<NumberRandomPair> tableRandomView2;
    private TableView<NumberRandomPair> tableRandomView3;
    private TableView<NumberRandomPair> tableRandomView4;
    private TableView<NumberRandomPair> tableRandomView5;


    private TableView<DataItem> tableSimulateView = new TableView<>();
    private String name;

    public TableViewSteelBar() {
        utils = new Utils();
        dataRandomList1 = utils.getRandomDataForTableView(utils.getRandomStackNumbers1());
        dataRandomList2 = utils.getRandomDataForTableView(utils.getRandomStackNumbers2());
        dataRandomList3 = utils.getRandomDataForTableView(utils.getRandomStackNumbers3());
        dataRandomList4 = utils.getRandomDataForTableView(utils.getRandomStackNumbers4());
        dataRandomList5 = utils.getRandomDataForTableView(utils.getRandomStackNumbers5());


        dataSimulate = utils.getDataSimulated();

        tableRandomView1 = generateRandomTable(dataRandomList1);
        tableRandomView2 = generateRandomTable(dataRandomList2);
        tableRandomView3 = generateRandomTable(dataRandomList3);
        tableRandomView4 = generateRandomTable(dataRandomList4);
        tableRandomView5 = generateRandomTable(dataRandomList5);

        tableSimulateView = generateTableSimulated(FXCollections.observableArrayList(new DataItem(), new DataItem()));

        name = "Steel Bars";
    }
    public VBox createTabContent() {
        // Buttons
        Button btnGenerateRandom = new Button("Generate Random");
        Button btnRun = new Button("Run");
        Button btnClean = new Button("Clean");
        Button btnDefault = new Button("Default Random");
        Button btnReadRandomManually = new Button("Read Manually Number");

        btnGenerateRandom.setOnAction(e -> onGenerateRandomAction());
        btnRun.setOnAction(e -> onRunAction());
        btnClean.setOnAction(e -> onCleanAction());
        btnDefault.setOnAction(e -> onUseDefaultRandom());
        btnReadRandomManually.setOnAction(e -> onReadManuallyData());

        HBox buttonBox = new HBox(10, btnGenerateRandom, btnRun, btnClean, btnDefault, btnReadRandomManually);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(10));

        HBox tablesBox = new HBox(20, tableRandomView1,tableRandomView2,tableRandomView3,tableRandomView4,tableRandomView5 );
        tablesBox.setPadding(new Insets(10));

        HBox result = new HBox(20, tableSimulateView);
        tablesBox.setPadding(new Insets(10));

        VBox content = new VBox(10, buttonBox, tablesBox, result);
        content.setPadding(new Insets(20));
        return content;
    }

    public String getName() {
        return name;
    }
    private void onReadManuallyData() {
        ObservableList<NumberRandomPair> randManuallyList1 = tableRandomView1.getItems();
        ObservableList<NumberRandomPair> randManuallyList2 = tableRandomView2.getItems();
        ObservableList<NumberRandomPair> randManuallyList3 = tableRandomView3.getItems();
        ObservableList<NumberRandomPair> randManuallyList4 = tableRandomView4.getItems();
        ObservableList<NumberRandomPair> randManuallyList5 = tableRandomView5.getItems();
        List<Double> randomList1 = new ArrayList<>();
        List<Double> randomList2 = new ArrayList<>();
        List<Double> randomList3 = new ArrayList<>();
        List<Double> randomList4 = new ArrayList<>();
        List<Double> randomList5 = new ArrayList<>();
        for (NumberRandomPair data : randManuallyList1) {
            randomList1.add(data.getRandom());
        }
        for (NumberRandomPair data : randManuallyList2) {
            randomList2.add(data.getRandom());
        }
        for (NumberRandomPair data : randManuallyList3) {
            randomList3.add(data.getRandom());
        }
        for (NumberRandomPair data : randManuallyList4) {
            randomList4.add(data.getRandom());
        }
        for (NumberRandomPair data : randManuallyList5) {
            randomList5.add(data.getRandom());
        }
        utils.setRandomStackNumbers1(randomList1.stream().mapToDouble(Double::doubleValue).toArray());
        utils.setRandomStackNumbers2(randomList2.stream().mapToDouble(Double::doubleValue).toArray());
        utils.setRandomStackNumbers3(randomList3.stream().mapToDouble(Double::doubleValue).toArray());
        utils.setRandomStackNumbers4(randomList4.stream().mapToDouble(Double::doubleValue).toArray());
        utils.setRandomStackNumbers5(randomList5.stream().mapToDouble(Double::doubleValue).toArray());
    }
    private void onGenerateRandomAction() {
        double[] randList1 = utils.generateRandomNumbers();
        double[] randList2 = utils.generateRandomNumbers();
        double[] randList3 = utils.generateRandomNumbers();
        double[] randList4 = utils.generateRandomNumbers();
        double[] randList5 = utils.generateRandomNumbers();
        utils.setRandomStackNumbers1(randList1);
        utils.setRandomStackNumbers2(randList2);
        utils.setRandomStackNumbers3(randList3);
        utils.setRandomStackNumbers4(randList4);
        utils.setRandomStackNumbers5(randList5);

        dataRandomList1.clear();
        dataRandomList2.clear();
        dataRandomList3.clear();
        dataRandomList4.clear();
        dataRandomList5.clear();


        dataRandomList1 = utils.getRandomDataForTableView(utils.getRandomStackNumbers1());
        dataRandomList2 = utils.getRandomDataForTableView(utils.getRandomStackNumbers2());
        dataRandomList3 = utils.getRandomDataForTableView(utils.getRandomStackNumbers3());
        dataRandomList4 = utils.getRandomDataForTableView(utils.getRandomStackNumbers4());
        dataRandomList5 = utils.getRandomDataForTableView(utils.getRandomStackNumbers5());


        tableRandomView1.setItems(dataRandomList1);
        tableRandomView2.setItems(dataRandomList2);
        tableRandomView3.setItems(dataRandomList3);
        tableRandomView4.setItems(dataRandomList4);
        tableRandomView5.setItems(dataRandomList5);


        tableRandomView1.refresh();
        tableRandomView2.refresh();
        tableRandomView3.refresh();
        tableRandomView4.refresh();
        tableRandomView5.refresh();
    }

    private void onRunAction() {
        dataSimulate = utils.getDataSimulated();
        tableSimulateView.setItems(dataSimulate);
        tableSimulateView.refresh();
    }
    private void onUseDefaultRandom() {
        dataRandomList1.clear();
        dataRandomList2.clear();
        dataRandomList3.clear();
        dataRandomList4.clear();
        dataRandomList5.clear();


        dataRandomList1 = utils.getRandomDataForTableView(utils.getRandomStackNumbers1Def());
        dataRandomList2 = utils.getRandomDataForTableView(utils.getRandomStackNumbers2Def());
        dataRandomList3 = utils.getRandomDataForTableView(utils.getRandomStackNumbers3Def());
        dataRandomList4 = utils.getRandomDataForTableView(utils.getRandomStackNumbers4Def());
        dataRandomList5 = utils.getRandomDataForTableView(utils.getRandomStackNumbers5Def());

        tableRandomView1.setItems(dataRandomList1);
        tableRandomView2.setItems(dataRandomList2);
        tableRandomView3.setItems(dataRandomList3);
        tableRandomView4.setItems(dataRandomList4);
        tableRandomView5.setItems(dataRandomList5);

        tableRandomView1.refresh();
        tableRandomView2.refresh();
        tableRandomView3.refresh();
        tableRandomView4.refresh();
        tableRandomView5.refresh();
    }
    private void onCleanAction() {
        dataSimulate.clear();
    }
    private TableView<DataItem> generateTableSimulated(ObservableList<DataItem> data) {
        TableView<DataItem> tableView = new TableView<>();
        tableView.setPrefWidth(1000);
        TableColumn<DataItem, Integer> assembly = new TableColumn<>("Ensambles");
        assembly.setCellValueFactory(new PropertyValueFactory<>("assembly"));

        TableColumn<DataItem, Double> rand1 = new TableColumn<>("Rand1");
        rand1.setCellValueFactory(new PropertyValueFactory<>("rand1"));

        TableColumn<DataItem, Double> sizeSteelBarA = new TableColumn<>("Dimensiones de la Barra A (cm)");
        sizeSteelBarA.setCellValueFactory(new PropertyValueFactory<>("sizeSteelBarA"));

        TableColumn<DataItem, Double> rand2 = new TableColumn<>("Rand2");
        rand2.setCellValueFactory(new PropertyValueFactory<>("rand2"));

        TableColumn<DataItem, Double> rand3 = new TableColumn<>("Rand3");
        rand3.setCellValueFactory(new PropertyValueFactory<>("rand3"));

        TableColumn<DataItem, Double> rand4 = new TableColumn<>("Rand4");
        rand4.setCellValueFactory(new PropertyValueFactory<>("rand4"));

        TableColumn<DataItem, Double> rand5 = new TableColumn<>("Rand5");
        rand5.setCellValueFactory(new PropertyValueFactory<>("rand5"));

        TableColumn<DataItem, Double> sizeSteelBarB = new TableColumn<>("Dimensiones de la Barra B (cm)");
        sizeSteelBarB.setCellValueFactory(new PropertyValueFactory<>("sizeSteelBarB"));

        TableColumn<DataItem, Double> totalSizeSteel = new TableColumn<>("Longitud total de la barra (cm)");
        totalSizeSteel.setCellValueFactory(new PropertyValueFactory<>("totalSizeSteel"));

        TableColumn<DataItem, Integer> lowSpecification = new TableColumn<>("Especificación inferior)");
        lowSpecification.setCellValueFactory(new PropertyValueFactory<>("lowSpecification"));

        TableColumn<DataItem, Integer> upSpecification = new TableColumn<>("Especificación superior");
        upSpecification.setCellValueFactory(new PropertyValueFactory<>("upSpecification"));

        TableColumn<DataItem, Integer> isDefect = new TableColumn<>("Es Defectuosa? 1(SI)/2(NO)");
        isDefect.setCellValueFactory(new PropertyValueFactory<>("isDefect"));

        TableColumn<DataItem, Integer> cumulativeDefect = new TableColumn<>("Piezas defectuosas acumuladas");
        cumulativeDefect.setCellValueFactory(new PropertyValueFactory<>("cumulativeDefect"));

        TableColumn<DataItem, Integer> percentDefect = new TableColumn<>("% de piezas defectuosas");
        percentDefect.setCellValueFactory(new PropertyValueFactory<>("percentDefect"));

        tableView.getColumns().add(assembly);
        tableView.getColumns().add(rand1);
        tableView.getColumns().add(sizeSteelBarA);
        tableView.getColumns().add(rand2);
        tableView.getColumns().add(rand3);
        tableView.getColumns().add(rand4);
        tableView.getColumns().add(rand5);
        tableView.getColumns().add(sizeSteelBarB);
        tableView.getColumns().add(totalSizeSteel);
        tableView.getColumns().add(lowSpecification);
        tableView.getColumns().add(upSpecification);
        tableView.getColumns().add(isDefect);
        tableView.getColumns().add(cumulativeDefect);
        tableView.getColumns().add(percentDefect);
        tableView.setItems(data);
        return tableView;

    }

    private TableView<NumberRandomPair> generateRandomTable(ObservableList<NumberRandomPair> data) {
        // Create the TableView
        TableView<NumberRandomPair> tableView = new TableView<>();
        tableView.setPrefWidth(200);
        // Create the "Random" column
        TableColumn<NumberRandomPair, Double> randomDataColumn = new TableColumn<>("#");
        randomDataColumn.setCellValueFactory(new PropertyValueFactory<>("number"));

        TableColumn<NumberRandomPair, Double> randomColumn = new TableColumn<>("Aleatorio");
        randomColumn.setCellValueFactory(cellData -> cellData.getValue().randomProperty().asObject());
        randomColumn.setCellFactory(TextFieldTableCell.forTableColumn(new DoubleStringConverter()));
        randomColumn.setOnEditCommit(event -> {
            NumberRandomPair rowData = event.getRowValue();
            rowData.setRandom(event.getNewValue());
        });
        tableView.setEditable(true);
        tableView.getColumns().add(randomDataColumn);
        tableView.getColumns().add(randomColumn);
        tableView.setItems(data);
        return tableView;
    }
}
