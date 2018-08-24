/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Bilan;
import Entity.Compte;
import Entity.Comptebilan;
import Entity.Rubrique;
import Technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aziz
 */
public class CompteBilanService {
    public Connection con = DataSource.getInstance().getCon();
    private Statement ste ;
    private Statement ste1 ;

    public CompteBilanService() {
        try {
            ste =con.createStatement();
            ste1 =con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CompteBilanService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ajouterToutCompteBilan(Bilan bilan,List<Compte> listeCompte)
    {
        for(Compte compte : listeCompte)
        {
            try {
                String req ="INSERT INTO comptebilan (idcompte,idbilan,date) VALUES (?,?,NOW())";
                PreparedStatement pre = con.prepareStatement(req);
                pre.setInt(1, compte.getId());
                pre.setInt(2, bilan.getId());
                pre.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CompteBilanService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void modifiercompteBilan(List<Comptebilan> listCompteBilan)
    {
        for (Comptebilan c : listCompteBilan)
        {
            try {
                String req ="update comptebilan set brut="+c.getBrut()+" ,ammort = "+c.getAmmort()+" ,date =Now() where id="+c.getId();
                PreparedStatement pre = con.prepareStatement(req);
                pre.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(CompteBilanService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Comptebilan> ListeCompteRubrique(String rub)
    {
        ArrayList<Comptebilan> listeCompte = new ArrayList<>();
        try {
            ResultSet rsCompte = ste.executeQuery("select * from compte c , rubrique r , comptebilan cb where c.id=cb.idcompte and cb.idbilan="+Bilan.idActif+" and c.idrubrique=r.id and r.nom='"+ rub +"' ") ;
            while(rsCompte.next())
            {
                Comptebilan compteBilan = new Comptebilan(rsCompte.getInt("cb.id"), rsCompte.getDouble("cb.brut"), rsCompte.getDate("cb.date"), rsCompte.getDouble("ammort"));
                Compte compte = new Compte(rsCompte.getInt("c.id"), rsCompte.getString("c.reference"), rsCompte.getString("c.nom"));
                Rubrique rubrique = new Rubrique(rsCompte.getInt("r.id"), rsCompte.getString("r.nom"), rsCompte.getString("r.reference"));
                compte.setIdrubrique(rubrique);
                compteBilan.setIdcompte(compte);
                listeCompte.add(compteBilan);
            }
            
            return listeCompte;
        } catch (SQLException ex) {
            Logger.getLogger(CompteBilanService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCompte;

    }
    
}
