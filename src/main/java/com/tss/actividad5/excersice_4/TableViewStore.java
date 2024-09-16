package com.tss.actividad5.excersice_4;

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

public class TableViewStore {
    private Utils utils;
    private ObservableList<DataItem> dataSimulate;
    private ObservableList<NumberRandomPair> dataRandomListOne;

    private TableView<NumberRandomPair> tableRandomViewOne;

    private TableView<DataItem> tableSimulateView = new TableView<>();
    private String name;

    public TableViewStore() {
        utils = new Utils();
        dataRandomListOne = utils.getRandomDataForTableView(utils.getRandomListOne());
        dataSimulate = utils.getDataSimulated();

        tableRandomViewOne = generateRandomTable(dataRandomListOne);
        tableSimulateView = generateTableSimulated(FXCollections.observableArrayList(new DataItem(), new DataItem()));

        name = "Store";
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

        HBox tablesBox = new HBox(20, tableRandomViewOne);
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
        List<Double> randomList1 = new ArrayList<>();
        for (NumberRandomPair data : randManuallyList1) {
            randomList1.add(data.getRandom());
        }
        utils.setRandomListOne(randomList1.stream().mapToDouble(Double::doubleValue).toArray());
    }
    private void onGenerateRandomAction() {
        double[] randListOne = utils.generateRandomNumbers();
        utils.setRandomListOne(randListOne);

        dataRandomListOne.clear();

        dataRandomListOne = utils.getRandomDataForTableView(utils.getRandomListOne());
        tableRandomViewOne.setItems(dataRandomListOne);

        tableRandomViewOne.refresh();
    }

    private void onRunAction() {
        dataSimulate = utils.getDataSimulated();
        tableSimulateView.setItems(dataSimulate);
        tableSimulateView.refresh();
    }
    private void onUseDefaultRandom() {
        dataRandomListOne.clear();
        dataRandomListOne = utils.getRandomDataForTableView(utils.getRandomListOneDefault());
        tableRandomViewOne.setItems(dataRandomListOne);
        tableRandomViewOne.refresh();
    }
    private void onCleanAction() {
        dataSimulate.clear();
    }
    private TableView<DataItem> generateTableSimulated(ObservableList<DataItem> data) {
        TableView<DataItem> tableView = new TableView<>();
        tableView.setPrefWidth(1000);
        TableColumn<DataItem, Integer> day = new TableColumn<>("Dia");
        day.setCellValueFactory(new PropertyValueFactory<>("day"));

        TableColumn<DataItem, Double> initialInventory = new TableColumn<>("Inventario inicial");
        initialInventory.setCellValueFactory(new PropertyValueFactory<>("initialInventory"));

        TableColumn<DataItem, Double> supplierDelivery = new TableColumn<>("Entregas que hace el proveedor (kg)");
        supplierDelivery.setCellValueFactory(new PropertyValueFactory<>("supplierDelivery"));

        TableColumn<DataItem, Double> totalInventory = new TableColumn<>("Inventario total (kg)");
        totalInventory.setCellValueFactory(new PropertyValueFactory<>("totalInventory"));

        TableColumn<DataItem, Double> timeStartedInspection = new TableColumn<>("Minuto en que inicia la inspeccion");
        timeStartedInspection.setCellValueFactory(new PropertyValueFactory<>("timeStartedInspection"));

        TableColumn<DataItem, Double> rand = new TableColumn<>("Rand");
        rand.setCellValueFactory(new PropertyValueFactory<>("rand"));

        TableColumn<DataItem, Double> demand = new TableColumn<>("Demanda (kg)");
        demand.setCellValueFactory(new PropertyValueFactory<>("demand"));

        TableColumn<DataItem, Double> sales = new TableColumn<>("Venta (kg)");
        sales.setCellValueFactory(new PropertyValueFactory<>("sales"));

        TableColumn<DataItem, Double> finalInventory = new TableColumn<>("Inventario final (kg)");
        finalInventory.setCellValueFactory(new PropertyValueFactory<>("finalInventory"));

        TableColumn<DataItem, Double> lostSales = new TableColumn<>("Ventas perdidas (kg)");
        lostSales.setCellValueFactory(new PropertyValueFactory<>("lostSales"));

        TableColumn<DataItem, Double> orderCost = new TableColumn<>("Costo de ordenar ($)");
        orderCost.setCellValueFactory(new PropertyValueFactory<>("orderCost"));

        TableColumn<DataItem, Double> missingCost = new TableColumn<>("Costo de faltante ($)");
        missingCost.setCellValueFactory(new PropertyValueFactory<>("missingCost"));

        TableColumn<DataItem, Double> maintenanceCost = new TableColumn<>("Costo de mantenimiento de inventarios ($)");
        maintenanceCost.setCellValueFactory(new PropertyValueFactory<>("maintenanceCost"));

        TableColumn<DataItem, Double> totalCost = new TableColumn<>("Costo Total ($)");
        totalCost.setCellValueFactory(new PropertyValueFactory<>("totalCost"));

        tableView.getColumns().add(day);
        tableView.getColumns().add(initialInventory);
        tableView.getColumns().add(supplierDelivery);
        tableView.getColumns().add(totalInventory);
        tableView.getColumns().add(rand);
        tableView.getColumns().add(demand);
        tableView.getColumns().add(sales);
        tableView.getColumns().add(finalInventory);
        tableView.getColumns().add(lostSales);
        tableView.getColumns().add(orderCost);
        tableView.getColumns().add(missingCost);
        tableView.getColumns().add(maintenanceCost);
        tableView.getColumns().add(totalCost);
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
