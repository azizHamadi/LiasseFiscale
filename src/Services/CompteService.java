/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entity.Compte;
import Entity.Rubrique;
import Technique.DataSource;
import java.sql.Connection;
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
public class CompteService {
    public Connection con = DataSource.getInstance().getCon();
    private Statement ste ;
    private Statement ste1 ;

    public CompteService() throws SQLException {
        ste =con.createStatement();
        ste1 =con.createStatement();
    }
    
    public List<Compte> AllComptes()
    {
        ArrayList<Compte> listeCompte = new ArrayList<>();
        try {
            ResultSet rsCompte = ste.executeQuery("select * from compte") ;
            while(rsCompte.next())
            {
               Compte compte = new Compte(rsCompte.getInt("id"), rsCompte.getString("reference"), rsCompte.getString("nom"));
               ResultSet rsRubrique = ste1.executeQuery("select * from rubrique where id="+rsCompte.getInt("idrubrique")) ;
               while(rsRubrique.next())
               {
                   Rubrique rubrique = new Rubrique(rsRubrique.getInt("id"), rsRubrique.getString("nom"), rsRubrique.getString("reference"));
                   compte.setIdrubrique(rubrique);
               }
               listeCompte.add(compte);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeCompte;
    }
    
}
