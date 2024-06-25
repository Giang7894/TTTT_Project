package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeNvController {

    @FXML
    void getDat(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("thuesan-view.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getDv(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Bán hàng.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void getLogout(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
