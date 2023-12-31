const climberBadgeUrl = `${process.env.REACT_APP_API_URL}/climber-badge`;
const badgeUrl = `${process.env.REACT_APP_API_URL}/badge`;
const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";

export async function validateNewClimberBadge(climberBadge) {
    if (climberBadge.awardeeId === climberBadge.giverId) {
        console.log("nice try")
        return false;
    }
    try {
        findClimberBadgesByAwardeeId(climberBadge.awardeeId)
        .then((currentAwardeeBadges) => {
            if (currentAwardeeBadges !== null) {
                for (let b of currentAwardeeBadges) {
                    console.log(`currentAwardeeBadge: ${b.badgeId}`)
                }
                
                const badgeIdList = currentAwardeeBadges.map((badge) => badge.badgeId);
                if (badgeIdList.includes(climberBadge.badgeId)) {
                    console.log("it includes it");
                    return false;
                } else {
                    // successful! We only return true so we can move on.
                    return true;
                }
            } else {
                return {
                    success: false,
                    message: "There was an error awarding this badge!"
                }
            }
        } )

    } catch(err) {
        console.log(err);
    }
}

export async function createNewClimberBadge(climberBadge) {

    const jwtToken = localStorage.getItem(LOCAL_STORAGE_TOKEN_KEY);
    const config = {
        method: 'POST',
        headers: {
            "Content-Type": "application/json",
            Accept: "application/json",
            Authorization: "Bearer " + jwtToken,
        },
        body: JSON.stringify(climberBadge),
    };

    const response = await fetch(climberBadgeUrl, config);
    if (response.status === 201) {
        return true;
    } else if (response.status === 400) {
        const result = await response.json();
        return {
            success: false,
            message: result.messages
        }
    } else {
        return Promise.reject("Unexpected error occurred awarding badge. Contact complaint department.");
    }
    
}

export async function findClimberBadgesByAwardeeId(climberId) {
    try {
        const response = await fetch(`${climberBadgeUrl}/awardee=${climberId}`);
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

// Fetch all badges based on the badge IDs in an array of ClimberBadges
export async function findAllBadgesById(climberBadges) {
    let idArray = [];
    if (climberBadges.length < 1 || climberBadges === null) {
        console.log("Climber Badges array was length 0 or null.");
        return [];
    }
    climberBadges.forEach((value) => {
        idArray.push(value.badgeId);
    });
    let badgeArray = [];
    if (idArray.length < 0 || idArray === null) {
        console.log("Array of badge IDs was length 0 or null.");
        return [];
    }
    for (let i = 0; i < idArray.length; i++) {
        const waitBadge = await fetchBadge(idArray[i]);
        badgeArray.push(waitBadge);
    }
    return badgeArray;
}

export async function fetchBadge(value) {
    try {
        const response = await fetch(`${badgeUrl}/id=${value}`);
        if (response.status === 200) {
            const result = await response.json();
            return result;
        } else {
            return null;
        }
    } catch(err) {
        console.log(`Caught an error in fetching badges by ID: ${err}`);
        return null;
    }
}

export async function findAllBadges() {
    try {
        const response = await fetch(`${badgeUrl}`);
        if (response.status === 200) {
            const result = await response.json();
            return result;
        } else {
            console.log("Find all badges did not produce a 200 status: ", response);
            return [];
        }
    } catch(err) {
        console.log(`Caught an error fetching all badges: ${err}`);
        return [];
    }
}