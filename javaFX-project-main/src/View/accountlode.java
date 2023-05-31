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
public class accountlode extends Stage {
    accountlode() throws IOException{
        FXMLLoader lode = new FXMLLoader(getClass().getResource("createnewaccount.fxml") );
        Parent p = lode.load();
        Scene sc = new Scene(p);
        this.setScene(sc);
        this.setTitle("Create new Accoutn");
        this.show();
        
    }
    
}
