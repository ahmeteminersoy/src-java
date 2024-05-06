module marmara.carmovement {
    requires javafx.controls;
    requires javafx.fxml;


    opens marmara.carmovement to javafx.fxml;
    exports marmara.carmovement;
}