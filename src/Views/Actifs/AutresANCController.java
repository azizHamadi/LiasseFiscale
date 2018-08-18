/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Actifs;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class AutresANCController implements Initializable {

    @FXML
    private TextField TFraisPBrut;
    @FXML
    private TextField TFraisPAmmort;
    @FXML
    private TextField TFraisPNetN;
    @FXML
    private TextField TFraisPNetN1;
    @FXML
    private TextField TChargeRepBrut;
    @FXML
    private TextField TChargeRepAmmort;
    @FXML
    private TextField TChargeRepNetN;
    @FXML
    private TextField TChargeRepNetN1;
    @FXML
    private TextField TFraisEmissBrut;
    @FXML
    private TextField TFraisEmissAmmort;
    @FXML
    private TextField TFraisEmissNetN;
    @FXML
    private TextField TFraisEmissNetN1;
    @FXML
    private TextField TEcartCenvBrut;
    @FXML
    private TextField TEcartCenvAmmort;
    @FXML
    private TextField TEcartCenvNetN;
    @FXML
    private TextField TEcartCenvNetN1;
    @FXML
    private JFXButton BtnQuitter;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnEnregistrer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberFormat(TChargeRepAmmort);
        NumberFormat(TChargeRepBrut);
        NumberFormat(TEcartCenvAmmort);
        NumberFormat(TEcartCenvBrut);
        NumberFormat(TFraisEmissAmmort);
        NumberFormat(TFraisEmissBrut);
        NumberFormat(TFraisPAmmort);
        NumberFormat(TFraisPBrut);
        // TODO
    }  
    
    public void NumberFormat(TextField txtField){
        txtField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("[0-9]{0}(\\.[0-9]*)?")) {
                    txtField.setText(newValue.replaceAll("[^\\d.]", ""));
                    StringBuilder aus = new StringBuilder(newValue);
                    boolean firstPointFound = false;
                    for (int i = 0; i < aus.length(); i++){
                        if(aus.charAt(i) == '.') {
                            if(!firstPointFound)
                                firstPointFound = true;
                            else
                                aus.deleteCharAt(i);
                        }
                    }
                    newValue = aus.toString();
                }
            }
        });
    }
    
    public String CalculBrut(TextField Tbrut , TextField Tammort)
    {   
        double Vbrut = 0;
        double Vammort = 0 ;
        if (!Tbrut.getText().isEmpty() )
            Vbrut = Double.parseDouble(Tbrut.getText());
        if (!Tammort.getText().isEmpty() )
            Vammort = Double.parseDouble(Tammort.getText());
        return ""+(Vbrut-Vammort);
    }

    @FXML
    private void FraisPBrut(KeyEvent event) {
        TFraisPNetN.setText(CalculBrut(TFraisPBrut, TFraisPAmmort));
    }

    @FXML
    private void FraisPAmmort(KeyEvent event) {
        TFraisPNetN.setText(CalculBrut(TFraisPBrut, TFraisPAmmort));
    }

    @FXML
    private void ChargeRepBrut(KeyEvent event) {
        TChargeRepNetN.setText(CalculBrut(TChargeRepBrut, TChargeRepAmmort));
    }

    @FXML
    private void ChargeRepAmmort(KeyEvent event) {
        TChargeRepNetN.setText(CalculBrut(TChargeRepBrut, TChargeRepAmmort));
    }

    @FXML
    private void FraisEmissBrut(KeyEvent event) {
        TFraisEmissNetN.setText(CalculBrut(TFraisEmissBrut, TFraisEmissAmmort));
    }

    @FXML
    private void FraisEmissAmmort(KeyEvent event) {
        TFraisEmissNetN.setText(CalculBrut(TFraisEmissBrut, TFraisEmissAmmort));
    }

    @FXML
    private void EcartCenvBrut(KeyEvent event) {
        TEcartCenvNetN.setText(CalculBrut(TEcartCenvBrut, TEcartCenvAmmort));
    }

    @FXML
    private void EcartCenvAmmort(KeyEvent event) {
        TEcartCenvNetN.setText(CalculBrut(TEcartCenvBrut, TEcartCenvAmmort));
    }

    @FXML
    private void Quitter(ActionEvent event) {
    }

    @FXML
    private void Annuler(ActionEvent event) {
    }

    @FXML
    private void Enregistrer(ActionEvent event) {
    }
    
}
