package entity;

import entity.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Feedback.class)
public class Feedback_ { 

    public static volatile SingularAttribute<Feedback, User> userIDFK;
    public static volatile SingularAttribute<Feedback, Integer> feedbackIDPK;
    public static volatile SingularAttribute<Feedback, Integer> mechanicIDFK;
    public static volatile SingularAttribute<Feedback, String> comment;
    public static volatile SingularAttribute<Feedback, String> mechanicname;
    public static volatile SingularAttribute<Feedback, String> username;

}