package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Controller.ManageEmpRecordController;
import entity.Employeerecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageEmployeeRecordView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Employeerecord> tableView;

    @FXML
    private TableColumn<Employeerecord, Integer> empId;

    @FXML
    private TableColumn<Employeerecord, LocalDate> hireDate;

    @FXML
    private TableColumn<Employeerecord, Integer> phoneNum;

    @FXML
    private TableColumn<Employeerecord, Integer> salary;


    @FXML
    void initialize() {
        assert empId != null : "fx:id=\"empId\" was not injected: check your FXML file 'ManageEmployeeRecord.fxml'.";
        assert salary != null : "fx:id=\"empRec\" was not injected: check your FXML file 'ManageEmployeeRecord.fxml'.";

        List<Employeerecord> empRec = ManageEmpRecordController.getAllEmpRec();

        empId.setCellValueFactory(new PropertyValueFactory<Employeerecord, Integer>("empId"));
        phoneNum.setCellValueFactory(new PropertyValueFactory<Employeerecord, Integer>("phoneNumber"));
        salary.setCellValueFactory(new PropertyValueFactory<Employeerecord, Integer>("salary"));
        hireDate.setCellValueFactory(new PropertyValueFactory<Employeerecord, LocalDate>("hireDate"));

        ObservableList<Employeerecord> empRecList = FXCollections.observableArrayList();
        for(Employeerecord emp: empRec){
            empRecList.add(emp);
        }

        tableView.setItems(empRecList);
    }

    @FXML
    public void deleteRecord(ActionEvent event)throws IOException {
        Employeerecord empRec = tableView.getSelectionModel().getSelectedItem();
        System.out.println(empRec.getEmpId());
        ManageEmpRecordController.deleteRec(empRec.getEmpId());
        initialize();
    }

    @FXML
    public void addRecord(ActionEvent event)throws IOException {
        Common common = new Common();
        common.changeScene(event, "AddNewEmployee.fxml", null);

    }

    @FXML
    public void updateRecord(ActionEvent event)throws IOException {
        Employeerecord empRec = tableView.getSelectionModel().getSelectedItem();
        String val = String.valueOf(empRec.getEmpId());
        System.out.println(val.getClass().getName());
        Employeerecord obj = ManageEmpRecordController.getEmployeeRec(empRec.getEmpId());
        Common common = new Common();
        common.changeScene(event, "UpdateEmployeeRecord.fxml", obj);

    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AdminLanding.fxml", null);
    }

}

