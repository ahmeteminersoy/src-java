module org.example.loancalculator {
    requires javafx.controls;
    requires javafx.fxml;


    opens lab.util to javafx.fxml;
    exports lab.util;
}