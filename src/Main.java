


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Timer;

import javax.swing.SwingUtilities;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction transaction = null;
		Movie unFilm;
		try {
			ShowMovie sm  = new ShowMovie(session,"The Princess Bride", 0);

		} catch (HibernateException e) {
			//transaction.rollback();
			e.printStackTrace();
		} finally {
			//session.close();
		}
	}

}
