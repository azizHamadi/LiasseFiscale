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
    
    public TextField TImmobIncBrut ;
    public TextField TImmobIncAmmort ;
    public TextField TImmobIncNet ;
    double immobAmmort = 0 ;
    double immobBrut = 0 ;
    
    public List<Comptebilan> listImmobInc;

    public TextField getTImmobIncBrut() {
        return TImmobIncBrut;
    }

    public void setTImmobIncBrut(TextField TImmobIncBrut) {
        this.TImmobIncBrut = TImmobIncBrut;
    }

    public TextField getTImmobIncAmmort() {
        return TImmobIncAmmort;
    }

    public void setTImmobIncAmmort(TextField TImmobIncAmmort) {
        this.TImmobIncAmmort = TImmobIncAmmort;
    }

    public TextField getTImmobIncNet() {
        return TImmobIncNet;
    }

    public void setTImmobIncNet(TextField TImmobIncNet) {
        this.TImmobIncNet = TImmobIncNet;
    }
    
    public List<Comptebilan> getListImmobInc() {
        return listImmobInc;
    }

    public void setListImmobInc(List<Comptebilan> listImmobInc) {
        this.listImmobInc = listImmobInc;
    }


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //initialisation des zones de text
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
        newList();
        CompteBilanService compteBilanService = new CompteBilanService();
        compteBilanService.modifiercompteBilan(listImmobInc);
        for(Comptebilan c : listImmobInc)
        {
            immobAmmort+=c.getAmmort();
            immobBrut+=c.getBrut();
        }
        TImmobIncBrut.setText(String.valueOf(immobBrut));
        TImmobIncAmmort.setText(String.valueOf(immobAmmort));
        TImmobIncNet.setText(String.valueOf(immobBrut-immobAmmort));
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
    
    public void newList()
    {
        for(Comptebilan c : listImmobInc)
        {
            if(c.getIdcompte().getNom().equals("Autres Immobilisations Incorporelles"))
            {
                c.setBrut(Double.parseDouble(TAutreImmobIncBrut.getText()));
                c.setAmmort(Double.parseDouble(TAutreImmobIncAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Investissement recherche et développement"))
            {
                c.setBrut(Double.parseDouble(TInvestRechDevBrut.getText()));
                c.setAmmort(Double.parseDouble(TInvestRechDevAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Concess.marque,brevet,licence,marque"))
            {
                c.setBrut(Double.parseDouble(TConcMarqBrut.getText()));
                c.setAmmort(Double.parseDouble(TConcMarqAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Logiciels"))
            {
                c.setBrut(Double.parseDouble(TLogicielBrut.getText()));
                c.setAmmort(Double.parseDouble(TLogicielAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Fonds commercial"))
            {
                c.setBrut(Double.parseDouble(TfondComBrut.getText()));
                c.setAmmort(Double.parseDouble(TLogicielAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Droit au bail"))
            {
                c.setBrut(Double.parseDouble(TDroitBailBrut.getText()));
                c.setAmmort(Double.parseDouble(TDroitBailAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Immobilisations Incorporelles en cours"))
            {
                c.setBrut(Double.parseDouble(TImmobIncEnCoursBrut.getText()));
                c.setAmmort(Double.parseDouble(TImmobIncEnCoursAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Av. et Ac.Verses/Cmde.Immob.Incorp"))
            {
                c.setBrut(Double.parseDouble(TAvAcVersesBrut.getText()));
                c.setAmmort(Double.parseDouble(TAvAcVersesAmmort.getText()));
            }
        }
    }
    
    public void initTextBox()
    {
        //afficher les valeur des zones de text à partir du bd
        for(Comptebilan c : listImmobInc)
        {
            if(c.getIdcompte().getNom().equals("Autres Immobilisations Incorporelles"))
            {
                TAutreImmobIncBrut.setText(String.valueOf(c.getBrut()));
                TAutreImmobIncAmmort.setText(String.valueOf(c.getAmmort()));
                TAutreImmobIncNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Investissement recherche et développement"))
            {
                TInvestRechDevBrut.setText(String.valueOf(c.getBrut()));
                TInvestRechDevAmmort.setText(String.valueOf(c.getAmmort()));
                TInvestRechDevNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Concess.marque,brevet,licence,marque"))
            {
                TConcMarqBrut.setText(String.valueOf(c.getBrut()));
                TConcMarqAmmort.setText(String.valueOf(c.getAmmort()));
                TConcMarqNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Logiciels"))
            {
                TLogicielBrut.setText(String.valueOf(c.getBrut()));
                TLogicielAmmort.setText(String.valueOf(c.getAmmort()));
                TLogicielNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Fonds commercial"))
            {
                TfondComBrut.setText(String.valueOf(c.getBrut()));
                TfondComAmmort.setText(String.valueOf(c.getAmmort()));
                TfondComNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Droit au bail"))
            {
                TDroitBailBrut.setText(String.valueOf(c.getBrut()));
                TDroitBailAmmort.setText(String.valueOf(c.getAmmort()));
                TDroitBailNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Immobilisations Incorporelles en cours"))
            {
                TImmobIncEnCoursBrut.setText(String.valueOf(c.getBrut()));
                TImmobIncEnCoursAmmort.setText(String.valueOf(c.getAmmort()));
                TImmobIncEnCoursNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Av. et Ac.Verses/Cmde.Immob.Incorp"))
            {
                TAvAcVersesBrut.setText(String.valueOf(c.getBrut()));
                TAvAcVersesAmmort.setText(String.valueOf(c.getAmmort()));
                TAvAcVersesNetN1.setText(String.valueOf(c.getTotal()));
            }
        }
        TInvestRechDevNetN.setText(CalculBrut(TInvestRechDevBrut, TInvestRechDevAmmort));
        TConcMarqNetN.setText(CalculBrut(TConcMarqBrut, TConcMarqAmmort));
        TLogicielNetN.setText(CalculBrut(TLogicielBrut, TLogicielAmmort));
        TfondComNetN.setText(CalculBrut(TfondComBrut, TfondComAmmort));
        TDroitBailNetN.setText(CalculBrut(TDroitBailBrut, TDroitBailAmmort));
        TAutreImmobIncNetN.setText(CalculBrut(TAutreImmobIncBrut, TAutreImmobIncAmmort));
        TImmobIncEnCoursNetN.setText(CalculBrut(TImmobIncEnCoursBrut, TImmobIncEnCoursAmmort));
        TAvAcVersesNetN.setText(CalculBrut(TAvAcVersesBrut, TAvAcVersesAmmort));

    }
    
}
