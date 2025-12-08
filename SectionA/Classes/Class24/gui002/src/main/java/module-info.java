module org.example.gui002 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens org.example.gui002 to javafx.fxml;
    exports org.example.gui002;
}