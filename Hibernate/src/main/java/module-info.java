module com.example.hibernate {
    requires javafx.controls;
    requires javafx.fxml;

    //dodane do dependencies - później należy dodać do requaries
    requires org.hibernate.orm.core;
    requires org.controlsfx.controls;
    requires jakarta.persistence; // do @Entity itd
    requires java.sql; //obsługa drivera bazy danych

    opens com.example.hibernate to javafx.fxml;
    exports com.example.hibernate;
}