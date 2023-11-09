import ListGroup from "react-bootstrap/ListGroup";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";
import Button from "react-bootstrap/Button";
import Image from "react-bootstrap/Image";
import { useNavigate } from "react-router-dom";

export default function ListOfProfilesByState({ profilesByState }) {
  const navigate = useNavigate();
  
  return (
    <div className="list-group">
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
                  <Col className="image-col">
                  <div className="list-image-container">
                    <Image className="list-image" src={p.profilePicPath} fluid/>
                  </div>
                  
                  </Col>
                  <Col className="button-col">
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
