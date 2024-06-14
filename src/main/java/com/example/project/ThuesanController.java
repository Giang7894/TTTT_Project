package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ThuesanController {

    @FXML
    void getDat(MouseEvent event) {

    }

    @FXML
    void getDv(MouseEvent event) {

    }

    @FXML
    void getQlnv(MouseEvent event) {

    }

    @FXML
    void getQls(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home-view.fxml"));
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene= new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
