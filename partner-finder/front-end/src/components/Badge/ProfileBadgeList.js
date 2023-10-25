import Container from "react-bootstrap/Container";
import ListGroup from "react-bootstrap/ListGroup";
import Col from "react-bootstrap/Col";
import BadgeCard from "./BadgeCard";
import { useEffect, useState } from "react";

export default function ProfileBadgeList({ badges }) {

  const [initiated, setInitiated] = useState(false);
  console.log("BadgeList logging: ", badges);
  console.log("Length of Badges: ", badges.length);

  return (
    <Container className="cards-wrapper">
      {/* {badges.map((b) => <div key={[b.badgeId]}>{b.name}</div>)} */}
      {badges.map((badge) => <Col><BadgeCard key={badge.badgeId} badge={badge} /></Col>)}
     </Container>
  );
}
