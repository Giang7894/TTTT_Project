package com.example.project;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ResourceBundle;

public class StaffController implements Initializable {

    @FXML
    private TableColumn<Staff, String> Pass;

    @FXML
    private TableColumn<Staff, String> Role;

    @FXML
    private TableColumn<Staff, Integer> id;

    @FXML
    private TableColumn<Staff, String> loginN;

    @FXML
    private TableColumn<Staff, String> staffN;

    @FXML
    private TextField name;

    @FXML
    private PasswordField pass;

    @FXML
    private TextField uname;

    @FXML
    private TableView<Staff> stafftb;

    DatabaseConnection connection = new DatabaseConnection();
    Connection connectionDB = connection.getConnection();

    ObservableList<Staff> staffs= FXCollections.observableArrayList();


    @FXML
    void addStaff(ActionEvent event) throws NoSuchAlgorithmException, SQLException {
        String n=name.getText();
        String un=uname.getText();
        String p=pass.getText();
        String ep=encryptString(p);
        String role="NV";
        PreparedStatement pr= connectionDB.prepareStatement("INSERT INTO nhan_vien(Ten_NV,Ten_DN,Mat_khau,Chuc_vu) value(?,?,?,?)");
        pr.setString(1,n);
        pr.setString(2,un);
        pr.setString(3,ep);
        pr.setString(4,role);
        pr.execute();
        staffs.clear();
        getData();
        stafftb.setItems(staffs);
    }


    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void deleteStaff(ActionEvent event) throws SQLException {
        Staff st= stafftb.getSelectionModel().getSelectedItem();
        int id=st.getId();
        PreparedStatement pr=connectionDB.prepareStatement("DELETE FROM nhan_vien where Ma_NV=?");
        pr.setInt(1,id);
        pr.execute();
        staffs.clear();
        getData();
        stafftb.setItems(staffs);
    }

    public String encryptString (String input) throws NoSuchAlgorithmException {
        MessageDigest md= MessageDigest.getInstance("MD5");
        byte[] messageDigest = md.digest(input.getBytes());

        BigInteger bigInt=new BigInteger(1,messageDigest);

        return bigInt.toString(16);
    }

    void getData(){
        String connectQuery="SELECT * FROM nhan_vien";
        try {
            Statement statement = connectionDB.createStatement();
            ResultSet resultSet = statement.executeQuery(connectQuery);

            while (resultSet.next()){
                int ma_nv=resultSet.getInt("Ma_NV");
                String ten_nv=resultSet.getString("Ten_NV");
                String ten_dn=resultSet.getString("Ten_DN");
                String password=resultSet.getString("Mat_khau");
                String role=resultSet.getString("Chuc_vu");
                staffs.add(new Staff(ma_nv,ten_nv,ten_dn,password,role));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pass.setCellValueFactory(new PropertyValueFactory<>("password"));
        Role.setCellValueFactory(new PropertyValueFactory<>("role"));
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        staffN.setCellValueFactory(new PropertyValueFactory<>("name"));
        loginN.setCellValueFactory(new PropertyValueFactory<>("userName"));
        getData();
        stafftb.setItems(staffs);
    }
}

