package entity;

import entity.Mechanic;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-06-22T10:11:31")
@StaticMetamodel(Gallery.class)
public class Gallery_ { 

    public static volatile SingularAttribute<Gallery, String> image;
    public static volatile SingularAttribute<Gallery, Integer> galleryIDPK;
    public static volatile SingularAttribute<Gallery, Mechanic> mechanicIDFK;
    public static volatile SingularAttribute<Gallery, String> mechanicname;

}