package database;

import java.util.ArrayList;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.2.0.v20110202-r8913", date="2013-01-28T12:05:12")
@StaticMetamodel(Person.class)
public class Person_ { 

    public static volatile SingularAttribute<Person, Long> id;
    public static volatile SingularAttribute<Person, ArrayList> friends;
    public static volatile SingularAttribute<Person, String> email;
    public static volatile SingularAttribute<Person, String> name;
    public static volatile SingularAttribute<Person, Integer> money;
    public static volatile SingularAttribute<Person, ArrayList> monsters;
    public static volatile SingularAttribute<Person, String> password;

}