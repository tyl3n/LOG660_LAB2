import org.hibernate.HibernateException;
import org.hibernate.Session;

public class Main {
	static Session session;
	
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
	        public void run() {
	        	// We close the session when the application is closed
	            if (session != null) {
	            	session.close();
				}
	        }
	    }, "Shutdown-thread"));
		
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			new Login(session).setVisible(true);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
}