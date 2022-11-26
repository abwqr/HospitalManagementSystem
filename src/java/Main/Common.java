package Main;
import java.io.IOException;

import entity.Employee;
import entity.Employeerecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;


public class Common {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public static void main(String[] args) {

    }

    public void changeScene(ActionEvent event, String page, Object obj) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(page));
        root = loader.load();

        if(obj != null) {
            String empRec = "Employeerecord";
            String emp = "Employee";
            String name = obj.getClass().getSimpleName();
            if (name.equals(empRec)) {
                UpdateEmployeeRecordView empRecUpdateController = loader.getController();
                empRecUpdateController.setValues((Employeerecord) obj);
            }

            else if (name.equals(emp)) {
                NewEmployeeRecordView empRecNewController = loader.getController();
                empRecNewController.initialize((Employee) obj);
            }
        }
//        Parent root = FXMLLoader.load(getClass().getResource(page));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();


        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

//    public void changeSceneUpdateEmployeeRecord(ActionEvent event, String page, Employeerecord obj) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource(page));
//        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        UpdateEmployeeRecordView cvc = loader.getController(); // This did the "trick"
//        cvc.setClient(client); // Passing the client-object to the ClientViewController
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
}
