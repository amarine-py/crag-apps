import ValidationSummary from "../ValidationSummary";
import { useContext, useState, useEffect } from "react";
import { useNavigate, useLocation } from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import { updateProfileById } from "../../services/profileAPI";
import ClimberContext from "../../context/ClimberContext";

export default function EditProfile() {
  const location = useLocation();
  let profileInfo = location.state;
  const climber = useContext(ClimberContext);
  const [errors, setErrors] = useState([]);
  const [profile, setProfile] = useState(profileInfo);

  const handleChange = (evt) => {
    const nextProfileInfo = { ...profile };
    if (evt.target.type === "checkbox") {
      nextProfileInfo[evt.target.name] = evt.target.checked;
    } else {
      nextProfileInfo[evt.target.name] = evt.target.value;
    }
    setProfile(nextProfileInfo);
  };

  const navigate = useNavigate();

  const handleSubmit = async (evt) => {
    evt.preventDefault();
    setErrors([]);
    console.log(
      "Logging form profile info right after submit button, but before data call: ",
      profile
    );
    updateProfileById(profile)
      .then((profileData) => {
        navigate("/profile");
      })
      .catch((err) => {
        console.log(err);
        setErrors([err]);
      });
  };

  return (
    <>
      <ValidationSummary errors={errors} />
      <Form onSubmit={handleSubmit}>
        <Container>
          <Form.Group className="mb-3">
            <Form.Control
              type="text"
              placeholder="Enter username"
              className="form-control"
              id="username"
              name="username"
              value={profile.username}
              onChange={handleChange}
              required
            />
          </Form.Group>
          <Form.Group>
            <Form.Control
              type="text"
              placeholder="Enter description"
              className="form-control"
              id="description"
              name="description"
              value={profile.description}
              onChange={handleChange}
              required
            />
          </Form.Group>
          <br></br>
          <Form.Group
            className="mb-3"
            name="climbingCountryName"
            controlId="profile.climbingCountryName"
          >
            <Form.Select
              name="climbingCountryName"
              onChange={handleChange}
              value={profile.climbingCountryName}
              required
            >
              <option>Select your country</option>
              <option value={"UNITED_STATES"}>United States</option>
              <option value={"CANADA"}>Canada</option>
              <option value={"MEXICO"}>Mexico</option>
            </Form.Select>
          </Form.Group>
          <Form.Group
            className="mb-3"
            name="climbingStateName"
            controlId="profile.climbingStateName"
          >
            <Form.Select
              name="climbingStateName"
              onChange={handleChange}
              value={profile.climbingStateName}
              required
            >
              <option>Select your state or province</option>
              <option value={"ALABAMA"}>Alabama</option>
              <option value={"ALASKA"}>Alaska</option>
              <option value={"AMERICAN_SAMOA"}>American Samoa</option>
              <option value={"INDIANA"}>Indiana</option>
              <option value={"CALIFORNIA"}>California</option>
              <option value={"TEXAS"}>Texas</option>
            </Form.Select>
          </Form.Group>
          <Form.Group
            className="mb-3"
            name="climbingPostalCode"
            controlId="profile.climbingPostalCode"
          ></Form.Group>
          <Form.Control
            type="text"
            placeholder="Enter your primary climbing postal code"
            className="form-control"
            id="climbingPostalCode"
            name="climbingPostalCode"
            value={profile.climbingPostalCode}
            onChange={handleChange}
            required
          />
          <Form.Group
            className="mb-3"
            name="profilePicPath"
            controlId="profileInfo.profilePicPath"
          ></Form.Group>
          <Form.Control
            type="text"
            placeholder="Enter URL of profile pic"
            className="form-control"
            id="profilePicPath"
            name="profilePicPath"
            value={profileInfo.profilePicPath}
            onChange={handleChange}
          />
        </Container>
        <br />
        <Container>
          <Row>
            <Col>
              <Form.Group
                className="mb-3"
                controlId="profile.safetyAttitudeName"
              >
                <Form.Label>General attitude towards safety:</Form.Label>
                <Form.Check
                  type="radio"
                  label="Very Important"
                  id=""
                  name="safetyAttitudeName"
                  value={"VERY_IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Important"
                  id=""
                  name="safetyAttitudeName"
                  value={"IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Minimally Important"
                  id=""
                  name="safetyAttitudeName"
                  value={"MINIMALLY_IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Safety Third"
                  id=""
                  name="safetyAttitudeName"
                  value={"SAFETY_THIRD"}
                  onChange={handleChange}

                />
              </Form.Group>
            </Col>
            <Col>
              <Form.Group
                className="mb-3"
                controlId="profile.climbingMotivationName"
              >
                <Form.Label>Basic climbing motivation:</Form.Label>
                <Form.Check
                  type="radio"
                  label="Adventure"
                  id=""
                  name="climbingMotivationName"
                  value={"ADVENTURE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Nature"
                  id=""
                  name="climbingMotivationName"
                  value={"NATURE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Excercise"
                  id=""
                  name="climbingMotivationName"
                  value={"EXERCISE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Competition"
                  id=""
                  name="climbingMotivationName"
                  value={"COMPETITION"}
                  onChange={handleChange}
                />
              </Form.Group>
            </Col>
            <Col>
              <Form.Group
                className="mb-3"
                controlId="profile.climbingStyleName"
              >
                <Form.Label>Favorite climbing style:</Form.Label>
                <Form.Check
                  type="radio"
                  label="Trad climbing"
                  id=""
                  name="climbingStyleName"
                  value={"TRAD"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Sport climbing"
                  id=""
                  name="climbingStyleName"
                  value={"SPORT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Bouldering"
                  id=""
                  name="climbingStyleName"
                  value={"BOULDERING"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Ice climbing"
                  id=""
                  name="climbingStyleName"
                  value={"ICE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Alpine Climbing"
                  id=""
                  name="climbingStyleName"
                  value={"ALPINE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Mixed climbing"
                  id=""
                  name="climbingStyleName"
                  value={"MIXED"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Gym bouldering"
                  id=""
                  name="climbingStyleName"
                  value={"GYM"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Gym top-roping"
                  id=""
                  name="climbingStyleName"
                  value={"GYM"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Gym lead climbing"
                  id=""
                  name="climbingStyleName"
                  value={"GYM"}
                  onChange={handleChange}
                />
              </Form.Group>
            </Col>
          </Row>
        </Container>
        <Container>
          <Form.Group className="mb-3">
            <Form.Control
              type="text"
              placeholder="Enter hardest sport grade"
              className="form-control"
              id="sportGrade"
              name="sportGrade"
              value={profile.sportGrade}
              onChange={handleChange}
            />
            <Form.Control
              type="text"
              placeholder="Enter hardest bouldering grade"
              className="form-control"
              id="boulderGrade"
              name="boulderGrade"
              value={profile.boulderGrade}
              onChange={handleChange}
            />
            <Form.Control
              type="text"
              placeholder="Enter hardest trad grade"
              className="form-control"
              id="tradGrade"
              name="tradGrade"
              value={profile.tradGrade}
              onChange={handleChange}
            />
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
                  checked={profile.openToMentee}
                  onChange={handleChange}
                />
                <Form.Check
                  type="switch"
                  label="Looking for mentor?"
                  id="openToMentor"
                  name="openToMentor"
                  checked={profile.openToMentor}
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
                  checked={profile.hasTradGear}
                  onChange={handleChange}
                />
                <Form.Check
                  type="switch"
                  label="I have sport-climbing gear."
                  id="hasSportGear"
                  name="hasSportGear"
                  checked={profile.hasSportGear}
                  onChange={handleChange}
                />
                <Form.Check
                  type="switch"
                  label="I have a rope."
                  id="hasRope"
                  name="hasRope"
                  checked={profile.hasRope}
                  onChange={handleChange}
                />
                <Form.Check
                  type="switch"
                  label="I have transportation."
                  id="hasTransportation"
                  name="hasTransportation"
                  checked={profile.hasTransportation}
                  onChange={handleChange}
                />
              </Form.Group>
            </Col>
          </Row>
        </Container>
        <Button variant="primary" type="submit">
          Submit
        </Button>
        <Button variant="secondary" onClick={() => navigate("/profile")}>Cancel</Button>
      </Form>
    </>
  );
}
