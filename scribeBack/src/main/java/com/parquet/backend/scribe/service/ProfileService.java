package com.parquet.backend.scribe.service;

import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;
import com.parquet.backend.scribe.model.Profile;
import com.parquet.backend.scribe.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;

/**
 * Service class that handles business logic related to profile
 * objects within this application.
 */
@Service
@RequiredArgsConstructor
public class ProfileService {

	private final ProfileRepository profileRepository;

	/**
	 * Get all  profiles  currently configured within this 
	 * application's sqlite db file.
	 * 
	 * @return 
	 * 	list of profiles returned by jpa repo
	 */	
	public List<Profile> getAllProfiles() {
		return profileRepository.findAll();
	}

	/**
	 * Get a paritcular profile by the id
	 * 
	 * @return
	 * 	profile that matches the id passed or null otherwise
	 */
	public Profile getProfileById(String profileId) {
		return profileRepository.findById(profileId).get();
	}

	/**
	 * Create a new profile object
	 * 
	 * @return
	 * 	the created profile object
	 */
	public Profile createProfile(Profile profile) {
		return profileRepository.save(profile);
	}

	/**
	 * Deletes a profile object and all stored configurations
	 * @return
	 * 	True if valuue exists and can be deleted or false otherwise
	 */
	public boolean deleteProfile(String id) {
		if (profileRepository.existsById(id)) {
			profileRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
