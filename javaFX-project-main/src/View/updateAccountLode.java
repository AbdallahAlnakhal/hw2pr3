/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class updateAccountLode extends Stage {

    updateAccountLode() throws IOException {
        FXMLLoader loder = new FXMLLoader(getClass().getResource("updateAccount.fxml"));
        Parent p = loder.load();
        Scene sc = new Scene(p);
        this.setScene(sc);
        this.setTitle("Update Account");
        this.show();

    }

}
