package jpa.advanced;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(House.class)
public abstract class House_ {

	public static volatile SingularAttribute<House, String> address;
	public static volatile ListAttribute<House, PersonWithAccount> owners;
	public static volatile SingularAttribute<House, Long> id;

}

