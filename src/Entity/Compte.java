/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author aziz
 */
public class Compte implements Serializable {

    private Integer id;
    private String reference;
    private String nom;
    private String referenceammort;
    private Collection<Comptebilan> comptebilanCollection;
    private Rubrique idrubrique;

    public Compte() {
    }

    public Compte(Integer id) {
        this.id = id;
    }

    public Compte(Integer id, String reference, String nom) {
        this.id = id;
        this.reference = reference;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReferenceammort() {
        return referenceammort;
    }

    public void setReferenceammort(String referenceammort) {
        this.referenceammort = referenceammort;
    }

    public Collection<Comptebilan> getComptebilanCollection() {
        return comptebilanCollection;
    }

    public void setComptebilanCollection(Collection<Comptebilan> comptebilanCollection) {
        this.comptebilanCollection = comptebilanCollection;
    }

    public Rubrique getIdrubrique() {
        return idrubrique;
    }

    public void setIdrubrique(Rubrique idrubrique) {
        this.idrubrique = idrubrique;
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
        if (!(object instanceof Compte)) {
            return false;
        }
        Compte other = (Compte) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compte{" + "id=" + id + ", reference=" + reference + ", nom=" + nom + ", referenceammort=" + referenceammort + ", idrubrique=" + idrubrique + '}';
    }

    
    
}
