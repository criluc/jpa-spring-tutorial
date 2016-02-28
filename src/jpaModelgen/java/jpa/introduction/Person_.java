package jpa.introduction;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends jpa.introduction.BaseEntity_ {

	public static volatile SingularAttribute<Person, String> firstname;
	public static volatile SingularAttribute<Person, String> phone;
	public static volatile SingularAttribute<Person, String> email;
	public static volatile SingularAttribute<Person, String> lastname;

}

