package jpa.advanced;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PersonWithAccount.class)
public abstract class PersonWithAccount_ {

	public static volatile SingularAttribute<PersonWithAccount, String> surname;
	public static volatile SingularAttribute<PersonWithAccount, String> name;
	public static volatile ListAttribute<PersonWithAccount, House> houses;
	public static volatile SingularAttribute<PersonWithAccount, Long> id;
	public static volatile SingularAttribute<PersonWithAccount, Account> account;

}

