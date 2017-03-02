import java.math.BigDecimal;
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
		Disjunction orQuery = Restrictions.disjunction();
		orQuery.add(Restrictions.eq("c.crewmemberid", id));
		crewCriteria.add(orQuery);
		
		List Crewmembers = crewCriteria.list();
		
		if (Crewmembers.size()>0) {
			Crewmember m = (Crewmember) Crewmembers.get(0);
			return (Crewmember) Crewmembers.get(0);
		}
		else {
			return null;
		}
	}
}
