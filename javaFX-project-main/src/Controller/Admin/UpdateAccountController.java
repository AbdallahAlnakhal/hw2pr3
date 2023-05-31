/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller.Admin;

import Model.User;
import Model.account;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class UpdateAccountController implements Initializable {

    private account oldAccount;
    @FXML
    private TextField username;
    @FXML
    private TextField accNumber;
    @FXML
    private TextField currency;
    @FXML
    private Button updateAccount;
    @FXML
    private Button cancelBtn;
    @FXML
    private TextField balance;
    @FXML
    private TextField creationDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.oldAccount = Controller.Admin.AccountsManagmentController.selectedAccountToUpdate;
        accNumber.setText(String.valueOf(oldAccount.getAccount_number()));
        currency.setText(oldAccount.getCurrency());
        username.setText(oldAccount.getUsername());
        balance.setText(String.valueOf(oldAccount.getBalance()));
        creationDate.setText(oldAccount.getCreation_date());
        // TODO
    }

    @FXML
    private void updateAccountBtn(ActionEvent event) throws SQLException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        LocalDateTime now = LocalDateTime.now();
        Integer accountnumber = Integer.valueOf(accNumber.getText());
        String user = username.getText();
        String currency = this.currency.getText();
        Integer bal = Integer.valueOf(balance.getText());
        String cdate = creationDate.getText();
        account a = new account(accountnumber, user, currency, bal, cdate);
        a.setId(oldAccount.getId());
        a.Update();
        Alert al = new Alert(Alert.AlertType.INFORMATION);
        al.setContentText("Account Updated");
        al.showAndWait();

    }

    @FXML
    private void cancelCreation(ActionEvent event) {
    }

}
