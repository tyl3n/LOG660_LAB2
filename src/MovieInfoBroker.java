import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

public class MovieInfoBroker {
	Session session;
	
	MovieInfoBroker(Session session) {
		this.session = session;
	}
	
	public List getMoviesFromCriteria(String[] titleKeywords,
			ArrayList<String> countryKeywords,
			ArrayList<String> languageKeywords,
			ArrayList<String> genreKeywords,
			ArrayList<String> directorKeywords,
			ArrayList<String> actorKeywords,
			Integer minYear,
			Integer maxYear) {
		
		Criteria movieCriteria = session.createCriteria(Movie.class, "m");
		movieCriteria.createAlias("m.genres", "g");
		movieCriteria.createAlias("m.countries", "c");
		movieCriteria.createAlias("m.crewmember", "d");
		movieCriteria.createAlias("m.movieactors", "ma");
		movieCriteria.createAlias("ma.crewmember", "a");

		Conjunction andQuery = Restrictions.conjunction();

		if (titleKeywords != null) {
			for (String keyword : titleKeywords) {
				andQuery.add(Restrictions.like("m.title", '%' + keyword + '%').ignoreCase());
			}
		}

		if (countryKeywords != null) {
			for (String keyword : countryKeywords) {
				// If there's a list of countries, the movie must have ALL the countries, so ANDs or ORs are not enough here
				DetachedCriteria countrySubCriteria = DetachedCriteria.forClass(Movie.class, "m");
				countrySubCriteria.createAlias("m.countries", "c");
				countrySubCriteria.setProjection(Projections.property("m.movieid"));
				countrySubCriteria.add(Restrictions.eq("c.name", keyword).ignoreCase());
				
				andQuery.add(Property.forName("movieid").in(countrySubCriteria));
			}
		}
		
		if (languageKeywords != null) {
			for (String keyword : languageKeywords) {
				andQuery.add(Restrictions.like("m.language", keyword).ignoreCase());
			}
		}
		
		if (genreKeywords != null) {
			for (String keyword : genreKeywords) {
				andQuery.add(Restrictions.eq("g.name", keyword).ignoreCase());
			}
		}
		
		if (directorKeywords != null) {
			for (String keyword : directorKeywords) {
				Disjunction fullNameQuery = Restrictions.disjunction();
				fullNameQuery.add(Restrictions.like("d.firstname", '%' + keyword + '%').ignoreCase());
				fullNameQuery.add(Restrictions.like("d.lastname", '%' + keyword + '%').ignoreCase());
				andQuery.add(fullNameQuery);
			}
		}
		
		if (actorKeywords != null) {
			for (String keyword : actorKeywords) {
				// If there's a list of actors, the movie must have ALL the actors, so ANDs or ORs are not enough here
				DetachedCriteria countrySubCriteria = DetachedCriteria.forClass(Movie.class, "m");
				countrySubCriteria.createAlias("m.movieactors", "ma");
				countrySubCriteria.createAlias("ma.crewmember", "a");
				
				Disjunction fullNameQuery = Restrictions.disjunction();
				fullNameQuery.add(Restrictions.like("a.firstname", '%' + keyword + '%').ignoreCase());
				fullNameQuery.add(Restrictions.like("a.lastname", '%' + keyword + '%').ignoreCase());
				countrySubCriteria.add(fullNameQuery);
				
				countrySubCriteria.setProjection(Projections.property("m.movieid"));
				countrySubCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
				
				andQuery.add(Property.forName("movieid").in(countrySubCriteria));
			}
		}
		
		if (minYear != null) {
			andQuery.add(Restrictions.ge("m.releaseyear", new BigDecimal(minYear.intValue())));
		}
		
		if (maxYear != null) {
			andQuery.add(Restrictions.le("m.releaseyear", new BigDecimal(maxYear.intValue())));
		}
		
		movieCriteria.add(andQuery);
		movieCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);

		List movies = movieCriteria.list();
		
		System.out.println(movies.size());
		
		if (movies.size() > 0) {
			Iterator movieIter = movies.iterator();
			Movie movie;
			
			while (movieIter.hasNext()) {
				movie = (Movie)movieIter.next();
				System.out.println(movie.getTitle());
			}
		}
		
		return movies;
	}
}
