module example.demo.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.demo.demo to javafx.fxml;
    exports example.demo.demo;
}