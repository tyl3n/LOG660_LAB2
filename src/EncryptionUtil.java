import java.security.*;
import java.math.*;
public class EncryptionUtil {
	public static String hashWithMD5(String message)
	{

	        MessageDigest m = null;
			try {
				m = MessageDigest.getInstance("MD5");
		        m.update(message.getBytes(),0,message.length());
			}
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}
			return (m == null)? new BigInteger(1,m.digest()).toString(16):"";
	}
	public static String hashWithSHA(String message)
	{

	        MessageDigest m = null;
			try {
				m = MessageDigest.getInstance("SHA-1");
		        m.update(message.getBytes(),0,message.length());
			}
			catch (NoSuchAlgorithmException e) 
			{
				e.printStackTrace();
			}
			return (m == null)? new BigInteger(1,m.digest()).toString(16):"";
	}
}
