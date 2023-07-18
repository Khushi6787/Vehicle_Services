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
@Table(name = "service")
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s"),
    @NamedQuery(name = "Service.findByServiceIDPK", query = "SELECT s FROM Service s WHERE s.serviceIDPK = :serviceIDPK"),
    @NamedQuery(name = "Service.findByImage", query = "SELECT s FROM Service s WHERE s.image = :image"),
    @NamedQuery(name = "Service.findByServicename", query = "SELECT s FROM Service s WHERE s.servicename = :servicename"),
    @NamedQuery(name = "Service.findByDescription", query = "SELECT s FROM Service s WHERE s.description = :description")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "serviceIDPK")
    private Integer serviceIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "servicename")
    private String servicename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "description")
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceIDFK")
    private Collection<Request> requestCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceIDFK")
    private Collection<Mechanic> mechanicCollection;

    public Service() {
    }

    public Service(Integer serviceIDPK) {
        this.serviceIDPK = serviceIDPK;
    }

    public Service(Integer serviceIDPK, String image, String servicename, String description) {
        this.serviceIDPK = serviceIDPK;
        this.image = image;
        this.servicename = servicename;
        this.description = description;
    }

    public Integer getServiceIDPK() {
        return serviceIDPK;
    }

    public void setServiceIDPK(Integer serviceIDPK) {
        this.serviceIDPK = serviceIDPK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (serviceIDPK != null ? serviceIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.serviceIDPK == null && other.serviceIDPK != null) || (this.serviceIDPK != null && !this.serviceIDPK.equals(other.serviceIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Service[ serviceIDPK=" + serviceIDPK + " ]";
    }
    
}
