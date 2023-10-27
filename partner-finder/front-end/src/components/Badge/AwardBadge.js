import { useLocation, useNavigate } from "react-router-dom";
import { useState, useEffect, useContext } from "react";
import { findByUsername } from "../../services/profileAPI";
import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import Form from "react-bootstrap/Form";
import SearchResultsList from "./SearchResultsList";
import ClimberContext from "../../context/ClimberContext";
import FormErrors from "../Forms/FormErrors";
import AwardSuccessModal from "./AwardSuccessModal";
import {
  createNewClimberBadge,
  validateNewClimberBadge,
} from "../../services/badgeAPI";

export default function AwardBadge() {
  const location = useLocation();
  const navigate = useNavigate();
  const badgeInfo = location.state;
  const [badge, setBadge] = useState(badgeInfo);
  const [usernameSearchResults, setUsernameSearchResults] = useState([]);
  const [username, setUsername] = useState("");
  const [errors, setErrors] = useState([]);
  const [badgeAwarded, setBadgeAwarded] = useState(false);
  const [showModal, setShowModal] = useState(false);
  const { climberId } = useContext(ClimberContext);

  const handleSubmit = (evt) => {
    evt.preventDefault();
    setErrors([]);
    findByUsername(username)
      .then((data) => {
        console.log(data);
        if (data === null) {
          setErrors(["No results found for that username."]);
        } else {
          let newData = [];
          newData.push(data);
          console.log("After pushing into array: ", newData);
          setUsernameSearchResults(newData);
        }
      })
      .catch((error) => {
        console.log("Got an error when searching by profile username: ", error);
        setErrors([error]);
      });
  };

  const handleChange = (evt) => {
    let nextUsername = "";
    nextUsername = evt.target.value;
    setUsername(nextUsername);
  };

  const awardBadge = async (awardeeId) => {
    const climberBadge = {
      awardeeId: awardeeId,
      badgeId: badge.badgeId,
      giverId: climberId,
      dateAwarded: getFormattedDate(),
      isEnabled: true,
    };
    if (validateNewClimberBadge(climberBadge)) {
      setShowModal(true);
      if (createNewClimberBadge(climberBadge)) {
      }
    } else {
      console.log("nope: ");
    }
  };

  const onHide = () => {
    setShowModal(false);
    navigate("/");
  };

  function getFormattedDate() {
    const today = new Date();
    let year = today.getFullYear();
    let month = today.getMonth() + 1;
    if (month < 10) {
      month = "0" + month;
    }
    let day = today.getDate();
    if (day < 10) {
      day = "0" + day;
    }
    return year + "-" + month + "-" + day;
  }

  return (
    <>
      <Container>
        <AwardSuccessModal show={showModal} onHide={onHide} />
        <Row>
          <Col lg={4}>
            <h2>Award Badge!</h2>
            <br />
            <Container>
              <Row>
                <Col>
                  <Image src={badge.iconPath} alt="Badge image" thumbnail />
                </Col>
              </Row>
              <Row>
                <Col>
                  <h5>{badge.name}</h5>
                </Col>
              </Row>
              <Row>
                <Col>
                  <p>{badge.description}</p>
                </Col>
              </Row>
              <Row>
                <Col>
                  <b>Beta Points: </b>
                  {badge.cost}
                </Col>
              </Row>
              <Row>
                <Col>
                  <Button variant="secondary" size="lg" onClick={() => navigate("/")}>
                    Cancel
                  </Button>
                </Col>
              </Row>
            </Container>
          </Col>
          <Col lg={5}>
            <h2>Search for Partners to Award</h2>
            <br />
            <Row>
              <Form onSubmit={handleSubmit}>
                <Form.Control
                  size="lg"
                  type="text"
                  placeholder="Find partner by username"
                  id="username"
                  name="username"
                  value={username}
                  onChange={handleChange}
                  required
                />
                <Button variant="primary" type="submit">
                  Search
                </Button>
              </Form>
            </Row>
            <Row>
              <FormErrors errors={errors} />
              <Container className="top-padding">
                <h3>Search Results</h3>
                <hr />
              </Container>
            </Row>
            <Row>
              {usernameSearchResults.length > 0 ? (
                <Container>
                  <SearchResultsList
                    searchResults={usernameSearchResults}
                    awardBadge={awardBadge}
                  />
                </Container>
              ) : (
                <p>No results.</p>
              )}
            </Row>
          </Col>
        </Row>
      </Container>
    </>
  );
}
