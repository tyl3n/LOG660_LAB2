import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
		
		
		Criteria movieCriteria = session.createCriteria(Movie.class, "m");
		//movieCriteria.createAlias("m.genres", "g");
		//BigDecimal movieId = new BigDecimal(id);
		//Conjunction andQuery = Restrictions.conjunction();
		Disjunction orQuery = Restrictions.disjunction();
		//orQuery.add(Restrictions.eq("m.title", title));
		orQuery.add(Restrictions.eq("m.movieid",movieId));

		
		
		//andQuery.add(orQuery);
		movieCriteria.add(orQuery);
		
		List movies = movieCriteria.list();
		
		System.out.println(movies.size());
		if (movies.size()>0)
		{
			Movie m = (Movie) movies.get(0);
			Set<Moviecopy>  movieCopies = m.getMoviecopies();
			for(Moviecopy mvc : movieCopies)
			{
				if(mvc.getClient() == null)
					return mvc;
			}
			return null;			
		}
		else
			return null;
	}

}
