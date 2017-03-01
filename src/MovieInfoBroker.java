import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

public class MovieInfoBroker {
	Session session;
	
	MovieInfoBroker(Session session) {
		this.session = session;
	}
	
	public Movie[] getMoviesFromCriteria(String[] titleKeywords,
			String[] countryKeywords,
			String[] languageKeywords,
			String[] genreKeywords,
			String[] directorKeywords,
			String[] actorKeywords,
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

		return (Movie[])movieCriteria.list().toArray(new Movie[0]);
	}
}
