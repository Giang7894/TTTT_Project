module com.example.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires de.jensd.fx.glyphs.fontawesome;
    requires mysql.connector.j;


    opens com.example.project to javafx.fxml;
    exports com.example.project;
}