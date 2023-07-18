/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Feedback;
import entity.Service;
import entity.User;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "userCDIBean")
@SessionScoped
public class userCDIBean implements Serializable{
    @EJB
    adminBeanLocal abl;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
    adminClient ac = new adminClient();
    Response rs;
    List<User> user;
    GenericType<List<User>> guser;
    Collection<User> user1;
    int userIDPK;
    String username;
    String address;
    String email;
    String mobileno;
    String password;
    String usertype;
    String mechanicname;
    /**
     * Creates a new instance of userCDIBean
     */
    public userCDIBean() {
        username="";
        address="";
        email ="";
        mobileno="";
        password="";
        usertype="";
         mechanicname="";
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
    
     public Collection<User> findalluser() {

        return this.abl.findalluser();
    }
     
     
    public Collection<Feedback> findallfeedback() {

        return this.abl.findallfeedback();
    }
     
    public String addUser() {
        //this.ac.addUser(username, address, email, mobileno);
        abl.addUser(username, address, email, mobileno, password, usertype);
        userIDPK=0;
        username = "";
        address="";
        email="";
        mobileno="";
        password="";
        usertype="";
        return "showUsers.xhtml";

    }

    public String deleteUser(int userIDPK) {
        this.ac.removeUser(userIDPK);
        return "showUsers.xhtml";
    }

    public String updateUser() {
        //this.ac.updateUser(username, username, address, email, mobileno);
        abl.updateUser(userIDPK, username, address, email, mobileno,password,usertype);
        userIDPK=0;
        username = "";
        address="";
        email="";
        mobileno="";
         password="";
        usertype="";
        return "showUsers.xhtml?faces-redirect=true;";
    }

    public String editUser(int id) {
        //User user1 = this.ac.getUser(userIDPK);
        User user1 = abl.getUser(id);
        userIDPK = user1.getUserIDPK();
        username = user1.getUsername();
        address = user1.getAddress();
        email = user1.getEmail();
        mobileno = user1.getMobileno();
         password=user1.getPassword();
        usertype=user1.getUsertype();
        return "addUsers.xhtml?faces-redirect=true;";
    }
    
    public String goToDisplay()
    {
        userIDPK=0;
        username = "";
        address="";
        email="";
        mobileno="";
         password="";
        usertype="";
        return "showUsers.xhtml?faces-redirect=true;";
    }
    
    
}
