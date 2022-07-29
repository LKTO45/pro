package pro.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import pro.controller.HelloApplication;

public class HelloController {
    @FXML
    public AnchorPane rootVbox;

    @FXML
    public Label notif;

    @FXML
    public TextField username;

    @FXML
    public PasswordField password;

    @FXML
    public void openlogin (ActionEvent actionEvent)throws IOException {
        spareonline connectNew = new spareonline();
        Connection connectionDB = connectNew.getconnection();

        String verifikasiLogin = "SELECT COUNT(1) FROM data_akun Where username = '" + username.getText() + "' AND password = '" + password.getText() + "'";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifikasiLogin);

            while (queryResult.next()) {
                if (queryResult.getInt(1) ==1){
                    Parent root = FXMLLoader.load(HelloApplication.class.getResource("Beranda.fxml"));
                    Stage beranda = new Stage();
                    beranda.setTitle("Home Rent App");
                    beranda.setScene(new Scene(root));
                    beranda.initOwner(rootVbox.getScene().getWindow());
                    beranda.show();
                } else {
                    notif.setText("Gagal Login, Coba Lagi");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}