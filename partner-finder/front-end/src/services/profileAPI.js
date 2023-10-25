const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";
const url = `${process.env.REACT_APP_API_URL}/profile`;

export async function findByProfileId(profileId) {
    try {
        const response = await fetch(`${url}/id=${profileId}`);
        if (response.status === 200) {
            const result = await response.json();
            return result;
        } else {
            return null;
        }
    } catch(err) {
        console.log(`Caught an error in finding Profile by profile ID: ${err}`);
        return null;
    } 
}

export async function findByClimberId(climberId) {
    try {
        const response = await fetch(`${url}/climber-id=${climberId}`);
        if (response.status === 200) {
            const result = await response.json();
            return result;
        } else {
            return null;
        }
    } catch(err) {
        console.log(`Caught an error in finding Profile by climber ID: ${err}`);
        return null;
    } 
    
}

export async function createNewProfile(profileInfo) {
    const config = {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
        },
        body: JSON.stringify(profileInfo),
    }; 
    const response = await fetch(`${url}`, config);
    if (response.status === 201) {
        const result = await response.json();
        return result;
    } else if (response.status === 400) {
        const result = await response.json();
        return { errors: result.messages };
    } else {
        return Promise.reject("Unexpected error occurred. Contact complaint department.");
    }
}

export async function findTopTenProfiles() {
    const config = {
        method: 'GET',
        headers: {
            Accept: "application/json",
        }
    };

    const response = await fetch(`${url}/top-10`, config);
    if (response.status === 200) {
        const tops = await response.json();
        return tops;
    } else if (response.status === 400) {
        const result = await response.json();
        return { errors: result.messages };
    } else {
        return Promise.reject("Unexpected error occurred. Contact complaint department.");
    }
}

export async function findByState(stateName) {
    const config = {
        method: 'GET',
        headers: {
            Accept: "application/json",
        }
    };

    const response = await fetch(`${url}/state=${stateName}`, config);
    if (response.status === 200) {
        const byState = await response.json();
        return byState;
    } else if (response.status === 400) {
        const result = await response.json();
        return { errors: result.messages };
    } else {
        return Promise.reject("Unexpected error occurred. Contact complaint department.");
    }
}
