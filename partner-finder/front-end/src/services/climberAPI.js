const url = `${process.env.REACT_APP_API_URL}/climber`;
const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";

export async function findAllClimbers() {
    const response = await fetch(url);
    if (response.status === 200) {
        return response.json();
    } else {
        console.log("Error fetching all climbers. ", response);
    }
}

export async function findClimberByClimberId(climberId) {
    const response = await fetch(`${url}/id=${climberId}`);
    if (response.status === 200) {
        return response.json();
    } else {
        console.log("Error fetching climber by climberId");
    }
}
export async function findByEmail(email) {
    const response = await fetch(`${url}/email=${email}`);
    if (response.status === 200) {
        return response.json();
    } else {
        console.log("Error fetching climber by email");
    }
}

export async function createClimber(climberInfo) {
    const config = {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            
        },
        body: JSON.stringify(climberInfo),
    };

    const response = await fetch(url, config);
    if (response.status === 201) {
        return response.json();
    } else if (response.status === 400) {
        const result = await response.json();
        return { errors: result.messages };
    } else {
        return Promise.reject("Unexpected error occurred creating climber. Contact complaint department.");
    }

}

export async function saveClimber(climberInfo) {
    const jwtToken = localStorage.getItem(LOCAL_STORAGE_TOKEN_KEY);
    if (!jwtToken) {
        return Promise.reject("Unauthorized.");
    }

    console.log("climberAPI.js");
    console.log(climberInfo);

    const config = {
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + jwtToken,
        },
        body: JSON.stringify(climberInfo),
    };

    if (climberInfo.climberId > 0) {
        config.method = "PUT";
        const response = await fetch(`${url}/${climberInfo.climberId}`, config);
        if (response.status === 400) {
            const result = await response.json();
            return { errors: result.message };
        } else if (response.status === 404) {
            return Promise.reject(`Climber with ID: ${climberInfo.climberId} could not be found.`);
        } else if (response.status !== 203) {
            return Promise.reject("Unexpected error occurred. Contact complaint department.");
        } 
    } else {
        config.method = "POST";
        const response = await fetch(url, config);
        if (response.status === 201) {
        return response.json();
        } else if (response.status === 400) {
        const result = await response.json();
        return { errors: result.messages };
        } else {
        return Promise.reject("Unexpected error occurred. Contact complaint department.");
        }
    }
}



