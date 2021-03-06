// default package
// Generated Mar 1, 2017 4:12:55 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Movie generated by hbm2java
 */
public class Movie implements java.io.Serializable {

	private BigDecimal movieid;
	private Crewmember crewmember;
	private Synopsis synopsis;
	private String title;
	private BigDecimal releaseyear;
	private BigDecimal length;
	private String language;
	private Set movieactors = new HashSet(0);
	private Set moviecopies = new HashSet(0);
	private Set genres = new HashSet(0);
	private Set movieactors_1 = new HashSet(0);
	private Set countries = new HashSet(0);
	private Set scriptwriters = new HashSet(0);

	public Movie() {
	}

	public Movie(BigDecimal movieid, BigDecimal releaseyear, BigDecimal length) {
		this.movieid = movieid;
		this.releaseyear = releaseyear;
		this.length = length;
	}

	public Movie(BigDecimal movieid, Crewmember crewmember, Synopsis synopsis, String title, BigDecimal releaseyear,
			BigDecimal length, String language, Set movieactors, Set moviecopies, Set genres, Set movieactors_1,
			Set countries, Set scriptwriters) {
		this.movieid = movieid;
		this.crewmember = crewmember;
		this.synopsis = synopsis;
		this.title = title;
		this.releaseyear = releaseyear;
		this.length = length;
		this.language = language;
		this.movieactors = movieactors;
		this.moviecopies = moviecopies;
		this.genres = genres;
		this.movieactors_1 = movieactors_1;
		this.countries = countries;
		this.scriptwriters = scriptwriters;
	}

	public BigDecimal getMovieid() {
		return this.movieid;
	}

	public void setMovieid(BigDecimal movieid) {
		this.movieid = movieid;
	}

	public Crewmember getCrewmember() {
		return this.crewmember;
	}

	public void setCrewmember(Crewmember crewmember) {
		this.crewmember = crewmember;
	}

	public Synopsis getSynopsis() {
		return this.synopsis;
	}

	public void setSynopsis(Synopsis synopsis) {
		this.synopsis = synopsis;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getReleaseyear() {
		return this.releaseyear;
	}

	public void setReleaseyear(BigDecimal releaseyear) {
		this.releaseyear = releaseyear;
	}

	public BigDecimal getLength() {
		return this.length;
	}

	public void setLength(BigDecimal length) {
		this.length = length;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set getMovieactors() {
		return this.movieactors;
	}

	public void setMovieactors(Set movieactors) {
		this.movieactors = movieactors;
	}

	public Set getMoviecopies() {
		return this.moviecopies;
	}

	public void setMoviecopies(Set moviecopies) {
		this.moviecopies = moviecopies;
	}

	public Set getGenres() {
		return this.genres;
	}

	public void setGenres(Set genres) {
		this.genres = genres;
	}

	public Set getMovieactors_1() {
		return this.movieactors_1;
	}

	public void setMovieactors_1(Set movieactors_1) {
		this.movieactors_1 = movieactors_1;
	}

	public Set getCountries() {
		return this.countries;
	}

	public void setCountries(Set countries) {
		this.countries = countries;
	}

	public Set getScriptwriters() {
		return this.scriptwriters;
	}

	public void setScriptwriters(Set scriptwriters) {
		this.scriptwriters = scriptwriters;
	}

}
