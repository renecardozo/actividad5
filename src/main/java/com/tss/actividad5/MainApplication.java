package com.tss.actividad5;

import com.tss.actividad5.excersice_1.TableViewPartInspection;
import com.tss.actividad5.excersice_2.TableViewComponent;
import com.tss.actividad5.excersice_3.TableViewSteelBar;
import com.tss.actividad5.excersice_4.TableViewStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private final TableViewComponent tableViewComponent = new TableViewComponent();
    private final TableViewSteelBar tableViewSteelBar = new TableViewSteelBar();
    private final TableViewStore tableViewStore = new TableViewStore();
    private final TableViewPartInspection tableViewPartInspection = new TableViewPartInspection();

    @Override
    public void start(Stage stage) throws IOException {

        TabPane tabPane = new TabPane();

        Tab tabPartInspection = new Tab(tableViewPartInspection.getName());
        tabPartInspection.setContent(tableViewPartInspection.createTabContent());

        Tab tabFactory = new Tab(tableViewComponent.getName());
        tabFactory.setContent(tableViewComponent.createTabContent());

        Tab tabSteelBar = new Tab(tableViewSteelBar.getName());
        tabSteelBar.setContent(tableViewSteelBar.createTabContent());

        Tab tabStore = new Tab(tableViewStore.getName());
        tabStore.setContent(tableViewStore.createTabContent());

        tabPane.getTabs().add(tabPartInspection);
        tabPane.getTabs().add(tabFactory);
        tabPane.getTabs().add(tabSteelBar);
        tabPane.getTabs().add(tabStore);

        VBox vBox = new VBox(tabPane);
        Scene scene = new Scene( vBox,900, 700);
        stage.setTitle("Actividad 5");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}