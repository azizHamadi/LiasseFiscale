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
public class ImmobilisationFinanController implements Initializable {

    @FXML
    private TextField TActionBrut;
    @FXML
    private TextField TActionAmmort;
    @FXML
    private TextField TActionNetN;
    @FXML
    private TextField TActionNetN1;
    @FXML
    private TextField TAutreCreancePBrut;
    @FXML
    private TextField TAutreCreancePNetN;
    @FXML
    private TextField TAutreCreancePNetN1;
    @FXML
    private TextField TCreanceRattBrut;
    @FXML
    private TextField TCreanceRattAmmort;
    @FXML
    private TextField TCreanceRattNetN;
    @FXML
    private TextField TCreanceRattNetN1;
    @FXML
    private TextField TVersEffPBrut;
    @FXML
    private TextField TVersEffPAmmort;
    @FXML
    private TextField TVersEffPNetN;
    @FXML
    private TextField TVersEffPNetN1;
    @FXML
    private TextField TTitreImmobPBrut;
    @FXML
    private TextField TTitreImmobPAmmort;
    @FXML
    private TextField TTitreImmobPNetN;
    @FXML
    private TextField TTitreImmobPNetN1;
    @FXML
    private TextField TTitreImmobCBrut;
    @FXML
    private TextField TTitreImmobCAmmort;
    @FXML
    private TextField TTitreImmobCNetN;
    @FXML
    private TextField TTitreImmobCNetN1;
    @FXML
    private TextField TDepotBrut;
    @FXML
    private TextField TDepotAmmort;
    @FXML
    private TextField TDepotNetN;
    @FXML
    private TextField TDepotNetN1;
    @FXML
    private TextField TAutreCreanceImmobBrut;
    @FXML
    private TextField TAutreCreanceImmobAmmort;
    @FXML
    private TextField TAutreCreanceImmobNetN;
    @FXML
    private TextField TAutreCreanceImmobNetN1;
    @FXML
    private TextField TVersEffImmobBrut;
    @FXML
    private TextField TVersEffImmobAmmort;
    @FXML
    private TextField TVersEffImmobNetN;
    @FXML
    private TextField TVersEffImmobNetN1;
    @FXML
    private JFXButton BtnQuitter;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnEnregistrer;
    @FXML
    private TextField TAutreCreancePAmmort;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NumberFormat(TActionAmmort);
        NumberFormat(TActionBrut);
        NumberFormat(TAutreCreanceImmobAmmort);
        NumberFormat(TAutreCreanceImmobBrut);
        NumberFormat(TAutreCreancePBrut);
        NumberFormat(TAutreCreancePAmmort);
        NumberFormat(TCreanceRattAmmort);
        NumberFormat(TCreanceRattBrut);
        NumberFormat(TDepotAmmort);
        NumberFormat(TDepotBrut);
        NumberFormat(TTitreImmobCAmmort);
        NumberFormat(TTitreImmobCBrut);
        NumberFormat(TTitreImmobPAmmort);
        NumberFormat(TTitreImmobPBrut);
        NumberFormat(TVersEffImmobAmmort);
        NumberFormat(TVersEffImmobBrut);
        NumberFormat(TVersEffPAmmort);
        NumberFormat(TVersEffPBrut);
        
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
    private void ActionBrut(KeyEvent event) {
        TActionNetN.setText(CalculBrut(TActionBrut, TActionAmmort));
    }

    @FXML
    private void ActionAmmort(KeyEvent event) {
        TActionNetN.setText(CalculBrut(TActionBrut, TActionAmmort));
    }

    @FXML
    private void AutreCreancePBrut(KeyEvent event) {
        TAutreCreancePNetN.setText(CalculBrut(TAutreCreancePBrut, TAutreCreancePAmmort));
    }

    @FXML
    private void AutreCreancePAmmort(KeyEvent event) {
        TAutreCreancePNetN.setText(CalculBrut(TAutreCreancePBrut, TAutreCreancePAmmort));
    }

    @FXML
    private void CreanceRattBrut(KeyEvent event) {
        TCreanceRattNetN.setText(CalculBrut(TCreanceRattBrut, TCreanceRattAmmort));
    }

    @FXML
    private void CreanceRattAmmort(KeyEvent event) {
        TCreanceRattNetN.setText(CalculBrut(TCreanceRattBrut, TCreanceRattAmmort));
    }

    @FXML
    private void VersEffPBrut(KeyEvent event) {
        TVersEffPNetN.setText(CalculBrut(TVersEffPBrut, TVersEffPAmmort));
    }

    @FXML
    private void VersEffPAmmort(KeyEvent event) {
        TVersEffPNetN.setText(CalculBrut(TVersEffPBrut, TVersEffPAmmort));
    }

    @FXML
    private void TitreImmobPBrut(KeyEvent event) {
        TTitreImmobPNetN.setText(CalculBrut(TTitreImmobPBrut, TTitreImmobPAmmort));
    }

    @FXML
    private void TitreImmobPAmmort(KeyEvent event) {
        TTitreImmobPNetN.setText(CalculBrut(TTitreImmobPBrut, TTitreImmobPAmmort));
    }

    @FXML
    private void TitreImmobCBrut(KeyEvent event) {
        TTitreImmobCNetN.setText(CalculBrut(TTitreImmobCBrut, TTitreImmobCAmmort));
    }

    @FXML
    private void TitreImmobCAmmort(KeyEvent event) {
        TTitreImmobCNetN.setText(CalculBrut(TTitreImmobCBrut, TTitreImmobCAmmort));
    }

    @FXML
    private void DepotBrut(KeyEvent event) {
        TDepotNetN.setText(CalculBrut(TDepotBrut, TDepotAmmort));
    }

    @FXML
    private void DepotAmmort(KeyEvent event) {
        TDepotNetN.setText(CalculBrut(TDepotBrut, TDepotAmmort));
    }

    @FXML
    private void AutreCreanceImmobBrut(KeyEvent event) {
        TAutreCreanceImmobNetN.setText(CalculBrut(TAutreCreanceImmobBrut, TAutreCreanceImmobAmmort));
    }

    @FXML
    private void AutreCreanceImmobAmmort(KeyEvent event) {
        TAutreCreanceImmobNetN.setText(CalculBrut(TAutreCreanceImmobBrut, TAutreCreanceImmobAmmort));
    }

    @FXML
    private void VersEffImmobBrut(KeyEvent event) {
        TVersEffImmobNetN.setText(CalculBrut(TVersEffImmobBrut, TVersEffImmobAmmort));
    }

    @FXML
    private void VersEffImmobAmmort(KeyEvent event) {
        TVersEffImmobNetN.setText(CalculBrut(TVersEffImmobBrut, TVersEffImmobAmmort));
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
