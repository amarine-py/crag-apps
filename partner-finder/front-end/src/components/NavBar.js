import { useContext } from "react";
import { Link } from "react-router-dom";
import AuthContext from "../context/AuthContext";

function NavBar() {
  const { user, logout } = useContext(AuthContext);

  // If we have an auth.user, render a profile link and image and a logout button.
  // If we don't have an auth.user, render "Login"
  // and "Register" navigation.
  // TODO: Add profile image link
  return (
    <nav>
      <ul>
        <li>
          <Link to="/">Home</Link>
        </li>
        {user ? (
            <li>
              <Link to="/">Your Partners</Link>
            </li>
        ) : (
          <>
            <li>
              <Link to="/login">Login</Link>
            </li>
            <li>
              <Link to="/register">Register</Link>
            </li>
          </>
        )}
      </ul>
      {user && (
        <div>
          Welcome <Link to="/profile">{user.username}</Link>!
          <button onClick={() => logout()}>Logout</button>
        </div>
      )}
    </nav>
  );
}

export default NavBar;
