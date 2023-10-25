const climberBadgeUrl = `${process.env.REACT_APP_API_URL}/climber-badge`;
const badgeUrl = `${process.env.REACT_APP_API_URL}/badge`;

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
        console.log(`Badge.api idArray[${i}] is: `, idArray[i]);
        const waitBadge = await fetchBadge(idArray[i]);
        badgeArray.push(waitBadge);
    }
    return badgeArray;
}

async function fetchBadge(value) {
    try {
        const response = await fetch(`${badgeUrl}/id=${value}`);
        if (response.status === 200) {
            const result = await response.json();
            // badgeArray.push(result);
            return result;
        } else {
            return null;
        }
    } catch(err) {
        console.log(`Caught an error in fetching badges by ID: ${err}`);
        return null;
    }
}