import { useState, useEffect } from "react";
import { Button, Container, Form } from "react-bootstrap";
import Offcanvas from "react-bootstrap/Offcanvas";

function FilterCanvas(props) {
  const { onHide, handleSubmit } = props;
  const [filterInfo, setFilterInfo] = useState({
    safetyAttitude: null,
    climbingMotivation: null,
    climbingStyle: null
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
    handleSubmit(evt, filterInfo);
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
                  name="safetyAttitude"
                  value={"VERY_IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Important"
                  name="safetyAttitude"
                  value={"IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Minimally Important"
                  name="safetyAttitude"
                  value={"MINIMALLY_IMPORTANT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Safety Third"
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
              <Form.Group
                className="mb-3"
                controlId="filterInfo.climbingStyle"
              >
                <h4>Climbing Style</h4>
                <Form.Check
                  type="radio"
                  label="Trad climbing"
                  id=""
                  name="climbingStyle"
                  value={"TRAD"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Sport climbing"
                  id=""
                  name="climbingStyle"
                  value={"SPORT"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Bouldering"
                  id=""
                  name="climbingStyle"
                  value={"BOULDERING"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Ice climbing"
                  id=""
                  name="climbingStyle"
                  value={"ICE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Alpine Climbing"
                  id=""
                  name="climbingStyle"
                  value={"ALPINE"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Mixed climbing"
                  id=""
                  name="climbingStyle"
                  value={"MIXED"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Gym bouldering"
                  id=""
                  name="climbingStyle"
                  value={"GYM_BOULDERING"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Gym top-roping"
                  id=""
                  name="climbingStyle"
                  value={"GYM_TOP_ROPING"}
                  onChange={handleChange}
                />
                <Form.Check
                  type="radio"
                  label="Gym lead climbing"
                  id=""
                  name="climbingStyle"
                  value={"GYM_LEAD_CLIMBING"}
                  onChange={handleChange}
                />
              </Form.Group>
              <Button variant="primary" type="submit" onClick={onHide}>
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
