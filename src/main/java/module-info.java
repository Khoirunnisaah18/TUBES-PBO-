module com.example.tubespbo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.tubespbo to javafx.fxml;
    exports com.example.tubespbo;
}