import ListGroup from "react-bootstrap/ListGroup";
import Col from "react-bootstrap/Col";
import Button from "react-bootstrap/Button";

export default function ProfileByState({ profile }) {
  return (
    <ListGroup.Item as="li">
      <Col>
        {profile.username},{profile.climbingStateName}, Beta Points:
        {profile.betaPoints}
        Hello
      </Col>
      <Col>
        <Button variant="primary"> View Profile</Button>
      </Col>
    </ListGroup.Item>
  );
}
