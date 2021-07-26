package exo.spring.awsimager.profile;

import java.util.Optional;
import java.util.UUID;

public class UserProfile {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userProfileID == null) ? 0 : userProfileID.hashCode());
		result = prime * result + ((userProfileImageLink == null) ? 0 : userProfileImageLink.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		if (userProfileID == null) {
			if (other.userProfileID != null)
				return false;
		} else if (!userProfileID.equals(other.userProfileID))
			return false;
		if (userProfileImageLink == null) {
			if (other.userProfileImageLink != null)
				return false;
		} else if (!userProfileImageLink.equals(other.userProfileImageLink))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	
	public UUID getUserProfileID() {
		return userProfileID;
	}
	public void setUserProfileID(UUID userProfileID) {
		this.userProfileID = userProfileID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Optional<String> getUserProfileImageLink() {
		return Optional.ofNullable(userProfileImageLink) ;
	}
	public void setUserProfileImageLink(String userProfileImageLink) {
		this.userProfileImageLink = userProfileImageLink;
	}
	
	
	
	public UserProfile(UUID userProfileID, String username, String userProfileImageLink) {
		super();
		this.userProfileID = userProfileID;
		this.username = username;
		this.userProfileImageLink = userProfileImageLink;
	}
	private UUID userProfileID;
	private String username;
	private String userProfileImageLink; //S3 Key link

}
