import { useEffect, useState, useContext } from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "../context/AuthContext";
import TopPartnerList from "./Landing/TopPartnerList";
import ListOfProfilesByState from "./Landing/ListOfProfilesByState";
import HomeBadgeList from "./Badge/HomeBadgeList";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Map from "./Landing/Map";
import { findByState } from "../services/profileAPI";

function Home() {
  const [profilesByState, setProfilesByState] = useState([]);
  const [mapClicked, setMapClicked] = useState(false);
  const auth = useContext(AuthContext);
  const navigate = useNavigate();

  const findByStateName = (stateName) => {
    let parsedName = stateName.replaceAll(" ", "_").toUpperCase();
    findByState(parsedName)
      .then((profiles) => {
        let newProfilesByState = profiles;
        setProfilesByState(newProfilesByState);
        setMapClicked(true);
      })
      .catch((err) => console.error);
  };

  return (
    <>
      <Container>
        <TopPartnerList />
      </Container>
      <hr />
      <Container>
        <Row>
          <Col sm={8}>
            <h2>Find Partner by State</h2>
          </Col>
          <Col sm={4}>
            <h2>Results</h2>
          </Col>
        </Row>
        <Row>
          <Col sm={8}>
            <Map findByStateName={findByStateName} />
          </Col>

          <Col sm={4}>
            {profilesByState.length < 1 && !mapClicked ? (
              <div>Please click the map to search.</div>
            ) : (
              <ListOfProfilesByState profilesByState={profilesByState} />
            )}
          </Col>
        </Row>
      </Container>
      <hr />
      <Container>
        <HomeBadgeList />
      </Container>
      <hr />
    </>
  );
}

export default Home;
