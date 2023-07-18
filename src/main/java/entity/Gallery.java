/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author KHUSHI
 */
@Entity
@Table(name = "gallery")
@NamedQueries({
    @NamedQuery(name = "Gallery.findAll", query = "SELECT g FROM Gallery g"),
    @NamedQuery(name = "Gallery.findByGalleryIDPK", query = "SELECT g FROM Gallery g WHERE g.galleryIDPK = :galleryIDPK"),
    @NamedQuery(name = "Gallery.findByImage", query = "SELECT g FROM Gallery g WHERE g.image = :image"),
    @NamedQuery(name = "Gallery.findByMechanicname", query = "SELECT g FROM Gallery g WHERE g.mechanicname = :mechanicname")})
public class Gallery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "galleryIDPK")
    private Integer galleryIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mechanicname")
    private String mechanicname;
    @JoinColumn(name = "mechanicIDFK", referencedColumnName = "mechanicIDPK")
    @ManyToOne(optional = false)
    private Mechanic mechanicIDFK;

    public Gallery() {
    }

    public Gallery(Integer galleryIDPK) {
        this.galleryIDPK = galleryIDPK;
    }

    public Gallery(Integer galleryIDPK, String image, String mechanicname) {
        this.galleryIDPK = galleryIDPK;
        this.image = image;
        this.mechanicname = mechanicname;
    }

    public Integer getGalleryIDPK() {
        return galleryIDPK;
    }

    public void setGalleryIDPK(Integer galleryIDPK) {
        this.galleryIDPK = galleryIDPK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public Mechanic getMechanicIDFK() {
        return mechanicIDFK;
    }

    public void setMechanicIDFK(Mechanic mechanicIDFK) {
        this.mechanicIDFK = mechanicIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (galleryIDPK != null ? galleryIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gallery)) {
            return false;
        }
        Gallery other = (Gallery) object;
        if ((this.galleryIDPK == null && other.galleryIDPK != null) || (this.galleryIDPK != null && !this.galleryIDPK.equals(other.galleryIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Gallery[ galleryIDPK=" + galleryIDPK + " ]";
    }
    
}
