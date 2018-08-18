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
public class ClientComptRatController implements Initializable {

    @FXML
    private TextField TClientComptRBrut;
    @FXML
    private TextField TClientComptRAmmort;
    @FXML
    private TextField TClientComptRNetN;
    @FXML
    private TextField TClientEffRBrut;
    @FXML
    private TextField TClientEffRAmmort;
    @FXML
    private TextField TClientEffRNetN;
    @FXML
    private TextField TClientEffRNetN1;
    @FXML
    private TextField TClientDoutBrut;
    @FXML
    private TextField TClientDoutAmmort;
    @FXML
    private TextField TClientDoutNetN;
    @FXML
    private TextField TClientDoutNetN1;
    @FXML
    private TextField TCreanceBrut;
    @FXML
    private TextField TCreanceAmmort;
    @FXML
    private TextField TCreanceNetN;
    @FXML
    private TextField TCreanceNetN1;
    @FXML
    private TextField TCltPdtBrut;
    @FXML
    private TextField TCltPdtAmmort;
    @FXML
    private TextField TCltPdtNetN;
    @FXML
    private TextField TCltPdtNetN1;
    @FXML
    private JFXButton BtnQuitter;
    @FXML
    private JFXButton BtnAnnuler;
    @FXML
    private JFXButton BtnEnregistrer;
    @FXML
    private TextField TClientComptRNetN1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        NumberFormat(TClientComptRAmmort);
        NumberFormat(TClientComptRBrut);
        NumberFormat(TClientDoutBrut);
        NumberFormat(TClientDoutAmmort);
        NumberFormat(TClientEffRAmmort);
        NumberFormat(TClientEffRBrut);
        NumberFormat(TCltPdtAmmort);
        NumberFormat(TCltPdtBrut);
        NumberFormat(TCreanceAmmort);
        NumberFormat(TCreanceBrut);
        
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
    private void ClientComptRBrut(KeyEvent event) {
        TClientComptRNetN.setText(CalculBrut(TClientComptRBrut, TClientComptRAmmort));
    }

    @FXML
    private void ClientComptRAmmort(KeyEvent event) {
        TClientComptRNetN.setText(CalculBrut(TClientComptRBrut, TClientComptRAmmort));
    }

    @FXML
    private void ClientEffRBrut(KeyEvent event) {
        TClientEffRNetN.setText(CalculBrut(TClientEffRBrut, TClientEffRAmmort));
    }

    @FXML
    private void ClientEffRAmmort(KeyEvent event) {
        TClientEffRNetN.setText(CalculBrut(TClientEffRBrut, TClientEffRAmmort));
    }

    @FXML
    private void ClientDoutBrut(KeyEvent event) {
        TClientDoutNetN.setText(CalculBrut(TClientDoutBrut, TClientDoutAmmort));
    }

    @FXML
    private void ClientDoutAmmort(KeyEvent event) {
        TClientDoutNetN.setText(CalculBrut(TClientDoutBrut, TClientDoutAmmort));
    }

    @FXML
    private void CreanceBrut(KeyEvent event) {
        TCreanceNetN.setText(CalculBrut(TCreanceBrut, TCreanceAmmort));
    }

    @FXML
    private void CreanceAmmort(KeyEvent event) {
        TCreanceNetN.setText(CalculBrut(TCreanceBrut, TCreanceAmmort));
    }

    @FXML
    private void CltPdtBrut(KeyEvent event) {
        TCltPdtNetN.setText(CalculBrut(TCltPdtBrut, TCltPdtAmmort));
    }

    @FXML
    private void CltPdtAmmort(KeyEvent event) {
        TCltPdtNetN.setText(CalculBrut(TCltPdtBrut, TCltPdtAmmort));
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
