package jpa.introduction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BaseEntity.class)
public abstract class BaseEntity_ {

	public static volatile SingularAttribute<BaseEntity, Date> createdAt;
	public static volatile SingularAttribute<BaseEntity, Integer> id;
	public static volatile SingularAttribute<BaseEntity, Date> updatedAt;

}

