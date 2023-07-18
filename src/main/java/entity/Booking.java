/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author KHUSHI
 */
@Entity
@Table(name = "booking")
@NamedQueries({
    @NamedQuery(name = "Booking.findAll", query = "SELECT b FROM Booking b"),
    @NamedQuery(name = "Booking.findByBookingIDPK", query = "SELECT b FROM Booking b WHERE b.bookingIDPK = :bookingIDPK"),
    @NamedQuery(name = "Booking.findByRequestname", query = "SELECT b FROM Booking b WHERE b.requestname = :requestname"),
    @NamedQuery(name = "Booking.findByStatus", query = "SELECT b FROM Booking b WHERE b.status = :status"),
    @NamedQuery(name = "Booking.findByDate", query = "SELECT b FROM Booking b WHERE b.date = :date"),
    @NamedQuery(name = "Booking.findByTime", query = "SELECT b FROM Booking b WHERE b.time = :time")})
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookingIDPK")
    private Integer bookingIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "requestname")
    private String requestname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.TIME)
    private Date time;
    @JoinColumn(name = "requestIDFK", referencedColumnName = "requestIDPK")
    @ManyToOne(optional = false)
    private Request requestIDFK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bookingIDFK")
    private Collection<Payment> paymentCollection;

    public Booking() {
    }

    public Booking(Integer bookingIDPK) {
        this.bookingIDPK = bookingIDPK;
    }

    public Booking(Integer bookingIDPK, String requestname, String status, Date date, Date time) {
        this.bookingIDPK = bookingIDPK;
        this.requestname = requestname;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public Integer getBookingIDPK() {
        return bookingIDPK;
    }

    public void setBookingIDPK(Integer bookingIDPK) {
        this.bookingIDPK = bookingIDPK;
    }

    public String getRequestname() {
        return requestname;
    }

    public void setRequestname(String requestname) {
        this.requestname = requestname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Request getRequestIDFK() {
        return requestIDFK;
    }

    public void setRequestIDFK(Request requestIDFK) {
        this.requestIDFK = requestIDFK;
    }

    public Collection<Payment> getPaymentCollection() {
        return paymentCollection;
    }

    public void setPaymentCollection(Collection<Payment> paymentCollection) {
        this.paymentCollection = paymentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bookingIDPK != null ? bookingIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Booking)) {
            return false;
        }
        Booking other = (Booking) object;
        if ((this.bookingIDPK == null && other.bookingIDPK != null) || (this.bookingIDPK != null && !this.bookingIDPK.equals(other.bookingIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Booking[ bookingIDPK=" + bookingIDPK + " ]";
    }
    
}
