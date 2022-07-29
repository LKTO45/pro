module pro.iko2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires com.jfoenix;
    requires java.logging;


    opens pro.controller to javafx.fxml;
    exports pro.controller;

}