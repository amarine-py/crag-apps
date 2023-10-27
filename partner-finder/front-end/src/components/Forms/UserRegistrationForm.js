import { useState } from "react";
import { Link } from "react-router-dom";
import { register } from "../../services/authAPI";
import { createClimber } from "../../services/climberAPI";
import ValidationSummary from "./ValidationSummary";
import Container from 'react-bootstrap/Container';

function UserRegistrationForm() {
  const [errors, setErrors] = useState([]);
  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
    confirmPassword: "",
  });
  const [climberInfo, setClimberInfo] = useState({
    climberId: 0,
    appUserId: "",
    email: "",
    firstName: "",
    lastName: "",
    dob: "",
    climberSex: "MALE",
  });
  const [success, setSuccess] = useState(false);

  const handleCredChange = (evt) => {
    const nextCredentials = { ...credentials };
    nextCredentials[evt.target.name] = evt.target.value;
    setCredentials(nextCredentials);
  };
  const handleInfoChange = (evt) => {
    const nextClimberInfo = { ...climberInfo };
    nextClimberInfo[evt.target.name] = evt.target.value;
    setClimberInfo(nextClimberInfo);
  }

  const handleSubmit = async (evt) => {
    evt.preventDefault();
    setErrors([]);
    if (!validatePassword()) {
      setErrors(["Passwords do not match!"]);
      return;
    }

    await register(credentials).then((data) => {
      if (data && data.messages) {
        console.log("WE HAVE DATA AND ERRORS!!!")
        setErrors(data.messages);
      } else {
        let newClimberInfo = { ...climberInfo };
        newClimberInfo.appUserId = data.user_id;
        newClimberInfo.email = credentials.username;
        createClimber(newClimberInfo);
        setSuccess(true);
      }
    });
  };

  const validatePassword = () => {
    return credentials.password === credentials.confirmPassword;
  };

  return (
    <Container>
    <div>
      <ValidationSummary errors={errors} />
      {success ? (
        <div className="alert alert-success">
          Congratulations {credentials.username}, you have been registered.
          Login <Link to="/login">here</Link>.
        </div>
      ) : (
        <form onSubmit={handleSubmit}>
          <div>
            <div className="form-group">
              <label htmlFor="label">Username</label>
              <input
                type="text"
                className="form-control"
                id="username"
                name="username"
                value={credentials.username}
                onChange={handleCredChange}
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
                value={credentials.password}
                onChange={handleCredChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="label">Confirm password</label>
              <input
                type="password"
                className="form-control"
                id="confirmPassword"
                name="confirmPassword"
                value={credentials.confirmPassword}
                onChange={handleCredChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="label">First Name</label>
              <input
                type="text"
                className="form-control"
                id="firstName"
                name="firstName"
                value={climberInfo.firstName}
                onChange={handleInfoChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="label">Last Name</label>
              <input
                type="text"
                className="form-control"
                id="lastName"
                name="lastName"
                value={climberInfo.lastName}
                onChange={handleInfoChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="label">Date of Birth</label>
              <input
                type="date"
                className="form-control"
                id="dob"
                name="dob"
                value={climberInfo.dob}
                onChange={handleInfoChange}
                required
              />
            </div>
            <div className="form-group">
              <label htmlFor="label">Sex</label>
              <select
                className="form-control"
                id="climberSex"
                name="climberSex"
                value={climberInfo.climberSex}
                onChange={handleInfoChange}
                required
              >
                <option value="MALE">Male</option>
                <option value="FEMALE">Female</option>
                <option value="NONBINARY">Non-Binary</option>
                <option value="OTHER">Other</option>
              </select>
            </div>
            <div>
              <Link to="/" className="btn btn-secondary">
                Cancel
              </Link>
              <button type="submit" className="btn btn-primary">
                Sign up
              </button>
            </div>
          </div>
        </form>
      )}
    </div>
    </Container>
  );
}

export default UserRegistrationForm;
