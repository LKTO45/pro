package pro.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class spareonline {

    public Connection databaseLink;
    String data_akun                  = "sparepartonline";
    String sparepartonlineusername    = "root";
    String sparepartonlinepassword    = "";
    String url              = "jdbc:mysql://Localhost/" + data_akun;

    public Connection getconnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, sparepartonlineusername, sparepartonlinepassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return databaseLink;
    }
    void saveDB(String merk, String kybrd, String mbr, int lcd){

        String sqlSave = "INSERT INTO data_akun(merk, kybrd, mbr,lcd) VALUES (\""+ merk + "\", \"" + kybrd + "\", \"" + mbr + "\", \"" + lcd + "\")";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, sparepartonlineusername, sparepartonlinepassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlSave);
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}