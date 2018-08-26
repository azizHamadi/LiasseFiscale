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
    
    public TextField TImmobCBrut ;
    public TextField TImmobCAmmort ;
    public TextField TImmobCNet ;
    double immobAmmort = 0 ;
    double immobBrut = 0 ;
    
    public List<Comptebilan> listImmobCorp;

    public TextField getTImmobCBrut() {
        return TImmobCBrut;
    }

    public void setTImmobCBrut(TextField TImmobCBrut) {
        this.TImmobCBrut = TImmobCBrut;
    }

    public TextField getTImmobCAmmort() {
        return TImmobCAmmort;
    }

    public void setTImmobCAmmort(TextField TImmobCAmmort) {
        this.TImmobCAmmort = TImmobCAmmort;
    }

    public TextField getTImmobCNet() {
        return TImmobCNet;
    }

    public void setTImmobCNet(TextField TImmobCNet) {
        this.TImmobCNet = TImmobCNet;
    }

    
    public List<Comptebilan> getListImmobCorp() {
        return listImmobCorp;
    }

    public void setListImmobCorp(List<Comptebilan> listImmobCorp) {
        this.listImmobCorp = listImmobCorp;
    }

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
        newList();
        CompteBilanService compteBilanService = new CompteBilanService();
        compteBilanService.modifiercompteBilan(listImmobCorp);
        for(Comptebilan c : listImmobCorp)
        {
            immobAmmort+=c.getAmmort();
            immobBrut+=c.getBrut();
        }
        TImmobCBrut.setText(String.valueOf(immobBrut));
        TImmobCAmmort.setText(String.valueOf(immobAmmort));
        TImmobCNet.setText(String.valueOf(immobBrut-immobAmmort));
    }

    public void newList()
    {
        for(Comptebilan c : listImmobCorp)
        {
            if(c.getIdcompte().getNom().equals("Terrains"))
            {
                c.setBrut(Double.parseDouble(TTerrainBrut.getText()));
                c.setAmmort(Double.parseDouble(TTerrainAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Constructions"))
            {
                c.setBrut(Double.parseDouble(TConstructionBrut.getText()));
                c.setAmmort(Double.parseDouble(TConstructionAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Inst. Tech., materiel et outillages Industriels"))
            {
                c.setBrut(Double.parseDouble(TInstTechBrut.getText()));
                c.setAmmort(Double.parseDouble(TInstTechAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Materiel de transport"))
            {
                c.setBrut(Double.parseDouble(TmaterielTranBrut.getText()));
                c.setAmmort(Double.parseDouble(TmaterielTranAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Autres Immobilisations Corporelles"))
            {
                c.setBrut(Double.parseDouble(TAutreImmobCBrut.getText()));
                c.setAmmort(Double.parseDouble(TAutreImmobCAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Immob. Corporelles en cours"))
            {
                c.setBrut(Double.parseDouble(TImmobCorpBrut.getText()));
                c.setAmmort(Double.parseDouble(TImmobCorpAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Av. et Ac. Verses/Commande Immob.Corp"))
            {
                c.setBrut(Double.parseDouble(TAvVersesBrut.getText()));
                c.setAmmort(Double.parseDouble(TAvVersesAmmort.getText()));
            }
            if(c.getIdcompte().getNom().equals("Immob. a statut juridique particulier"))
            {
                c.setBrut(Double.parseDouble(TImmobStatJBrut.getText()));
                c.setAmmort(Double.parseDouble(TImmobStatJAmmort.getText()));
            }
        }
    }
    
    public void initTextBox()
    {
        //afficher les valeur des zones de text à partir du bd
        for(Comptebilan c : listImmobCorp)
        {
            if(c.getIdcompte().getNom().equals("Terrains"))
            {
                TTerrainBrut.setText(String.valueOf(c.getBrut()));
                TTerrainAmmort.setText(String.valueOf(c.getAmmort()));
                TTerrainNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Constructions"))
            {
                TConstructionBrut.setText(String.valueOf(c.getBrut()));
                TConstructionAmmort.setText(String.valueOf(c.getAmmort()));
                TConstructionNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Inst. Tech., materiel et outillages Industriels"))
            {
                TInstTechBrut.setText(String.valueOf(c.getBrut()));
                TInstTechAmmort.setText(String.valueOf(c.getAmmort()));
                TInstTechNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Materiel de transport"))
            {
                TmaterielTranBrut.setText(String.valueOf(c.getBrut()));
                TmaterielTranAmmort.setText(String.valueOf(c.getAmmort()));
                TmaterielTranNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Autres Immobilisations Corporelles"))
            {
                TAutreImmobCBrut.setText(String.valueOf(c.getBrut()));
                TAutreImmobCAmmort.setText(String.valueOf(c.getAmmort()));
                TAutreImmobCNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Immob. Corporelles en cours"))
            {
                TImmobCorpBrut.setText(String.valueOf(c.getBrut()));
                TImmobCorpAmmort.setText(String.valueOf(c.getAmmort()));
                TImmobCorpNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Av. et Ac. Verses/Commande Immob.Corp"))
            {
                TAvVersesBrut.setText(String.valueOf(c.getBrut()));
                TAvVersesAmmort.setText(String.valueOf(c.getAmmort()));
                TAvVersesNetN1.setText(String.valueOf(c.getTotal()));
            }
            if(c.getIdcompte().getNom().equals("Immob. a statut juridique particulier"))
            {
                TImmobStatJBrut.setText(String.valueOf(c.getBrut()));
                TImmobStatJAmmort.setText(String.valueOf(c.getAmmort()));
                TImmobStatJNetN1.setText(String.valueOf(c.getTotal()));
            }
        }
        TTerrainNetN.setText(CalculBrut(TTerrainBrut, TTerrainAmmort));
        TConstructionNetN.setText(CalculBrut(TConstructionBrut, TConstructionAmmort));
        TInstTechNetN.setText(CalculBrut(TInstTechBrut, TInstTechAmmort));
        TmaterielTranNetN.setText(CalculBrut(TmaterielTranBrut, TmaterielTranAmmort));
        TAutreImmobCNetN.setText(CalculBrut(TAutreImmobCBrut, TAutreImmobCAmmort));
        TImmobCorpNetN.setText(CalculBrut(TImmobCorpBrut, TImmobCorpAmmort));
        TAvVersesNetN.setText(CalculBrut(TAvVersesBrut, TAvVersesAmmort));
        TImmobStatJNetN.setText(CalculBrut(TImmobStatJBrut, TImmobStatJAmmort));

    }
    
}
