package entity;

import entity.Booking;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, String> bookingname;
    public static volatile SingularAttribute<Payment, Integer> paymentIDPK;
    public static volatile SingularAttribute<Payment, Booking> bookingIDFK;
    public static volatile SingularAttribute<Payment, String> paymenttype;
    public static volatile SingularAttribute<Payment, String> status;

}