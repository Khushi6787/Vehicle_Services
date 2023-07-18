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
@Table(name = "payment")
@NamedQueries({
    @NamedQuery(name = "Payment.findAll", query = "SELECT p FROM Payment p"),
    @NamedQuery(name = "Payment.findByPaymentIDPK", query = "SELECT p FROM Payment p WHERE p.paymentIDPK = :paymentIDPK"),
    @NamedQuery(name = "Payment.findByBookingname", query = "SELECT p FROM Payment p WHERE p.bookingname = :bookingname"),
    @NamedQuery(name = "Payment.findByPaymenttype", query = "SELECT p FROM Payment p WHERE p.paymenttype = :paymenttype"),
    @NamedQuery(name = "Payment.findByStatus", query = "SELECT p FROM Payment p WHERE p.status = :status")})
public class Payment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentIDPK")
    private Integer paymentIDPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "bookingname")
    private String bookingname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "paymenttype")
    private String paymenttype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "bookingIDFK", referencedColumnName = "bookingIDPK")
    @ManyToOne(optional = false)
    private Booking bookingIDFK;

    public Payment() {
    }

    public Payment(Integer paymentIDPK) {
        this.paymentIDPK = paymentIDPK;
    }

    public Payment(Integer paymentIDPK, String bookingname, String paymenttype, String status) {
        this.paymentIDPK = paymentIDPK;
        this.bookingname = bookingname;
        this.paymenttype = paymenttype;
        this.status = status;
    }

    public Integer getPaymentIDPK() {
        return paymentIDPK;
    }

    public void setPaymentIDPK(Integer paymentIDPK) {
        this.paymentIDPK = paymentIDPK;
    }

    public String getBookingname() {
        return bookingname;
    }

    public void setBookingname(String bookingname) {
        this.bookingname = bookingname;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Booking getBookingIDFK() {
        return bookingIDFK;
    }

    public void setBookingIDFK(Booking bookingIDFK) {
        this.bookingIDFK = bookingIDFK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentIDPK != null ? paymentIDPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Payment)) {
            return false;
        }
        Payment other = (Payment) object;
        if ((this.paymentIDPK == null && other.paymentIDPK != null) || (this.paymentIDPK != null && !this.paymentIDPK.equals(other.paymentIDPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Payment[ paymentIDPK=" + paymentIDPK + " ]";
    }
    
}
