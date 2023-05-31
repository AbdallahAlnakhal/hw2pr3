/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.Admin;

import Model.DB;
import Model.User;
import Model.account;
import View.ViewManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Yahya
 */
public class AccountsManagmentController implements Initializable {

    public static account selectedAccountToUpdate;

    @FXML
    private TableView<account> accountTable;
    @FXML

    private TableColumn<account, Integer> accbalance;

    @FXML
    private TableColumn<account, String> acccreationdate;

    @FXML
    private TableColumn<account, String> acccurrency;

    @FXML
    private TableColumn<account, Integer> accid;

    @FXML
    private TableColumn<account, Integer> accnum;
    @FXML
    private TableColumn<account, String> accusername;
    @FXML
    private Button usersManagmentPageBtn;
    @FXML
    private Button accountsPageBtn;
    @FXML
    private Button operationsPageBtn;
    @FXML
    private Button createNewAccountrBtn;
    @FXML
    private Button showAllAccountsBtn;
    @FXML
    private Button updateSelectedAccountBtn;
    @FXML
    private Button deleteSelectedAccountBtn;
    @FXML
    private Button searchAccountBtn;
    @FXML
    private TextField accontSearchTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accid.setCellValueFactory(new PropertyValueFactory("id"));
        accnum.setCellValueFactory(new PropertyValueFactory("account_number"));
        accusername.setCellValueFactory(new PropertyValueFactory("username"));
        acccurrency.setCellValueFactory(new PropertyValueFactory("currency"));
        accbalance.setCellValueFactory(new PropertyValueFactory("balance"));
        acccreationdate.setCellValueFactory(new PropertyValueFactory("creation_date"));

    }

    @FXML
    private void showUsersManagmentPage(ActionEvent event) {
        ViewManager.adminPage.changeSceneToUsersManagment();
    }

    @FXML
    private void showAccountsPage(ActionEvent event) {
    }

    @FXML
    private void showOperationsPage(ActionEvent event) {
    }

    @FXML
    private void showAccountCreationPage(ActionEvent event) throws IOException {
        View.ViewManager.openNewuser();
    }

    @FXML
    private void showAllAccounts(ActionEvent event) throws SQLException, ClassNotFoundException {
        ObservableList<account> usersList
                = FXCollections.observableArrayList(account.getAllAccount());

        accountTable.setItems(usersList);
    }

    @FXML
    private void updateSelectedAccount(ActionEvent event) throws IOException {
        if (accountTable.getSelectionModel().getSelectedItem() != null) {
            selectedAccountToUpdate = accountTable.getSelectionModel().getSelectedItem();
            View.ViewManager.openUpdateAccount();
        }
    }

    @FXML
    private void deleteSelectedAccount(ActionEvent event) throws SQLException {
        account acc = accountTable.getSelectionModel().getSelectedItem();

        if (acc != null) {
            Connection c = DB.getInstance().getConnection();
            int id = acc.getId();
            Alert del = new Alert(Alert.AlertType.CONFIRMATION);
            del.setTitle("Account delete");
            del.setContentText("Are you sure to delete this Account ?");
            del.showAndWait().ifPresent(e -> {
                if (e == ButtonType.OK) {
                    try {

                        String sql = "DELETE FROM ACCOUNTS WHERE ID=? ";
                        PreparedStatement ps = c.prepareStatement(sql);
                        ps.setInt(1, id);
                        ps.executeUpdate();
                        accountTable.refresh();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            });
            Alert deleted = new Alert(Alert.AlertType.INFORMATION);
            deleted.setTitle("Account deleted");
            deleted.setContentText("Account Deleted Successfully");
            deleted.showAndWait();
            accountTable.refresh();

        }

    }

    @FXML
    private void searchForAnAccount(ActionEvent event) {
    }

}
