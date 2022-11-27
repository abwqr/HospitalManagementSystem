package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Controller.ManageEmpRecordController;
import Controller.ManageScheduleController;
import entity.Employeerecord;
import entity.Empschedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageScheduleView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Empschedule> tableView;


    @FXML
    private TableColumn<Empschedule, LocalDate> appDate;

    @FXML
    private TableColumn<Empschedule, String> eTime;

    @FXML
    private TableColumn<Empschedule, Integer> empId;

    @FXML
    private TableColumn<Empschedule, String> room;

    @FXML
    private TableColumn<Empschedule, String> sTime;

    @FXML
    void initialize() {
        assert appDate != null : "fx:id=\"appDate\" was not injected: check your FXML file 'ManageSchedule.fxml'.";
        assert eTime != null : "fx:id=\"eTime\" was not injected: check your FXML file 'ManageSchedule.fxml'.";
        assert empId != null : "fx:id=\"empId\" was not injected: check your FXML file 'ManageSchedule.fxml'.";
        assert room != null : "fx:id=\"room\" was not injected: check your FXML file 'ManageSchedule.fxml'.";
        assert sTime != null : "fx:id=\"sTime\" was not injected: check your FXML file 'ManageSchedule.fxml'.";


        List<Empschedule> empSched = ManageScheduleController.getAllSchedules();

        empId.setCellValueFactory(new PropertyValueFactory<Empschedule, Integer>("empId"));
        appDate.setCellValueFactory(new PropertyValueFactory<Empschedule, LocalDate>("shiftDate"));
        room.setCellValueFactory(new PropertyValueFactory<Empschedule, String>("room"));
        sTime.setCellValueFactory(new PropertyValueFactory<Empschedule, String>("startTime"));
        eTime.setCellValueFactory(new PropertyValueFactory<Empschedule, String>("endTime"));

        ObservableList<Empschedule> empSchedList = FXCollections.observableArrayList();
        for(Empschedule emp: empSched){
            empSchedList.add(emp);
        }

        tableView.setItems(empSchedList);
    }

    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AdminLanding.fxml", null);
    }


    @FXML
    public void clearSchedule(ActionEvent event)throws IOException {
        Empschedule empSched = tableView.getSelectionModel().getSelectedItem();
        System.out.println(empSched.getEmpId());
        ManageScheduleController.clearSchedule(empSched.getEmpId());
        initialize();
    }


    @FXML
    public void updateSchedule(ActionEvent event) throws IOException {
        Empschedule empschedule = tableView.getSelectionModel().getSelectedItem();
        String val = String.valueOf(empschedule.getEmpId());
        System.out.println(val);
        Empschedule obj = ManageScheduleController.getSchedule(empschedule.getEmpId());
        Common common = new Common();
        common.changeScene(event, "UpdateSchedule.fxml", obj);
    }


}

