module com.example.airwars_controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.airwars_controller to javafx.fxml;
    exports com.example.airwars_controller;
}