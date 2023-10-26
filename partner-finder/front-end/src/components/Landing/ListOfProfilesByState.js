import ListGroup from "react-bootstrap/ListGroup";
import { useEffect } from "react";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import { useNavigate } from "react-router-dom";

export default function ListOfProfilesByState({ profilesByState }) {
  const navigate = useNavigate();

  useEffect(() => {
    console.log("Profiles by state from list: ", profilesByState);
  });

  return (
    <div>
      <ListGroup>
        {profilesByState.length < 1 ? (
          <>No results for this state.</>
        ) : (
          <>
            {profilesByState.map((p) => (
              <ListGroup.Item key={p.profileId}>
                <Row>
                  <Col>
                    <h5>{p.username}</h5>
                    <h6>State: {p.climbingStateName}</h6>
                    <span>
                      {" "}
                      <em>Beta Points:</em>
                    </span>
                    {p.betaPoints}
                  </Col>
                  <Col>
                    <Button
                      variant="primary"
                      onClick={() => navigate(`/partner/${p.profileId}`)}
                    >
                      View Profile
                    </Button>
                  </Col>
                </Row>
              </ListGroup.Item>
            ))}
          </>
        )}
      </ListGroup>
    </div>
  );
}
