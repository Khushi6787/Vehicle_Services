/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import ejb.adminBeanLocal;
import ejb.userBeanLocal;
import entity.Area;
import entity.Auth;
import entity.Booking;
import entity.Gallery;
import entity.Mechanic;
import entity.Request;
import entity.Service;
import entity.User;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "userSide")
@SessionScoped
public class userSide implements Serializable {

    @EJB
    userBeanLocal abl;
    Response rs;
    List<Area> area;
    GenericType<List<Area>> garea;
    Collection<Area> area1;
    Collection<Service> services;
    Collection<Gallery> mygallery;
    Collection<User> users;
    Collection<Auth> auths;
    Collection<Mechanic> mech;
    
    String username;
    int userIDPK;
    String address;
    String email;
    String mobileno;
    String password;
    String usertype;
    String message;
    int userIDFK;
    List<Request> request;
    GenericType<List<Request>> grequest;
    Collection<Request> r1;
    int requestIDPK;
    int areaIDFK;
    String areaname;
    int serviceIDFK;
    String servicename;
    String requestname;
    String mechanicname;
    int mechanicIDFK;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    String status;

    /**
     * Creates a new instance of userSide
     */
    public userSide() {
        services = new ArrayList<>();
        mygallery = new ArrayList<>();
        users = new ArrayList<>();
        auths = new ArrayList<>();
        userIDPK = 0;
        username = "";
        address = "";
        email = "";
        mobileno = "";
        password = "";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserIDPK() {
        return userIDPK;
    }

    public void setUserIDPK(int userIDPK) {
        this.userIDPK = userIDPK;
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

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    public Collection<Service> getServices() {
        return this.abl.findallservice();
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    public Collection<Area> findallarea() {
        return this.abl.findallarea();
    }
    
     public Collection<Mechanic> findallmechanic() {
        return this.abl.findallmechanic();
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public int getUserIDFK() {
        return userIDFK;
    }

    public void setUserIDFK(int userIDFK) {
        this.userIDFK = userIDFK;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public int getMechanicIDFK() {
        return mechanicIDFK;
    }

    public void setMechanicIDFK(int mechanicIDFK) {
        this.mechanicIDFK = mechanicIDFK;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }
    
    public Collection<User> findalluser() {
        return this.abl.findalluser();
    }

    public Collection<Service> findallservice() {

        return this.abl.findallservice();
    } 
    
    public Collection<Gallery> findallgallery() {

        return this.abl.findallgallery();
    } 
    
    public Collection<Request> findallrequests() {

        return this.abl.findallrequests();
    } 
    
    public Collection<Booking> findallbooking() {

        return this.abl.findallbooking();
    } 
    
    
    public Collection<Gallery> getMygallery() {
        return mygallery;
    }

    public void setMygallery(Collection<Gallery> mygallery) {
        this.mygallery = mygallery;
    }

    HttpServletRequest httpRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

    HttpSession authSession = httpRequest.getSession();

    
    public String addUser() {
        try {
            //this.ac.addUser(username, address, email, mobileno);
            abl.addUser(username, address, email, mobileno, password, usertype);
            //abl.addAuth(userIDFK, username, email, password, usertype);
            userIDPK = 0;
            username = "";
            address = "";
            email = "";
            mobileno = "";
            password = "";
            usertype="";
            
            return "login?faces-redirect = true";

        } catch (Exception e) {
            return e.getMessage();
        }

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
        return "user/index.xhtml?faces-redirect=true;";
    }

    public String editUser(int id) {
        getUser(id);
        return "user/profile.xhtml?faces-redirect=true;";
    }
    
    public void getUser(int id) {
          //User user1 = this.ac.getUser(userIDPK);
        User user1 = abl.getUser(id);
        userIDPK = user1.getUserIDPK();
        username = user1.getUsername();
        address = user1.getAddress();
        email = user1.getEmail();
        mobileno = user1.getMobileno();
         password=user1.getPassword();
        usertype=user1.getUsertype();
    }
    
    public String addAppointment() {
        try {
            abl.addAppointment(areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDPK, username, mechanicIDFK, mechanicname, "0", "0");
            
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
            status="0";
            payment = "0";

            return "user/showServices.xhtml?faces-redirect=true;";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
    public String login() {
        try {
            User a = abl.login(email, password);

            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

            HttpSession authSession = request.getSession();

            authSession.setAttribute("userIDPK", a.getUserIDPK().toString());
            authSession.setAttribute("email", a.getEmail());
            //authSession.setAttribute("password", a.getAuthPassword());
            authSession.setAttribute("userType", a.getUsertype());

            //if(am.getUserType().equals("admin") || am.getUserType().equals("employee"))
            //String authIDPK = (String) authSession.getAttribute("authIDPK");
            getUser(a.getUserIDPK());
            loginClear();
           
            if (a.getUsertype().equalsIgnoreCase("Admin")) {
                message = "";
                return "/admin/index.xhtml?faces-redirect=true";
            } else if (a.getUsertype().equalsIgnoreCase("User")) {
                message = "";
                return "/index.xhtml?faces-redirect=true";
            } else {
                message = "username and password incorrect";

                return "/login.xhtml?faces-redirect=true";

            }
            
        } catch (Exception e) {
            message = "username and password incorrect";
        }
        
        return null;
    }

    public String logout() {
        try {
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
            HttpSession authSession = request.getSession();
            authSession.invalidate();

            loginClear();
            return "login.xhtml?faces-redirect=true";

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void loginClear() {
        email = "";
        password = "";
    }

}
