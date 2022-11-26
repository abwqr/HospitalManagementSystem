package Main;

import java.net.URL;
import java.util.ResourceBundle;

import Controller.LoginController;
import entity.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;

import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.management.Query;



public class LoginView {



    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="password"
    private PasswordField password; // Value injected by FXMLLoader

    @FXML // fx:id="username"
    private TextField id; // Value injected by FXMLLoader

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert password != null : "fx:id=\"password\" was not injected: check your FXML file 'Login.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'Login.fxml'.";

    }


    private Stage stage;
    private Scene scene;
    private Parent root;


    public void checkLogin(ActionEvent event) throws IOException {


        final String empPassword = password.getText();
        final String  empId = id.getText();
        System.out.println(empPassword);
        int id =Integer.parseInt(empId);
        System.out.println(id);

        Employee emp = LoginController.checkLogin(id, empPassword);
        System.out.println(emp.toString());

        System.out.println(emp.getType().getClass().getName());
        String admin = "admin";
        String receptionist = "receptionist";
        if(admin.equals(emp.getType())){
            System.out.println("admin");
            Main.id = emp.getEmpId();
            Common common = new Common();
            common.changeScene(event, "AdminLanding.fxml", null);
        }

        else if(receptionist.equals(emp.getType())){
            System.out.println("receptionist");
            Main.id = emp.getEmpId();
            Common common = new Common();
            common.changeScene(event, "ReceptionistLanding.fxml", null);
        }

    }

    public void switchToScene2(String page) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource(page));
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}





//import Controller.LoginController;

//
//public class LoginView {
//    @FXML
//    private ResourceBundle resources;
//
//    @FXML
//    private URL location;
//
//    @FXML
//    private TextField id;
//
//    @FXML
//    private TextField username;
//
//    @FXML
//    void initialize() {
//
//    }
//

//


//
//
//
//}
