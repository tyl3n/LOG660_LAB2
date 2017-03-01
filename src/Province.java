// default package
// Generated Mar 1, 2017 4:12:55 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

/**
 * Province generated by hbm2java
 */
public class Province implements java.io.Serializable {

	private String provincecode;
	private String name;
	private Set systemusers = new HashSet(0);

	public Province() {
	}

	public Province(String provincecode, String name) {
		this.provincecode = provincecode;
		this.name = name;
	}

	public Province(String provincecode, String name, Set systemusers) {
		this.provincecode = provincecode;
		this.name = name;
		this.systemusers = systemusers;
	}

	public String getProvincecode() {
		return this.provincecode;
	}

	public void setProvincecode(String provincecode) {
		this.provincecode = provincecode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getSystemusers() {
		return this.systemusers;
	}

	public void setSystemusers(Set systemusers) {
		this.systemusers = systemusers;
	}

}
