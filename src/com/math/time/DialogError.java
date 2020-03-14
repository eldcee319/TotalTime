package com.math.time;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class DialogError {

    @FXML
    private Label lblError;

    public void errorNof(String message) {
        lblError.setText(message);
    }
}

