package com.visualcounter;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class VisualCounterController {
    public TextField textFeildUPC;
    public TextArea dialogArea;

    @FXML
    private Label welcomeText;

    @FXML
    private void onEnterPressed() {
        String enteredText = textFeildUPC.getText();
        if(enteredText.length() == 12){
            if (enteredText.isEmpty()) {
                welcomeText.setText("");
                return;
            }
            else
            {
                UpcCounter upc = new UpcCounter(enteredText);
                upc.hashCheck();
                welcomeText.setText("Scanned: " + enteredText);
            }
        }
        else
        {
          welcomeText.setText("INVALID SCAN!!!!");
        }

        textFeildUPC.clear();
    }
    @FXML
    protected void onFinishedButtonClick() {
        dialogArea.appendText("\n=== Scanning Finished ===\n");
        dialogArea.appendText(UpcCounter.getKeysAndVals());
    }
}