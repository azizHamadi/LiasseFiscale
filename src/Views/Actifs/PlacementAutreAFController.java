/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Actifs;

import Entity.Comptebilan;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.List;
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
public class PlacementAutreAFController implements Initializable {

    @FXML
    private TextField TPretBrut;
    @FXML
    private TextField TPretAmmort;
    @FXML
    private TextField TPretNetN;
    @FXML
    private TextField TPretNetN1;
    @FXML
    private TextField TPlacementBrut;
    @FXML
    private TextField TPlacementAmmort;
    @FXML
    private TextField TPlacementNetN;
    @FXML
    private TextField TPlacementNetN1;
    @FXML
    private TextField TRegiesAvBrut;
    @FXML
    private TextField TRegiesAvAmmort;
    @FXML
    private TextField TRegiesAvNetN;
    @FXML
    private TextField TRegiesAvNetN1;
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
    
    public List<Comptebilan> comptebilan ;

    public List<Comptebilan> getComptebilan() {
        return comptebilan;
    }

    public void setComptebilan(List<Comptebilan> comptebilan) {
        this.comptebilan = comptebilan;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        NumberFormat(TAutreAmmort);
        NumberFormat(TAutreBrut);
        NumberFormat(TPlacementAmmort);
        NumberFormat(TPlacementBrut);
        NumberFormat(TPretAmmort);
        NumberFormat(TPretBrut);
        NumberFormat(TRegiesAvAmmort);
        NumberFormat(TRegiesAvBrut);
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
    private void PretBrut(KeyEvent event) {
        TPretNetN.setText(CalculBrut(TPretBrut, TPretAmmort));
    }

    @FXML
    private void PretAmmort(KeyEvent event) {
        TPretNetN.setText(CalculBrut(TPretBrut, TPretAmmort));
    }

    @FXML
    private void PlacementBrut(KeyEvent event) {
        TPlacementNetN.setText(CalculBrut(TPlacementBrut, TPlacementAmmort));
    }

    @FXML
    private void PlacementAmmort(KeyEvent event) {
        TPlacementNetN.setText(CalculBrut(TPlacementBrut, TPlacementAmmort));
    }

    @FXML
    private void RegiesAvBrut(KeyEvent event) {
        TRegiesAvNetN.setText(CalculBrut(TRegiesAvBrut, TRegiesAvAmmort));
    }

    @FXML
    private void RegiesAvAmmort(KeyEvent event) {
        TRegiesAvNetN.setText(CalculBrut(TRegiesAvBrut, TRegiesAvAmmort));
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
