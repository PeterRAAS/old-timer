package Controller;

import Model.Cars;
import Model.Members;
import Model.OldTimerQueries;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 18/11/2018<br/>
 * Time: 10:19<br/>
 * To change this template use File | Settings | File Templates.
 */
public class CarsController {

    private final OldTimerQueries oldTimerQueries = new OldTimerQueries();
    private int ID;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @FXML
    private Button addCarsButton;

    @FXML
    private TextField colorTextField;

    @FXML
    private TextField yearTextField;

    @FXML
    private TextField modelTextField;

    @FXML
    private TextField constructorTextField;


    public void start(Members member) {

        this.ID = member.getMemberID();

    }

    @FXML
    void addCarsButtonClicked(ActionEvent event) {


        try {
            int result = oldTimerQueries.addCar(
                    this.ID,
                    constructorTextField.getText(),
                    modelTextField.getText(),
                    Integer.parseInt(yearTextField.getText()),
                    colorTextField.getText()

            );


            if (result == 1) {


                displayAlert(Alert.AlertType.INFORMATION, "Nieuwe wagen toegevoegd", "Nieuwe wagen succesvol toegevoegd");
                //Controller controller  = new Controller();
                //controller.laadDataView(this.ID);



            } else {
                displayAlert(Alert.AlertType.ERROR, "Nieuwe wagen niet toegevoegd", "Nieuwe wagen niet toegevoegd");
            }
        } catch (Exception ex) {
            displayAlert(Alert.AlertType.ERROR, "Fout opgetreden", ex.getMessage());

        }


    }


    private void displayAlert(Alert.AlertType type, String title, String message) {

        Alert alert = new Alert((type));
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}
