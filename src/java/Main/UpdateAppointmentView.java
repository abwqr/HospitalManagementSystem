package Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import Controller.ManageAppointmentController;
import entity.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class UpdateAppointmentView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker appDate;

    @FXML
    private TextField appTime;

    @FXML
    private TextField cnic;

    @FXML
    private TextField docId;

    @FXML
    private TextField fee;

    @FXML
    private Text appId;


    @FXML
    private ChoiceBox status;

    ObservableList<String> statusList = FXCollections.observableArrayList("finished", "pending", "missed", "cancelled");

    @FXML
    void handelBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageAppointments.fxml", null);
    }





    @FXML
    void updateAppointment(ActionEvent event) throws IOException {
        int appointmentId = Integer.parseInt(appId.getText());

        String id = cnic.getText();
        Date dateofApp = Date.valueOf(appDate.getValue());
        String doctorID = docId.getText();
        String timeofApp = appTime.getText();
        String appStatus = (String) status.getValue();
        String amount = fee.getText();


        int cnic = Integer.parseInt(id);
        int doc = Integer.parseInt(doctorID);
        System.out.println(dateofApp + " " + timeofApp);
        Appointment appointment = new Appointment();
        appointment.setPatientCnic(cnic);
        appointment.setDoctorId(doc);
        appointment.setAppointmentDate(dateofApp);


        ManageAppointmentController.updateAppointment(appointmentId, cnic, doc, dateofApp, timeofApp, appStatus, Integer.parseInt(amount));
        handelBack(event);
    }

    @FXML
    void initialize(Appointment obj) {
        assert appDate != null : "fx:id=\"appDate\" was not injected: check your FXML file 'UpdateAppointment.fxml'.";
        assert appTime != null : "fx:id=\"appTime\" was not injected: check your FXML file 'UpdateAppointment.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'UpdateAppointment.fxml'.";
        assert docId != null : "fx:id=\"docId\" was not injected: check your FXML file 'UpdateAppointment.fxml'.";
        assert fee != null : "fx:id=\"fee\" was not injected: check your FXML file 'UpdateAppointment.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'UpdateAppointment.fxml'.";


        cnic.setText(String.valueOf(obj.getPatientCnic()));
        appId.setText(String.valueOf(obj.getAppointmentId()));

        docId.setText(String.valueOf(obj.getDoctorId()));
//        String sal = String.valueOf(obj.getSalary());
//        sal = sal.substring(0, sal.length()-2);
//        salary.setText(sal);
        appDate.setValue(obj.getAppointmentDate().toLocalDate());
        appTime.setText(String.valueOf(obj.getAppointmentTime()));
        status.setValue(obj.getStatus());
        status.setItems(statusList);
        fee.setText(String.valueOf(obj.getFeeAmount()));
    }

}
