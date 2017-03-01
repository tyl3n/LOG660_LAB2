// default package
// Generated 2017-02-28 18:17:33 by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;

/**
 * MovieactorId generated by hbm2java
 */
public class MovieactorId implements java.io.Serializable {

	private BigDecimal movieid;
	private BigDecimal actorid;
	private String character;

	public MovieactorId() {
	}

	public MovieactorId(BigDecimal movieid, BigDecimal actorid, String character) {
		this.movieid = movieid;
		this.actorid = actorid;
		this.character = character;
	}

	public BigDecimal getMovieid() {
		return this.movieid;
	}

	public void setMovieid(BigDecimal movieid) {
		this.movieid = movieid;
	}

	public BigDecimal getActorid() {
		return this.actorid;
	}

	public void setActorid(BigDecimal actorid) {
		this.actorid = actorid;
	}

	public String getCharacter() {
		return this.character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MovieactorId))
			return false;
		MovieactorId castOther = (MovieactorId) other;

		return ((this.getMovieid() == castOther.getMovieid()) || (this.getMovieid() != null
				&& castOther.getMovieid() != null && this.getMovieid().equals(castOther.getMovieid())))
				&& ((this.getActorid() == castOther.getActorid()) || (this.getActorid() != null
						&& castOther.getActorid() != null && this.getActorid().equals(castOther.getActorid())))
				&& ((this.getCharacter() == castOther.getCharacter()) || (this.getCharacter() != null
						&& castOther.getCharacter() != null && this.getCharacter().equals(castOther.getCharacter())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMovieid() == null ? 0 : this.getMovieid().hashCode());
		result = 37 * result + (getActorid() == null ? 0 : this.getActorid().hashCode());
		result = 37 * result + (getCharacter() == null ? 0 : this.getCharacter().hashCode());
		return result;
	}

}
