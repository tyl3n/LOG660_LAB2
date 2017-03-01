

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Client generated by hbm2java
 */
public class Client implements java.io.Serializable {

	private BigDecimal systemuserid;
	private Systemuser systemuser;
	private Creditcard creditcard;
	private Subscription subscription;
	private Set moviecopies = new HashSet(0);

	public Client() {
	}

	public Client(Systemuser systemuser, Creditcard creditcard, Subscription subscription) {
		this.systemuser = systemuser;
		this.creditcard = creditcard;
		this.subscription = subscription;
	}

	public Client(Systemuser systemuser, Creditcard creditcard, Subscription subscription, Set moviecopies) {
		this.systemuser = systemuser;
		this.creditcard = creditcard;
		this.subscription = subscription;
		this.moviecopies = moviecopies;
	}

	public BigDecimal getSystemuserid() {
		return this.systemuserid;
	}

	public void setSystemuserid(BigDecimal systemuserid) {
		this.systemuserid = systemuserid;
	}

	public Systemuser getSystemuser() {
		return this.systemuser;
	}

	public void setSystemuser(Systemuser systemuser) {
		this.systemuser = systemuser;
	}

	public Creditcard getCreditcard() {
		return this.creditcard;
	}

	public void setCreditcard(Creditcard creditcard) {
		this.creditcard = creditcard;
	}

	public Subscription getSubscription() {
		return this.subscription;
	}

	public void setSubscription(Subscription subscription) {
		this.subscription = subscription;
	}

	public Set getMoviecopies() {
		return this.moviecopies;
	}

	public void setMoviecopies(Set moviecopies) {
		this.moviecopies = moviecopies;
	}

}