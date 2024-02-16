module com.tipicocantabria.sigpymeadv {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.tipicocantabria.sigpymeadv to javafx.fxml;
    exports com.tipicocantabria.sigpymeadv;
}