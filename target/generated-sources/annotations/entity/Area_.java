package entity;

import entity.Mechanic;
import entity.Request;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Area.class)
public class Area_ { 

    public static volatile SingularAttribute<Area, Integer> pincode;
    public static volatile CollectionAttribute<Area, Request> requestCollection;
    public static volatile SingularAttribute<Area, String> areaname;
    public static volatile SingularAttribute<Area, Integer> areaIDPK;
    public static volatile CollectionAttribute<Area, Mechanic> mechanicCollection;

}