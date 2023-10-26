import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import ListGroup from "react-bootstrap/ListGroup";
import Image from "react-bootstrap/Image";
import { findAllClimbers } from "../services/climberAPI";
import { useEffect, useState } from "react";
import { findAllBadges } from "../services/badgeAPI";

export default function About() {
  const [numberOfClimbers, setNumberOfClimbers] = useState(0);
  const [numberOfBadges, setNumberOfBadges] = useState(0);
  useEffect(() => {
    findAllClimbers().then((data) => {
      const numClimbers = data.length;
      setNumberOfClimbers(numClimbers);
    });

    findAllBadges().then((badges) => {
      const numBadges = badges.length;
      setNumberOfBadges(numBadges);
    });
  }, []);

  return (
    <Container>
      <Row>
        <h2>Partner Finder</h2>
      </Row>
      <Row>
        <Col>
          <div className="text-box">
            <h3>About Us</h3>
            <p>
              As a climber, it can be frustrating to find partners whose goals
              align with your own. There isn't one archetypal "climber." People
              climb for many reasons, including recreation, competition,
              exercise, solitude, and adventure. There are also many different
              types of climbing. This fact makes it difficult to find a partner
              that shares similar goals and ambitions.
            </p>
            <p>
              What's more, climbing is a passion that can involve inherent
              risks. This makes it not only convenient but sometimes essential
              to align yourself with others who take safety as seriously as you
              do.
            </p>
            <p>
              Partner Finder aims to help climbers find partners who share
              similar goals, styles, and attitudes toward their shared passion.
              In addition, it hopes to provide a means to verify that a
              particular user meets certain criteria before being "vouched for"
              by the app. Users can award badges to other users. These badges
              serve as votes of confidence attesting to another user's, say,
              ability to provide a safe belay. Or their ambition to climb a
              certain grade. Or their ability to safely climb multi-pitch rock
              routes. Or their desire to complete certain training goals. Or
              even their desire to take find a mentor or take on a mentee.
            </p>
            <p>
              Through the use of badges from other app users, users can earn an
              attestation from the app itself. As a user, you will then be able
              to filter by any number of criteria to find a climber who, for
              example, lives in the Mountain West, climbs at least 5.10, has
              their own trad climbing gear, and takes safety seriously.
            </p>
          </div>
        </Col>
        <Col>
          <Row>
            <div className="text-box">
              <h5>Statistics</h5>
              <ListGroup>
                <ListGroup.Item>
                  <b>Number of Partners:</b>{" "}
                  {numberOfClimbers ? `${numberOfClimbers}` : "Loading"}
                </ListGroup.Item>
                <ListGroup.Item>
                  <b>Number of Badges:</b>{" "}
                  {numberOfBadges ? `${numberOfBadges}` : "Loading"}
                </ListGroup.Item>
                <ListGroup.Item>Morbi leo risus</ListGroup.Item>
                <ListGroup.Item>Porta ac consectetur ac</ListGroup.Item>
                <ListGroup.Item>Vestibulum at eros</ListGroup.Item>
              </ListGroup>
            </div>
          </Row>
          <Row>
            <div className="text-box">
              <h5>Contributors</h5>
              <ListGroup>
                <ListGroup.Item>
                  <b>Site Designer:</b> Alex Marine
                </ListGroup.Item>
                <ListGroup.Item>
                  <b>Zen Master:</b> Corbin March
                </ListGroup.Item>
                <ListGroup.Item>
                  <b>Minister of Games: </b> Brendan Kendrick
                </ListGroup.Item>
                <ListGroup.Item>
                  <b>Court Mathematician:</b> Esin Saribudak
                </ListGroup.Item>
                <ListGroup.Item>
                  <b>Special Thanks to:</b> First Dev10 Academy Cohort!
                </ListGroup.Item>
              </ListGroup>
            </div>
          </Row>
        </Col>
      </Row>
      <Row>
        <div className="picture-footer">
            <Row>
        <Col><Image fluid src="https://images.unsplash.com/photo-1593132517397-ceb31d77194a?auto=format&fit=crop&q=80&w=1964&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="climber bouldering"/></Col>
        <Col><Image fluid src="https://images.unsplash.com/photo-1628361520980-8983cbc5bef2?auto=format&fit=crop&q=80&w=1964&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="mountain background"/></Col>
        <Col><Image fluid src="https://plus.unsplash.com/premium_photo-1684315353973-3839e4620451?auto=format&fit=crop&q=80&w=1974&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" alt="climber on lead"/></Col>
        </Row>
        </div>
      </Row>
    </Container>
  );
}
