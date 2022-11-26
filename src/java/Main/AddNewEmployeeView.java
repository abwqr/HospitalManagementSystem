package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.ManageEmployeeController;
import Controller.ManageScheduleController;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class AddNewEmployeeView {

    ObservableList<String> typeList = FXCollections.observableArrayList("receptionist",
            "surgeon", "dermatologists", "cardiologists"
            );

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox employeeType;

    @FXML
    private TextField empId;

    @FXML
    private TextField fname;

    @FXML
    private TextField lname;

    @FXML
    private TextField password;


    @FXML
    void initialize() {
        employeeType.setValue("");
        employeeType.setItems(typeList);

        int newId = ManageEmployeeController.getLastEmpID() + 1;
        empId.setText( String.valueOf(newId));

    }

    public void createEmployee(ActionEvent event)throws IOException {
        String newId = empId.getText();
        String type = (String) employeeType.getValue();
        String firstName = fname.getText();
        String lastName = lname.getText();
        String pass = password.getText();
        System.out.println(firstName + lastName + type + pass);
        int id = Integer.parseInt(newId);
        ManageEmployeeController.addEmployee(id, firstName, lastName, type, pass);

        Employee employee = new Employee();
        employee.setEmpId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setType(type);
        employee.setPassword(pass);


        String admin = "admin";
        String receptionist = "receptionist";
        if(!type.equals(admin) && !type.equals(receptionist)){
            ManageScheduleController.addSchedule(id);
        }

        Common common = new Common();
        common.changeScene(event, "NewEmployeeRecord.fxml", employee);
    }


    @FXML
    void backToRecord(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AdminLanding.fxml", null);
    }

}
