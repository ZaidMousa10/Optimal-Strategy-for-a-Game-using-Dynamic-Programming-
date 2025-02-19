module com.example.algo_testing {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.algo_testing to javafx.fxml;
    exports com.example.algo_testing;
}