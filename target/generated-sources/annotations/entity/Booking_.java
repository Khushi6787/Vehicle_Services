package entity;

import entity.Payment;
import entity.Request;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Integer> bookingIDPK;
    public static volatile SingularAttribute<Booking, Date> date;
    public static volatile SingularAttribute<Booking, String> requestname;
    public static volatile SingularAttribute<Booking, Request> requestIDFK;
    public static volatile SingularAttribute<Booking, Date> time;
    public static volatile CollectionAttribute<Booking, Payment> paymentCollection;
    public static volatile SingularAttribute<Booking, String> status;

}