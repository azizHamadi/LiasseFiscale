/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Bilan;
import Entity.Compte;
import Entity.Comptebilan;
import Technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
}
