module com.tss.actividad5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires commons.math3;


    opens com.tss.actividad5 to javafx.fxml;
    exports com.tss.actividad5;
    exports com.tss.actividad5.common;
    exports com.tss.actividad5.excersice_1;
    exports com.tss.actividad5.excersice_2;
    exports com.tss.actividad5.excersice_3;
    exports com.tss.actividad5.excersice_4;
}