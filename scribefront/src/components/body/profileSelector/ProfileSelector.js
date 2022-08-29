import { useState } from "react";

/**
 * Component that is responsible for rendering the profile
 * selection screen for the user upon first starting the application
 * where no state has been recorded.
 */
const ProfileSelector = (props) => {
	// Gets the list of configured profiles when application is started
	let [configuredProfiles, updateProfiles] = useState(props.profiles);
	
	let mapProfileOption = (profileName) => {
		console.log(profileName);
		return (
			<option value={profileName}>
				{profileName}
			</option>
		);
	};

	return (
		<div className="profile">
			<form>				
				<label htmlFor="profileName">Choose Profile:</label>
				<select id="profileName">					
					{configuredProfiles.map( (profile) => mapProfileOption(profile) )}
				</select>
				<br></br>		
				<label htmlFor="createProfile">Create new profile:</label>
				<input id="createProfile" type='text'></input>
				<button>Create Profile</button>
				<br></br>				
			</form>
		</div>	
	);
}

export default ProfileSelector;