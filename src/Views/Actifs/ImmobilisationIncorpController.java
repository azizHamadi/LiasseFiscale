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
public class ImmobilisationIncorpController implements Initializable {

    @FXML
    private TextField TInvestRechDevBrut;
    @FXML
    private TextField TInvestRechDevAmmort;
    @FXML
    private TextField TInvestRechDevNetN;
    @FXML
    private TextField TInvestRechDevNetN1;
    @FXML
    private TextField TConcMarqBrut;
    @FXML
    private TextField TConcMarqAmmort;
    @FXML
    private TextField TConcMarqNetN;
    @FXML
    private TextField TConcMarqNetN1;
    @FXML
    private TextField TLogicielBrut;
    @FXML
    private TextField TLogicielAmmort;
    @FXML
    private TextField TLogicielNetN;
    @FXML
    private TextField TLogicielNetN1;
    @FXML
    private TextField TfondComBrut;
    @FXML
    private TextField TfondComAmmort;
    @FXML
    private TextField TfondComNetN;
    @FXML
    private TextField TfondComNetN1;
    @FXML
    private TextField TDroitBailBrut;
    @FXML
    private TextField TDroitBailAmmort;
    @FXML
    private TextField TDroitBailNetN;
    @FXML
    private TextField TDroitBailNetN1;
    @FXML
    private TextField TAutreImmobIncBrut;
    @FXML
    private TextField TAutreImmobIncAmmort;
    @FXML
    private TextField TAutreImmobIncNetN;
    @FXML
    private TextField TAutreImmobIncNetN1;
    @FXML
    private TextField TImmobIncEnCoursBrut;
    @FXML
    private TextField TImmobIncEnCoursAmmort;
    @FXML
    private TextField TImmobIncEnCoursNetN;
    @FXML
    private TextField TImmobIncEnCoursNetN1;
    @FXML
    private TextField TAvAcVersesBrut;
    @FXML
    private TextField TAvAcVersesAmmort;
    @FXML
    private TextField TAvAcVersesNetN;
    @FXML
    private TextField TAvAcVersesNetN1;
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
        NumberFormat(TAutreImmobIncBrut);
        NumberFormat(TAutreImmobIncAmmort);
        NumberFormat(TAvAcVersesAmmort);
        NumberFormat(TAvAcVersesBrut);
       
        NumberFormat(TConcMarqAmmort);
        NumberFormat(TConcMarqBrut);
       
        NumberFormat(TDroitBailAmmort);
        NumberFormat(TDroitBailBrut);
      
        NumberFormat(TImmobIncEnCoursAmmort);
        NumberFormat(TImmobIncEnCoursBrut);
       
        NumberFormat(TInvestRechDevAmmort);
        NumberFormat(TInvestRechDevBrut);
      
        NumberFormat(TLogicielAmmort);
        NumberFormat(TLogicielBrut);
       
        NumberFormat(TfondComAmmort);
        NumberFormat(TfondComBrut);
        
        // TODO
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
    private void InvestissementBrut(KeyEvent event) {
        TInvestRechDevNetN.setText(CalculBrut(TInvestRechDevBrut, TInvestRechDevAmmort));
    }

    @FXML
    private void InvestissementAmmort(KeyEvent event) {
        TInvestRechDevNetN.setText(CalculBrut(TInvestRechDevBrut, TInvestRechDevAmmort));
    }

    @FXML
    private void ConcMarqBrut(KeyEvent event) {
        TConcMarqNetN.setText(CalculBrut(TConcMarqBrut, TConcMarqAmmort));
    }

    @FXML
    private void ConcMarqAmmort(KeyEvent event) {
        TConcMarqNetN.setText(CalculBrut(TConcMarqBrut, TConcMarqAmmort));
    }

    @FXML
    private void LogicielBrut(KeyEvent event) {
        TLogicielNetN.setText(CalculBrut(TLogicielBrut, TLogicielAmmort));
    }

    @FXML
    private void LogicielAmmort(KeyEvent event) {
        TLogicielNetN.setText(CalculBrut(TLogicielBrut, TLogicielAmmort));
    }

    @FXML
    private void FondComBrut(KeyEvent event) {
        TfondComNetN.setText(CalculBrut(TfondComBrut, TfondComAmmort));
    }

    @FXML
    private void FondComAmmort(KeyEvent event) {
        TfondComNetN.setText(CalculBrut(TfondComBrut, TfondComAmmort));
    }

    @FXML
    private void DroitBrut(KeyEvent event) {
        TDroitBailNetN.setText(CalculBrut(TDroitBailBrut, TDroitBailAmmort));
    }

    @FXML
    private void DroitAmmort(KeyEvent event) {
        TDroitBailNetN.setText(CalculBrut(TDroitBailBrut, TDroitBailAmmort));
    }

    @FXML
    private void AutreImmobIncBrut(KeyEvent event) {
        TAutreImmobIncNetN.setText(CalculBrut(TAutreImmobIncBrut, TAutreImmobIncAmmort));
    }

    @FXML
    private void AutreImmobIncAmmort(KeyEvent event) {
        TAutreImmobIncNetN.setText(CalculBrut(TAutreImmobIncBrut, TAutreImmobIncAmmort));
    }

    @FXML
    private void ImmobIncorpEnCoursBrut(KeyEvent event) {
        TImmobIncEnCoursNetN.setText(CalculBrut(TImmobIncEnCoursBrut, TImmobIncEnCoursAmmort));
    }

    @FXML
    private void ImmobIncorpEnCoursAmmort(KeyEvent event) {
        TImmobIncEnCoursNetN.setText(CalculBrut(TImmobIncEnCoursBrut, TImmobIncEnCoursAmmort));
    }

    @FXML
    private void AvVersesBrut(KeyEvent event) {
        TAvAcVersesNetN.setText(CalculBrut(TAvAcVersesBrut, TAvAcVersesAmmort));
    }

    @FXML
    private void AvVersesAmmort(KeyEvent event) {
        TAvAcVersesNetN.setText(CalculBrut(TAvAcVersesBrut, TAvAcVersesAmmort));
    }
    
}
