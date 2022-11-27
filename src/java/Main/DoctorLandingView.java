package Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class DoctorLandingView {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void viewAppointments(ActionEvent event) {

    }

    @FXML
    void viewSchedule(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "ViewPersonalSchedule.fxml", null);
    }

    @FXML
    void initialize() {

    }

}
