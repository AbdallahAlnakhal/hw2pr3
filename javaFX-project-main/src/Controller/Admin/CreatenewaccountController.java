/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.account;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class CreatenewaccountController implements Initializable {

    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button Cnewaccount;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField userid;
    @FXML
    private TextField accnum;
    @FXML
    private TextField username;
    @FXML
    private TextField currency;
    @FXML
    private TextField balance;
    @FXML
    private TextField cdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void CnewaccountBtn(ActionEvent event) throws SQLException, ClassNotFoundException {
        Integer userid = Integer.valueOf(this.userid.getText());
        Integer accnum = Integer.valueOf(this.accnum.getText());
        String username = this.username.getText();
        String currancy = this.currency.getText();
        Integer balance = Integer.valueOf(this.balance.getText());
//        String cdata = this.cdate.getText();

        account a = new account(userid, accnum, username, currancy, balance, "");
        a.save();
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setContentText(this.username.getText()+" Account created successfully");
        al.showAndWait();
        View.ViewManager.closeNewuser();
    }

    @FXML
    private void cancelaccountCreation(ActionEvent event) {
    }

}
