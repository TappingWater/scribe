import ProfileSelector from "./profileSelector/ProfileSelector";
import { useState } from "react";

/**
 * This component is the parent component of the UI panel that the user interacts
 * with as well as the navigation bar. If a profile has not been selected will render
 * the profile selector component by default.
 */
function Body() {
	// 
	let [selectedProfile, updateSelectedProfile] = useState(undefined);

	let profiles = ['default', 'test', 'new'];

	// The application data is tied to a profile and to initialize the panel
	// a profile needs to be created or an existing one needs to be selected.
	// If no profile has been selected such as when the app is first initialized
	// it renders the profile selector component.
	if (selectedProfile == undefined) {
		return (
			<div className="body">			
				<ProfileSelector profiles={profiles}></ProfileSelector>
	    		</div>	
		)
	} else {
		return (
			<div className="body">
				<h2>nnn</h2>
			</div>
		)
	}
}

export default Body;