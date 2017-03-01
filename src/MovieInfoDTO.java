import java.math.BigDecimal;

public class MovieInfoDTO {
	public BigDecimal movieID;
	public String title;
	public int releaseYear;
	public String directorName;
	
	MovieInfoDTO(BigDecimal movieID, String title, int releaseYear, String directorName) {
		this.movieID = movieID;
		this.title = title;
		this.releaseYear = releaseYear;
		this.directorName = directorName;
	}
}
