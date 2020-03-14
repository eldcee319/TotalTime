package com.math.time;

import com.math.time.Compute;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.time.Duration;
import java.util.List;

public class DialogController {

    @FXML
    private Label DialogLabel;

    public void addTime(List<Compute> theList) {
        Duration sum = Duration.ZERO;
        for(Compute duration : theList) {
            sum = sum.plus(duration.getDuration());
        }

        System.out.println(sum);
        DialogLabel.setText("Total time is: " + String.format("%d:%02d", sum.toHours(), sum.toMinutesPart()));
    }


}
