const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";
const url = `${process.env.REACT_APP_API_URL}/profile`;

export async function findByClimberId(climberId) {
    console.log("Find profile by climberID");
    
    try {
        const response = await fetch(`${url}/climber-id=${climberId}`);
        if (response.status === 200) {
        return await response.json();
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
        return await response.json();
    } else if (response.status === 400) {
        const result = await response.json();
        return { errors: result.messages };
    } else {
        return Promise.reject("Unexpected error occurred. Contact complaint department.");
    }
}
