/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Area;
import entity.Booking;
import entity.Gallery;
import entity.Mechanic;
import entity.Request;
import entity.Service;
import entity.User;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author KHUSHI
 */
@Local
public interface userBeanLocal {
    User getUser(int UserIDPK);
    Collection<Area> findallarea();
    Collection<Gallery> findallgallery();
    Collection<Service> findallservice();
    Collection<Mechanic> findallmechanic();
    Collection<Request> findallrequests();
    Collection<Booking> findallbooking();
    
    Collection<User> findalluser();
    public void addUser(String username,String address,String email,String mobileno,String password,String usertype);
    public void updateUser(int userIDPK,String username,String address,String email,String mobileno,String password,String usertype);
     public void addAppointment(int areaIDFK,String areaname,int serviceIDFK,String servicename,String requestname,int userIDFK,String username,int mechanicIDFK,String mechanicname,String status,String payment);
   
    public User login(String email, String password);
}
