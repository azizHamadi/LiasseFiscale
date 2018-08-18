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
public class StockController implements Initializable {

    @FXML
    private TextField TStockMatPBrut;
    @FXML
    private TextField TStockMatPAmmort;
    @FXML
    private TextField TStockMatPNetN;
    @FXML
    private TextField TStockMatPNetN1;
    @FXML
    private TextField TStockAutreAproBrut;
    @FXML
    private TextField TStockAutreAproAmmort;
    @FXML
    private TextField TStockAutreAproNetN;
    @FXML
    private TextField TStockAutreAproNetN1;
    @FXML
    private TextField TStockEnCoursBienBrut;
    @FXML
    private TextField TStockEnCoursAmmort;
    @FXML
    private TextField TStockEnCoursBienNetN;
    @FXML
    private TextField TStockEnCoursBienNetN1;
    @FXML
    private TextField TStockEnCourServiceBrut;
    @FXML
    private TextField TStockEnCourServiceAmmort;
    @FXML
    private TextField TStockEnCourServiceNetN;
    @FXML
    private TextField TStockEnCourServiceNetN1;
    @FXML
    private TextField TStockProduitBrut;
    @FXML
    private TextField TStockProduitAmmort;
    @FXML
    private TextField TStockProduitNetN;
    @FXML
    private TextField TStockProduitNetN1;
    @FXML
    private TextField TStockMarchandiseBrut;
    @FXML
    private TextField TStockMarchandiseAmmort;
    @FXML
    private TextField TStockMarchandiseNetN;
    @FXML
    private TextField TStockMarchandiseNetN1;
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
        NumberFormat(TStockAutreAproAmmort);
        NumberFormat(TStockAutreAproBrut);
        NumberFormat(TStockEnCourServiceAmmort);
        NumberFormat(TStockEnCourServiceBrut);
        NumberFormat(TStockEnCoursAmmort);
        NumberFormat(TStockEnCoursBienBrut);
        NumberFormat(TStockMarchandiseAmmort);
        NumberFormat(TStockMarchandiseBrut);
        NumberFormat(TStockMatPAmmort);
        NumberFormat(TStockMatPBrut);
        NumberFormat(TStockProduitAmmort);
        NumberFormat(TStockProduitBrut);
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
    private void StockMatPBrut(KeyEvent event) {
        TStockMatPNetN.setText(CalculBrut(TStockMatPBrut, TStockMatPAmmort));
    }

    @FXML
    private void StockMatPAmmort(KeyEvent event) {
        TStockMatPNetN.setText(CalculBrut(TStockMatPBrut, TStockMatPAmmort));
    }

    @FXML
    private void StockAutreAproBrut(KeyEvent event) {
        TStockAutreAproNetN.setText(CalculBrut(TStockAutreAproBrut, TStockAutreAproAmmort));
    }

    @FXML
    private void StockAutreAproAmmort(KeyEvent event) {
        TStockAutreAproNetN.setText(CalculBrut(TStockAutreAproBrut, TStockAutreAproAmmort));
    }

    @FXML
    private void StockEnCoursBienBrut(KeyEvent event) {
        TStockEnCoursBienNetN.setText(CalculBrut(TStockEnCoursBienBrut, TStockAutreAproAmmort));
    }

    @FXML
    private void StockEnCoursBienAmmort(KeyEvent event) {
        TStockEnCoursBienNetN.setText(CalculBrut(TStockEnCoursBienBrut, TStockAutreAproAmmort));
    }

    @FXML
    private void StockEnCourServiceBrut(KeyEvent event) {
        TStockEnCourServiceNetN.setText(CalculBrut(TStockEnCourServiceBrut, TStockEnCourServiceAmmort));
    }

    @FXML
    private void StockEnCourServiceAmmort(KeyEvent event) {
        TStockEnCourServiceNetN.setText(CalculBrut(TStockEnCourServiceBrut, TStockEnCourServiceAmmort));
    }

    @FXML
    private void StockProduitBrut(KeyEvent event) {
        TStockProduitNetN.setText(CalculBrut(TStockProduitBrut, TStockProduitAmmort));
    }

    @FXML
    private void StockProduitAmmort(KeyEvent event) {
        TStockProduitNetN.setText(CalculBrut(TStockProduitBrut, TStockProduitAmmort));
    }

    @FXML
    private void StockMarchandiseBrut(KeyEvent event) {
        TStockMarchandiseNetN.setText(CalculBrut(TStockMarchandiseBrut, TStockMarchandiseAmmort));
    }

    @FXML
    private void StockMarchandiseAmmort(KeyEvent event) {
        TStockMarchandiseNetN.setText(CalculBrut(TStockMarchandiseBrut, TStockMarchandiseAmmort));
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
