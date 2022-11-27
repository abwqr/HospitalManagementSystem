package Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Controller.ManageAppointmentController;
import Controller.ManageBedsController;
import entity.Appointment;
import entity.Bed;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UpdateBedsView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amount;

    @FXML
    private Text bedID;

    @FXML
    private TextField cnic;

    @FXML
    private DatePicker eDate;

    @FXML
    private DatePicker sDate;

    @FXML
    private ChoiceBox bedStatus;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageBeds.fxml", null);
    }

    @FXML
    void updateBed(ActionEvent event) throws IOException {
        int bID = Integer.parseInt(bedID.getText());
        int pCnic = Integer.parseInt(cnic.getText());
        LocalDate starDate = (LocalDate) sDate.getValue();
        LocalDate endDate = (LocalDate) eDate.getValue();
        String status = (String) bedStatus.getValue();
        int fee = Integer.parseInt(amount.getText());


        Bed bed = new Bed();
        bed.setPatientCnic(pCnic);
        bed.setBedId(bID);
        bed.setStartDate(starDate);
        bed.setEndDate(endDate);
        bed.setFeeAmount(fee);
        bed.setStatus(status);

        ManageBedsController.updateBed(bed);

        handleBack(event);
    }

    ObservableList<String> statusList = FXCollections.observableArrayList("available", "occuppied");

    @FXML
    void initialize(Bed obj) throws IndexOutOfBoundsException {
        assert amount != null : "fx:id=\"amount\" was not injected: check your FXML file 'UpdateBed.fxml'.";
        assert bedID != null : "fx:id=\"bedID\" was not injected: check your FXML file 'UpdateBed.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'UpdateBed.fxml'.";
        assert eDate != null : "fx:id=\"eDate\" was not injected: check your FXML file 'UpdateBed.fxml'.";
        assert sDate != null : "fx:id=\"sDate\" was not injected: check your FXML file 'UpdateBed.fxml'.";
        assert bedStatus != null : "fx:id=\"status\" was not injected: check your FXML file 'UpdateBed.fxml'.";


        bedID.setText(String.valueOf(obj.getBedId()));
        cnic.setText(String.valueOf(obj.getPatientCnic()));
        amount.setText(String.valueOf(obj.getFeeAmount()));
        eDate.setValue(obj.getEndDate());
        sDate.setValue(obj.getStartDate());
        bedStatus.setValue(obj.getStatus());
        bedStatus.setItems(statusList);
    }

}
