package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Controller.ManageEmpRecordController;
import entity.Employee;
import entity.Employeerecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class NewEmployeeRecordView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField empid;

    @FXML
    private DatePicker hireDate;

    @FXML
    private TextField phoneNum;

    @FXML
    private TextField salary;



    @FXML
    void toEmpRec(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageEmployeeRecord.fxml", null);
    }

    @FXML
    void saveRecord(ActionEvent event) {
        String employeeID = empid.getText();
        LocalDate hDate = hireDate.getValue();
        String phNum = phoneNum.getText();
        String sal = salary.getText();

        System.out.println(employeeID + " " + hDate + " " + sal + " " + phNum);
        ManageEmpRecordController.addEmployeeRecord(
                Integer.parseInt(employeeID),
                hDate,
                Integer.parseInt(sal),
                Integer.parseInt(phNum)
        );
    }

    @FXML
    void initialize(Employee obj) {
        assert empid != null : "fx:id=\"empid\" was not injected: check your FXML file 'NewEmployeeRecord.fxml'.";
        assert hireDate != null : "fx:id=\"hireDate\" was not injected: check your FXML file 'NewEmployeeRecord.fxml'.";
        assert phoneNum != null : "fx:id=\"phoneNum\" was not injected: check your FXML file 'NewEmployeeRecord.fxml'.";
        assert salary != null : "fx:id=\"salary\" was not injected: check your FXML file 'NewEmployeeRecord.fxml'.";
        empid.setText(String.valueOf(obj.getEmpId()));
    }




}
