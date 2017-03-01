package DataTransferLayer;
// default package
// Generated 2017-02-28 18:17:33 by Hibernate Tools 4.3.1.Final

/**
 * Biography generated by hbm2java
 */
public class Biography implements java.io.Serializable {

	private BiographyId id;
	private Crewmember crewmember;

	public Biography() {
	}

	public Biography(BiographyId id, Crewmember crewmember) {
		this.id = id;
		this.crewmember = crewmember;
	}

	public BiographyId getId() {
		return this.id;
	}

	public void setId(BiographyId id) {
		this.id = id;
	}

	public Crewmember getCrewmember() {
		return this.crewmember;
	}

	public void setCrewmember(Crewmember crewmember) {
		this.crewmember = crewmember;
	}

}