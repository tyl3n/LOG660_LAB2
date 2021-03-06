// default package
// Generated Mar 1, 2017 4:12:55 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Country generated by hbm2java
 */
public class Country implements java.io.Serializable {

	private BigDecimal countryid;
	private String name;
	private Set movies = new HashSet(0);

	public Country() {
	}

	public Country(BigDecimal countryid, String name) {
		this.countryid = countryid;
		this.name = name;
	}

	public Country(BigDecimal countryid, String name, Set movies) {
		this.countryid = countryid;
		this.name = name;
		this.movies = movies;
	}

	public BigDecimal getCountryid() {
		return this.countryid;
	}

	public void setCountryid(BigDecimal countryid) {
		this.countryid = countryid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getMovies() {
		return this.movies;
	}

	public void setMovies(Set movies) {
		this.movies = movies;
	}

}
