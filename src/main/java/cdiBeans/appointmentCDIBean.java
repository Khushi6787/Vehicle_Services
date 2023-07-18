/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Request;
import entity.Request;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "appointmentCDIBean")
@SessionScoped
public class appointmentCDIBean implements Serializable {

    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Request> request;
    GenericType<List<Request>> grequest;
    Collection<Request> r1;
    int requestIDPK;
    int areaIDFK;
    String areaname;
    int serviceIDFK;
    String servicename;
    String requestname;
    int userIDFK;
    String username;
    String status;
    String payemnt;
    String cost;

    public String getPayemnt() {
        return payemnt;
    }

    public void setPayemnt(String payemnt) {
        this.payemnt = payemnt;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    int mechanicIDFK;
    String mechanicname;

    public int getMechanicIDFK() {
        return mechanicIDFK;
    }

    public void setMechanicIDFK(int mechanicIDFK) {
        this.mechanicIDFK = mechanicIDFK;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }
    String payment;

    public int getRequestIDPK() {
        return requestIDPK;
    }

    public void setRequestIDPK(int requestIDPK) {
        this.requestIDPK = requestIDPK;
    }

    public int getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(int areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public int getServiceIDFK() {
        return serviceIDFK;
    }

    public void setServiceIDFK(int serviceIDFK) {
        this.serviceIDFK = serviceIDFK;
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

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

   

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * Creates a new instance of appointmentCDIBean
     */
    public appointmentCDIBean() {
        requestIDPK = 0;
        areaIDFK = 0;
        areaname = "";
        serviceIDFK = 0;
        servicename = "";
        requestname = "";
        userIDFK = 0;
        username = "";
        mechanicIDFK = 0;
        mechanicname = "";
         status="";
        payment = "";
        cost="";

    }

    public Collection<Request> findallrequest() {

        return this.abl.findallrequest();
    }

    public String addRequest() {
        try {
            abl.addRequest(areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname, status,payment,cost);
            //requestIDPK = 0;
            areaIDFK = 0;
            areaname = "";
            serviceIDFK = 0;
            servicename = "";
            requestname = "";
            userIDFK = 0;
            username = "";
            mechanicIDFK = 0;
            mechanicname = "";
            status="";
            payment = "";
            cost="";

            return "showAppointment.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String updateRequest() {
        try {

            abl.updateRequest(requestIDPK, areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname, status,payment,cost);
            requestIDPK = 0;
            areaIDFK = 0;
            areaname = "";
            serviceIDFK = 0;
            servicename = "";
            requestname = "";
            userIDFK = 0;
            username = "";
            mechanicIDFK = 0;
            mechanicname = "";
             status="";
            payment = "";
            cost="";
            return "showAppointment.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

     public String updateStatus() {
        try {

            abl.updateStatus(requestIDPK, status, cost);
            requestIDPK = 0;
            status="";
            payment = "";
            cost="";
            return "showAppointment.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String editRequest(int id) {
        Request r1 = abl.getRequest(id);
        requestIDPK = r1.getRequestIDPK();
        areaIDFK = r1.getAreaIDFK().getAreaIDPK();
        areaname = r1.getAreaname();
        serviceIDFK = r1.getServiceIDFK().getServiceIDPK();
        servicename = r1.getServicename();
        requestname = r1.getRequestname();
        userIDFK = r1.getUserIDFK().getUserIDPK();
        username = r1.getUsername();
        mechanicIDFK = r1.getMechanicIDFK().getMechanicIDPK();
        mechanicname = r1.getMechanicname();
         status=r1.getStatus();
        payment = r1.getPayment();
        cost=r1.getCost();
        return "addAppointment.xhtml?faces-redirect=true;";
    }

    public String deleteRequest(int requestIDPK) {
        this.ac.removeRequest(requestIDPK);
        return "showAppointment.xhtml?faces-redirect=true;";
    }

    public String goToDisplay() {
        requestIDPK = 0;
        areaIDFK = 0;
        areaname = "";
        serviceIDFK = 0;
        servicename = "";
        requestname = "";
        userIDFK = 0;
        username = "";
        mechanicIDFK = 0;
        mechanicname = "";
         status="";
        payment = "";
        cost="";
        return "showAppointment.xhtml?faces-redirect=true;";
    }
}
