package Controller;

import Model.Cars;
import Model.Members;
import Model.OldTimerQueries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.<br/>
 * User: peter<br/>
 * Date: 11/11/2018<br/>
 * Time: 20:09<br/>
 * To change this template use File | Settings | File Templates.
 */

public class Controller {


    private final ObservableList<Members> membersList = FXCollections.observableArrayList();
    private final OldTimerQueries oldTimerQueries = new OldTimerQueries();
    private Members member;



    @FXML
    private TableView<Cars> tableView;

    @FXML
    private Pane bottomPane;

    @FXML
    private ListView<Members> listView;

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

    @FXML
    private TextField findTextField;

    @FXML
    private Button addMemberButton;

    @FXML
    private Button addCarsButton;

    @FXML
    private Button findButton;

    @FXML
    private Button deleteMemberButton;

    @FXML
    private Button deleteCarsButton;

    @FXML
    private Button selectAllMembersButton;

    public void initialize() {
        listView.setItems(membersList);

        //OldTimerQueries qryCars = new OldTimerQueries();
        getAllEntries();
        //laadTableData(qryCars.getAllCars());

    }


    private void getAllEntries() {


        membersList.setAll(oldTimerQueries.getAllMembers());
        selectFirstEntry();

        listView.getSelectionModel().selectedItemProperty().addListener(
                (observableValue, oldValue, newValue) -> {
                    displayContact(newValue);
                }
        );
    }

    public void laadDataView(int ID) {

        OldTimerQueries qry = new OldTimerQueries();
        qry.laadCars(ID);
        laadTableData(qry.getAllCars());

    }

    private void displayContact(Members member) {
        //Cars car = new Cars(member.getMemberID());
        OldTimerQueries qry = new OldTimerQueries();
        qry.laadCars(member.getMemberID());
        this.member = member;

        laadTableData(qry.getAllCars());
        if (member != null) {

            nameTextFiield.setText(member.getName());
            firstnameTextField.setText(member.getFirstName());
            streetTextField.setText(member.getStreet());
            numberTextField.setText(Integer.toString(member.getNumber()));
            zipCodeTextField.setText(Integer.toString(member.getZipCode()));
            cityTextField.setText(member.getCity());
            countryTextField.setText(member.getCountry());
            phoneTextField.setText(member.getPhone());
            mobileTextField.setText(member.getMobile());
            emailTextField.setText(member.getEmail());

        } else {

            nameTextFiield.clear();
            firstnameTextField.clear();
            streetTextField.clear();
            numberTextField.clear();
            zipCodeTextField.clear();
            countryTextField.clear();
            phoneTextField.clear();
            mobileTextField.clear();
            emailTextField.clear();

        }
    }

    private void selectFirstEntry() {
        listView.getSelectionModel().selectFirst();
    }




    public void laadTableData(List<Cars> qryCars) {

       tableView.getColumns().clear();
      //tableView.setItems(null);

        TableColumn carIDClm = new TableColumn();
        carIDClm.setText("CarID");
        carIDClm.setMinWidth(100);
        carIDClm.setCellValueFactory(new PropertyValueFactory("carnumber"));

        TableColumn constructorClm = new TableColumn();
        constructorClm.setText("Constructor");
        constructorClm.setMinWidth(100);
        constructorClm.setCellValueFactory(new PropertyValueFactory("constructor"));

        TableColumn modelClm = new TableColumn();
        modelClm.setText("Model");
        modelClm.setMinWidth(100);
        modelClm.setCellValueFactory(new PropertyValueFactory("model"));

        TableColumn yearClm = new TableColumn();
        yearClm.setText("Year");
        modelClm.setMinWidth(100);
        yearClm.setCellValueFactory(new PropertyValueFactory("year"));

        TableColumn colorClm = new TableColumn();
        colorClm.setText("Color");
        colorClm.setMinWidth(100);
        colorClm.setCellValueFactory(new PropertyValueFactory("color"));

        ObservableList<Cars> cars = FXCollections.observableArrayList(qryCars);

        tableView.setItems(cars);

        tableView.getColumns().addAll(carIDClm, constructorClm, modelClm, yearClm, colorClm);


    }

    @FXML
    void addNewMemberClicked(ActionEvent event) {
        try {
            int result = oldTimerQueries.addMember(
                    nameTextFiield.getText(),
                    firstnameTextField.getText(),
                    streetTextField.getText(),
                    Integer.parseInt(numberTextField.getText()),
                    Integer.parseInt(zipCodeTextField.getText()),
                    cityTextField.getText(),
                    countryTextField.getText(),
                    phoneTextField.getText(),
                    mobileTextField.getText(),
                    emailTextField.getText()
            );

            getAllEntries();
            if (result == 1) {
                displayAlert(Alert.AlertType.INFORMATION, "Nieuw lid toegevoegd", "Nieuw lid succesvol toegevoegd");
            } else {
                displayAlert(Alert.AlertType.ERROR, "Nieuw lid niet toegevoegd", "Nieuw lid niet toegevoegd");
            }
        } catch (Exception ex) {
            displayAlert(Alert.AlertType.ERROR, "Fout opgetreden", ex.getMessage());
        }
    }


    @FXML
    void addCarsButtonClicked(ActionEvent event) {

        try {

            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("oldTimerCars.fxml"));
            Parent parent = fxmlLoader.load();
            CarsController dialogFXController = fxmlLoader.getController();
            dialogFXController.start(this.member);
            Stage stage = new Stage();
            stage.setScene(new Scene(parent));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void findButtonClicked(ActionEvent event) {

        OldTimerQueries qry = new OldTimerQueries();
        ObservableList<Members> member = FXCollections.observableArrayList(qry.filterByFirstName(findTextField.getText() + "%"));
        listView.setItems(member);

    }


    @FXML
    void deleteNewMemberClicked(ActionEvent event) {

        OldTimerQueries qry = new OldTimerQueries();
        qry.deleteMember(listView.getSelectionModel().getSelectedItem().getMemberID());
        initialize();

    }

    @FXML
    void deleteCarsButtonClicked(ActionEvent event) {

        OldTimerQueries qry = new OldTimerQueries();
        qry.deleteCars(tableView.getSelectionModel().getSelectedItem().getCarnumber());
        laadDataView(listView.getSelectionModel().getSelectedItem().getMemberID());


    }

    @FXML
    void selectAllMembersButtonClicked(ActionEvent event) {
        listView.setItems(membersList);
        getAllEntries();
    }


    private void displayAlert(Alert.AlertType type, String title, String message) {

        Alert alert = new Alert((type));
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


}



