package entity;

import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Auth.class)
public class Auth_ { 

    public static volatile SingularAttribute<Auth, String> password;
    public static volatile SingularAttribute<Auth, User> userIDFK;
    public static volatile SingularAttribute<Auth, Integer> authIDPK;
    public static volatile SingularAttribute<Auth, String> usertype;
    public static volatile SingularAttribute<Auth, String> email;
    public static volatile SingularAttribute<Auth, String> username;

}