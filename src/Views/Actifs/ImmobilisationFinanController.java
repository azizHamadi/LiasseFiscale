/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Actifs;

import Entity.Comptebilan;
import Services.CompteBilanService;
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

    public TextField TImmobFBrut ;
    public TextField TImmobFAmmort ;
    public TextField TImmobFNet ;
    double immobAmmort = 0 ;
    double immobBrut = 0 ;
    public List<Comptebilan> listImmobFin;

    public TextField getTImmobFBrut() {
        return TImmobFBrut;
    }

    public void setTImmobFBrut(TextField TImmobFBrut) {
        this.TImmobFBrut = TImmobFBrut;
    }

    public TextField getTImmobFAmmort() {
        return TImmobFAmmort;
    }

    public void setTImmobFAmmort(TextField TImmobFAmmort) {
        this.TImmobFAmmort = TImmobFAmmort;
    }

    public TextField getTImmobFNet() {
        return TImmobFNet;
    }

    public void setTImmobFNet(TextField TImmobFNet) {
        this.TImmobFNet = TImmobFNet;
    }

    public List<Comptebilan> getListImmobFin() {
        return listImmobFin;
    }

    public void setListImmobFin(List<Comptebilan> listImmobFin) {
        this.listImmobFin = listImmobFin;
    }
    
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
        newList();
        CompteBilanService compteBilanService = new CompteBilanService();
        compteBilanService.modifiercompteBilan(listImmobFin);
        for(Comptebilan c : listImmobFin)
        {
            immobAmmort+=c.getAmmort();
            immobBrut+=c.getBrut();
        }
        TImmobFBrut.setText(String.valueOf(immobBrut));
        TImmobFAmmort.setText(String.valueOf(immobAmmort));
        TImmobFNet.setText(String.valueOf(immobBrut-immobAmmort));
    }
    
    public void newList()
    {
        for(Comptebilan c : listImmobFin)
        {
            if(c.getIdcompte().getNom().equals("Actions"))
            {
                c.setBrut(Double.parseDouble(TActionBrut.getText()));
                c.setAmmort(Double.parseDouble(TActionAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Autres creances rattach. a des participat"))
            {
                c.setBrut(Double.parseDouble(TAutreCreancePBrut.getText()));
                c.setAmmort(Double.parseDouble(TAutreCreancePAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Creances rattach. a des stes en participat"))
            {
                c.setBrut(Double.parseDouble(TCreanceRattBrut.getText()));
                c.setAmmort(Double.parseDouble(TCreanceRattAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Vers.a eff./titre de participation"))
            {
                c.setBrut(Double.parseDouble(TVersEffPBrut.getText()));
                c.setAmmort(Double.parseDouble(TVersEffPAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Titres immobilises (droit de propriete)"))
            {
                c.setBrut(Double.parseDouble(TTitreImmobPBrut.getText()));
                c.setAmmort(Double.parseDouble(TTitreImmobPAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Titres immobilises (droit de creance)"))
            {
                c.setBrut(Double.parseDouble(TTitreImmobCBrut.getText()));
                c.setAmmort(Double.parseDouble(TTitreImmobCAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Depots et cautionnements verses"))
            {
                c.setBrut(Double.parseDouble(TDepotBrut.getText()));
                c.setAmmort(Double.parseDouble(TDepotAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Autres creances immobilisees"))
            {
                c.setBrut(Double.parseDouble(TAutreCreanceImmobBrut.getText()));
                c.setAmmort(Double.parseDouble(TAutreCreanceImmobAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Vers.a eff./Titres immobilises non liberes"))
            {
                c.setBrut(Double.parseDouble(TVersEffImmobBrut.getText()));
                c.setAmmort(Double.parseDouble(TVersEffImmobAmmort.getText()));
            }
        }
    }
    
    public void initTextBox()
    {
        //afficher les valeur des zones de text à partir du bd
        for(Comptebilan c : listImmobFin)
        {
            if(c.getIdcompte().getNom().equals("Actions"))
            {
                TActionBrut.setText(String.valueOf(c.getBrut()));
                TActionAmmort.setText(String.valueOf(c.getAmmort()));
                TActionNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Autres creances rattach. a des participat"))
            {
                TAutreCreancePBrut.setText(String.valueOf(c.getBrut()));
                TAutreCreancePAmmort.setText(String.valueOf(c.getAmmort()));
                TAutreCreancePNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Creances rattach. a des stes en participat"))
            {
                TCreanceRattBrut.setText(String.valueOf(c.getBrut()));
                TCreanceRattAmmort.setText(String.valueOf(c.getAmmort()));
                TCreanceRattNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Vers.a eff./titre de participation"))
            {
                TVersEffPBrut.setText(String.valueOf(c.getBrut()));
                TVersEffPAmmort.setText(String.valueOf(c.getAmmort()));
                TVersEffPNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Titres immobilises (droit de propriete)"))
            {
                TTitreImmobPBrut.setText(String.valueOf(c.getBrut()));
                TTitreImmobPAmmort.setText(String.valueOf(c.getAmmort()));
                TTitreImmobPNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Titres immobilises (droit de creance)"))
            {
                TTitreImmobCBrut.setText(String.valueOf(c.getBrut()));
                TTitreImmobCAmmort.setText(String.valueOf(c.getAmmort()));
                TTitreImmobCNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Depots et cautionnements verses"))
            {
                TDepotBrut.setText(String.valueOf(c.getBrut()));
                TDepotAmmort.setText(String.valueOf(c.getAmmort()));
                TDepotNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Autres creances immobilisees"))
            {
                TAutreCreanceImmobBrut.setText(String.valueOf(c.getBrut()));
                TAutreCreanceImmobAmmort.setText(String.valueOf(c.getAmmort()));
                TAutreCreanceImmobNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Vers.a eff./Titres immobilises non liberes"))
            {
                TVersEffImmobBrut.setText(String.valueOf(c.getBrut()));
                TVersEffImmobAmmort.setText(String.valueOf(c.getAmmort()));
                TVersEffImmobNetN1.setText(String.valueOf(c.getTotal()));
            }
        }
        TActionNetN.setText(CalculBrut(TActionBrut, TActionAmmort));
        TAutreCreancePNetN.setText(CalculBrut(TAutreCreancePBrut, TAutreCreancePAmmort));
        TCreanceRattNetN.setText(CalculBrut(TCreanceRattBrut, TCreanceRattAmmort));
        TVersEffPNetN.setText(CalculBrut(TVersEffPBrut, TVersEffPAmmort));
        TTitreImmobPNetN.setText(CalculBrut(TTitreImmobPBrut, TTitreImmobPAmmort));
        TTitreImmobCNetN.setText(CalculBrut(TTitreImmobCBrut, TTitreImmobCAmmort));
        TDepotNetN.setText(CalculBrut(TDepotBrut, TDepotAmmort));
        TAutreCreanceImmobNetN.setText(CalculBrut(TAutreCreanceImmobBrut, TAutreCreanceImmobAmmort));
        TVersEffImmobNetN.setText(CalculBrut(TVersEffImmobBrut, TVersEffImmobAmmort));

    }
    
}
