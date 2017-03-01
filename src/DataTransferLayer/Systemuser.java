package DataTransferLayer;
// default package
// Generated 2017-02-28 18:17:33 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * Systemuser generated by hbm2java
 */
public class Systemuser implements java.io.Serializable {

	private BigDecimal systemuserid;
	private Province province;
	private String lastname;
	private String firstname;
	private String email;
	private String phonenumber;
	private Date birthdate;
	private String password;
	private BigDecimal civicnumber;
	private String streetname;
	private String postalcode;
	private String cityname;
	private Client client;
	private Employee employee;

	public Systemuser() {
	}

	public Systemuser(BigDecimal systemuserid, String lastname, String firstname, String email, String phonenumber,
			Date birthdate, String password, BigDecimal civicnumber, String streetname, String postalcode,
			String cityname) {
		this.systemuserid = systemuserid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
		this.password = password;
		this.civicnumber = civicnumber;
		this.streetname = streetname;
		this.postalcode = postalcode;
		this.cityname = cityname;
	}

	public Systemuser(BigDecimal systemuserid, Province province, String lastname, String firstname, String email,
			String phonenumber, Date birthdate, String password, BigDecimal civicnumber, String streetname,
			String postalcode, String cityname, Client client, Employee employee) {
		this.systemuserid = systemuserid;
		this.province = province;
		this.lastname = lastname;
		this.firstname = firstname;
		this.email = email;
		this.phonenumber = phonenumber;
		this.birthdate = birthdate;
		this.password = password;
		this.civicnumber = civicnumber;
		this.streetname = streetname;
		this.postalcode = postalcode;
		this.cityname = cityname;
		this.client = client;
		this.employee = employee;
	}

	public BigDecimal getSystemuserid() {
		return this.systemuserid;
	}

	public void setSystemuserid(BigDecimal systemuserid) {
		this.systemuserid = systemuserid;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getCivicnumber() {
		return this.civicnumber;
	}

	public void setCivicnumber(BigDecimal civicnumber) {
		this.civicnumber = civicnumber;
	}

	public String getStreetname() {
		return this.streetname;
	}

	public void setStreetname(String streetname) {
		this.streetname = streetname;
	}

	public String getPostalcode() {
		return this.postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}