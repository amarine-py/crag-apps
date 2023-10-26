import { useState, useEffect, useCallback } from "react";
import { BrowserRouter as Router, Route, Routes, useNavigate, Navigate } from "react-router-dom";
import jwtDecode from "jwt-decode";
import Error from "./components/Error";
import Home from "./components/Home";
import About from "./components/About";
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
import mapboxgl from '!mapbox-gl'; // eslint-disable-line import/no-webpack-loader-syntax
import PartnerProfile from "./components/Profile/PartnerProfile";
import EditProfile from "./components/Profile/EditProfile";
import AwardBadge from "./components/Badge/AwardBadge";
 
mapboxgl.accessToken = 'pk.eyJ1IjoiYW1hcmluZSIsImEiOiJjbG5xaDExNWQwZmt2MnZtaGl4dXNnY3l0In0.B8f5WdHtDgqY4g6zlJzguQ';

// Define a variable for the localStorage token item key
const TIMEOUT_MILLISECONDS = 14 * 60 * 1000;
const LOCAL_STORAGE_TOKEN_KEY = "partnerFinderToken";

function App() {
  const [user, setUser] = useState(null);
  const [restoreLoginAttemptCompleted, setRestoreLoginAttemptCompleted] = useState(false);
  const [climber, setClimber] = useState(null);
  // Define a state variable to track if 
  // the initialization attempt has completed or not
  const [userInitialized, setUserInitialized] = useState(false);
  const [climberInitialized, setClimberInitialized] = useState(false);
  const navigate = useNavigate();

  // Define a useEffect hook callback function to attempt
  // to restore the user's token from localStorage
  useEffect(() => {
    const token = localStorage.getItem(LOCAL_STORAGE_TOKEN_KEY);
    if (token) {
      login(token);
    }
    setRestoreLoginAttemptCompleted(true);
  }, []);

  useEffect(() => {
    if (user) {
      loadClimber(user.username);
    }
  }, [user]);

  const loadClimber = async (username) => {
    findByEmail(username)
      .then((climbers) => {
        setClimber(climbers[0]);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => setClimberInitialized(true));
  };

  // Define a login function
  const login = (token) => {
    localStorage.setItem(LOCAL_STORAGE_TOKEN_KEY, token);
    // Decode the token
    const { sub: username, authorities: authoritiesString } = jwtDecode(token);
    // // Split the authorities string into an array of roles
    // const roles = authoritiesString.split(',');
    const roles = authoritiesString
  
    // Create the "user" object
    const user = {
      username,
      roles,
      token,
      hasRole(role) {
        return this.roles.includes(role);
      }
    };
    setUser(user);
    return user;
  };

  const logout = () => {
    setUser(null);
    localStorage.removeItem(LOCAL_STORAGE_TOKEN_KEY);
    navigate("/");
  };

  const auth = {
    user: user ? { ...user } : null,
    login,
    logout
  };

  if (!restoreLoginAttemptCompleted) {
    return null;
  }
  
  return (
    <AuthContext.Provider value={auth}>
      <ClimberContext.Provider value={climber}>
      
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/login" element={!user ? <LoginForm /> : <Navigate to="/" replace={true} />} />
          <Route path="/register" element={<UserRegistrationForm />} />
          <Route path="/about" element={<About />} />
          <Route path="/profile" element={ <ClimberProfile climber={climber}/> } />
          <Route path="/profile/create" element={ <ProfileForm />} />
          <Route path="/profile/edit" element={ <EditProfile />} />
          <Route path="/partner/:profileId" element={<PartnerProfile />} />
          <Route path="/badge/award/:badgeId" element={<AwardBadge /> } />
          <Route path="/error" element={<Error />}/>
          <Route path="*" element={<NotFound />}/>
        </Routes>
      </ClimberContext.Provider>
    </AuthContext.Provider>
  );
}

export default App;
