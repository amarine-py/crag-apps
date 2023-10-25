import ValidationSummary from "../ValidationSummary";
import { useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import { createNewProfile } from "../../services/profileAPI";
import ClimberContext from "../../context/ClimberContext";

export default function ProfileForm() {
    const climber = useContext(ClimberContext);
  const [errors, setErrors] = useState([]);
  const [profileInfo, setProfileInfo] = useState({
    profileId: 0,
    climberId: climber.climberId,
    username: "",
    description: "",
    profilePicPath: "",
    betaPoints: 1000,
    isPublic: true,
    tradGrade: "",
    sportGrade: "",
    boulderGrade: "",
    iceGrade: "",
    aidGrade: "",
    hasTradGear: false,
    hasSportGear: false,
    hasRope: false,
    hasTransportation: false,
    openToMentor: false,
    openToMentee: false,
    numPartners: 0,
    safetyAttitude: null,
    climbingMotivation: null,
    climbingStyle: null,
    climbingCountry: null,
    climbingState: null,
    climbingPostalCode: "",
    enabled: true,
  });

  const handleChange = (evt) => {
    const nextProfileInfo = { ...profileInfo };
    if (evt.target.type === "checkbox" ) {
        nextProfileInfo[evt.target.name] = evt.target.checked;
    } else {
        nextProfileInfo[evt.target.name] = evt.target.value;

    }
    setProfileInfo(nextProfileInfo);
  };

  const navigate = useNavigate();

  const handleSubmit = async (evt) => {
    evt.preventDefault();
    setErrors([]);
    console.log(profileInfo);
    createNewProfile(profileInfo)
        .then((profile) => {
            setProfileInfo(profile);
            console.log(profile);
            navigate("/profile");
        })
        .catch((err) => {
            console.log(err);
            setErrors([err]);
        })
    };

  return (
    <>
      <ValidationSummary errors={errors} />
      <Form onSubmit={handleSubmit}>
        <Container>
        <Form.Group className="mb-3" >
          <Form.Control type="text" 
                placeholder="Enter username"    
                className="form-control"
                id="username"
                name="username"
                value={profileInfo.username}
                onChange={handleChange}
                required/>
        </Form.Group>
        <Form.Group>
          <Form.Control type="text" 
                placeholder="Enter description"    
                className="form-control"
                id="description"
                name="description"
                value={profileInfo.description}
                onChange={handleChange}
                required/>
        </Form.Group>
        <br></br>
        <Form.Group className="mb-3" name="climbingCountryName" controlId="profileInfo.climbingCountryName">
            <Form.Select name="climbingCountryName" onChange={handleChange} required>
                <option>Select your country</option>
                <option value={"UNITED_STATES"}>United States</option>
                <option value={"CANADA"}>Canada</option>
                <option value={"MEXICO"}>Mexico</option>
            </Form.Select>
        </Form.Group>
        <Form.Group className="mb-3" name="climbingStateName" controlId="profileInfo.climbingStateName">
            <Form.Select name="climbingStateName" onChange={handleChange} required>
                <option>Select your state or province</option>
                <option value={"ALABAMA"}>Alabama</option>
                <option value={"ALASKA"}>Alaska</option>
                <option value={"AMERICAN_SAMOA"}>American Samoa</option>
                <option value={"INDIANA"}>Indiana</option>
                <option value={"CALIFORNIA"}>California</option>
                <option value={"TEXAS"}>Texas</option>
            </Form.Select>
        </Form.Group>
        <Form.Group className="mb-3" name="climbingPostalCode" controlId="profileInfo.climbingPostalCode">

        </Form.Group>
        <Form.Control type="text" 
                placeholder="Enter your primary climbing postal code"    
                className="form-control"
                id="climbingPostalCode"
                name="climbingPostalCode"
                value={profileInfo.climbingPostalCode}
                onChange={handleChange}
                required/>
        </Container>
        <br />
        <Container>
        <Row>
            <Col>
        <Form.Group className="mb-3" controlId="profileInfo.safetyAttitudeName">
          <Form.Label>General attitude towards safety:</Form.Label>
          <Form.Check type="radio" 
                label="Very Important"
                id=""
                name="safetyAttitudeName"
                value={"VERY_IMPORTANT"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Important"
                id=""
                name="safetyAttitudeName"
                value={"IMPORTANT"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Minimally Important"
                id=""
                name="safetyAttitudeName"
                value={"MINIMALLY_IMPORTANT"}
                onChange={handleChange}  /> 
            <Form.Check type="radio" 
                label="Safety Third"
                id=""
                name="safetyAttitudeName"
                value={"SAFETY_THIRD"}
                onChange={handleChange}  />  
        </Form.Group>
        </Col>
        <Col>
        <Form.Group className="mb-3" controlId="profileInfo.climbingMotivationName">
          <Form.Label>Basic climbing motivation:</Form.Label>
          <Form.Check type="radio" 
                label="Adventure"
                id=""
                name="climbingMotivationName"
                value={"ADVENTURE"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Nature"
                id=""
                name="climbingMotivationName"
                value={"NATURE"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Excercise"
                id=""
                name="climbingMotivationName"
                value={"EXERCISE"}
                onChange={handleChange}  /> 
            <Form.Check type="radio" 
                label="Competition"
                id=""
                name="climbingMotivationName"
                value={"COMPETITION"}
                onChange={handleChange}  />  
        </Form.Group>
        </Col>
        <Col>
        <Form.Group className="mb-3" controlId="profileInfo.climbingStyleName">
          <Form.Label>Favorite climbing style:</Form.Label>
          <Form.Check type="radio" 
                label="Trad climbing"
                id=""
                name="climbingStyleName"
                value={"TRAD"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Sport climbing"
                id=""
                name="climbingStyleName"
                value={"SPORT"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Bouldering"
                id=""
                name="climbingStyleName"
                value={"BOULDERING"}
                onChange={handleChange}  /> 
            <Form.Check type="radio" 
                label="Ice climbing"
                id=""
                name="climbingStyleName"
                value={"ICE"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Alpine Climbing"
                id=""
                name="climbingStyleName"
                value={"ALPINE"}
                onChange={handleChange}  />  
            <Form.Check type="radio" 
                label="Mixed climbing"
                id=""
                name="climbingStyleName"
                value={"MIXED"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Gym bouldering"
                id=""
                name="climbingStyleName"
                value={"GYM_BOULDERING"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Gym top-roping"
                id=""
                name="climbingStyleName"
                value={"GYM_TOP_ROPING"}
                onChange={handleChange}  />
            <Form.Check type="radio" 
                label="Gym lead climbing"
                id=""
                name="climbingStyleName"
                value={"GYM_LEAD_CLIMBING"}
                onChange={handleChange}  />
        </Form.Group>
        </Col>
        </Row>
        </Container>
        <Container>
        <Form.Group className="mb-3">
            <Form.Control type="text" 
                    placeholder="Enter hardest sport grade"    
                    className="form-control"
                    id="sportGrade"
                    name="sportGrade"
                    value={profileInfo.sportGrade}
                    onChange={handleChange}/>
            <Form.Control type="text" 
                    placeholder="Enter hardest bouldering grade"    
                    className="form-control"
                    id="boulderGrade"
                    name="boulderGrade"
                    value={profileInfo.boulderGrade}
                    onChange={handleChange}/>
            <Form.Control type="text" 
                    placeholder="Enter hardest trad grade"    
                    className="form-control"
                    id="tradGrade"
                    name="tradGrade"
                    value={profileInfo.tradGrade}
                    onChange={handleChange}/>
        </Form.Group>
        </Container>
        <Container>
            <Row>
            <Col>
        <Form.Group className="mb-3">
            <Form.Check
                type="switch"
                label="Open to becoming a mentor?"
                id="openToMentee"
                name="openToMentee"
                checked={profileInfo.openToMentee}
                onChange={handleChange}
                
            />
            <Form.Check
                type="switch"
                label="Looking for mentor?"
                id="openToMentor"
                name="openToMentor"
                checked={profileInfo.openToMentor}
                onChange={handleChange}
            />
        </Form.Group>
        </Col>
        <Col>
        <Form.Group className="mb-3">
            <Form.Check
                type="switch"
                label="I have trad-climbing gear!"
                id="hasTradGear"
                name="hasTradGear"
                checked={profileInfo.hasTradGear}
                onChange={handleChange}
                
            />
            <Form.Check
                type="switch"
                label="I have sport-climbing gear."
                id="hasSportGear"
                name="hasSportGear"
                checked={profileInfo.hasSportGear}
                onChange={handleChange}
            />
            <Form.Check
                type="switch"
                label="I have a rope."
                id="hasRope"
                name="hasRope"
                checked={profileInfo.hasRope}
                onChange={handleChange}
            />
            <Form.Check
                type="switch"
                label="I have transportation."
                id="hasTransportation"
                name="hasTransportation"
                checked={profileInfo.hasTransportation}
                onChange={handleChange}
            />
        </Form.Group>
        </Col>
        </Row>
        </Container>
        {/* <Form.Group className="mb-3" controlId="formBasicCheckbox">
          <Form.Check type="checkbox" label="Check me out" />
        </Form.Group> */}
        <Button variant="primary" type="submit">
          Submit
        </Button>
      </Form>
      
      {/* <form onSubmit={handleSubmit}>
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
      </form> */}
    </>
  );
  
}
