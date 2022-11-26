package Main;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.ManageEmployeeController;
import Controller.ManagePatientController;
import entity.Employee;
import entity.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddNewPatientView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField cnic;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField phoneNum;

    @FXML
    void addNewPatient(ActionEvent event) {
        String id = cnic.getText();
        String firstName = fname.getText();
        String lastName = lname.getText();
        String phNum = phoneNum.getText();

        int cnic = Integer.parseInt(id);
        System.out.println(firstName + " " + lastName + " " + cnic + " " + phNum);
        Patient patient = new Patient();
        patient.setPatientCnic(cnic);
        patient.setPatientFirstName(firstName);
        patient.setPatientLastName(lastName);
        patient.setPatientPhoneNumber(phNum);
        ManagePatientController.addPatient(cnic, firstName, lastName, phNum);
    }

    @FXML
    void handleBack(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'AddNewPatient.fxml'.";
        assert fname != null : "fx:id=\"fname\" was not injected: check your FXML file 'AddNewPatient.fxml'.";
        assert lname != null : "fx:id=\"lname\" was not injected: check your FXML file 'AddNewPatient.fxml'.";
        assert phoneNum != null : "fx:id=\"phoneNum\" was not injected: check your FXML file 'AddNewPatient.fxml'.";

    }

}
