const url = process.env.REACT_APP_API_URL;
const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";


export async function login(credentials) {

  const init = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
    },
    body: JSON.stringify(credentials)
  };

  const response = await fetch(url + '/login', init);
  if (response.status === 200) {
    const jwtTokenResponse = await response.json();
    localStorage.setItem(LOCAL_STORAGE_TOKEN_KEY, jwtTokenResponse.jwt_token);
    return makeUserFromJwt(jwtTokenResponse.jwt_token);
  } else {
    return Promise.reject('Unauthorized.');
  }
}

export async function register(credentials) {
  const init = {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
    },
    body: JSON.stringify(credentials)
  };

  const response = await fetch(url + '/register', init);
  if (response.status === 400) {
    console.log("We got to the 400 status section, but...");
    const result = response.json();
    console.log(result);
    return result;
  } else if (response.status !== 201) {
    return Promise.reject("Unexpected error, oops.");
  } else {
    return response.json();
  }
}

export async function refreshToken() {

  const jwtToken = localStorage.getItem(LOCAL_STORAGE_TOKEN_KEY);
  if (!jwtToken) {
    return Promise.reject('Unauthorized.')
  }

  const init = {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Authorization': 'Bearer ' + jwtToken
    }
  }

  const response = await fetch(url + '/refresh-token', init);
  if (response.status === 200) {
    const jwtTokenResponse = await response.json();
    localStorage.setItem(LOCAL_STORAGE_TOKEN_KEY, jwtTokenResponse.jwt_token);
    return makeUserFromJwt(jwtTokenResponse.jwt_token);
  } else {
    localStorage.removeItem(LOCAL_STORAGE_TOKEN_KEY);
    return Promise.reject('Unauthorized.');
  }
}

export function logout() {
  localStorage.removeItem(LOCAL_STORAGE_TOKEN_KEY);

}

export function makeUserFromJwt(jwtToken) {
  const jwtParts = jwtToken.split('.');
  if (jwtParts.length === 3) {
    const userData = atob(jwtParts[1]);
    const decodedToken = JSON.parse(userData);
    return {
      username: decodedToken.sub,
      authorities: decodedToken.authorities
    };
  }
}