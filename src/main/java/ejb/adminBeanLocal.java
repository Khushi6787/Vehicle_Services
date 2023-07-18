/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Area;
import entity.Auth;
import entity.Booking;
import entity.Feedback;
import entity.Gallery;
import entity.Mechanic;
import entity.Payment;
import entity.Request;
import entity.Service;
import entity.User;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author KHUSHI
 */
@Local
public interface adminBeanLocal {
    Collection<Area> findallarea();
    public void addArea(String areaname,int pincode);
    public void updateArea(int areaIDPK,String areaname,int pincode);
    public void removeArea(int areaIDPK);
    Area getArea(int areaIDPK);
    
    Collection<User> findalluser();
    public void addUser(String username,String address,String email,String mobileno,String password,String usertype);
    public void updateUser(int userIDPK,String username,String address,String email,String mobileno,String password,String usertype);
    public void removeUser(int userIDPK);
    User getUser(int userIDPK);
    
    Collection<Service> findallservice();
    public void addService(String image,String servicename,String description);
    public void updateService(int serviceIDPK,String image,String servicename,String description);
    public void removeService(int serviceIDPK);
    Service getService(int serviceIDPK);
    
    Collection<Auth> findallauth();
    public void addAuth(int userIDFK,String username,String email,String password,String usertype);
    public void updateAuth(int authIDPK,int userIDFK,String username,String email,String usertype);
    public void removeAuth(int authIDPK,int userIDFK);
    Collection<Auth> getAuth();
    
    Collection<Mechanic> findallmechanic();
    public void addMechanic(String image,int serviceIDFK,String servicename,String mechanicname,String gender,int areaIDFK,String areaname,String skill,String experience,String costperhour,int ratings);
    public void updateMechanic(int mechanicIDPK,String image,int serviceIDFK,String servicename,String mechanicname,String gender,int areaIDFK,String areaname,String skill,String experience,String costperhour,int ratings);
    public void removeMechanic(int mechanicIDPK);
    Mechanic getMechanic(int mechanicIDPK);
    
    Collection<Request> findallrequest();
    public void addRequest(int areaIDFK,String areaname,int serviceIDFK,String servicename,String requestname,int userIDFK,String username,int mechanicIDFK,String mechanicname,String status,String payment,String cost);
    public void updateRequest(int requestIDPK,int areaIDFK,String areaname,int serviceIDFK,String servicename,String requestname,int userIDFK,String username,int mechanicIDFK,String mechanicname,String status,String payment,String cost);
    public void removeRequest(int requestIDPK);
    Request getRequest(int requestIDPK);
    public void updateStatus(int requestIDPK,String status,String cost);
    
    
    Collection<Booking> findallbooking();
    public void addBooking(int requestIDFK,String requestname,String status,Date date,Time time);
    public void updateBooking(int bookingIDPK,int requestIDFK,String requestname,String status,Date date,Time time);
    public void removeBooking(int bookingIDPK);
    Booking getBooking(int bookingIDPK);
    
    Collection<Gallery> findallgallery();
    public void addGallery(String image,int mechanicIDFK,String mechanicname);
    public void updateGallery(int galleryIDPK,String image,int mechanicIDFK,String mechanicname);
    public void removeGallery(int galleryIDPK);
    Gallery getGallery(int galleryIDPK);
    
    Collection<Feedback> findallfeedback();
    public void addFeedback(String comment,int userIDFK,String username,int mechanicIDFK,String mechanicname);
    public void updateFeedback(int feedbackIDPK,String comment,int userIDFK,String username,int mechanicIDFK,String mechanicname);
    public void removeFeedback(int feedbackIDPK);
    Collection<Feedback> getFeedback();
    
    public void addPayment(int bookingIDFK,String bookingname,String paymenttype,String status);
    public void updatePayment(int paymentIDPK,int bookingIDFK,String bookingname,String paymenttype,String status);
    public void removePayment(int paymentIDPK);
    Collection<Payment> getPayment();
}
