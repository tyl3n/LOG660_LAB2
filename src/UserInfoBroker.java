import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.xml.bind.DatatypeConverter;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;

public class UserInfoBroker {
Session session;
	
	UserInfoBroker(Session session) {
		this.session = session;
	}
	
	public Systemuser IsValidLoginInfo(String email,String password) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		String hashPassword = DatatypeConverter.printHexBinary(MessageDigest.getInstance("SHA-256").digest(password.getBytes("UTF-8")));

		Criteria loginCriteria = session.createCriteria(Systemuser.class, "s");
		Conjunction andQuery = Restrictions.conjunction();
		andQuery.add(Restrictions.eq("s.email", email));
		andQuery.add(Restrictions.eq("s.password", hashPassword));
		loginCriteria.add(andQuery);
		
		List logins = loginCriteria.list();

		if (logins.size()>0)
		{
			Systemuser m = (Systemuser) logins.get(0);
			return (Systemuser) logins.get(0);
		}
		else {
			return null;
		}
	}
}
