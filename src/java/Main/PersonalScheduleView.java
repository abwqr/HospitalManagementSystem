package Main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Controller.ManageScheduleController;
import entity.Empschedule;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PersonalScheduleView {

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
    private TableColumn<Empschedule, String> room;

    @FXML
    private TableColumn<Empschedule, String> sTime;


    @FXML
    void handleBack(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "DoctorLanding.fxml", null);
    }

    @FXML
    void initialize() {
        assert appDate != null : "fx:id=\"Appdate\" was not injected: check your FXML file 'ViewSchedule.fxml'.";
        assert eTime != null : "fx:id=\"eTime\" was not injected: check your FXML file 'ViewSchedule.fxml'.";
        assert room != null : "fx:id=\"room\" was not injected: check your FXML file 'ViewSchedule.fxml'.";
        assert sTime != null : "fx:id=\"sTime\" was not injected: check your FXML file 'ViewSchedule.fxml'.";

        Empschedule empSchedule = ManageScheduleController.getSchedule(Main.id);
        System.out.println(empSchedule);
        appDate.setCellValueFactory(new PropertyValueFactory<Empschedule, LocalDate>("shiftDate"));
        room.setCellValueFactory(new PropertyValueFactory<Empschedule, String>("room"));
        sTime.setCellValueFactory(new PropertyValueFactory<Empschedule, String>("startTime"));
        eTime.setCellValueFactory(new PropertyValueFactory<Empschedule, String>("endTime"));

        ObservableList<Empschedule> empSchedList = FXCollections.observableArrayList();

        LocalDate shiftDate = empSchedule.getShiftDate();

        if(empSchedule.getShiftDate() != null) {
            for (int i = 0; i < 5; i++) {
                Empschedule emp = new Empschedule();
                emp.setRoom(empSchedule.getRoom());
                emp.setEndTime(empSchedule.getEndTime());
                emp.setStartTime(empSchedule.getStartTime());
                emp.setShiftDate(shiftDate);
                shiftDate = shiftDate.plusDays(1);
                System.out.println(shiftDate);
                empSchedList.add(emp);
            }

            tableView.setItems(empSchedList);
        }
    }

}
