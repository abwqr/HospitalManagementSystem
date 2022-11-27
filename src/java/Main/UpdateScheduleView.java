package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

import Controller.ManageBedsController;
import Controller.ManageScheduleController;
import entity.Bed;
import entity.Empschedule;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UpdateScheduleView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker date;

    @FXML
    private Text docId;

    @FXML
    private TextField eTime;

    @FXML
    private TextField room;

    @FXML
    private TextField sTime;

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageSchedule.fxml", null);
    }

    @FXML
    void update(ActionEvent event) throws IOException {
        int doc = Integer.parseInt(docId.getText());
        LocalDate schedDate = date.getValue();
        String startTime = sTime.getText();
        String endTime = eTime.getText();
        String roomNum = room.getText();


        Empschedule empschedule = new Empschedule();
        empschedule.setStartTime(LocalTime.parse(startTime));
        empschedule.setEndTime(LocalTime.parse(endTime));
        empschedule.setRoom(roomNum);
        empschedule.setShiftDate(schedDate);
        empschedule.setEmpId(doc);

        System.out.println(empschedule.getRoom());
        ManageScheduleController.updateSchedule(empschedule);

        handleBack(event);

    }

    @FXML
    void initialize(Empschedule obj) {
        assert date != null : "fx:id=\"date\" was not injected: check your FXML file 'UpdateSchedule.fxml'.";
        assert docId != null : "fx:id=\"docId\" was not injected: check your FXML file 'UpdateSchedule.fxml'.";
        assert eTime != null : "fx:id=\"eTime\" was not injected: check your FXML file 'UpdateSchedule.fxml'.";
        assert room != null : "fx:id=\"room\" was not injected: check your FXML file 'UpdateSchedule.fxml'.";
        assert sTime != null : "fx:id=\"sTime\" was not injected: check your FXML file 'UpdateSchedule.fxml'.";

        docId.setText(String.valueOf(obj.getEmpId()));;
        date.setValue(obj.getShiftDate());
        sTime.setText(String.valueOf(obj.getStartTime()));
        eTime.setText(String.valueOf(obj.getEndTime()));
        room.setText(obj.getRoom());

    }

}
