/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rtmfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.stage.Modality;
import javafx.stage.Stage;
import rtmfx.agorithm.ThomasAlgorithm;

/**
 *
 * @author yasser
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private MenuBar menubar;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        int n = 4;
        double a[] = {0, -1, -1, -1};
        double b[] = {4, 4, 4, 4};
        double c[] = {-1, -1, -1, 0};
        double d[] = {5, 5, 10, 23};
        // results    { 2,  3,  5, 7  }
        ThomasAlgorithm.solve(a, b, c, d, n);

        for (int i = 0; i < n; i++) {
            System.out.print(d[i] + " ");
        }
        System.out.println("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    private void handleHelpAction(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            root = FXMLLoader.load(
                    FXMLDocumentController.class.getResource("FXMLAbout.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        stage.setScene(new Scene(root));
        //stage.getIcons().add(new Image("/res/derkunde.png"));
        stage.setTitle("Über");

        stage.initModality(Modality.WINDOW_MODAL);

        stage.initOwner(
                (Stage) menubar.getScene().getWindow());
        stage.setResizable(false);
        stage.show();

    }

}
