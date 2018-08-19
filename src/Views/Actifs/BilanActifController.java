/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Actifs;

import Entity.Bilan;
import Services.BilanService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author aziz
 */
public class BilanActifController implements Initializable {

    @FXML
    private AnchorPane BilanActif;
    @FXML
    private Label TAnneeN;
    @FXML
    private Label TAnneeN1;
    @FXML
    private JFXTextField TImmobIncBrut;
    @FXML
    private JFXTextField TImmobIncAmmort;
    @FXML
    private JFXTextField TImmobIncNetN;
    @FXML
    private JFXTextField TImmobIncNetN1;
    @FXML
    private JFXButton BtnAddImmobInc;
    @FXML
    private JFXTextField TImmobCorpBrut;
    @FXML
    private JFXTextField TImmobCorpAmmort;
    @FXML
    private JFXTextField TImmobCorpNetN;
    @FXML
    private JFXTextField TImmobCorpNetN1;
    @FXML
    private JFXButton BtnAddImmobCorp;
    @FXML
    private JFXTextField TImmobFinBrut;
    @FXML
    private JFXTextField TImmobFinAmmort;
    @FXML
    private JFXTextField TImmobFinNetN;
    @FXML
    private JFXTextField TImmobFinNetN1;
    @FXML
    private JFXButton BtnAddImmobFin;
    @FXML
    private JFXTextField TTotalImmobBrut;
    @FXML
    private JFXTextField TTotalImmobAmmort;
    @FXML
    private JFXTextField TTotalImmobNetN;
    @FXML
    private JFXTextField TTotalImmobNetN1;
    @FXML
    private JFXTextField TAutreAncBrut;
    @FXML
    private JFXTextField TAutreAncAmmort;
    @FXML
    private JFXTextField TAutreAncNetN;
    @FXML
    private JFXTextField TAutreAncNetN1;
    @FXML
    private JFXButton BtnAddAutreAnc;
    @FXML
    private JFXTextField TTotalAncBrut;
    @FXML
    private JFXTextField TTotalAncAmmort;
    @FXML
    private JFXTextField TTotalAncNetN;
    @FXML
    private JFXTextField TTotalAncNetN1;
    @FXML
    private JFXTextField TStockBrut;
    @FXML
    private JFXTextField TStockAmmort;
    @FXML
    private JFXTextField TStockNetN;
    @FXML
    private JFXTextField TStockNetN1;
    @FXML
    private JFXButton BtnAddStock;
    @FXML
    private JFXTextField TClientComptBrut;
    @FXML
    private JFXTextField TClientComptAmmort;
    @FXML
    private JFXTextField TClientComptNetN;
    @FXML
    private JFXTextField TClientComptNetN1;
    @FXML
    private JFXButton BtnAddClientCompt;
    @FXML
    private JFXTextField TAutreACBrut;
    @FXML
    private JFXTextField TAutreACAmmort;
    @FXML
    private JFXTextField TAutreACNetN;
    @FXML
    private JFXTextField TAutreACNetN1;
    @FXML
    private JFXButton BtnAddAutreAC;
    @FXML
    private JFXTextField TPlacAutreAFBrut;
    @FXML
    private JFXTextField TPlacAutreAFAmmort;
    @FXML
    private JFXTextField TPlacAutreAFNetN;
    @FXML
    private JFXTextField TPlacAutreAFNetN1;
    @FXML
    private JFXButton BtnAddPlacAutreAF;
    @FXML
    private JFXTextField TLiquiditeBrut;
    @FXML
    private JFXTextField TLiquiditeAmmort;
    @FXML
    private JFXTextField TLiquiditeNetN;
    @FXML
    private JFXTextField TLiquiditeNetN1;
    @FXML
    private JFXButton BtnAddLiquidite;
    @FXML
    private JFXTextField TAutrePostBrut;
    @FXML
    private JFXTextField TAutrePostAmmort;
    @FXML
    private JFXTextField TAutrePostNetN;
    @FXML
    private JFXTextField TAutrePostNetN1;
    @FXML
    private JFXButton BtnAddAutrePost;
    @FXML
    private JFXTextField TTotalACBrut;
    @FXML
    private JFXTextField TTotalACAmmort;
    @FXML
    private JFXTextField TTotalACNetN;
    @FXML
    private JFXTextField TTotalACNetN1;
    @FXML
    private JFXTextField TTotalABrut;
    @FXML
    private JFXTextField TTotalAAmmort;
    @FXML
    private JFXTextField TTotalANetN;
    @FXML
    private JFXTextField TTotalANetN1;
    
    Stage stageImmobInc = new Stage();
    Stage stageImmobcorp = new Stage();
    Stage stageImmobFin = new Stage();
    Stage stageAutreAnc = new Stage();
    Stage stageStock = new Stage();
    Stage stageClientCompt = new Stage();
    Stage stageAutreAC = new Stage();
    Stage StagePlacement = new Stage();
    Stage stageLiquidite = new Stage();
    @FXML
    private JFXButton BtnValider;
    private JFXButton btnAddBilan;

    public JFXButton getBtnAddBilan() {
        return btnAddBilan;
    }

    public void setBtnAddBilan(JFXButton btnAddBilan) {
        this.btnAddBilan = btnAddBilan;
    }

    public JFXButton getBtnValider() {
        return BtnValider;
    }

