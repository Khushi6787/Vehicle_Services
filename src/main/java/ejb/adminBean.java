/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.*;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.mail.Part;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author KHUSHI
 */
@Stateless
public class adminBean implements adminBeanLocal {

    @PersistenceContext(unitName = "vehiclejndi")
    private EntityManager em;
    Part file;
    String grfile;
    
    @Inject
    private Pbkdf2PasswordHash PasswordHash;
    //area
    @Override
    public Collection<Area> findallarea() {
        try {
            Collection<Area> area = em.createNamedQuery("Area.findAll").getResultList();
            if (!area.isEmpty()) {
                return area;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public void addArea(String areaname, int pincode) {
        try {
            Area area = new Area();
            area.setAreaIDPK(0);
            area.setAreaname(areaname);
            area.setPincode(pincode);

            em.persist(area);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());
        }
    }

    @Override
    public void updateArea(int areaIDPK, String areaname, int pincode) {
        try {
            Area area = em.find(Area.class, areaIDPK);
            area.setAreaname(areaname);
            area.setPincode(pincode);
            em.merge(area);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }

    }

    @Override
    public void removeArea(int areaIDPK) {
        try {
            Area area = em.find(Area.class, areaIDPK);
            em.remove(area);
        } catch (Exception e) {
            System.err.println("Delete Error" + e.getMessage());
        }
    }

    @Override
    public Area getArea(int areaIDPK) {
        try {
            Area area = em.find(Area.class, areaIDPK);
            if (area.getAreaIDPK() != 0) {
                return area;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    //for user
    @Override
    public void addUser(String username, String address, String email, String mobileno,String password,String usertype) {
        try {
            User user = new User();
            user.setUsername(username);
            user.setAddress(address);
            user.setEmail(email);
            user.setMobileno(mobileno);
            user.setPassword(password);
            user.setUsertype(usertype);
            em.persist(user);
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
    public void removeUser(int userIDPK) {
        try {
            User user = em.find(User.class, userIDPK);
            em.remove(user);
        } catch (Exception e) {
            System.err.println("Delete Error" + e.getMessage());
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
    public User getUser(int userIDPK) {
        try {
            User user = em.find(User.class, userIDPK);
            if (user.getUserIDPK() != 0) {
                return user;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void addService(String image, String servicename, String description) {
        try {
            Service service = new Service();

            service.setImage(image);
            service.setServicename(servicename);
            service.setDescription(description);
            em.persist(service);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());
        }

    }

    @Override
    public void updateService(int serviceIDPK, String image, String servicename, String description) {
        try {
            Service service = em.find(Service.class, serviceIDPK);
            service.setImage(image);
            service.setServicename(servicename);
            service.setDescription(description);
            em.merge(service);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }
    }

    @Override
    public void removeService(int serviceIDPK) {
        try {
            Service service = em.find(Service.class, serviceIDPK);
            em.remove(service);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
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
            Collection<Mechanic> mechanic = em.createNamedQuery("Mechanic.findAll").getResultList();
            if (!mechanic.isEmpty()) {
                return mechanic;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public Service getService(int serviceIDPK) {
        try {
            Service service = em.find(Service.class, serviceIDPK);
            if (service.getServiceIDPK() != 0) {
                return service;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Mechanic getMechanic(int mechanicIDPK) {
        try {
            Mechanic mechanic = em.find(Mechanic.class, mechanicIDPK);
            if (mechanic.getMechanicIDPK() != 0) {
                return mechanic;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void addMechanic(String image, int serviceIDFK, String servicename, String mechanicname, String gender, int areaIDFK, String areaname, String skill, String experience, String costperhour, int ratings) {
        try {
            //Collection<Mechanic> mechanic = mechanic

            Service service = em.find(Service.class, serviceIDFK);
            Area area = em.find(Area.class, areaIDFK);
            Mechanic mechanic = new Mechanic();
            mechanic.setMechanicIDPK(0);
            mechanic.setImage(image);
            mechanic.setServiceIDFK(service);
            mechanic.setServicename(service.getServicename());
            mechanic.setMechanicname(mechanicname);
            mechanic.setGender(gender);
            mechanic.setAreaIDFK(area);
            mechanic.setAreaname(area.getAreaname());
            mechanic.setSkill(skill);
            mechanic.setExperience(experience);
            mechanic.setCostperhour(costperhour);
            mechanic.setRatings(ratings);
            em.persist(mechanic);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());
        }

    }

    @Override
    public void updateMechanic(int mechanicIDPK, String image, int serviceIDFK, String servicename, String mechanicname, String gender, int areaIDFK, String areaname, String skill, String experience, String costperhour, int ratings) {
        try {
            Mechanic mechanic = em.find(Mechanic.class, mechanicIDPK);
            Service service = em.find(Service.class, serviceIDFK);
            Area area = em.find(Area.class, areaIDFK);
            mechanic.setImage(image);
            mechanic.setServiceIDFK(service);
            mechanic.setServicename(servicename);
            mechanic.setMechanicname(mechanicname);
            mechanic.setGender(gender);
            mechanic.setAreaIDFK(area);
            mechanic.setAreaname(areaname);
            mechanic.setSkill(skill);
            mechanic.setExperience(experience);
            mechanic.setCostperhour(costperhour);
            mechanic.setRatings(ratings);
            em.merge(mechanic);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }
    }

    @Override
    public void removeMechanic(int mechanicIDPK) {
        try {

            Mechanic mechanic = em.find(Mechanic.class, mechanicIDPK);
            em.remove(mechanic);

        } catch (Exception e) {
            System.err.println("Delete Error" + e.getMessage());
        }

    }

    @Override
    public Request getRequest(int requestIDPK) {
        try {
            Request request = em.find(Request.class, requestIDPK);
            if (request.getRequestIDPK() != 0) {
                return request;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Collection<Request> findallrequest() {
        try {
            Collection<Request> request = em.createNamedQuery("Request.findAll").getResultList();
            if (!request.isEmpty()) {
                return request;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public void addRequest(int areaIDFK, String areaname, int serviceIDFK, String servicename, String requestname, int userIDFK, String username, int mechanicIDFK, String mechanicname, String status, String payment, String cost) {
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
            request.setPayment(payment);
            request.setCost(cost);
            em.persist(request);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());

        }

    }

    @Override
    public void updateRequest(int requestIDPK, int areaIDFK, String areaname, int serviceIDFK, String servicename, String requestname, int userIDFK, String username, int mechanicIDFK, String mechanicname, String status, String payment,String cost) {
        try {
            Request request = em.find(Request.class, requestIDPK);
            Service service = em.find(Service.class, serviceIDFK);
            Area area = em.find(Area.class, areaIDFK);
            User user = em.find(User.class, userIDFK);
            Mechanic mechanic = em.find(Mechanic.class, mechanicIDFK);
            request.setAreaIDFK(area);
            request.setAreaname(areaname);
            request.setServiceIDFK(service);
            request.setServicename(servicename);
            request.setRequestname(requestname);
            request.setUserIDFK(user);
            request.setUsername(username);
            request.setMechanicIDFK(mechanic);
            request.setMechanicname(mechanicname);
            request.setStatus(status);
            request.setPayment(payment);
            request.setCost(cost);
            em.merge(request);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }

    }
    
     @Override
    public void updateStatus(int requestIDPK, String status,String cost) {
         try {
            Request request = em.find(Request.class, requestIDPK);
            request.setStatus(status);
            request.setCost(cost);
            em.merge(request);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }
    }
    
    @Override
    public void removeRequest(int requestIDPK) {
        try {

            Request req = em.find(Request.class, requestIDPK);
            em.remove(req);

        } catch (Exception e) {
            System.err.println("Delete Error" + e.getMessage());
        }

    }

    @Override
    public Collection<Booking> findallbooking() {
        try {
            Collection<Booking> booking = em.createNamedQuery("Booking.findAll").getResultList();
            if (!booking.isEmpty()) {
                return booking;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public Booking getBooking(int bookingIDPK) {
        try {
            Booking booking = em.find(Booking.class, bookingIDPK);
            if (booking.getBookingIDPK() != 0) {
                return booking;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public void addBooking(int requestIDFK, String requestname, String status, Date date, Time time) {
        try {
            Booking booking = new Booking();
            Request request = em.find(Request.class, requestIDFK);
            booking.setRequestIDFK(request);
            booking.setRequestname(request.getRequestname());
            booking.setStatus(status);
            booking.setDate(date);
            booking.setTime(time);
            em.persist(booking);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());
        }

    }

    @Override
    public void updateBooking(int bookingIDPK, int requestIDFK, String requestname, String status, Date date, Time time) {
        try {
            Booking booking = em.find(Booking.class, bookingIDPK);
            Request request = em.find(Request.class, requestIDFK);
            booking.setRequestIDFK(request);
            booking.setRequestname(requestname);
            booking.setStatus(status);
            booking.setDate(date);
            booking.setTime(time);
            em.merge(booking);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }

    }

    @Override
    public void removeBooking(int bookingIDPK) {
        try {
            Booking booking = em.find(Booking.class, bookingIDPK);
            em.remove(booking);
        } catch (Exception e) {
            System.err.println("Delete Error" + e.getMessage());
        }

    }

    @Override
    public void addGallery(String image, int mechanicIDFK, String mechanicname) {
        try {
            Gallery gallery = new Gallery();
            Mechanic mechanic = em.find(Mechanic.class, mechanicIDFK);
            gallery.setImage(image);
            gallery.setMechanicIDFK(mechanic);
            gallery.setMechanicname(mechanic.getMechanicname());
            em.persist(gallery);
        } catch (Exception e) {
            System.err.println("Insert Error" + e.getMessage());
        }

    }

    @Override
    public void updateGallery(int galleryIDPK, String image, int mechanicIDFK, String mechanicname) {
        try {
            Gallery gallery = em.find(Gallery.class, galleryIDPK);
            Mechanic mechanic = em.find(Mechanic.class, mechanicIDFK);
            gallery.setImage(image);
            gallery.setMechanicIDFK(mechanic);
            gallery.setMechanicname(mechanicname);
            em.merge(gallery);
        } catch (Exception e) {
            System.err.println("Update Error" + e.getMessage());
        }

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
    public Collection<Feedback> findallfeedback() {
         try {
            Collection<Feedback> fb = em.createNamedQuery("Feedback.findAll").getResultList();
            if (!fb.isEmpty()) {
                return fb;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

    @Override
    public Gallery getGallery(int galleryIDPK) {
        try {
            Gallery gallery = em.find(Gallery.class, galleryIDPK);
            if (gallery.getGalleryIDPK()!= 0) {
                return gallery;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void removeGallery(int galleryIDPK) {
        try{
            Gallery gallery = em.find(Gallery.class, galleryIDPK);
        em.remove(gallery);
        }catch(Exception e){
            System.err.println("Error" + e.getMessage());
        }
        
    }

    @Override
    public void addFeedback(String comment, int userIDFK, String username, int mechanicIDFK, String mechanicname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateFeedback(int feedbackIDPK, String comment, int userIDFK, String username, int mechanicIDFK, String mechanicname) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeFeedback(int feedbackIDPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Feedback> getFeedback() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addPayment(int bookingIDFK, String bookingname, String paymenttype, String status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updatePayment(int paymentIDPK, int bookingIDFK, String bookingname, String paymenttype, String status) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removePayment(int paymentIDPK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Payment> getPayment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateAuth(int authIDPK, int userIDFK, String username, String email, String usertype) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeAuth(int authIDPK, int userIDFK) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addAuth(int userIDFK, String username, String email,String password, String usertype) 
    {
        Auth auth = new Auth();   
        User user = em.find(User.class,userIDFK);
        Collection<Auth> auths = user.getAuthCollection();
        auth.setUserIDFK(user);
        auth.setUsername(user.getUsername());
        auth.setEmail(email);
        String HashPassword= PasswordHash.generate(password.toCharArray());
        auth.setPassword(HashPassword);
        auth.setUsertype(usertype);
        auths.add(auth);
        user.setAuthCollection(auths);
        em.persist(auth);
        em.merge(auth);
        
    }

//    @Override
//    public void updateAuth(int authIDPK, int userIDFK, String username, String email, String usertype) {
//        Auth a = em.find(Auth.class, authIDPK);
//        User user = em.find(User.class,userIDFK);
//        Collection<Auth> auths = user.getAuthCollection();
//        Auth auth = new Auth(); 
//        auth.setUserIDFK(user);
//        auth.setUsername(username);
//        auth.setEmail(email);
//        auth.setUsertype(usertype);
//        user.setAuthCollection(auths);
//        em.merge(a);
//    }
//
//    @Override
//    public void removeAuth(int authIDPK, int userIDFK) {
//         Auth auth = em.find(Auth.class, authIDPK);
//         User user = em.find(User.class,userIDFK);
//         Collection<Auth> authcollection = user.getAuthCollection();
//         if(authcollection.remove(auth)) {
//            em.remove(em);
//            authcollection.remove(auth);        
//            user.setAuthCollection(authcollection);
//         }
//         
//    }
//
    @Override
    public Collection<Auth> getAuth() {
        try{
            Collection<Auth> auth = em.createNamedQuery("Auth.findAll").getResultList();
            if(!auth.isEmpty())
            {
                return auth;
            }else{
                return null;
            }
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public Collection<Auth> findallauth() {
          try {
            Collection<Auth> auth = em.createNamedQuery("Auth.findAll").getResultList();
            if (!auth.isEmpty()) {
                return auth;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error" + e.getMessage());
            return null;
        }
    }

   


}
