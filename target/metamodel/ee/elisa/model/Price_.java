package ee.elisa.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Price.class)
public abstract class Price_ {

	public static volatile SingularAttribute<Price, Double> oneTimePrice;
	public static volatile SingularAttribute<Price, Double> recurringPrice;
	public static volatile SingularAttribute<Price, String> description;
	public static volatile SingularAttribute<Price, Long> id;
	public static volatile SingularAttribute<Price, Date> timeLeft;
	public static volatile SingularAttribute<Price, Integer> recurringCount;
	public static volatile SingularAttribute<Price, String> sapId;

	public static final String ONE_TIME_PRICE = "oneTimePrice";
	public static final String RECURRING_PRICE = "recurringPrice";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String TIME_LEFT = "timeLeft";
	public static final String RECURRING_COUNT = "recurringCount";
	public static final String SAP_ID = "sapId";

}

