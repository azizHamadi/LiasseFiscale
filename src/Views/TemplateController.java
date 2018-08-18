/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.ANC.ImmobCorporelleController;
import Views.ANC.ImmobIncorporelleController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class TemplateController  extends Application  {

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
    
    
    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        Parent root = FXMLLoader.load(getClass().getResource("Template.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        launch(args);
      
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
            root = FXMLLoader.load(getClass().getResource("Actifs/BilanActif.fxml"));
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

    
}
