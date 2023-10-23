const url = `${process.env.REACT_APP_API_URL}/profile`;

export async function findByClimberId(climberId) {
    console.log("Find profile by climberID");
    const response = await fetch(`${url}/climber-id=${climberId}`);
    if (response.status===200) {
        return response.json();
    } else {
        console.log(response);
        return response.json();
    }
}