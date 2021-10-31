module com.spacenews {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    // FasterXML JSON library
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    opens spacenews.gui to javafx.graphics, javafx.fxml;

}