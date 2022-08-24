package com.parquet.backend.scribe.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.parquet.backend.scribe.controller.util.ResponseEntityWrapper;
import com.parquet.backend.scribe.model.Profile;
import com.parquet.backend.scribe.service.ProfileService;
import lombok.AllArgsConstructor;

/**
 * Class that maps and handles incoming requests to the application
 * that are related to profiles.
 */
@RestController
@RequestMapping("/profiles")
@AllArgsConstructor
public class ProfileController {
	
	private final ProfileService profileService;

	/**
	 * Gets a list of profiles that have been configured 
	 * to the application
	 */
	@GetMapping("") 
	public ResponseEntity<List<Profile>> getAllProfiles() {
		ResponseEntityWrapper<List<Profile>> profiles = new ResponseEntityWrapper<>(profileService.getAllProfiles());
		return profiles.getResponseEntity();
	}

	/**
	 * Gets a list of profiles that have been configured 
	 * to the application
	 */
	@GetMapping("/{id}") 
	public ResponseEntity<Profile> getllProfileById(@PathVariable String id) {
		ResponseEntityWrapper<Profile> profile = new ResponseEntityWrapper<>(profileService.getProfileById(id));
		return profile.getResponseEntity();
	}

	/**
	 * Create and configure a new profile to the application.
	 * 
	 * @RequestBody profile
	 * 	Profile to create passed in args
	 */
	@PostMapping("")
	public ResponseEntity<Profile> createNewProfile(@RequestBody Profile profile) {
		Profile newProfile = profileService.createProfile(profile);
		if (newProfile == null) {
			ResponseEntityWrapper<Profile> errorWrapper = new ResponseEntityWrapper<Profile>(null, HttpStatus.BAD_REQUEST);
			return errorWrapper.getResponseEntity();
		} else {
			ResponseEntityWrapper<Profile> createdWrapper = new ResponseEntityWrapper<Profile>(newProfile, HttpStatus.CREATED);
			return createdWrapper.getResponseEntity();
		}
	}

	/**
	 * Removes a configured profile from the application
	 * 
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteProfile(@PathVariable("id") String id) {
		boolean deleted = profileService.deleteProfile(id);
		if (deleted) {
			ResponseEntityWrapper<Boolean> deletedWrapper = new ResponseEntityWrapper<Boolean>(deleted, HttpStatus.OK);
			return deletedWrapper.getResponseEntity();
		} else {
			ResponseEntityWrapper<Boolean> deletedWrapper = new ResponseEntityWrapper<Boolean>(deleted, HttpStatus.BAD_REQUEST);
			return deletedWrapper.getResponseEntity();
		}
	}
}
