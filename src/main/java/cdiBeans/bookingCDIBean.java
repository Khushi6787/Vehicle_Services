/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Booking;
import entity.Booking;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "bookingCDIBean")
@SessionScoped
public class bookingCDIBean implements Serializable {

    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Booking> booking;
    GenericType<List<Booking>> grbooking;
    Collection<Booking> b1;

    int bookingIDPK;
    int requestIDFK;
    String requestname;
    String status;
    Date date;
    Time time;

    public int getBookingIDPK() {
        return bookingIDPK;
    }

    public void setBookingIDPK(int bookingIDPK) {
        this.bookingIDPK = bookingIDPK;
    }

    public int getBookingIDFK() {
        return requestIDFK;
    }

    public void setBookingIDFK(int requestIDFK) {
        this.requestIDFK = requestIDFK;
    }

    public String getBookingname() {
        return requestname;
    }

    public void setBookingname(String requestname) {
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    /**
     * Creates a new instance of bookingCDIBean
     */
    public bookingCDIBean() {
        bookingIDPK = 0;
        requestIDFK = 0;
        requestname = "";
        status = "";
        date = null;
        time = null;
    }

    public Collection<Booking> findallbooking() {

        return this.abl.findallbooking();
    }

    public String addBooking() {
        try {
            abl.addBooking(requestIDFK, requestname, status, date, time);
            bookingIDPK = 0;
            requestIDFK = 0;
            requestname = "";
            status = "";
            date = null;
            time = null;
            return "showBooking.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public int getRequestIDFK() {
        return requestIDFK;
    }

    public void setRequestIDFK(int requestIDFK) {
        this.requestIDFK = requestIDFK;
    }

    public String getRequestname() {
        return requestname;
    }

    public void setRequestname(String requestname) {
        this.requestname = requestname;
    }

    public String updateBooking() {
        try {

            abl.updateBooking(bookingIDPK, requestIDFK, requestname, status, date, time);
            bookingIDPK = 0;
            requestIDFK = 0;
            requestname = "";
            status = "";
            date = null;
            time = null;
            return "showBooking.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String editBooking(int id) {
        Booking r1 = abl.getBooking(id);
        bookingIDPK = r1.getBookingIDPK();
        requestIDFK = r1.getRequestIDFK().getRequestIDPK();
        requestname = r1.getRequestname();
        status = r1.getStatus();
        date = r1.getDate();
        time = (Time) r1.getTime();
        return "addBooking.xhtml?faces-redirect=true;";
    }

    public String deleteBooking(int requestIDPK) {
        this.ac.removeBooking(bookingIDPK);
        return "showBooking.xhtml?faces-redirect=true;";
    }

    public String goToDisplay() {
        bookingIDPK = 0;
        requestIDFK = 0;
        requestname = "";
        status = "";
        date = null;
        time = null;
        return "showBooking.xhtml?faces-redirect=true;";
    }

}
