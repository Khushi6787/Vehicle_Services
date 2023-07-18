/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author KHUSHI
 */
@Entity
@Table(name = "area")
@NamedQueries({
    @NamedQuery(name = "Area.findAll", query = "SELECT a FROM Area a"),
    @NamedQuery(name = "Area.findByAreaIDPK", query = "SELECT a FROM Area a WHERE a.areaIDPK = :areaIDPK"),
    @NamedQuery(name = "Area.findByAreaname", query = "SELECT a FROM Area a WHERE a.areaname = :areaname"),
    @NamedQuery(name = "Area.findByPincode", query = "SELECT a FROM Area a WHERE a.pincode = :pincode")})
public class Area implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "areaIDPK")
    private Integer areaIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "areaname")
    private String areaname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pincode")
    private int pincode;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaIDFK")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "areaIDFK")
    private Collection<Mechanic> mechanicCollection;

    public Area() {
    }

    public Area(Integer areaIDPK) {
        this.areaIDPK = areaIDPK;
    }

    public Area(Integer areaIDPK, String areaname, int pincode) {
        this.areaIDPK = areaIDPK;
        this.areaname = areaname;
        this.pincode = pincode;
    }

    public Integer getAreaIDPK() {
        return areaIDPK;
    }

    public void setAreaIDPK(Integer areaIDPK) {
        this.areaIDPK = areaIDPK;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public Collection<Mechanic> getMechanicCollection() {
        return mechanicCollection;
    }

    public void setMechanicCollection(Collection<Mechanic> mechanicCollection) {
        this.mechanicCollection = mechanicCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaIDPK != null ? areaIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.areaIDPK == null && other.areaIDPK != null) || (this.areaIDPK != null && !this.areaIDPK.equals(other.areaIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Area[ areaIDPK=" + areaIDPK + " ]";
    }
    
}
