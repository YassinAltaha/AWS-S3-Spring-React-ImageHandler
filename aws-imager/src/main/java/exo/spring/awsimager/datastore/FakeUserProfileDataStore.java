package exo.spring.awsimager.datastore;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import exo.spring.awsimager.profile.UserProfile;

@Repository
public class FakeUserProfileDataStore {

	private static final List<UserProfile> USER_PROFILES = new ArrayList<>();
	
	static {
		USER_PROFILES.add(new UserProfile(
				UUID.fromString("d88016cd-0239-4bba-b51d-d06501271e40"),
				"JanetRose",
				null
				)
				);
		USER_PROFILES.add(new UserProfile(
				UUID.fromString("f900a4d9-b1d2-416e-9827-0723db0a5a0e"),
				"JasimJones",
				null
				)
				);
	}
	
	public List<UserProfile> getUserProfiles(){
		return USER_PROFILES;
	}
	
}
