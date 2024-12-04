module com.manager.filemanagergradle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.apache.logging.log4j;

    opens com.manager.filemanagergradle to javafx.fxml;
    exports com.manager.filemanagergradle;
}