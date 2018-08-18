/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ANC;

import Views.ANC.*;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class ImmobCorporelleController implements Initializable {

    @FXML
    private TextField TAvAcVerses;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnEnregistrer;
    @FXML
    private TextField TTerrain;
    @FXML
    private TextField TConstruction;
    @FXML
    private TextField TInstTech;
    @FXML
    private TextField TMatTransport;
    @FXML
    private TextField TAutreImmobCorp;
    @FXML
    private TextField TImmobCorpEnCours;
    @FXML
    private TextField TImmobStatJur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NumberFormat(TConstruction);
        NumberFormat(TTerrain);
        NumberFormat(TInstTech);
        NumberFormat(TMatTransport);
        NumberFormat(TAutreImmobCorp);
        NumberFormat(TImmobCorpEnCours);
        NumberFormat(TImmobStatJur);
        NumberFormat(TAvAcVerses);
    }    
    
    public void NumberFormat(TextField txtField){
        txtField.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (!newValue.matches("\\d*")) {
                txtField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }
    
}
