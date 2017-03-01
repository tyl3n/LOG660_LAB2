import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

public class CrewMemberDetailBroker {
	Session session;
	
	CrewMemberDetailBroker(Session session) {
		this.session = session;
	}
	
	public Crewmember GetCrewmemberById(BigDecimal id ) {
		
		Criteria crewCriteria = session.createCriteria(Crewmember.class, "c");
		//movieCriteria.createAlias("m.genres", "g");
		//BigDecimal crewMemberId = new BigDecimal(id);
		//Conjunction andQuery = Restrictions.conjunction();
		Disjunction orQuery = Restrictions.disjunction();
		orQuery.add(Restrictions.eq("c.crewmemberid", id));
		//orQuery.add(Restrictions.eq("m.movieid",movieId));

		
		
		//andQuery.add(orQuery);
		crewCriteria.add(orQuery);
		
		List Crewmembers = crewCriteria.list();
		
		System.out.println(Crewmembers.size());
		if (Crewmembers.size()>0)
		{
			Crewmember m = (Crewmember) Crewmembers.get(0);
			return (Crewmember) Crewmembers.get(0);
		}
		else
			return null;
	}
}
