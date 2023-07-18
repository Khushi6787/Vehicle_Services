/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Auth;
import entity.Request;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "authCDIBean")
@SessionScoped
public class authCDIBean implements Serializable {

    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Auth> auth;
    GenericType<List<Auth>> gauth;
    Collection<Auth> a1;
    int authIDPK;
    int userIDFK;
    String username;
    String email;
    String password;
    String usertype;

    public int getAuthIDPK() {
        return authIDPK;
    }

    public void setAuthIDPK(int authIDPK) {
        this.authIDPK = authIDPK;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    /**
     * Creates a new instance of authCDIBean
     */
    public authCDIBean() {
        userIDFK = 0;
        username = "";
        email = "";
        password = "";
        usertype = "";
    }

    public Collection<Auth> findallauths() {

        return this.abl.findallauth();
    }

    public String addAuth() {
        try {
            abl.addAuth(userIDFK, username, email, password, usertype);
            //requestIDPK = 0;
            userIDFK = 0;
            username = "";
            email = "";
            password = "";
            usertype = "";
            return "showAuth.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String goToDisplay() {
        authIDPK = 0;
        userIDFK = 0;
        username = "";
        email = "";
        password = "";
        usertype = "";
        return "showAuth.xhtml?faces-redirect=true;";
    }
}
