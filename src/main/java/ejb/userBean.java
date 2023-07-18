/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Area;
import entity.Auth;
import entity.Booking;
import entity.Gallery;
import entity.Mechanic;
import entity.Request;
import entity.Service;
import entity.User;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author KHUSHI
 */
@Stateless
public class userBean implements userBeanLocal {

    @PersistenceContext(unitName = "vehiclejndi")
    EntityManager em;

     @Inject
    private Pbkdf2PasswordHash PasswordHash;
     
    @Override
    public User getUser(int UserIDPK) {
        return em.find(User.class,UserIDPK);
    }

    @Override
    public Collection<Area> findallarea() {
        return em.createNamedQuery("Area.findAll").getResultList();
    }

    @Override
    public Collection<Gallery> findallgallery() {
        try {
            Collection<Gallery> gallery = em.createNamedQuery("Gallery.findAll").getResultList();
            if (!gallery.isEmpty()) {
                return gallery;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<Service> findallservice() {
        try {
            Collection<Service> service = em.createNamedQuery("Service.findAll").getResultList();
            if (!service.isEmpty()) {
                return service;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Mechanic> findallmechanic() {
        try {
            Collection<Mechanic> mech = em.createNamedQuery("Mechanic.findAll").getResultList();
            if (!mech.isEmpty()) {
                return mech;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public Collection<User> findalluser() {
        try {
            Collection<User> user = em.createNamedQuery("User.findAll").getResultList();
            if (!user.isEmpty()) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }
    
    @Override
    public Collection<Request> findallrequests() {
        try {
            Collection<Request> req = em.createNamedQuery("Request.findAll").getResultList();
            if (!req.isEmpty()) {
                return req;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }
    
     @Override
    public Collection<Booking> findallbooking() {
        try {
            Collection<Booking> b = em.createNamedQuery("Booking.findAll").getResultList();
            if (!b.isEmpty()) {
                return b;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public void addUser(String username, String address, String email, String mobileno, String password, String usertype) {
        try {
            User user = new User();
            user.setUserIDPK(0);
            user.setUsername(username);
            user.setAddress(address);
            user.setEmail(email);
            user.setMobileno(mobileno);
           // String HashPassword = PasswordHash.generate(password.toCharArray());
            user.setPassword(password);
            user.setUsertype("User");
            em.persist(user);
            //List<User> userList =em.createNamedQuery("User.findAll").getResultList();

        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());
        }
    }
    
    
     @Override
    public void updateUser(int userIDPK, String username, String address, String email, String mobileno,String password,String usertype) {
        try {
            User user = em.find(User.class, userIDPK);
            user.setUsername(username);
            user.setAddress(address);
            user.setEmail(email);
            user.setMobileno(mobileno);
            user.setPassword(password);
            user.setUsertype(usertype);
            em.merge(user);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }

    }

    
     @Override
    public User login(String email, String password) {
        User a = (User) em.createNamedQuery("User.findByUser").setParameter("email", email)
                .setParameter("password", password)
                .getSingleResult();
        return a;
    }

    @Override
    public void addAppointment(int areaIDFK, String areaname, int serviceIDFK, String servicename, String requestname, int userIDFK, String username, int mechanicIDFK, String mechanicname, String status, String payment) {
        System.out.println("Test");
        try {
            Request request = new Request();
            Service service = em.find(Service.class, serviceIDFK);
            Area area = em.find(Area.class, areaIDFK);
            User user = em.find(User.class, userIDFK);
            Mechanic mechanic = em.find(Mechanic.class, mechanicIDFK);
            request.setAreaIDFK(area);
            request.setAreaname(area.getAreaname());
            request.setServiceIDFK(service);
            request.setServicename(service.getServicename());
            request.setRequestname(requestname);
            request.setUserIDFK(user);
            request.setUsername(user.getUsername());
            request.setMechanicIDFK(mechanic);
            request.setMechanicname(mechanic.getMechanicname());
            request.setStatus(status);
            request.setCost("0");
            request.setPayment(payment);
            em.persist(request);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());

        }
    }


}
