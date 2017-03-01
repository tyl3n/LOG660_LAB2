

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

public class MovieInfoBroker {
	Session session;
	
	MovieInfoBroker(Session session) {
		this.session = session;
	}
	
	public List getMoviesFromCriteria(ArrayList<String> titleKeywords,
			ArrayList<String> countryKeywords,
			ArrayList<String> languageKeywords,
			ArrayList<String> genreKeywords,
			ArrayList<String> directorKeywords,
			ArrayList<String> actorKeywords,
			Integer minYear,
			Integer maxYear) {
		
		/*
		 
		+ " WHERE m.title like '*"+ FilmTitle + "*' OR " + FilmTitle + " IS NULL"
		+ " AND m.releaseyear =" + FilmYear + " OR " + FilmYear + " IS NULL"
		+ " AND m.language = " + FilmLang + " OR " + FilmLang + " IS NULL"
		+ " AND g.name like '*" + FilmGenre + "*' OR " + FilmGenre + " IS NULL" 
 
		 */
		
		Criteria movieCriteria = session.createCriteria(Movie.class, "m");
		movieCriteria.createAlias("m.genres", "g");

		//Conjunction andQuery = Restrictions.conjunction();
		Disjunction orQuery = Restrictions.disjunction();
		
		if (titleKeywords != null) {
			
		}
		
		if (genreKeywords != null) {
			for (String keyword : genreKeywords) {
				orQuery.add(Restrictions.eq("g.name", keyword));
			}
		}
		
		
		//andQuery.add(orQuery);
		movieCriteria.add(orQuery);
		
		List movies = movieCriteria.list();
		
		System.out.println(movies.size());
		
		return movies;
	}
}
