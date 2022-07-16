module progect.estimatefx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.postgresql.jdbc;


    opens project.estimatefx to javafx.fxml;
    exports project.estimatefx;
    exports project.estimatefx.controllers;
    opens project.estimatefx.controllers to javafx.fxml;
}