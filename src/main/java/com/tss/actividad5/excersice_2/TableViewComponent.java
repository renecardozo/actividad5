package com.tss.actividad5.excersice_2;

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

public class TableViewComponent {
    private Utils utils;
    private ObservableList<DataItem> dataSimulate;
    private ObservableList<NumberRandomPair> dataRandomListOne;
    private ObservableList<NumberRandomPair> dataRandomListTwo;

    private TableView<NumberRandomPair> tableRandomViewOne;
    private TableView<NumberRandomPair> tableRandomViewTwo;

    private TableView<DataItem> tableSimulateView = new TableView<>();
    private String name;

    public TableViewComponent() {
        utils = new Utils();
        dataRandomListOne = utils.getRandomDataForTableView(utils.getRandomListOne());
        dataRandomListTwo = utils.getRandomDataForTableView(utils.getRandomListTwo());
        dataSimulate = utils.getDataSimulated();

        tableRandomViewOne = generateRandomTable(dataRandomListOne);
        tableRandomViewTwo = generateRandomTable(dataRandomListTwo);
        tableSimulateView = generateTableSimulated(FXCollections.observableArrayList(new DataItem(), new DataItem()));

        name = "Factory";
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

        HBox tablesBox = new HBox(20, tableRandomViewOne, tableRandomViewTwo);
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
        ObservableList<NumberRandomPair> randManuallyList1 = tableRandomViewOne.getItems();
        ObservableList<NumberRandomPair> randManuallyList2 = tableRandomViewTwo.getItems();
        List<Double> randomList1 = new ArrayList<>();
        List<Double> randomList2 = new ArrayList<>();
        for (NumberRandomPair data : randManuallyList1) {
            randomList1.add(data.getRandom());
        }
        for (NumberRandomPair data : randManuallyList2) {
            randomList2.add(data.getRandom());
        }
        utils.setRandomListOne(randomList1.stream().mapToDouble(Double::doubleValue).toArray());
        utils.setRandomListTwo(randomList2.stream().mapToDouble(Double::doubleValue).toArray());
    }

    private void onGenerateRandomAction() {
        double[] randListOne = utils.generateRandomNumbers();
        double[] randListTwo = utils.generateRandomNumbers();
        utils.setRandomListOne(randListOne);
        utils.setRandomListTwo(randListTwo);
        utils.buildStackRandom();

        dataRandomListTwo.clear();
        dataRandomListOne.clear();

        dataRandomListOne = utils.getRandomDataForTableView(utils.getRandomListOne());
        dataRandomListTwo = utils.getRandomDataForTableView(utils.getRandomListTwo());
        tableRandomViewOne.setItems(dataRandomListOne);
        tableRandomViewTwo.setItems(dataRandomListTwo);

        tableRandomViewOne.refresh();
        tableRandomViewTwo.refresh();
    }

    private void onRunAction() {
        dataSimulate = utils.getDataSimulated();
        tableSimulateView.setItems(dataSimulate);
        tableSimulateView.refresh();
    }
    private void onUseDefaultRandom() {
        dataRandomListTwo.clear();
        dataRandomListOne.clear();

        dataRandomListOne = utils.getRandomDataForTableView(utils.getRandomListOneDefault());
        dataRandomListTwo = utils.getRandomDataForTableView(utils.getRandomListTwDefault());
        tableRandomViewOne.setItems(dataRandomListOne);
        tableRandomViewTwo.setItems(dataRandomListTwo);

        tableRandomViewOne.refresh();
        tableRandomViewTwo.refresh();
    }
    private void onCleanAction() {
        dataSimulate.clear();
    }
    private TableView<DataItem> generateTableSimulated(ObservableList<DataItem> data) {
        TableView<DataItem> tableView = new TableView<>();
        tableView.setPrefWidth(1000);
        TableColumn<DataItem, Integer> partColumn = new TableColumn<>("Piezas");
        partColumn.setCellValueFactory(new PropertyValueFactory<>("part"));

        TableColumn<DataItem, Double> randOneColumn = new TableColumn<>("Rand1");
        randOneColumn.setCellValueFactory(new PropertyValueFactory<>("randomOne"));

        TableColumn<DataItem, Double> timeBetweenArrived = new TableColumn<>("Tiempo entre llegadas(min/piezas)");
        timeBetweenArrived.setCellValueFactory(new PropertyValueFactory<>("timeBetweenArrived"));

        TableColumn<DataItem, Double> timeArrived = new TableColumn<>("Minuto en que llega la pieza");
        timeArrived.setCellValueFactory(new PropertyValueFactory<>("timeArrived"));

        TableColumn<DataItem, Double> timeStartedInspection = new TableColumn<>("Minuto en que inicia la inspeccion");
        timeStartedInspection.setCellValueFactory(new PropertyValueFactory<>("timeStartedInspection"));

        TableColumn<DataItem, Double> randomTwo = new TableColumn<>("Rand2");
        randomTwo.setCellValueFactory(new PropertyValueFactory<>("randomTwo"));

        TableColumn<DataItem, Double> durationTimeInspection = new TableColumn<>("Tiempo inspeccion (min/pieza)");
        durationTimeInspection.setCellValueFactory(new PropertyValueFactory<>("durationTimeInspection"));

        TableColumn<DataItem, Double> timeEndedInspection = new TableColumn<>("Minuto en que finaliza la inspeccion");
        timeEndedInspection.setCellValueFactory(new PropertyValueFactory<>("timeEndedInspection"));

        TableColumn<DataItem, Double> timeTotalInspection = new TableColumn<>("Tiempo total en inspección (min/piezas)");
        timeTotalInspection.setCellValueFactory(new PropertyValueFactory<>("timeTotalInspection"));

        TableColumn<DataItem, Double> timeWaiting = new TableColumn<>("Tiempo en espera (min)");
        timeWaiting.setCellValueFactory(new PropertyValueFactory<>("timeWaiting"));

        tableView.getColumns().add(partColumn);
        tableView.getColumns().add(randOneColumn);
        tableView.getColumns().add(timeBetweenArrived);
        tableView.getColumns().add(timeArrived);
        tableView.getColumns().add(timeStartedInspection);
        tableView.getColumns().add(randomTwo);
        tableView.getColumns().add(durationTimeInspection);
        tableView.getColumns().add(timeEndedInspection);
        tableView.getColumns().add(timeTotalInspection);
        tableView.getColumns().add(timeWaiting);
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
