import { Row, Col, Button, Container } from "react-bootstrap";
import Map from "../Landing/Map";
import { findByState } from "../../services/profileAPI";
import { useState } from "react";
import ListOfProfilesByState from "../Landing/ListOfProfilesByState";
import FilterCanvas from "./FilterOverlay";
import ValidationSummary from "../Forms/ValidationSummary";

export default function FindPartners() {
  const [profilesByState, setProfilesByState] = useState([]);
  const [mapClicked, setMapClicked] = useState(false);
  const [showCanvas, setShowCanvas] = useState(false);
  const [errors, setErrors] = useState([]);

  const handleClose = () => setShowCanvas(false);
  const handleShow = () =>  setShowCanvas(true);

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

  const handleSubmit = (evt, info) => {
    evt.preventDefault();
    setErrors([]);
    const filteredResults = filterResults(info);
    setProfilesByState([...filteredResults]);
  };

  function filterResults(resultFilter) {
    let tempArr = [...profilesByState];
    let results = [];
    for (let prop in resultFilter) {
        if (resultFilter[prop]) {
            results = tempArr.filter((profile) => {
                let match = profile[prop] === resultFilter[prop];
                return match;
            });
            tempArr = [...results];
        }
    }
    return results;
  }
    
  return (
    <div>
      <FilterCanvas
        show={showCanvas}
        onHide={handleClose}
        handleSubmit={handleSubmit}
      />
      <Container>
        <ValidationSummary errors={errors} />
        <Row>
          <h2>Find the Perfect Partner</h2>
        </Row>

        <Row>
          <Col>
            <h4>Search by State</h4>
          </Col>
          <Col>
            <h4>Filter Results</h4>
            <Button variant="success" onClick={handleShow}>
              Show Filters
            </Button>
          </Col>
        </Row>
        <Row>
          <Col>
            <Map findByStateName={findByStateName} />
          </Col>
          <Col>
            <ListOfProfilesByState profilesByState={profilesByState} />
          </Col>
        </Row>
      </Container>
    </div>
  );
}
