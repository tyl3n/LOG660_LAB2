
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Movie unFilm;
		try {
			//transaction = sessionHome.beginTransaction();
			String FilmLenght;
			String FilmTitle = null;
			String FilmYear = null;
			String FilmLang = null;
			String FilmGenre = null;
			String FilmScriptWriter;
			String FilmDirector;
			String FilmActor;
			
			MovieInfoBroker movieInfoBroker = new MovieInfoBroker(session);
			
			ArrayList<String> genreKeywords = new ArrayList<String>();
			genreKeywords.add("Action");
			
			movieInfoBroker.getMoviesFromCriteria(null, null, null, genreKeywords, null, null, null, null);
			
			//transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
