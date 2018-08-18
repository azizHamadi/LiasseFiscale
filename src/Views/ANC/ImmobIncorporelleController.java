/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.ANC;

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
public class ImmobIncorporelleController implements Initializable {

    @FXML
    private TextField TInvestRechDev;
    @FXML
    private TextField TConcMarq;
    @FXML
    private TextField TLogiciel;
    @FXML
    private TextField TfondCom;
    @FXML
    private TextField TDroitBail;
    @FXML
    private TextField TAutreImmobInc;
    @FXML
    private TextField TImmobIncEnCours;
    @FXML
    private TextField TAvAcVerses;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnEnregistrer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NumberFormat(TInvestRechDev);
        NumberFormat(TConcMarq);
        NumberFormat(TLogiciel);
        NumberFormat(TfondCom);
        NumberFormat(TDroitBail);
        NumberFormat(TAutreImmobInc);
        NumberFormat(TImmobIncEnCours);
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
