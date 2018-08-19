/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Entity.Bilan;
import Services.BilanService;
import Services.CompteBilanService;
import Services.CompteService;
import Views.Actifs.BilanActifController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class TemplateController  implements Initializable{

    @FXML
    private JFXButton BtnSociete;
    @FXML
    private JFXButton BtnExercice;
    @FXML
    private JFXButton BtnBilanActif;
    @FXML
    private JFXButton BtnBilanPassif;
    @FXML
    private JFXButton BtnEtatResultat;
    @FXML
    private JFXButton BtnFluxTresorerie;
    @FXML
    private JFXButton BtnXml;
    @FXML
    private JFXButton BtnXmlN1;
    @FXML
    private TabPane TabBody;
    
    private Tab TabSociete = null;
    private Tab TabExercice = null;
    private Tab TabBilanActif = null;
    private Tab TabBilanPassif = null ;
    private Tab TabEtatResultat = null ;
    private Tab TabFluxTresorerie = null ;
    private Parent root = null ;
    Stage stage ;
    @FXML
    private JFXButton btnAddBilan;
    @FXML
    private Label LabBilan;
    @FXML
    private Label LabTotalactif;
    @FXML
    private Label LabTotalPassif;
    BilanActifController bilanActifController ;

    public TabPane getTabBody() {
        return TabBody;
    }

    public void setTabBody(TabPane TabBody) {
        this.TabBody = TabBody;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            bilanActifController = new BilanActifController();
            // TODO
            //Bilan bilan = new Bilan(Calendar.getInstance().get(Calendar.YEAR)-1);
            BilanService bilanService = new BilanService();
            //Bilan bilanActuel = bilanService.RechercheBilan(bilan);
            Bilan bilanact = bilanService.MaxBilan();
            if(bilanact== null || !bilanact.getValide().equals("valide") || bilanact.getAnnee()==Calendar.getInstance().get(Calendar.YEAR) )
                btnAddBilan.setDisable(true);
            LabBilan.setText("Bilan "+ bilanact.getAnnee());
            btnAddBilan.setText(btnAddBilan.getText()+(bilanact.getAnnee()+1));
        } catch (SQLException ex) {
            Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    

    @FXML
    private void Societe(ActionEvent event) {            
        if(!TabBody.getTabs().contains(TabSociete))
        {
            TabSociete = new Tab("Société");
            TabBody.getTabs().add(TabSociete);
        }
        TabBody.getSelectionModel().select(TabSociete);
    }

    @FXML
    private void Exercice(ActionEvent event) {
        if(!TabBody.getTabs().contains(TabExercice))
        {
            TabExercice = new Tab("Exercices");
            TabBody.getTabs().add(TabExercice);
        }
        TabBody.getSelectionModel().select(TabExercice);
    }

    @FXML
    private void BilanActif(ActionEvent event) throws IOException {
        if(!TabBody.getTabs().contains(TabBilanActif))
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Actifs/BilanActif.fxml"));
            Node root = loader.load();
            bilanActifController = loader.getController();
            bilanActifController.setBtnAddBilan(btnAddBilan);
            /*if(!Bilan.valideActif.equals("valide") || !Bilan.valideActif.equals("ouiA"))
                bilanActifController.getBtnValider().setDisable(false);*/
            TabBilanActif = new Tab("Bilan actif");
            TabBilanActif.setContent(root);
            TabBody.getTabs().add(TabBilanActif);
        }
        TabBody.getSelectionModel().select(TabBilanActif);
    }

    @FXML
    private void BilanPassif(ActionEvent event) {
        if(!TabBody.getTabs().contains(TabBilanPassif))
        {
            TabBilanPassif = new Tab("Bilan passif");
            TabBody.getTabs().add(TabBilanPassif);
        }
        TabBody.getSelectionModel().select(TabBilanPassif);
    }

    @FXML
    private void EtatResultat(ActionEvent event) {
        if(!TabBody.getTabs().contains(TabEtatResultat))
        {
            TabEtatResultat = new Tab("Etats de résultat");
            TabBody.getTabs().add(TabEtatResultat);
        }
        TabBody.getSelectionModel().select(TabEtatResultat);
    }

    @FXML
    private void FluxTresorerie(ActionEvent event) {
        if(!TabBody.getTabs().contains(TabFluxTresorerie))
        {
            TabFluxTresorerie = new Tab("Flux de trésorerie");
            TabBody.getTabs().add(TabFluxTresorerie);
        }
        TabBody.getSelectionModel().select(TabFluxTresorerie);
    }

    @FXML
    private void GenerateXML(ActionEvent event) {
    }

    @FXML
    private void GenerateXMLN1(ActionEvent event) {
    }

    @FXML
    private void AjouterBilan(ActionEvent event) {
        try {
            BilanService bilanService = new BilanService();
            Bilan.anneeActif = Bilan.anneeActif+1;
            Bilan bilan = new Bilan(Bilan.anneeActif);
            bilanService.AjouterBilan(bilan);
            CompteService compteService = new CompteService();
            CompteBilanService compteBilanService = new CompteBilanService();
            bilan.setId(Bilan.idActif);
            bilan.setValide(Bilan.valideActif);
            compteBilanService.ajouterToutCompteBilan(bilan, compteService.AllComptes());
            btnAddBilan.setDisable(true);
            btnAddBilan.setText(btnAddBilan.getText().substring(0, btnAddBilan.getText().length()-4)+(Bilan.anneeActif+1 ));
            LabBilan.setText("Bilan "+Bilan.anneeActif);
            if(bilanActifController.getBtnValider() != null)
                bilanActifController.getBtnValider().setDisable(false);
        } catch (SQLException ex) {
            Logger.getLogger(TemplateController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public JFXButton getBtnAddBilan() {
        return btnAddBilan;
    }

    public void setBtnAddBilan(JFXButton btnAddBilan) {
        this.btnAddBilan = btnAddBilan;
    }
    
}
