package entity;

import entity.Auth;
import entity.Feedback;
import entity.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Request> requestCollection;
    public static volatile SingularAttribute<User, String> address;
    public static volatile CollectionAttribute<User, Feedback> feedbackCollection;
    public static volatile SingularAttribute<User, Integer> userIDPK;
    public static volatile SingularAttribute<User, String> usertype;
    public static volatile SingularAttribute<User, String> mobileno;
    public static volatile CollectionAttribute<User, Auth> authCollection;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}