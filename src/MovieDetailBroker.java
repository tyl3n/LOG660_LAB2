import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

public class MovieDetailBroker {
	Session session;
	
	MovieDetailBroker(Session session) {
		this.session = session;
	}
	
	public Movie GetMovieFromIDOrTitle(int id, String title ) {
		
		Criteria movieCriteria = session.createCriteria(Movie.class, "m");
		//movieCriteria.createAlias("m.genres", "g");
		BigDecimal movieId = new BigDecimal(id);
		//Conjunction andQuery = Restrictions.conjunction();
		Disjunction orQuery = Restrictions.disjunction();
		orQuery.add(Restrictions.eq("m.title", title));
		orQuery.add(Restrictions.eq("m.movieid",movieId));

		
		
		//andQuery.add(orQuery);
		movieCriteria.add(orQuery);
		
		List movies = movieCriteria.list();
		
		System.out.println(movies.size());
		if (movies.size()>0)
		{
			Movie m = (Movie) movies.get(0);
			return (Movie) movies.get(0);
		}
		else
			return null;
	}
}
