// default package
// Generated Mar 1, 2017 4:12:55 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Creditcard generated by hbm2java
 */
public class Creditcard implements java.io.Serializable {

	private BigDecimal creditcardid;
	private String type;
	private String cardnumber;
	private BigDecimal expirymonth;
	private BigDecimal expiryyear;
	private String cvv;
	private Set clients = new HashSet(0);

	public Creditcard() {
	}

	public Creditcard(BigDecimal creditcardid, String type, String cardnumber, BigDecimal expirymonth,
			BigDecimal expiryyear) {
		this.creditcardid = creditcardid;
		this.type = type;
		this.cardnumber = cardnumber;
		this.expirymonth = expirymonth;
		this.expiryyear = expiryyear;
	}

	public Creditcard(BigDecimal creditcardid, String type, String cardnumber, BigDecimal expirymonth,
			BigDecimal expiryyear, String cvv, Set clients) {
		this.creditcardid = creditcardid;
		this.type = type;
		this.cardnumber = cardnumber;
		this.expirymonth = expirymonth;
		this.expiryyear = expiryyear;
		this.cvv = cvv;
		this.clients = clients;
	}

	public BigDecimal getCreditcardid() {
		return this.creditcardid;
	}

	public void setCreditcardid(BigDecimal creditcardid) {
		this.creditcardid = creditcardid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCardnumber() {
		return this.cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public BigDecimal getExpirymonth() {
		return this.expirymonth;
	}

	public void setExpirymonth(BigDecimal expirymonth) {
		this.expirymonth = expirymonth;
	}

	public BigDecimal getExpiryyear() {
		return this.expiryyear;
	}

	public void setExpiryyear(BigDecimal expiryyear) {
		this.expiryyear = expiryyear;
	}

	public String getCvv() {
		return this.cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public Set getClients() {
		return this.clients;
	}

	public void setClients(Set clients) {
		this.clients = clients;
	}

}
