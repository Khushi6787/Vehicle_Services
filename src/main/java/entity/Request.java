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
@Table(name = "request")
@NamedQueries({
    @NamedQuery(name = "Request.findAll", query = "SELECT r FROM Request r"),
    @NamedQuery(name = "Request.findByRequestIDPK", query = "SELECT r FROM Request r WHERE r.requestIDPK = :requestIDPK"),
    @NamedQuery(name = "Request.findByAreaname", query = "SELECT r FROM Request r WHERE r.areaname = :areaname"),
    @NamedQuery(name = "Request.findByServicename", query = "SELECT r FROM Request r WHERE r.servicename = :servicename"),
    @NamedQuery(name = "Request.findByRequestname", query = "SELECT r FROM Request r WHERE r.requestname = :requestname"),
    @NamedQuery(name = "Request.findByUsername", query = "SELECT r FROM Request r WHERE r.username = :username"),
    @NamedQuery(name = "Request.findByMechanicname", query = "SELECT r FROM Request r WHERE r.mechanicname = :mechanicname"),
    @NamedQuery(name = "Request.findByStatus", query = "SELECT r FROM Request r WHERE r.status = :status"),
    @NamedQuery(name = "Request.findByCost", query = "SELECT r FROM Request r WHERE r.cost = :cost"),
    @NamedQuery(name = "Request.findByPayment", query = "SELECT r FROM Request r WHERE r.payment = :payment")})
public class Request implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "requestIDPK")
    private Integer requestIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "areaname")
    private String areaname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "servicename")
    private String servicename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "requestname")
    private String requestname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mechanicname")
    private String mechanicname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 210)
    @Column(name = "cost")
    private String cost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "payment")
    private String payment;
    @JoinColumn(name = "mechanicIDFK", referencedColumnName = "mechanicIDPK")
    @ManyToOne(optional = false)
    private Mechanic mechanicIDFK;
    @JoinColumn(name = "serviceIDFK", referencedColumnName = "serviceIDPK")
    @ManyToOne(optional = false)
    private Service serviceIDFK;
    @JoinColumn(name = "userIDFK", referencedColumnName = "userIDPK")
    @ManyToOne(optional = false)
    private User userIDFK;
    @JoinColumn(name = "areaIDFK", referencedColumnName = "areaIDPK")
    @ManyToOne(optional = false)
    private Area areaIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestIDFK")
    private Collection<Booking> bookingCollection;

    public Request() {
    }

    public Request(Integer requestIDPK) {
        this.requestIDPK = requestIDPK;
    }

    public Request(Integer requestIDPK, String areaname, String servicename, String requestname, String username, String mechanicname, String status, String cost, String payment) {
        this.requestIDPK = requestIDPK;
        this.areaname = areaname;
        this.servicename = servicename;
        this.requestname = requestname;
        this.username = username;
        this.mechanicname = mechanicname;
        this.status = status;
        this.cost = cost;
        this.payment = payment;
    }

    public Integer getRequestIDPK() {
        return requestIDPK;
    }

    public void setRequestIDPK(Integer requestIDPK) {
        this.requestIDPK = requestIDPK;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getRequestname() {
        return requestname;
    }

    public void setRequestname(String requestname) {
        this.requestname = requestname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Mechanic getMechanicIDFK() {
        return mechanicIDFK;
    }

    public void setMechanicIDFK(Mechanic mechanicIDFK) {
        this.mechanicIDFK = mechanicIDFK;
    }

    public Service getServiceIDFK() {
        return serviceIDFK;
    }

    public void setServiceIDFK(Service serviceIDFK) {
        this.serviceIDFK = serviceIDFK;
    }

    public User getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(User userIDFK) {
        this.userIDFK = userIDFK;
    }

    public Area getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(Area areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public Collection<Booking> getBookingCollection() {
        return bookingCollection;
    }

    public void setBookingCollection(Collection<Booking> bookingCollection) {
        this.bookingCollection = bookingCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestIDPK != null ? requestIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Request)) {
            return false;
        }
        Request other = (Request) object;
        if ((this.requestIDPK == null && other.requestIDPK != null) || (this.requestIDPK != null && !this.requestIDPK.equals(other.requestIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Request[ requestIDPK=" + requestIDPK + " ]";
    }
    
}
