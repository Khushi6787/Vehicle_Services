package entity;

import entity.Area;
import entity.Booking;
import entity.Mechanic;
import entity.Service;
import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Request.class)
public class Request_ { 

    public static volatile SingularAttribute<Request, Integer> requestIDPK;
    public static volatile SingularAttribute<Request, String> requestname;
    public static volatile SingularAttribute<Request, String> cost;
    public static volatile SingularAttribute<Request, String> areaname;
    public static volatile SingularAttribute<Request, Area> areaIDFK;
    public static volatile SingularAttribute<Request, String> mechanicname;
    public static volatile CollectionAttribute<Request, Booking> bookingCollection;
    public static volatile SingularAttribute<Request, User> userIDFK;
    public static volatile SingularAttribute<Request, Mechanic> mechanicIDFK;
    public static volatile SingularAttribute<Request, String> servicename;
    public static volatile SingularAttribute<Request, String> payment;
    public static volatile SingularAttribute<Request, Service> serviceIDFK;
    public static volatile SingularAttribute<Request, String> username;
    public static volatile SingularAttribute<Request, String> status;

}