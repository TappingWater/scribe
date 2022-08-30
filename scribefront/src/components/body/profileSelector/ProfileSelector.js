import { useState } from "react";
import styles from "./ProfileSelector.module.css";

/**
 * Component that is responsible for rendering the profile
 * selection screen for the user upon first starting the application
 * where no state has been recorded.
 */
const ProfileSelector = (props) => {
	// Gets the list of configured profiles when application is started
	let [configuredProfiles, updateProfiles] = useState(props.profiles);
	let [selectedProf, updatedSelectedProfile] = useState(undefined);
	// Helper function that is used to generate the option tag that is
	// used in the rendered JSX
	let mapProfileOption = (profileName) => {
		return (
			<option value={profileName}>
				{profileName}
			</option>
		);
	};
	
	const onSelectProfile = (event) => {
		updatedSelectedProfile(event.target.value);
	}

	// Renders and returns the profile selector object
	return (
		<div className={`profile + ${styles.profile}`}>
			<form>				
				<label htmlFor="profileName">Choose Profile:</label>
				<select id="profileName" onChange={onSelectProfile} value={selectedProf}>					
					{configuredProfiles.map( (profile) => mapProfileOption(profile) )}
				</select>
				<button onClick={props.onSelectProfile(selectedProf)}>Select profile</button>
				<br></br>		
				<label htmlFor="createProfile">Create new profile:</label>
				<input id="createProfile" type='text'></input>
				<button>Create new profile</button>
				<br></br>				
			</form>
		</div>	
	);
}

export default ProfileSelector;