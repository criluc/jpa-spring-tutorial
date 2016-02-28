package jpa.advanced;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LineItem.class)
public abstract class LineItem_ {

	public static volatile SingularAttribute<LineItem, BigDecimal> amount;
	public static volatile SingularAttribute<LineItem, String> description;
	public static volatile SingularAttribute<LineItem, Long> id;
	public static volatile SingularAttribute<LineItem, Order> order;

}

