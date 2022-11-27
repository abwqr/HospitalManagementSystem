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
    void logout(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "Login.fxml", null);
    }


    @FXML
    void viewAppointments(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "PersonalAppointments.fxml", null);
    }

    @FXML
    void viewSchedule(ActionEvent event) throws IOException {
        Common common = new Common();
        common.changeScene(event, "PersonalSchedule.fxml", null);
    }

    @FXML
    void initialize() {

    }

}
