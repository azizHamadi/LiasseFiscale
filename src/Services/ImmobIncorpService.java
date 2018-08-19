/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Technique.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aziz
 */
public class ImmobIncorpService {

    public Connection con = DataSource.getInstance().getCon();
    private Statement ste ;

    public ImmobIncorpService() {
        try {
            ste =con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ImmobIncorpService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void AjouterImmobIncorp()
    {
        
    }
    
    
}
