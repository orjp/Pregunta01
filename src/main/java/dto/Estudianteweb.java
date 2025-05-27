/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Alexis
 */
@Entity
@Table(name = "estudianteweb")
@NamedQueries({
    @NamedQuery(name = "Estudianteweb.findAll", query = "SELECT e FROM Estudianteweb e"),
    @NamedQuery(name = "Estudianteweb.findByCodiEstdWeb", query = "SELECT e FROM Estudianteweb e WHERE e.codiEstdWeb = :codiEstdWeb"),
    @NamedQuery(name = "Estudianteweb.findByNdniEstdWeb", query = "SELECT e FROM Estudianteweb e WHERE e.ndniEstdWeb = :ndniEstdWeb"),
    @NamedQuery(name = "Estudianteweb.findByAppEstdWeb", query = "SELECT e FROM Estudianteweb e WHERE e.appEstdWeb = :appEstdWeb"),
    @NamedQuery(name = "Estudianteweb.findByApmaEstWeb", query = "SELECT e FROM Estudianteweb e WHERE e.apmaEstWeb = :apmaEstWeb"),
    @NamedQuery(name = "Estudianteweb.findByNombEstdWeb", query = "SELECT e FROM Estudianteweb e WHERE e.nombEstdWeb = :nombEstdWeb"),
    @NamedQuery(name = "Estudianteweb.findByFechNaciEstdWeb", query = "SELECT e FROM Estudianteweb e WHERE e.fechNaciEstdWeb = :fechNaciEstdWeb"),
    @NamedQuery(name = "Estudianteweb.findByLogiEstd", query = "SELECT e FROM Estudianteweb e WHERE e.logiEstd = :logiEstd"),
    @NamedQuery(name = "Estudianteweb.findByPassEstd", query = "SELECT e FROM Estudianteweb e WHERE e.passEstd = :passEstd")})
public class Estudianteweb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codiEstdWeb")
    private Integer codiEstdWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ndniEstdWeb")
    private String ndniEstdWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "appEstdWeb")
    private String appEstdWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "apmaEstWeb")
    private String apmaEstWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombEstdWeb")
    private String nombEstdWeb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechNaciEstdWeb")
    @Temporal(TemporalType.DATE)
    private Date fechNaciEstdWeb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "logiEstd")
    private String logiEstd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "passEstd")
    private String passEstd;

    public Estudianteweb() {
    }

    public Estudianteweb(Integer codiEstdWeb) {
        this.codiEstdWeb = codiEstdWeb;
    }

    public Estudianteweb(Integer codiEstdWeb, String ndniEstdWeb, String appEstdWeb, String apmaEstWeb, String nombEstdWeb, Date fechNaciEstdWeb, String logiEstd, String passEstd) {
        this.codiEstdWeb = codiEstdWeb;
        this.ndniEstdWeb = ndniEstdWeb;
        this.appEstdWeb = appEstdWeb;
        this.apmaEstWeb = apmaEstWeb;
        this.nombEstdWeb = nombEstdWeb;
        this.fechNaciEstdWeb = fechNaciEstdWeb;
        this.logiEstd = logiEstd;
        this.passEstd = passEstd;
    }

    public Integer getCodiEstdWeb() {
        return codiEstdWeb;
    }

    public void setCodiEstdWeb(Integer codiEstdWeb) {
        this.codiEstdWeb = codiEstdWeb;
    }

    public String getNdniEstdWeb() {
        return ndniEstdWeb;
    }

    public void setNdniEstdWeb(String ndniEstdWeb) {
        this.ndniEstdWeb = ndniEstdWeb;
    }

    public String getAppEstdWeb() {
        return appEstdWeb;
    }

    public void setAppEstdWeb(String appEstdWeb) {
        this.appEstdWeb = appEstdWeb;
    }

    public String getApmaEstWeb() {
        return apmaEstWeb;
    }

    public void setApmaEstWeb(String apmaEstWeb) {
        this.apmaEstWeb = apmaEstWeb;
    }

    public String getNombEstdWeb() {
        return nombEstdWeb;
    }

    public void setNombEstdWeb(String nombEstdWeb) {
        this.nombEstdWeb = nombEstdWeb;
    }

    public Date getFechNaciEstdWeb() {
        return fechNaciEstdWeb;
    }

    public void setFechNaciEstdWeb(Date fechNaciEstdWeb) {
        this.fechNaciEstdWeb = fechNaciEstdWeb;
    }

    public String getLogiEstd() {
        return logiEstd;
    }

    public void setLogiEstd(String logiEstd) {
        this.logiEstd = logiEstd;
    }

    public String getPassEstd() {
        return passEstd;
    }

    public void setPassEstd(String passEstd) {
        this.passEstd = passEstd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codiEstdWeb != null ? codiEstdWeb.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudianteweb)) {
            return false;
        }
        Estudianteweb other = (Estudianteweb) object;
        if ((this.codiEstdWeb == null && other.codiEstdWeb != null) || (this.codiEstdWeb != null && !this.codiEstdWeb.equals(other.codiEstdWeb))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.Estudianteweb[ codiEstdWeb=" + codiEstdWeb + " ]";
    }
    
}
