package spittr.entity;

import java.util.Date;

/**
 * spittle entity
 * @author V4TOR
 *
 */
public class Spittle {
	private Long id;
	private String message;
	private Date time;
	private double latitude;
	private double longitude;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTime() {
		return time;
	}
	
	public void setTime(Date time) {
		this.time = time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public Double getLongitude() {
		return longitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public boolean equals(Object that) {
		return true;
		//return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}

	@Override
	public int hashCode() {
		return 1;
		//return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}

}