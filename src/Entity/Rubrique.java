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
public class Rubrique implements Serializable {

    private Integer id;
    private String nom;
    private String reference;
    private String referenceammort;
    private Collection<Rubrique> rubriqueCollection;
    private Rubrique idrubrique;
    private Collection<Compte> compteCollection;

    public Rubrique() {
    }

    public Rubrique(Integer id) {
        this.id = id;
    }

    public Rubrique(Integer id, String nom, String reference) {
        this.id = id;
        this.nom = nom;
        this.reference = reference;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getReferenceammort() {
        return referenceammort;
    }

    public void setReferenceammort(String referenceammort) {
        this.referenceammort = referenceammort;
    }

    public Collection<Rubrique> getRubriqueCollection() {
        return rubriqueCollection;
    }

    public void setRubriqueCollection(Collection<Rubrique> rubriqueCollection) {
        this.rubriqueCollection = rubriqueCollection;
    }

    public Rubrique getIdrubrique() {
        return idrubrique;
    }

    public void setIdrubrique(Rubrique idrubrique) {
        this.idrubrique = idrubrique;
    }

    public Collection<Compte> getCompteCollection() {
        return compteCollection;
    }

    public void setCompteCollection(Collection<Compte> compteCollection) {
        this.compteCollection = compteCollection;
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
        if (!(object instanceof Rubrique)) {
            return false;
        }
        Rubrique other = (Rubrique) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Rubrique[ id=" + id + " ]";
    }
    
}
