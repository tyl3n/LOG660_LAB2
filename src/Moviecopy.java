



// Generated 2017-02-28 18:17:33 by Hibernate Tools 4.3.1.Final

/**
 * Moviecopy generated by hbm2java
 */
public class Moviecopy implements java.io.Serializable {

	private MoviecopyId id;
	private Movie movie;
	private Client client;

	public Moviecopy() {
	}

	public Moviecopy(MoviecopyId id, Movie movie) {
		this.id = id;
		this.movie = movie;
	}

	public Moviecopy(MoviecopyId id, Movie movie, Client client) {
		this.id = id;
		this.movie = movie;
		this.client = client;
	}

	public MoviecopyId getId() {
		return this.id;
	}

	public void setId(MoviecopyId id) {
		this.id = id;
	}

	public Movie getMovie() {
		return this.movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}