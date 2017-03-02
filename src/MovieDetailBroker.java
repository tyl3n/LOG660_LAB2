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
	
	public Movie GetMovieFromID(BigDecimal movieId ) {
		
		Criteria movieCriteria = session.createCriteria(Movie.class, "m");
		Disjunction orQuery = Restrictions.disjunction();
		orQuery.add(Restrictions.eq("m.movieid",movieId));
		movieCriteria.add(orQuery);
		
		List movies = movieCriteria.list();
		
		if (movies.size() > 0) {
			Movie m = (Movie) movies.get(0);
			return (Movie) movies.get(0);
		}
		else {
			return null;
		}
	}
}
