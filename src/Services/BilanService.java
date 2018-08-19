/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Bilan;
import Technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aziz
 */
public class BilanService {
    public Connection con = DataSource.getInstance().getCon();
    private Statement ste ;
    private Statement ste1 ;

    public BilanService() {
        try {
            ste =con.createStatement();
            ste1 =con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(BilanService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AjouterBilan(Bilan bilan) throws SQLException
    {
        Bilan bilanActuel = RechercheBilan(bilan);
        if(bilanActuel == null )
        {
            String req ="INSERT INTO bilan (annee) VALUES (?)";
            PreparedStatement pre = con.prepareStatement(req,Statement.RETURN_GENERATED_KEYS);
            pre.setInt(1, bilan.getAnnee());
            pre.executeUpdate();
            ResultSet  clef = pre.getGeneratedKeys();
            while(clef.next())
                bilanActuel = new Bilan(clef.getInt(1),bilan.getAnnee(),"non");
        }
        Bilan.idActif = bilanActuel.getId();
        Bilan.valideActif = "non";
    }
    
    public Bilan RechercheBilan(Bilan bilan) throws SQLException
    {
        Bilan bilanRecherche = null ;
        ResultSet rsBilan = ste.executeQuery("select * from bilan where annee="+bilan.getAnnee()+"") ;
        while(rsBilan.next())
        {
            bilanRecherche = new Bilan(rsBilan.getInt("id"), rsBilan.getInt("annee"),rsBilan.getString("valide"));
        }
        return bilanRecherche;
    }
    
    public Bilan MaxBilan() throws SQLException
    {
        Bilan bilanRecherche = null ;
        ResultSet rsMaxAnnee = ste.executeQuery("select max(annee) as annee from bilan") ;
        while(rsMaxAnnee.next())
        {
            ResultSet rsBilan = ste1.executeQuery("select * from bilan where annee ='"+rsMaxAnnee.getInt("annee")+"'");
            while (rsBilan.next()) {
                bilanRecherche = new Bilan(rsBilan.getInt("id"), rsBilan.getInt("annee"),rsBilan.getString("valide"));
                System.out.println("Services.BilanService.MaxBilan() " + bilanRecherche);
                Bilan.anneeActif = bilanRecherche.getAnnee();
                Bilan.idActif = bilanRecherche.getId();
                Bilan.valideActif = bilanRecherche.getValide();
            }
        }
        return bilanRecherche;
    }
    
    public void ValiderBilan()
    {
        try {
            String req ="update bilan set valide='"+Bilan.valideActif+"' where id="+Bilan.idActif;
            PreparedStatement pre = con.prepareStatement(req);
            pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BilanService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
