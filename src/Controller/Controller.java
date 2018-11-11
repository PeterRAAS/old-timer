package Controller;

import Model.SingletonOldTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Controller {

    public Controller() {

        SingletonOldTimer conn = SingletonOldTimer.getInstance();
        conn.laadDataBase();

    }

    @FXML
    private TextField countryTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField nameTextFiield;

    @FXML
    private TextField mobileTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField zipCodeTextField;

    private void displayAlert(Alert.AlertType type,String title,String message){

        Alert alert = new Alert((type));
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

