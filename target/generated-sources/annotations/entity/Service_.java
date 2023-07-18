package entity;

import entity.Mechanic;
import entity.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, String> image;
    public static volatile SingularAttribute<Service, Integer> serviceIDPK;
    public static volatile CollectionAttribute<Service, Request> requestCollection;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SingularAttribute<Service, String> servicename;
    public static volatile CollectionAttribute<Service, Mechanic> mechanicCollection;

}