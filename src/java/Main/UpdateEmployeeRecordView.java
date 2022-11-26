package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import Controller.ManageEmpRecordController;
import entity.Employeerecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class UpdateEmployeeRecordView {

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
    void initialize() {

    }

    @FXML
    void toEmpRec(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageEmployeeRecord.fxml", null);
    }

    @FXML
    void updateRecord(ActionEvent event) throws IOException {
        String employeeID = empid.getText();
        LocalDate hDate = hireDate.getValue();
        String phNum = phoneNum.getText();
        String sal = salary.getText();

        System.out.println(employeeID + " " + hDate + " " + Integer.parseInt(sal) + " " + phNum);
        ManageEmpRecordController.updateEmployeeRecord(
                Integer.parseInt(employeeID),
                Integer.parseInt(sal),
                Integer.parseInt(phNum)
        );

        Common common = new Common();
        common.changeScene(event, "ManageEmployeeRecord.fxml", null);
    }

    @FXML
    void setValues(Employeerecord obj) {

        empid.setText(String.valueOf(obj.getEmpId()));

        phoneNum.setText(obj.getPhoneNumber());
        String sal = String.valueOf(obj.getSalary());
        sal = sal.substring(0, sal.length()-2);
        salary.setText(sal);
        hireDate.setValue(obj.getHireDate().toLocalDate());
    }

    @FXML
    public void backToRecord(ActionEvent event)throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageEmployeeRecord.fxml", null);
    }

}
