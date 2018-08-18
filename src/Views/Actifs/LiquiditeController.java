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
public class LiquiditeController implements Initializable {

    @FXML
    private TextField TBanqueBrut;
    @FXML
    private TextField TBanqueAmmort;
    @FXML
    private TextField TBanqueNetN;
    @FXML
    private TextField TBanqueNetN1;
    @FXML
    private TextField TCaisseBrut;
    @FXML
    private TextField TCaisseAmmort;
    @FXML
    private TextField TCaisseNetN;
    @FXML
    private TextField TCaisseNetN1;
    @FXML
    private TextField TAutrePosteBrut;
    @FXML
    private TextField TAutrePosteAmmort;
    @FXML
    private TextField TAutrePosteNetN;
    @FXML
    private TextField TAutrePosteNetN1;
    @FXML
    private TextField TTotalActifBrut;
    @FXML
    private TextField TTotalActifAmmort;
    @FXML
    private TextField TTotalActifNetN;
    @FXML
    private TextField TTotalActifNetN1;
    @FXML
    private TextField TActifAmProBrut;
    @FXML
    private TextField TActifAmProAmmort;
    @FXML
    private TextField TActifAmProNetN;
    @FXML
    private TextField TActifAmProNetN1;
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
        NumberFormat(TActifAmProAmmort);
        NumberFormat(TActifAmProBrut);
        NumberFormat(TAutrePosteAmmort);
        NumberFormat(TAutrePosteBrut);
        NumberFormat(TBanqueAmmort);
        NumberFormat(TBanqueBrut);
        NumberFormat(TCaisseAmmort);
        NumberFormat(TCaisseBrut);        
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
    private void BanqueBrut(KeyEvent event) {
        TBanqueNetN.setText(CalculBrut(TBanqueBrut, TBanqueAmmort));
    }

    @FXML
    private void BanqueAmmort(KeyEvent event) {
        TBanqueNetN.setText(CalculBrut(TBanqueBrut, TBanqueAmmort));
    }

    @FXML
    private void CaisseBrut(KeyEvent event) {
        TCaisseNetN.setText(CalculBrut(TCaisseBrut, TCaisseAmmort));
    }

    @FXML
    private void CaisseAmmort(KeyEvent event) {
        TCaisseNetN.setText(CalculBrut(TCaisseBrut, TCaisseAmmort));
    }

    @FXML
    private void AutrePosteBrut(KeyEvent event) {
        TAutrePosteNetN.setText(CalculBrut(TAutrePosteBrut, TAutrePosteAmmort));
    }

    @FXML
    private void AutrePosteAmmort(KeyEvent event) {
        TAutrePosteNetN.setText(CalculBrut(TAutrePosteBrut, TAutrePosteAmmort));
    }

    @FXML
    private void TotalActifBrut(KeyEvent event) {
        TTotalActifNetN.setText(CalculBrut(TTotalActifBrut, TTotalActifAmmort));
    }

    @FXML
    private void TotalActifAmmort(KeyEvent event) {
        TTotalActifNetN.setText(CalculBrut(TTotalActifBrut, TTotalActifAmmort));
    }

    @FXML
    private void ActifAmProBrut(KeyEvent event) {
        TActifAmProNetN.setText(CalculBrut(TActifAmProBrut, TActifAmProAmmort));
    }

    @FXML
    private void ActifAmProAmmort(KeyEvent event) {
        TActifAmProNetN.setText(CalculBrut(TActifAmProBrut, TActifAmProAmmort));
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
