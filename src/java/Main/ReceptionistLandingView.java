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
    void handleAppointments(ActionEvent event) {

    }

    @FXML
    void handleBeds(ActionEvent event) {

    }

    @FXML
    void handlePatients(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "AddNewPatient.fxml", null);
    }

    @FXML
    void initialize() {

    }

}
