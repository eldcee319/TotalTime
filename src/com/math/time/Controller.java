package com.math.time;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    private TextField txtHours;
    @FXML
    private TextField txtminutes;
    @FXML
    private VBox showVBox;
    @FXML
    private HBox mainHbox;


    private List<Compute> list = new ArrayList<>();

    @FXML
    public void clickSubmit() {
        try {
            Integer hr = Integer.parseInt(txtHours.getText());
            Integer min = Integer.parseInt(txtminutes.getText());

            if((min > 60 || min < 0 || hr < 0)) {
                dialogError("Invalid input. Please try again.");

            } else {
                Compute compute = new Compute(hr, min);
                list.add(compute);

                showVBox.getChildren().add(new Label(compute.toString()));
            }
        } catch (NumberFormatException e) {
            dialogError("Please enter numbers!");
        }

    }


    @FXML
    public void clickAdd() {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setResizable(true);
        dialog.setTitle("Computation");
        dialog.getDialogPane().setPrefSize(350,150);
        dialog.initOwner(mainHbox.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Dialogfx.fxml"));
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

            DialogController controller = fxmlLoader.getController();
            controller.addTime(list);

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.showAndWait();

    }

    @FXML
    public void clickReset() {
        list.clear();
        showVBox.getChildren().clear();
    }

    public Duration getTotal(List<Compute> theList) {
        Duration sum = Duration.ZERO;
        for(Compute duration : theList) {
            sum = sum.plus(duration.getDuration());
        }

        return sum;
    }

    public void dialogError(String message) {
        Dialog<ButtonType> dialogError = new Dialog<>();
        dialogError.setResizable(false);
        dialogError.setTitle("Invalid");
        dialogError.getDialogPane().setPrefSize(350,150);
        dialogError.initOwner(mainHbox.getScene().getWindow());
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DialogErrorFx.fxml"));
        try {
            dialogError.getDialogPane().setContent(fxmlLoader.load());

            DialogError dialogError1 = fxmlLoader.getController();
            dialogError1.errorNof(message);

        } catch (IOException e1) {
            System.out.println("Couldn't load the dialog");
            e1.printStackTrace();
            return;
        }

        dialogError.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialogError.showAndWait();
    }

}
