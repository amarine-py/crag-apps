const url = process.env.REACT_APP_API_URL;
const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";
import { findByState } from './profileAPI';

export async function findByStateName(stateName) {
    let parsedName = stateName.replaceAll(" ", "_").toUpperCase();
    findByState(parsedName)
      .then((profiles) => {
        console.log(profiles);
        let newProfilesByState = profiles;
        setProfilesByState(newProfilesByState);
        setMapClicked(true);
      })
      .catch((err) => console.error);
  };

//   export function filterBy

