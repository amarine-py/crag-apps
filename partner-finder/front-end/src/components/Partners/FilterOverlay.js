import { useState } from "react";
import { Button, Row, Col, Container, Form } from "react-bootstrap";
import Offcanvas from "react-bootstrap/Offcanvas";
import ValidationSummary from "../Forms/ValidationSummary";

function FilterCanvas(props) {
  const [filterInfo, setFilterInfo] = useState({
    safetyAttitude: null,
    climbingMotivation: null
  });

  const handleChange = (evt) => {
    const nextFilterInfo = { ...filterInfo };
    if (evt.target.type === "checkbox") {
      nextFilterInfo[evt.target.name] = evt.target.checked;
    } else {
      nextFilterInfo[evt.target.name] = evt.target.value;
    }
    console.log(nextFilterInfo);
    setFilterInfo(nextFilterInfo);
  };

  function handleFormSubmit(evt) {
    props.handleSubmit(evt, filterInfo);
  }

  return (
    <>
      <Offcanvas {...props}>
        <Offcanvas.Header closeButton>
          <Offcanvas.Title>Filter Results</Offcanvas.Title>
        </Offcanvas.Header>
        <Offcanvas.Body>
          <Container>
            <Form onSubmit={handleFormSubmit}>
              <Form.Group className="mb-3" controlId="filterInfo.safetyAttitude">
                <h4>Safety Attitude</h4>
                <Form.Check
                  type="radio"
                  label="Very Important"
                  id=""
                  name="safetyAttitude"
                  value={"VERY_IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Important"
                  id=""
                  name="safetyAttitude"
                  value={"IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Minimally Important"
                  id=""
                  name="safetyAttitude"
                  value={"MINIMALLY_IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Safety Third"
                  id=""
                  name="safetyAttitude"
                  value={"SAFETY_THIRD"}
                  onChange={handleChange}
                />
              </Form.Group>
              <Form.Group
                className="mb-3"
                controlId="filterInfo.climbingMotivation"
              >
                <h4>Climbing Motivation</h4>
                <Form.Check
                  type="radio"
                  label="Adventure"
                  id=""
                  name="climbingMotivation"
                  value={"ADVENTURE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Nature"
                  id=""
                  name="climbingMotivation"
                  value={"NATURE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Excercise"
                  id=""
                  name="climbingMotivation"
                  value={"EXERCISE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Competition"
                  id=""
                  name="climbingMotivation"
                  value={"COMPETITION"}
                  onChange={handleChange}
                />
              </Form.Group>
              <Button variant="primary" type="submit" onClick={props.onHide}>
                Apply
              </Button>
            </Form>
          </Container>
        </Offcanvas.Body>
      </Offcanvas>
    </>
  );
}

export default FilterCanvas;
