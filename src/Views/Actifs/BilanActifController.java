/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Actifs;

import Entity.Bilan;
import Entity.Comptebilan;
import Services.BilanService;
import Services.CompteBilanService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
    
    List<Comptebilan> listImmobInc;
    List<Comptebilan> listImmobCorp;
    List<Comptebilan> listImmobFin;
    List<Comptebilan> listAutreANC;
    List<Comptebilan> listStock;
    List<Comptebilan> listClient;
    List<Comptebilan> listAutreAC;
    List<Comptebilan> listPlacement;
    List<Comptebilan> listLiq;
    
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
            CompteBilanService compteBilanService = new CompteBilanService();
            listImmobInc = compteBilanService.ListeCompteRubrique("Immobilisations Incorporelles");
            listImmobCorp = compteBilanService.ListeCompteRubrique("Immobilisations corporelles");
            listImmobFin = compteBilanService.ListeCompteRubrique("Immobilisations financieres");
            listAutreANC = compteBilanService.ListeCompteRubrique("Autres actifs non courants");
            listStock = compteBilanService.ListeCompteRubrique("Stocks");
            listClient = compteBilanService.ListeCompteRubrique("Clients et comptes rattaches");
            listAutreAC = compteBilanService.ListeCompteRubrique("Autres Actifs Courants");
            listPlacement = compteBilanService.ListeCompteRubrique("Placements et autres actifs financiers");
            listLiq = compteBilanService.ListeCompteRubrique("Liquidites et equivalents de liquidites");
            double immobBrut=0;
            double immobAmmort=0;
            double immmobAmmort=0;
            double immobCorpBrut=0;
            double immobCorpAmmort=0;
            double immobFinBrut=0;
            double immobFinAmmort=0;
            double autreANCBrut=0;
            double autreANCAmmort=0;
            double StockBrut=0;
            double StockAmmort=0;
            double ClientBrut=0;
            double ClientAmmort=0;
            double autreACBrut=0;
            double autreACAmmort=0;
            double PlacementBrut=0;
            double PlacementAmmort=0;
            double LiqBrut=0;
            double LiqAmmort= 0 ;
            for (Comptebilan c : listImmobInc)
            {   
                immobAmmort+=c.getAmmort();
                immobBrut+=c.getBrut();
            }
            for (Comptebilan c : listImmobCorp)
            {
                immobCorpAmmort+=c.getAmmort();
                immobCorpBrut+=c.getBrut();
            }
            for (Comptebilan c : listImmobFin)
            {
                immobFinAmmort+=c.getAmmort();
                immobFinAmmort+=c.getBrut();
            }
            for (Comptebilan c : listAutreANC)
            {
                autreANCAmmort+=c.getAmmort();
                autreANCAmmort+=c.getBrut();
            }
            for (Comptebilan c : listStock)
            {
                StockAmmort+=c.getAmmort();
                StockBrut+=c.getBrut();
            }
            for (Comptebilan c : listClient)
            {
                ClientAmmort+=c.getAmmort();
                ClientBrut+=c.getBrut();
            }
            for (Comptebilan c : listAutreAC)
            {
                autreACAmmort+=c.getAmmort();
                autreACBrut+=c.getBrut();
            }
            for (Comptebilan c : listPlacement)
            {
                PlacementAmmort+=c.getAmmort();
                PlacementBrut+=c.getBrut();
            }
            for (Comptebilan c : listLiq)
            {
                LiqAmmort+=c.getAmmort();
                LiqBrut+=c.getBrut();
            }
            
            TImmobIncAmmort.setText(String.valueOf(immobAmmort));
            TImmobIncBrut.setText(String.valueOf(immobBrut));
            TImmobIncNetN.setText(String.valueOf(immobBrut-immobAmmort));
            TImmobCorpAmmort.setText(String.valueOf(immobCorpAmmort));
            TImmobCorpBrut.setText(String.valueOf(immobCorpBrut));
            TImmobCorpNetN.setText(String.valueOf(immobCorpBrut-immobCorpAmmort));
            TImmobFinAmmort.setText(String.valueOf(immobFinAmmort));
            TImmobFinBrut.setText(String.valueOf(immobFinBrut));
            TImmobFinNetN.setText(String.valueOf(immobFinBrut-immobFinAmmort));
            TAutreAncAmmort.setText(String.valueOf(autreANCAmmort));
            TAutreAncBrut.setText(String.valueOf(autreANCBrut));
            TAutreAncNetN.setText(String.valueOf(autreANCBrut-autreANCAmmort));
            TStockAmmort.setText(String.valueOf(StockAmmort));
            TStockBrut.setText(String.valueOf(StockBrut));
            TStockNetN.setText(String.valueOf(StockBrut-StockAmmort));
            TClientComptAmmort.setText(String.valueOf(ClientAmmort));
            TClientComptBrut.setText(String.valueOf(ClientBrut));
            TClientComptNetN.setText(String.valueOf(ClientBrut-ClientAmmort));
            TAutreACAmmort.setText(String.valueOf(autreACAmmort));
            TAutreACBrut.setText(String.valueOf(autreACBrut));
            TAutreACNetN.setText(String.valueOf(autreACBrut-autreACAmmort));
            TPlacAutreAFAmmort.setText(String.valueOf(PlacementAmmort));
            TPlacAutreAFBrut.setText(String.valueOf(PlacementBrut));
            TPlacAutreAFNetN.setText(String.valueOf(PlacementBrut-PlacementAmmort));
            TLiquiditeAmmort.setText(String.valueOf(LiqAmmort));
            TLiquiditeBrut.setText(String.valueOf(LiqBrut));
            TLiquiditeNetN.setText(String.valueOf(LiqBrut-LiqAmmort));
            
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ImmobilisationIncorp.fxml"));
            Parent root = loader.load();
            ImmobilisationIncorpController immobilisationIncorpController = loader.getController();
            immobilisationIncorpController.setListImmobInc(listImmobInc);
            immobilisationIncorpController.initTextBox();
            immobilisationIncorpController.setTImmobIncAmmort(TImmobIncAmmort);
            immobilisationIncorpController.setTImmobIncBrut(TImmobIncBrut);
            immobilisationIncorpController.setTImmobIncNet(TImmobIncNetN);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ImmobilisationCorp.fxml"));
            Parent root = loader.load();
            ImmobilisationCorpController immobilisationCorpController = loader.getController();
            immobilisationCorpController.setListImmobCorp(listImmobCorp);
            immobilisationCorpController.initTextBox();
            immobilisationCorpController.setTImmobCBrut(TImmobCorpBrut);
            immobilisationCorpController.setTImmobCAmmort(TImmobCorpAmmort);
            immobilisationCorpController.setTImmobCNet(TImmobCorpNetN);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ImmobilisationFinan.fxml"));
            Parent root = loader.load();
            ImmobilisationFinanController immobilisationFinanController= loader.getController();
            System.out.println("Views.Actifs.BilanActifController.AddImmobFin() " + listImmobFin);
            immobilisationFinanController.setListImmobFin(listImmobFin);
            immobilisationFinanController.initTextBox();
            immobilisationFinanController.setTImmobFNet(TImmobFinNetN);
            immobilisationFinanController.setTImmobFBrut(TImmobFinBrut);
            immobilisationFinanController.setTImmobFAmmort(TImmobFinAmmort);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AutresANC.fxml"));
            Parent root = loader.load();
            AutresANCController autresANCController = loader.getController();
            autresANCController.setListAutreAnc(listAutreANC);
            for (Comptebilan c : autresANCController.getListAutreAnc())
                System.out.println("autre anc : "+c);
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PlacementAutreAF.fxml"));
            Parent root = loader.load();
            PlacementAutreAFController placementAutreAFController = loader.getController();
            System.out.println("placement : "+listPlacement);
            placementAutreAFController.setComptebilan(listPlacement.stream().filter(c->c.getIdcompte().getIdrubrique().getNom().equals("Placements et autres actifs financiers")).collect(Collectors.toList()));
            for(Comptebilan c : placementAutreAFController.getComptebilan())
                System.out.println("compte : "+c);
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
