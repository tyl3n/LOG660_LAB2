import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;


public class MovieRentBroker {
	Session session;
	BigDecimal userId;
	BigDecimal movieId;
	
	MovieRentBroker(Session session, BigDecimal Id, BigDecimal mvId) {
		this.session = session;
		this.userId = Id;
		this.movieId = mvId;
	}
	public int insertRent(){
		Subscription thisSub = getSubscription();
		Client thisClient =  getUser();
		Moviecopy thisCopy = GetMovieFromID(movieId);
		System.out.println("thisSub count"  + thisSub.getSubscriptiontype().getName());
		System.out.println("thisClient count"  + thisClient.getSystemuser().getFirstname());
		//System.out.println("thisCopy count"  + thisCopy.getMovie().getTitle());
		if(thisSub == null)
			return -1;
		if(thisClient.getMoviecopies().size() >= thisSub.getSubscriptiontype().getMaxrentals().intValue())
			return -2;
		if(thisCopy == null)
			return -3;
		//Update Moviecopy Object
		session.beginTransaction();
		thisCopy.setClient(thisClient); 
		//Save the Moviecopy in database
		session.save(thisCopy);
		//Commit the transaction
		session.getTransaction().commit();
		return 0;
	}
	public Subscription getSubscription(){
		Client thisClient =  getUser();
		if(thisClient == null)
			return null;
		return thisClient.getSubscription();
	}
	public Client getUser(){
		Criteria clientCriteria = session.createCriteria(Client.class, "c");
		Conjunction andQuery = Restrictions.conjunction();
		Disjunction orQuery = Restrictions.disjunction();
		andQuery.add(Restrictions.eq("c.systemuserid", userId));
		clientCriteria.add(andQuery);
		
		List clients = clientCriteria.list();
		
		System.out.println(clients.size());
		if (clients.size()>0)
		{
			Client client = (Client) clients.get(0);
			return (Client) clients.get(0);
		}
		else
			return null;
	}
	
	public Moviecopy GetMovieFromID(BigDecimal movieId ) {
		
		Criteria movieCriteria = session.createCriteria(Moviecopy.class, "mc");
		Disjunction orQuery = Restrictions.disjunction();
		Conjunction andQuery = Restrictions.conjunction();
		MoviecopyId mcid = new MoviecopyId();
		mcid.setMovieid(movieId);
		andQuery.add(Restrictions.eq("mc.movie.movieid",movieId));
		andQuery.add(Restrictions.isNull("mc.client.systemuserid"));

		
		
		//andQuery.add(orQuery);
		//movieCriteria.add(andQuery);
		
		List movies = movieCriteria.list();
		
		System.out.println("movie count"  + movies.size());
		if (movies.size()>0)
		{
			Moviecopy m = (Moviecopy) movies.get(0);
			return m;
		}
		else
			return null;
	}

}
