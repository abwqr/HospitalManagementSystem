package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AdminLandingView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button manageEmp;

    @FXML
    private Button manageEmpRec;

    @FXML
    private Button manageSched;

    @FXML
    void NavigateEmp(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AddNewEmployee.fxml",null);
    }

    @FXML
    void NavigateEmpRec(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageEmployeeRecord.fxml", null);
    }

    @FXML
    void NavigateEmpSched(ActionEvent event) throws IOException {

    }

    @FXML
    void initialize() {
        System.out.println(Main.id);
        assert manageEmp != null : "fx:id=\"manageEmp\" was not injected: check your FXML file 'AdminLanding.fxml'.";
        assert manageEmpRec != null : "fx:id=\"manageEmpRec\" was not injected: check your FXML file 'AdminLanding.fxml'.";
        assert manageSched != null : "fx:id=\"manageSched\" was not injected: check your FXML file 'AdminLanding.fxml'.";

    }

}
