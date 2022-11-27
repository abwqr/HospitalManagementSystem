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

public class PersonalAppointmentsView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<Appointment> tableView;

    @FXML
    private TableColumn<Appointment, Integer> amount;

    @FXML
    private TableColumn<Appointment, LocalDate> appDate;

    @FXML
    private TableColumn<Appointment, String> appTime;

    @FXML
    private TableColumn<Appointment, Integer> cnic;


    @FXML
    private TableColumn<Appointment, String> status;


    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "DoctorLanding.fxml", null);
    }


    @FXML
    void initialize() {
        assert amount != null : "fx:id=\"amount\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert appDate != null : "fx:id=\"appDate\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert appTime != null : "fx:id=\"appTime\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'ManageAppointments.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'ManageAppointments.fxml'.";

        List<Appointment> appointments = ManageAppointmentController.getAppointments(Main.id);

        cnic.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("patientCnic"));
        appDate.setCellValueFactory(new PropertyValueFactory<Appointment, LocalDate>("appointmentDate"));
        appTime.setCellValueFactory(new PropertyValueFactory<Appointment, String>("appointmentTime"));
        status.setCellValueFactory(new PropertyValueFactory<Appointment, String>("status"));
        amount.setCellValueFactory(new PropertyValueFactory<Appointment, Integer>("feeAmount"));
        ObservableList<Appointment> appList = FXCollections.observableArrayList();
        for(Appointment a: appointments){
            appList.add(a);
        }

        tableView.setItems(appList);

    }

}
