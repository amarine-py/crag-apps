import { useState, useEffect, useCallback } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import jwtDecode from "jwt-decode";
import Error from "./components/Error";
import Home from "./components/Home";
import NavBar from "./components/NavBar";
import NotFound from "./components/NotFound";
import AuthContext from "./context/AuthContext";
import ClimberContext from "./context/ClimberContext";
import UserRegistrationForm from "./components/UserRegistrationForm";
import LoginForm from "./components/LoginForm";
import ClimberProfile from "./components/ClimberProfile";
import { findByEmail } from "./services/climberAPI";
import { refreshToken, logout } from "./services/authAPI";


// Define a variable for the localStorage token item key
const TIMEOUT_MILLISECONDS = 14 * 60 * 1000;

function App() {
  const [user, setUser] = useState(null);
  const [climber, setClimber] = useState(null);
  // Define a state variable to track if 
  // the initialization attempt has completed or not
  const [initialized, setInitialized] = useState(false);
  // Define a state variable to track if the
  // user has a climber and if climber is loaded
  const [climberLoaded, setClimberLoaded] = useState(false);

  const resetUser = useCallback(() => {
    refreshToken()
      .then((user) => {
        setUser(user);
        setTimeout(resetUser, TIMEOUT_MILLISECONDS);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => setInitialized(true));
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
        console.log(climber);
      })
      .catch((err) => {
        console.log(err);
      })
      .finally(() => setClimberLoaded(true));
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
    },
  };

  if (!initialized) {
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
      <Router>
        <NavBar />

        <Routes>
          <Route path="/" element={<Home />}/>
          <Route path="/login" element={!user ? <LoginForm /> : <Navigate to="/" replace={true} />} />
          <Route path="/register" element={<UserRegistrationForm />} />
          <Route path="/profile" element={renderWithAuthority(ClimberProfile, "USER")} />
          <Route path="/error" element={<Error />}/>
          <Route path="*" element={<NotFound />}/>
         
        </Routes>
      </Router>
      </ClimberContext.Provider>
    </AuthContext.Provider>
  );
}

export default App;
