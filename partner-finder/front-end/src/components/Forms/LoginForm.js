import { useState, useContext } from "react";
import { Link, useNavigate } from "react-router-dom";
import Container from 'react-bootstrap/Container';
import AuthContext from "../../context/AuthContext";
import ValidationSummary from "./ValidationSummary";

function LoginForm() {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errors, setErrors] = useState([]);

  const auth = useContext(AuthContext);
  const navigate = useNavigate()

  const handleSubmit = async (evt) => {
    evt.preventDefault();
    setErrors([]);
    const response = await fetch("http://localhost:8080/api/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        username,
        password,
      }),
    });
    // This code executes if the request is successful
    if (response.status === 200) {
      const { jwt_token } = await response.json();
      console.log(jwt_token);
      auth.login(jwt_token);
      navigate("/");
    } else if (response.status === 403) {
      setErrors(["Login failed."]);
    } else {
      setErrors(["Unknown error."]);
    }
  };

  const handleUsernameChange = (evt) => {
    const nextUsername = username;
    nextUsername[evt.target.name] = evt.target.value;
    setUsername(nextUsername);
  };
  const handlePasswordChange = (evt) => {
    const nextPassword = password;
    nextPassword[evt.target.name] = evt.target.value;
    setPassword(nextPassword);
  };
  
  return (
    <Container>
    <div>
      <ValidationSummary errors={errors} />
      <form onSubmit={handleSubmit}>
        <div>
          <div className="form-group">
            <label htmlFor="label">Username</label>
            <input
              type="text"
              className="form-control"
              id="username"
              name="username"
              onChange={(event) => setUsername(event.target.value)}
              required
            />
          </div>
          <div className="form-group">
            <label htmlFor="label">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              name="password"
              onChange={(event) => setPassword(event.target.value)}
              required
            />
          </div>
          <div>
            <Link to="/" className="btn btn-secondary">
              Cancel
            </Link>
            <button type="submit" className="btn btn-primary">
              Log in
            </button>
          </div>
        </div>
      </form>
    </div>
    </Container>
  );
}

export default LoginForm;
