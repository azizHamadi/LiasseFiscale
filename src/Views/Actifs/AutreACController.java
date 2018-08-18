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
public class AutreACController implements Initializable {

    @FXML
    private TextField TFournisseurDebBrut;
    @FXML
    private TextField TFournisseurDebAmmort;
    @FXML
    private TextField TPersonnelBrut;
    @FXML
    private TextField TPersonnelAmmort;
    @FXML
    private TextField TPersonnelNetN;
    @FXML
    private TextField TPersonnelNetN1;
    @FXML
    private TextField TEtatBrut;
    @FXML
    private TextField TEtatAmmort;
    @FXML
    private TextField TEtatNetN;
    @FXML
    private TextField TEtatNetN1;
    @FXML
    private TextField TSocieteBrut;
    @FXML
    private TextField TSocieteAmmort;
    @FXML
    private TextField TSocieteNetN;
    @FXML
    private TextField TSocieteNetN1;
    @FXML
    private TextField TDebiteurBrut;
    @FXML
    private TextField TDebiteurAmmort;
    @FXML
    private TextField TDebiteurNetN;
    @FXML
    private TextField TCompteTransitoireBrut;
    @FXML
    private TextField TCompteTransitoireAmmort;
    @FXML
    private TextField TCompteTransitoireNetN;
    @FXML
    private TextField TCompteTransitoireNetN1;
    @FXML
    private TextField TCompteRegBrut;
    @FXML
    private TextField TCompteRegAmmort;
    @FXML
    private TextField TCompteRegNetN;
    @FXML
    private TextField TCompteRegNetN1;
    @FXML
    private TextField TAutreBrut;
    @FXML
    private TextField TAutreAmmort;
    @FXML
    private TextField TAutreNetN;
    @FXML
    private TextField TAutreNetN1;
    @FXML
    private JFXButton BtnQuitter;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnEnregistrer;
    @FXML
    private TextField TDebiteurNetN1;
    @FXML
    private TextField TFournisseurDebNetN;
    @FXML
    private TextField TFournisseurDebNetN1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NumberFormat(TAutreAmmort);
        NumberFormat(TAutreBrut);
        NumberFormat(TCompteRegAmmort);
        NumberFormat(TCompteRegBrut);
        NumberFormat(TCompteTransitoireAmmort);
        NumberFormat(TCompteTransitoireBrut);
        NumberFormat(TDebiteurAmmort);
        NumberFormat(TDebiteurBrut);
        NumberFormat(TEtatAmmort);
        NumberFormat(TEtatBrut);
        NumberFormat(TFournisseurDebAmmort);
        NumberFormat(TFournisseurDebBrut);
        NumberFormat(TPersonnelAmmort);
        NumberFormat(TPersonnelBrut);
        NumberFormat(TSocieteAmmort);
        NumberFormat(TSocieteBrut);
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
    private void FournisseurDebBrut(KeyEvent event) {
        TFournisseurDebNetN.setText(CalculBrut(TFournisseurDebBrut, TFournisseurDebAmmort));
    }

    @FXML
    private void FournisseurDebAmmort(KeyEvent event) {
        TFournisseurDebNetN.setText(CalculBrut(TFournisseurDebBrut, TFournisseurDebAmmort));
    }

    @FXML
    private void PersonnelBrut(KeyEvent event) {
        TPersonnelNetN.setText(CalculBrut(TPersonnelBrut, TPersonnelAmmort));
    }

    @FXML
    private void PersonnelAmmort(KeyEvent event) {
        TPersonnelNetN.setText(CalculBrut(TPersonnelBrut, TPersonnelAmmort));
    }

    @FXML
    private void EtatBrut(KeyEvent event) {
        TEtatNetN.setText(CalculBrut(TEtatBrut, TEtatAmmort));
    }

    @FXML
    private void EtatAmmort(KeyEvent event) {
        TEtatNetN.setText(CalculBrut(TEtatBrut, TEtatAmmort));
    }

    @FXML
    private void SocieteBrut(KeyEvent event) {
        TSocieteNetN.setText(CalculBrut(TSocieteBrut, TSocieteAmmort));
    }

    @FXML
    private void SocieteAmmort(KeyEvent event) {
        TSocieteNetN.setText(CalculBrut(TSocieteBrut, TSocieteAmmort));
    }

    @FXML
    private void DebiteurBrut(KeyEvent event) {
        TDebiteurNetN.setText(CalculBrut(TDebiteurBrut, TDebiteurAmmort));
    }

    @FXML
    private void DebiteurAmmort(KeyEvent event) {
        TDebiteurNetN.setText(CalculBrut(TDebiteurBrut, TDebiteurAmmort));
    }

    @FXML
    private void CompteTransitoireBrut(KeyEvent event) {
        TCompteTransitoireNetN.setText(CalculBrut(TCompteTransitoireBrut, TCompteTransitoireAmmort));
    }

    @FXML
    private void CompteTransitoireAmmort(KeyEvent event) {
        TCompteTransitoireNetN.setText(CalculBrut(TCompteTransitoireBrut, TCompteTransitoireAmmort));
    }

    @FXML
    private void CompteRegBrut(KeyEvent event) {
        TCompteRegNetN.setText(CalculBrut(TCompteRegBrut, TCompteRegAmmort));
    }

    @FXML
    private void CompteRegAmmort(KeyEvent event) {
        TCompteRegNetN.setText(CalculBrut(TCompteRegBrut, TCompteRegAmmort));
    }

    @FXML
    private void AutreBrut(KeyEvent event) {
        TAutreNetN.setText(CalculBrut(TAutreBrut, TAutreAmmort));
    }

    @FXML
    private void AutreAmmort(KeyEvent event) {
        TAutreNetN.setText(CalculBrut(TAutreBrut, TAutreAmmort));
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
