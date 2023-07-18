package entity;

import entity.Area;
import entity.Gallery;
import entity.Request;
import entity.Service;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Mechanic.class)
public class Mechanic_ { 

    public static volatile SingularAttribute<Mechanic, String> image;
    public static volatile CollectionAttribute<Mechanic, Request> requestCollection;
    public static volatile SingularAttribute<Mechanic, String> gender;
    public static volatile SingularAttribute<Mechanic, String> areaname;
    public static volatile SingularAttribute<Mechanic, Area> areaIDFK;
    public static volatile SingularAttribute<Mechanic, Integer> mechanicIDPK;
    public static volatile SingularAttribute<Mechanic, String> mechanicname;
    public static volatile SingularAttribute<Mechanic, String> experience;
    public static volatile SingularAttribute<Mechanic, String> costperhour;
    public static volatile SingularAttribute<Mechanic, Integer> ratings;
    public static volatile SingularAttribute<Mechanic, String> skill;
    public static volatile SingularAttribute<Mechanic, String> servicename;
    public static volatile SingularAttribute<Mechanic, Service> serviceIDFK;
    public static volatile CollectionAttribute<Mechanic, Gallery> galleryCollection;

}