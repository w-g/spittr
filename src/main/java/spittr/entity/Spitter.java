package spittr.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * spitter entity
 * 
 * @author V4TOR
 *
 */
public class Spitter {

	@NotNull
	private long id;
	
	@NotNull
	@Size(min = 5, max = 16)
	private String firstName;
	
	@NotNull
	@Size(min = 5, max = 16)
	private String lastName;
	
	@NotNull
	@Size(min = 5, max = 16)
	private String username;
	
	@NotNull
	@Size(min = 5, max = 16)
	private String password;

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
