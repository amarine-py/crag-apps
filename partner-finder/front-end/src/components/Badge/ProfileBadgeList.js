import Container from "react-bootstrap/Container";
import Col from "react-bootstrap/Col";
import BadgeCard from "./BadgeCard";
import { v4 as uuidv4 } from "uuid";

export default function ProfileBadgeList({ badges }) {
  return (
    <Container className="cards-wrapper">
      {badges.map((badge) => (
        <Col key={uuidv4()}>
          <BadgeCard badge={badge} />
        </Col>
      ))}
    </Container>
  );
}
