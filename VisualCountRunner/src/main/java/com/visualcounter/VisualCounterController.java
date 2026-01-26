package com.visualcounter;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VisualCounterController {
    public TextField textFieldUPC;
    public TextArea dialogArea;

    @FXML
    private Label welcomeText;

    @FXML
    private void onEnterPressed() {
        String enteredText = textFieldUPC.getText();
        if(enteredText.length() == 12){
            UpcCounter upc = new UpcCounter(enteredText);
            upc.hashCheck();
            welcomeText.setText("Scanned: " + enteredText);
        }
        else
        {
          welcomeText.setText("INVALID SCAN!!!!");
        }

        textFieldUPC.clear();
    }
    @FXML
    protected void onFinishedButtonClick() {
        dialogArea.appendText("\n=== Scanning Finished ===\n");
        dialogArea.appendText(UpcCounter.getKeysAndVals());
    }

    public void handlesLightMode(ActionEvent event) {
        Scene scene = textFieldUPC.getScene();

        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("light-theme.css").toExternalForm());
    }

    public void handlesDarkMode(ActionEvent event) {
        Scene scene = textFieldUPC.getScene();

        scene.getStylesheets().clear();
        scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());
    }
}