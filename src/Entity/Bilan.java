/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author aziz
 */

public class Bilan implements Serializable {

    private Integer id;
    private int annee;
    private String valide;
    private Collection<Comptebilan> comptebilanCollection;
    public static int idActif ;
    public static int anneeActif ;
    public static String valideActif;
    

    public Bilan() {
    }

    public Bilan(Integer id) {
        this.id = id;
    }

    public Bilan(Integer id, int annee, String valide) {
        this.id = id;
        this.annee = annee;
        this.valide = valide;
    }

    public Bilan(int annee) {
        this.annee = annee;
    }

    public Bilan(int annee, String valide) {
        this.annee = annee;
        this.valide = valide;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getValide() {
        return valide;
    }

    public void setValide(String valide) {
        this.valide = valide;
    }

    public Collection<Comptebilan> getComptebilanCollection() {
        return comptebilanCollection;
    }

    public void setComptebilanCollection(Collection<Comptebilan> comptebilanCollection) {
        this.comptebilanCollection = comptebilanCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bilan)) {
            return false;
        }
        Bilan other = (Bilan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bilan{" + "id=" + id + ", annee=" + annee + ", valide=" + valide + '}';
    }

}
