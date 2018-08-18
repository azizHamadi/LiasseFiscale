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
public class ImmobilisationCorpController implements Initializable {

    @FXML
    private TextField TTerrainBrut;
    @FXML
    private TextField TTerrainAmmort;
    @FXML
    private TextField TTerrainNetN;
    @FXML
    private TextField TTerrainNetN1;
    @FXML
    private TextField TConstructionBrut;
    @FXML
    private TextField TConstructionAmmort;
    @FXML
    private TextField TConstructionNetN;
    @FXML
    private TextField TConstructionNetN1;
    @FXML
    private TextField TInstTechBrut;
    @FXML
    private TextField TInstTechAmmort;
    @FXML
    private TextField TInstTechNetN;
    @FXML
    private TextField TInstTechNetN1;
    @FXML
    private TextField TmaterielTranBrut;
    @FXML
    private TextField TmaterielTranAmmort;
    @FXML
    private TextField TmaterielTranNetN;
    @FXML
    private TextField TmaterielTranNetN1;
    @FXML
    private TextField TAutreImmobCBrut;
    @FXML
    private TextField TAutreImmobCAmmort;
    @FXML
    private TextField TAutreImmobCNetN;
    @FXML
    private TextField TAutreImmobCNetN1;
    @FXML
    private TextField TImmobCorpBrut;
    @FXML
    private TextField TImmobCorpAmmort;
    @FXML
    private TextField TImmobCorpNetN;
    @FXML
    private TextField TImmobCorpNetN1;
    @FXML
    private TextField TAvVersesBrut;
    @FXML
    private TextField TAvVersesAmmort;
    @FXML
    private TextField TAvVersesNetN;
    @FXML
    private TextField TAvVersesNetN1;
    @FXML
    private TextField TImmobStatJBrut;
    @FXML
    private TextField TImmobStatJAmmort;
    @FXML
    private TextField TImmobStatJNetN;
    @FXML
    private TextField TImmobStatJNetN1;
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
        NumberFormat(TAutreImmobCBrut);
        NumberFormat(TAutreImmobCBrut);
        NumberFormat(TAvVersesAmmort);
        NumberFormat(TAvVersesBrut);
        NumberFormat(TConstructionAmmort);
        NumberFormat(TConstructionBrut);
        NumberFormat(TImmobCorpAmmort);
        NumberFormat(TImmobCorpBrut);
        NumberFormat(TImmobStatJAmmort);
        NumberFormat(TImmobStatJBrut);
        NumberFormat(TTerrainAmmort);
        NumberFormat(TTerrainBrut);
        NumberFormat(TInstTechAmmort);
        NumberFormat(TInstTechBrut);
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
    private void TerrainBrut(KeyEvent event) {
        TTerrainNetN.setText(CalculBrut(TTerrainBrut, TTerrainAmmort));
    }

    @FXML
    private void TerrainAmmort(KeyEvent event) {
        TTerrainNetN.setText(CalculBrut(TTerrainBrut, TTerrainAmmort));
    }

    @FXML
    private void ConstructionBrut(KeyEvent event) {
        TConstructionNetN.setText(CalculBrut(TConstructionBrut, TConstructionAmmort));
    }

    @FXML
    private void ConstructionAmmort(KeyEvent event) {
        TConstructionNetN.setText(CalculBrut(TConstructionBrut, TConstructionAmmort));
    }

    @FXML
    private void InstTechBrut(KeyEvent event) {
        TInstTechNetN.setText(CalculBrut(TInstTechBrut, TInstTechAmmort));
    }

    @FXML
    private void InstTechAmmort(KeyEvent event) {
        TInstTechNetN.setText(CalculBrut(TInstTechBrut, TInstTechAmmort));
    }

    @FXML
    private void materielTranBrut(KeyEvent event) {
        TmaterielTranNetN.setText(CalculBrut(TmaterielTranBrut, TmaterielTranAmmort));
    }

    @FXML
    private void materielTranAmmort(KeyEvent event) {
        TmaterielTranNetN.setText(CalculBrut(TmaterielTranBrut, TmaterielTranAmmort));
    }

    @FXML
    private void AutreImmobCBrut(KeyEvent event) {
        TAutreImmobCNetN.setText(CalculBrut(TAutreImmobCBrut, TAutreImmobCAmmort));
    }

    @FXML
    private void AutreImmobCAmmort(KeyEvent event) {
        TAutreImmobCNetN.setText(CalculBrut(TAutreImmobCBrut, TAutreImmobCAmmort));
    }

    @FXML
    private void ImmobCorpBrut(KeyEvent event) {
        TImmobCorpNetN.setText(CalculBrut(TImmobCorpBrut, TImmobCorpAmmort));
    }

    @FXML
    private void ImmobCorpAmmort(KeyEvent event) {
        TImmobCorpNetN.setText(CalculBrut(TImmobCorpBrut, TImmobCorpAmmort));
    }

    @FXML
    private void AvVersesBrut(KeyEvent event) {
        TAvVersesNetN.setText(CalculBrut(TAvVersesBrut, TAvVersesAmmort));
    }

    @FXML
    private void AvVersesAmmort(KeyEvent event) {
        TAvVersesNetN.setText(CalculBrut(TAvVersesBrut, TAvVersesAmmort));
    }
    
    @FXML
    private void ImmobStatJBrut(KeyEvent event) {
        TImmobStatJNetN.setText(CalculBrut(TImmobStatJBrut, TImmobStatJAmmort));
    }

    @FXML
    private void ImmobStatJAmmort(KeyEvent event) {
        TImmobStatJNetN.setText(CalculBrut(TImmobStatJBrut, TImmobStatJAmmort));
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
