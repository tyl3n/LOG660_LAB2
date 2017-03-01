// default package
// Generated Mar 1, 2017 4:12:55 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Subscription generated by hbm2java
 */
public class Subscription implements java.io.Serializable {

	private BigDecimal subscriptionid;
	private Subscriptiontype subscriptiontype;
	private Date startdate;
	private Set clients = new HashSet(0);

	public Subscription() {
	}

	public Subscription(BigDecimal subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public Subscription(BigDecimal subscriptionid, Subscriptiontype subscriptiontype, Date startdate, Set clients) {
		this.subscriptionid = subscriptionid;
		this.subscriptiontype = subscriptiontype;
		this.startdate = startdate;
		this.clients = clients;
	}

	public BigDecimal getSubscriptionid() {
		return this.subscriptionid;
	}

	public void setSubscriptionid(BigDecimal subscriptionid) {
		this.subscriptionid = subscriptionid;
	}

	public Subscriptiontype getSubscriptiontype() {
		return this.subscriptiontype;
	}

	public void setSubscriptiontype(Subscriptiontype subscriptiontype) {
		this.subscriptiontype = subscriptiontype;
	}

	public Date getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Set getClients() {
		return this.clients;
	}

	public void setClients(Set clients) {
		this.clients = clients;
	}

}
