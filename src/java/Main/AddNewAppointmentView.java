package Main;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import Controller.ManageAppointmentController;
import Controller.ManageEmployeeController;
import entity.Appointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AddNewAppointmentView {

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
    private TextField fee;

    @FXML
    private ChoiceBox status;

    @FXML
    private Text appId;

    @FXML
    private TextField docId;

    ObservableList<String> statusList = FXCollections.observableArrayList("finished", "pending", "missed", "cancelled");


    @FXML
    void addAppointment(ActionEvent event) throws IOException {
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

        int newId = ManageAppointmentController.getLastAppointment() + 1;

        appId.setText(String.valueOf(newId));

        ManageAppointmentController.addAppointment(newId, cnic, doc, dateofApp, timeofApp, appStatus, Integer.parseInt(amount));

    }

    @FXML
    void handelBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageAppointments.fxml", null);
    }

    @FXML
    void viewSchedule(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ManageSchedule.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();

        FXMLLoader fxmlLoader2 = new FXMLLoader(getClass().getResource("ManageAppointments.fxml"));
        Parent root2 = (Parent) fxmlLoader2.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(root1));
        stage.show();

        Stage stage2 = new Stage();
        stage2.setTitle("My New Stage Title");
        stage2.setScene(new Scene(root2));
        stage2.show();
    }

    @FXML
    void initialize() {
        assert appDate != null : "fx:id=\"appDate\" was not injected: check your FXML file 'AddNewAppointment.fxml'.";
        assert appTime != null : "fx:id=\"appTime\" was not injected: check your FXML file 'AddNewAppointment.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'AddNewAppointment.fxml'.";
        assert fee != null : "fx:id=\"fee\" was not injected: check your FXML file 'AddNewAppointment.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'AddNewAppointment.fxml'.";

        status.setValue("pending");
        status.setItems(statusList);


    }

}
