import { useLocation, useNavigate } from "react-router-dom";
import { useState } from "react";
import Container from "react-bootstrap/Container";
import Button from "react-bootstrap/Button";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";

export default function AwardBadge() {
  const location = useLocation();
  const badgeInfo = location.state;
  const [badge, setBadge] = useState(badgeInfo);

  return (
    <>
      <Container>
        <Row>
          <Col lg={4}>
            <h2>Award Badge!</h2>
            <br />
            <Container>
              <Row>
                <Col>
                  <Image src={badge.iconPath} alt="Badge image" thumbnail/>
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
                  <Button variant="success" size="lg">
                    Award Badge
                  </Button>
                </Col>
                <Col>
                  <Button variant="secondary" size="lg">
                    Cancel
                  </Button>
                </Col>
              </Row>
            </Container>
          </Col>
            <Col lg={5}>
            <h2>Other Top Partners With This Badge</h2>
            <br />
            <Row>
                
            </Row>
            </Col>

        </Row>
      </Container>
    </>
  );
}
