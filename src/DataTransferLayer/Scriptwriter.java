package DataTransferLayer;
// default package
// Generated 2017-02-28 18:17:33 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Scriptwriter generated by hbm2java
 */
public class Scriptwriter implements java.io.Serializable {

	private BigDecimal scriptwriterid;
	private String lastname;
	private String firstname;
	private Set movies = new HashSet(0);

	public Scriptwriter() {
	}

	public Scriptwriter(BigDecimal scriptwriterid) {
		this.scriptwriterid = scriptwriterid;
	}

	public Scriptwriter(BigDecimal scriptwriterid, String lastname, String firstname, Set movies) {
		this.scriptwriterid = scriptwriterid;
		this.lastname = lastname;
		this.firstname = firstname;
		this.movies = movies;
	}

	public BigDecimal getScriptwriterid() {
		return this.scriptwriterid;
	}

	public void setScriptwriterid(BigDecimal scriptwriterid) {
		this.scriptwriterid = scriptwriterid;
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

	public Set getMovies() {
		return this.movies;
	}

	public void setMovies(Set movies) {
		this.movies = movies;
	}

}