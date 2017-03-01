
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session sessionHome = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = sessionHome.beginTransaction();
			//Client(Systemuser systemuser, Creditcard creditcard, Subscription subscription, Set moviecopies) 
			String FilmLenght;
			String FilmTitle;
			String FilmYear;
			String FilmLang;
			String FilmGenre;
			String FilmScriptWriter;
			String FilmDirector;
			String FilmActor;
			List lesMovies = transaction.createQuery(
					"FROM MOVIES m, GENRE g, MOVIEGENRE mg WHERE  "
					+ "		m.movieid = mg.movieid"
					+ "AND mg.genreid = g.genreid"
					+ "AND m.title like '*"+ FilmTitle + 
					"*'AND m.releaseyear =" +FilmYear + 
					"  AND m.language = "+ FilmLang + 
					"  AND mg.name like '*" + FilmGenre).list();
					//Movie unFim= (Movie) lesMovies.next();
			Set<Client> clients = new HashSet<Client>();

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			sessionHome.close();
		}
	}

}
