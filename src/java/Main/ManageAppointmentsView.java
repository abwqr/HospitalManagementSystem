package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Controller.ManageAppointmentController;
import Controller.ManageEmpRecordController;
import Controller.ManagePatientController;
import Controller.ManageScheduleController;
import entity.Appointment;
import entity.Employeerecord;
import entity.Empschedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageAppointmentsView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<Appointment> tableView;

    @FXML
    private TableColumn<Appointment, Integer> appId;

    @FXML
    private TableColumn<Appointment, Integer> amount;

    @FXML
    private TableColumn<Appointment, LocalDate> appDate;

    @FXML
    private TableColumn<Appointment, String> appTime;

    @FXML
    private TableColumn<Appointment, Integer> cnic;

    @FXML
    private TableColumn<Appointment, Integer> docId;

    @FXML
    private TableColumn<Appointment, String> status;

    @FXML
    void editAppoinment(ActionEvent event)throws IOException {
        Appointment app = tableView.getSelectionModel().getSelectedItem();
        String val = String.valueOf(app.getAppointmentId());
        System.out.println(val.getClass().getName());
        Appointment obj = ManageAppointmentController.getAppointment(app.getAppointmentId());
        Common common = new Common();
        common.changeScene(event, "UpdateAppointment.fxml", obj);
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {

    }

    @FXML
    void newAppoinment(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AddNewAppointment.fxml", null);
    }

    @FXML
    void initialize() {
        assert amount != null : "fx:id=\"amount\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert appDate != null : "fx:id=\"appDate\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert appTime != null : "fx:id=\"appTime\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert docId != null : "fx:id=\"docId\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'ManageAppointments.fxml'.";

        List<Appointment> appointments = ManageAppointmentController.getAllAppointments();

        cnic.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("patientCnic"));
        appDate.setCellValueFactory(new PropertyValueFactory<Appointment, LocalDate>("appointmentDate"));
        appTime.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentTime"));
        appId.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("appointmentId"));
        docId.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("doctorId"));
        status.setCellValueFactory(new PropertyValueFactory<Appointment, String>("status"));
        amount.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("feeAmount"));
        ObservableList<Appointment> appList = FXCollections.observableArrayList();
        for(Appointment a: appointments){
            appList.add(a);
        }

        tableView.setItems(appList);

    }

}
