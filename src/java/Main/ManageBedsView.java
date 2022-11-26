package Main;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import Controller.BedController;
import Controller.ManageEmpRecordController;
import entity.Bed;
import entity.Employeerecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManageBedsView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Bed> tableView;

    @FXML
    private TableColumn<Bed, Integer> amount;

    @FXML
    private TableColumn<Bed, Integer> appId;

    @FXML
    private TableColumn<Bed, Integer> cnic;

    @FXML
    private TableColumn<Bed, LocalDate> eDate;

    @FXML
    private TableColumn<Bed, LocalDate> sdate;

    @FXML
    private TableColumn<Bed, String> status;


    @FXML
    void handleBack(ActionEvent event) {

    }

    @FXML
    void newBed(ActionEvent event) {

    }

    @FXML
    void updateBed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert amount != null : "fx:id=\"amount\" was not injected: check your FXML file 'ManageBeds.fxml'.";
        assert appId != null : "fx:id=\"appId\" was not injected: check your FXML file 'ManageBeds.fxml'.";
        assert cnic != null : "fx:id=\"cnic\" was not injected: check your FXML file 'ManageBeds.fxml'.";
        assert eDate != null : "fx:id=\"eDate\" was not injected: check your FXML file 'ManageBeds.fxml'.";

        assert sdate != null : "fx:id=\"sdate\" was not injected: check your FXML file 'ManageBeds.fxml'.";
        assert status != null : "fx:id=\"status\" was not injected: check your FXML file 'ManageBeds.fxml'.";
        assert tableView != null : "fx:id=\"tableView\" was not injected: check your FXML file 'ManageBeds.fxml'.";

        List<Bed> beds = BedController.getBeds();

        appId.setCellValueFactory(new PropertyValueFactory<Bed, Integer>("bedId"));
        amount.setCellValueFactory(new PropertyValueFactory<Bed, Integer>("feeAmount"));
        cnic.setCellValueFactory(new PropertyValueFactory<Bed, Integer>("patientCnic"));
        sdate.setCellValueFactory(new PropertyValueFactory<Bed, LocalDate>("startDate"));
        eDate.setCellValueFactory(new PropertyValueFactory<Bed, LocalDate>("endDate"));
        status.setCellValueFactory(new PropertyValueFactory<Bed, String>("status"));

        ObservableList<Bed> bedList = FXCollections.observableArrayList();
        for(Bed b: beds){
            bedList.add(b);
        }

        tableView.setItems(bedList);

    }

}
