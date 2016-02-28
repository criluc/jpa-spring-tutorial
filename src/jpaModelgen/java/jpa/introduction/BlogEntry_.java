package jpa.introduction;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BlogEntry.class)
public abstract class BlogEntry_ {

	public static volatile SingularAttribute<BlogEntry, String> summary;
	public static volatile SingularAttribute<BlogEntry, Date> date;
	public static volatile SingularAttribute<BlogEntry, Integer> id;
	public static volatile SingularAttribute<BlogEntry, String> title;
	public static volatile SingularAttribute<BlogEntry, String> body;

}

