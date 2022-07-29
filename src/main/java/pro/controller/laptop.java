package pro.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class laptop {

    spareonline dBconn = new spareonline();

    @FXML
    private TextField merk;

    @FXML
    private TextField kybrd;

    @FXML
    private TextField mbr;

    @FXML
    private TextField lcd;

    @FXML
    void simpan(ActionEvent event) {
        dBconn.saveDB(merk.getText(), kybrd.getText(), mbr.getText(), Integer.parseInt(lcd.getText()));
    }

    @FXML
    void ubah(ActionEvent event) {

    }

    @FXML
    void hapus(ActionEvent event) {

    }

    @FXML
    void keluar(ActionEvent event) {

    }


}