    public void setBtnValider(JFXButton BtnValider) {
        this.BtnValider = BtnValider;
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!Bilan.valideActif.equals("ouiP")&&!Bilan.valideActif.equals("non") )
            BtnValider.setDisable(true);
        // TODO
    }    

    @FXML
    private void ValiderBilanActifs(ActionEvent event) {
        if(!Bilan.valideActif.equals("ouiA"))
        {
            if (Bilan.valideActif.equals("non"))
                Bilan.valideActif = "ouiA";
            else
            {
                Bilan.valideActif = "valide";
                if(Bilan.anneeActif<Calendar.getInstance().get(Calendar.YEAR))
                    btnAddBilan.setDisable(false);
            }
            BtnValider.setDisable(true);
            BilanService bilanService = new BilanService();
            bilanService.ValiderBilan();
        }
    }

    @FXML
    private void AddImmobInc(ActionEvent event) throws IOException {
        if (!stageImmobInc.isShowing())
        {   
            stageImmobInc.setResizable(false);
            stageImmobInc.setTitle("Immobilisations incorporelles");
            Parent root = FXMLLoader.load(getClass().getResource("ImmobilisationIncorp.fxml"));
            Scene scene = new Scene(root);
            stageImmobInc.setScene(scene);
            stageImmobInc.show();
        }
        stageImmobInc.toFront();
    }

    @FXML
    private void AddImmobCorp(ActionEvent event) throws IOException {
        if (!stageImmobcorp.isShowing())
        {
            stageImmobcorp.setResizable(false);
            stageImmobcorp.setTitle("Immobilisations corporelles");
            Parent root = FXMLLoader.load(getClass().getResource("ImmobilisationCorp.fxml"));
            Scene scene = new Scene(root);
            stageImmobcorp.setScene(scene);
            stageImmobcorp.show();
        }
        stageImmobcorp.toFront();
    }

    @FXML
    private void AddImmobFin(ActionEvent event) throws IOException {
        if(!stageImmobFin.isShowing())
        {
            stageImmobFin.setResizable(false);
            stageImmobFin.setTitle("Immobilisations financières");
            Parent root = FXMLLoader.load(getClass().getResource("ImmobilisationFinan.fxml"));
            Scene scene = new Scene(root);
            stageImmobFin.setScene(scene);
            stageImmobFin.show();    
        }
        stageImmobFin.toFront();
    }

    @FXML
    private void AddAutreAnc(ActionEvent event) throws IOException {
        if(!stageAutreAnc.isShowing())
        {
            stageAutreAnc.setResizable(false);
            stageAutreAnc.setTitle("Autres actifs non courants");
            Parent root = FXMLLoader.load(getClass().getResource("AutresANC.fxml"));
            Scene scene = new Scene(root);
            stageAutreAnc.setScene(scene);
            stageAutreAnc.show();
        }
        stageAutreAnc.toFront();
    }

    @FXML
    private void AddStock(ActionEvent event) throws IOException {
        if(!stageStock.isShowing())
        {
            stageStock.setResizable(false);
            stageStock.setTitle("Stocks");
            Parent root = FXMLLoader.load(getClass().getResource("Stock.fxml"));
            Scene scene = new Scene(root);
            stageStock.setScene(scene);
            stageStock.show();
        }
        stageStock.toFront();
    }

    @FXML
    private void AddClientCompt(ActionEvent event) throws IOException {
        if(!stageClientCompt.isShowing())
        {
            stageClientCompt.setResizable(false);
            stageClientCompt.setTitle("Clients et comptes rattachés");
            Parent root = FXMLLoader.load(getClass().getResource("ClientComptRat.fxml"));
            Scene scene = new Scene(root);
            stageClientCompt.setScene(scene);
            stageClientCompt.show();
        }
        stageStock.toFront();
    }

    @FXML
    private void AddAutreAC(ActionEvent event) throws IOException {
        if(!stageAutreAC.isShowing())
        {
            stageAutreAC.setResizable(false);
            stageAutreAC.setTitle("Autres actifs courants");
            Parent root = FXMLLoader.load(getClass().getResource("AutreAC.fxml"));
            Scene scene = new Scene(root);
            stageAutreAC.setScene(scene);
            stageAutreAC.show();
        }
        stageAutreAC.toFront();
    }

    @FXML
    private void AddPlacAutreAF(ActionEvent event) throws IOException {
        if(!StagePlacement.isShowing())
        {
            StagePlacement.setResizable(false);
            StagePlacement.setTitle("Placements et autres actifs financiers");
            Parent root = FXMLLoader.load(getClass().getResource("PlacementAutreAF.fxml"));
            Scene scene = new Scene(root);
            StagePlacement.setScene(scene);
            StagePlacement.show();
        }
        StagePlacement.toFront();
    }

    @FXML
    private void AddLiquidite(ActionEvent event) throws IOException {
        if(!stageLiquidite.isShowing())
        {
            stageLiquidite.setResizable(false);
            stageLiquidite.setTitle("Liquidités et équivalents de liquidités");
            Parent root = FXMLLoader.load(getClass().getResource("Liquidite.fxml"));
            Scene scene = new Scene(root);
            stageLiquidite.setScene(scene);
            stageLiquidite.show();
        }
        stageLiquidite.toFront();
    }

    @FXML
    private void AddAutrePost(ActionEvent event) {
    }
    
}
