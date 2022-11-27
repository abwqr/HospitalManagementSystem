package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Controller.ManageAppointmentController;
import Controller.ManageEmpRecordController;
import Controller.ManageEmployeeController;
import Controller.ManageScheduleController;
import entity.Employee;
import entity.Employeerecord;
import entity.Empschedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageEmployeeView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Employee> tableView;

    @FXML
    private TableColumn<Employee, Integer> empId;

    @FXML
    private TableColumn<Employee, String> fname;

    @FXML
    private TableColumn<Employee, String> lname;

    @FXML
    private TableColumn<Employee, String> type;

    @FXML
    void addEmployee(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AddNewEmployee.fxml", null);
    }

    @FXML
    void deleteEmployee(ActionEvent event) {
        Employee emp = tableView.getSelectionModel().getSelectedItem();
        String val = String.valueOf(emp.getEmpId());
//        System.out.println(val.getClass().getName());

        String admin = "admin";
        String receptionist = "receptionist";

        int id = emp.getEmpId();
        if(!admin.equals(emp.getType()) && !receptionist.equals(emp.getType())) {
            ManageEmpRecordController.deleteRec(id);
            ManageScheduleController.deleteSched(id);
            ManageAppointmentController.deleteAppointment(id);
        }

        ManageEmployeeController.deleteEmployee(id);

        initialize();
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AdminLanding.fxml", null);
    }

    @FXML
    void initialize() {
        assert empId != null : "fx:id=\"empId\" was not injected: check your FXML file 'ManageEmployee.fxml'.";
        assert fname != null : "fx:id=\"fname\" was not injected: check your FXML file 'ManageEmployee.fxml'.";
        assert lname != null : "fx:id=\"lname\" was not injected: check your FXML file 'ManageEmployee.fxml'.";
        assert type != null : "fx:id=\"salary\" was not injected: check your FXML file 'ManageEmployee.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ManageEmployee.fxml'.";


        List<Employee> emp = ManageEmployeeController.getAllEmployees();

        empId.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("empId"));
        fname.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
        lname.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
        type.setCellValueFactory(new PropertyValueFactory<Employee, String>("type"));

        ObservableList<Employee> empList = FXCollections.observableArrayList();
        for(Employee e: emp){
            empList.add(e);
        }

        tableView.setItems(empList);
    }

}
