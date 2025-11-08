module com.example.tryhardcountrunner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.visualcounter to javafx.fxml;
    exports com.visualcounter;
}