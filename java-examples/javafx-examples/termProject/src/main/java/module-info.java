module marmara.termproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens marmara.termproject to javafx.fxml;
    exports marmara.termproject;
}