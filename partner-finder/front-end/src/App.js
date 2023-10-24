import { useState, useEffect, useCallback } from "react";
import { BrowserRouter as Router, Route, Routes, useNavigate, Navigate } from "react-router-dom";
import jwtDecode from "jwt-decode";
import Error from "./components/Error";
import Home from "./components/Home";
import NavBar from "./components/NavBar";
import NotFound from "./components/NotFound";
import AuthContext from "./context/AuthContext";
import ClimberContext from "./context/ClimberContext";
import UserRegistrationForm from "./components/UserRegistrationForm";
import LoginForm from "./components/LoginForm";
import ClimberProfile from "./components/Profile/ClimberProfile";
import ProfileForm from "./components/Profile/ProfileForm";
import { findByEmail } from "./services/climberAPI";
import { refreshToken, logout, makeUserFromJwt } from "./services/authAPI";

// Define a variable for the localStorage token item key
const TIMEOUT_MILLISECONDS = 14 * 60 * 1000;
const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";

function App() {
  const [user, setUser] = useState(null);
  const [climber, setClimber] = useState(null);
  // Define a state variable to track if 
  // the initialization attempt has completed or not
  const [userInitialized, setUserInitialized] = useState(false);
  const [climberInitialized, setClimberInitialized] = useState(false);
  const navigate = useNavigate();

  useEffect( () => {
    const token = localStorage.getItem(LOCAL_STORAGE_TOKEN_KEY);
    if (token) {
      let appUser = makeUserFromJwt(token);
      setUser(appUser);
      console.log("User has been set in App.js: ");
      console.log(user);
    }
  }, []);

  const resetUser = useCallback(() => {
    refreshToken()
      .then((user) => {
        setUser(user);
        setTimeout(resetUser, TIMEOUT_MILLISECONDS);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => setUserInitialized(true));
  }, []);

  // Define a useEffect hook callback function to attempt
  // to restore the user's token from localStorage
  useEffect(() => {
    resetUser();
  }, [resetUser]);

  useEffect(() => {
    if (user) {
      console.log(user.username);
      findByEmail(user.username)
      .then((climbers) => {
        setClimber(climbers[0]);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => setClimberInitialized(true));
    }
  }, [user]);

  const auth = {
    user: user,
    handleLoggedIn(user) {
      setUser(user);
      setTimeout(resetUser, TIMEOUT_MILLISECONDS);
    },
    hasAuthority(authority) {
      return user?.authorities.includes(authority);
    },
    logout() {
      logout();
      setUser(null);
      navigate("/");
    },
  };

  if (!userInitialized) {
    return null;
  }
  
  const renderWithAuthority = (Component, ...authorities) => {
    for (let authority of authorities) {
      if (auth.hasAuthority(authority)) {
        return <Component />;
      }
    }
    return <Error />;
  };
  
  return (
    <AuthContext.Provider value={auth}>
      <ClimberContext.Provider value={climber}>
      
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/login" element={!user ? <LoginForm /> : <Navigate to="/" replace={true} />} />
          <Route path="/register" element={<UserRegistrationForm />} />
          <Route path="/profile" element={ <ClimberProfile initialized={climberInitialized} /> } />
          <Route path="/profile/create" element={ <ProfileForm />} />
          <Route path="/error" element={<Error />}/>
          <Route path="*" element={<NotFound />}/>
        </Routes>
      </ClimberContext.Provider>
    </AuthContext.Provider>
  );
}

export default App;
