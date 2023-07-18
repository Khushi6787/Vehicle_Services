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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "mechanic")
@NamedQueries({
    @NamedQuery(name = "Mechanic.findAll", query = "SELECT m FROM Mechanic m"),
    @NamedQuery(name = "Mechanic.findByMechanicIDPK", query = "SELECT m FROM Mechanic m WHERE m.mechanicIDPK = :mechanicIDPK"),
    @NamedQuery(name = "Mechanic.findByImage", query = "SELECT m FROM Mechanic m WHERE m.image = :image"),
    @NamedQuery(name = "Mechanic.findByServicename", query = "SELECT m FROM Mechanic m WHERE m.servicename = :servicename"),
    @NamedQuery(name = "Mechanic.findByMechanicname", query = "SELECT m FROM Mechanic m WHERE m.mechanicname = :mechanicname"),
    @NamedQuery(name = "Mechanic.findByGender", query = "SELECT m FROM Mechanic m WHERE m.gender = :gender"),
    @NamedQuery(name = "Mechanic.findByAreaname", query = "SELECT m FROM Mechanic m WHERE m.areaname = :areaname"),
    @NamedQuery(name = "Mechanic.findBySkill", query = "SELECT m FROM Mechanic m WHERE m.skill = :skill"),
    @NamedQuery(name = "Mechanic.findByExperience", query = "SELECT m FROM Mechanic m WHERE m.experience = :experience"),
    @NamedQuery(name = "Mechanic.findByCostperhour", query = "SELECT m FROM Mechanic m WHERE m.costperhour = :costperhour"),
    @NamedQuery(name = "Mechanic.findByRatings", query = "SELECT m FROM Mechanic m WHERE m.ratings = :ratings")})
public class Mechanic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mechanicIDPK")
    private Integer mechanicIDPK;
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
    @Column(name = "mechanicname")
    private String mechanicname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "areaname")
    private String areaname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "skill")
    private String skill;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "experience")
    private String experience;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "costperhour")
    private String costperhour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ratings")
    private int ratings;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mechanicIDFK")
    private Collection<Request> requestCollection;
    @JoinColumn(name = "serviceIDFK", referencedColumnName = "serviceIDPK")
    @ManyToOne(optional = false)
    private Service serviceIDFK;
    @JoinColumn(name = "areaIDFK", referencedColumnName = "areaIDPK")
    @ManyToOne(optional = false)
    private Area areaIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mechanicIDFK")
    private Collection<Gallery> galleryCollection;

    public Mechanic() {
    }

    public Mechanic(Integer mechanicIDPK) {
        this.mechanicIDPK = mechanicIDPK;
    }

    public Mechanic(Integer mechanicIDPK, String image, String servicename, String mechanicname, String gender, String areaname, String skill, String experience, String costperhour, int ratings) {
        this.mechanicIDPK = mechanicIDPK;
        this.image = image;
        this.servicename = servicename;
        this.mechanicname = mechanicname;
        this.gender = gender;
        this.areaname = areaname;
        this.skill = skill;
        this.experience = experience;
        this.costperhour = costperhour;
        this.ratings = ratings;
    }

    public Integer getMechanicIDPK() {
        return mechanicIDPK;
    }

    public void setMechanicIDPK(Integer mechanicIDPK) {
        this.mechanicIDPK = mechanicIDPK;
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

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCostperhour() {
        return costperhour;
    }

    public void setCostperhour(String costperhour) {
        this.costperhour = costperhour;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Collection<Request> getRequestCollection() {
        return requestCollection;
    }

    public void setRequestCollection(Collection<Request> requestCollection) {
        this.requestCollection = requestCollection;
    }

    public Service getServiceIDFK() {
        return serviceIDFK;
    }

    public void setServiceIDFK(Service serviceIDFK) {
        this.serviceIDFK = serviceIDFK;
    }

    public Area getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(Area areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public Collection<Gallery> getGalleryCollection() {
        return galleryCollection;
    }

    public void setGalleryCollection(Collection<Gallery> galleryCollection) {
        this.galleryCollection = galleryCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mechanicIDPK != null ? mechanicIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mechanic)) {
            return false;
        }
        Mechanic other = (Mechanic) object;
        if ((this.mechanicIDPK == null && other.mechanicIDPK != null) || (this.mechanicIDPK != null && !this.mechanicIDPK.equals(other.mechanicIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mechanic[ mechanicIDPK=" + mechanicIDPK + " ]";
    }
    
}
