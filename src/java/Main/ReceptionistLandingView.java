package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ReceptionistLandingView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void handleAppointments(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageAppointments.fxml", null);
    }

    @FXML
    void handleBeds(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ManageBeds.fxml", null);
    }

    @FXML
    void handlePatients(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AddNewPatient.fxml", null);
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "Login.fxml", null);
    }


    @FXML
    void initialize() {

    }

}
