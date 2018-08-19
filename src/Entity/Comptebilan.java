/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aziz
 */
public class Comptebilan implements Serializable {

    private Integer id;
    private double brut;
    private Date date;
    private Integer total;
    private double ammort;
    private Bilan idbilan;
    private Compte idcompte;

    public Comptebilan() {
    }

    public Comptebilan(Integer id) {
        this.id = id;
    }

    public Comptebilan(Integer id, double brut, Date date, double ammort) {
        this.id = id;
        this.brut = brut;
        this.date = date;
        this.ammort = ammort;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getBrut() {
        return brut;
    }

    public void setBrut(double brut) {
        this.brut = brut;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public double getAmmort() {
        return ammort;
    }

    public void setAmmort(double ammort) {
        this.ammort = ammort;
    }

    public Bilan getIdbilan() {
        return idbilan;
    }

    public void setIdbilan(Bilan idbilan) {
        this.idbilan = idbilan;
    }

    public Compte getIdcompte() {
        return idcompte;
    }

    public void setIdcompte(Compte idcompte) {
        this.idcompte = idcompte;
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
        if (!(object instanceof Comptebilan)) {
            return false;
        }
        Comptebilan other = (Comptebilan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Comptebilan[ id=" + id + " ]";
    }
    
}
