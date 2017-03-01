
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

public class UserInfoBroker {
Session session;
	
	UserInfoBroker(Session session) {
		this.session = session;
	}
	
	public Systemuser IsValidLoginInfo(String email,String password) {
		
		Criteria loginCriteria = session.createCriteria(Systemuser.class, "s");
		//movieCriteria.createAlias("s.genres", "g");

		Conjunction andQuery = Restrictions.conjunction();
		//Disjunction orQuery = Restrictions.disjunction();
		
		andQuery.add(Restrictions.eq("s.email", email));
		andQuery.add(Restrictions.eq("s.password", password));
		
		
		//andQuery.add(orQuery);
		loginCriteria.add(andQuery);
		
		List logins = loginCriteria.list();
		
		System.out.println(logins.size());
		System.out.println(email);
		System.out.println(password);
		
		System.out.println(logins.size());
		if (logins.size()>0)
		{
			Systemuser m = (Systemuser) logins.get(0);
			return (Systemuser) logins.get(0);
		}
		else
			return null;
	}
}
