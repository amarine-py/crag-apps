import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import ProfileInformation from "./ProfileInformation";
import BadgeList from "../Badge/BadgeList";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { findByClimberId } from "../../services/profileAPI";
import { findClimberBadgesByAwardeeId, findAllBadgesById} from "../../services/badgeAPI";

export default function ClimberProfile({ climber }) {
  const [profile, setProfile] = useState(null);
  const [climberBadges, setClimberBadges] = useState([]);
  const [badges, setBadges] = useState([]);
  const [initiated, setInitiated] = useState(false);

  useEffect(() => {
    if (climber) {
      // Find the Profile by climberId
      findByClimberId(climber.climberId)
        .then((climberProfile) => {
          let newProfile = climberProfile;
          newProfile.badges = [];
          setProfile(newProfile);
        })
        .catch((err) => {
          console.log(err);
        });
    }
  }, [climber]);

  useEffect(() => {
    if (profile) {
      findClimberBadgesByAwardeeId(profile.climberId)
        .then((climberBadges) => {
          let newClimberBadges = climberBadges;
          setClimberBadges(newClimberBadges);
        })
        .catch((err) => console.error);
    }
  }, [profile]);

  useEffect(() => {
    if (climberBadges) {
      findAllBadgesById(climberBadges).then((incomingBadges) => {
        let newBadges = incomingBadges;
        console.log("Logging badges: ", incomingBadges);
        setBadges(newBadges);
      });
    }
  }, [climberBadges]);

  useEffect(() => {
    setInitiated(true);
  }, [badges]);

  const getClimberAge = () => {
    let dob = new Date(climber.dob);
    const monthDiff = Date.now() - dob.getTime();
    const ageDT = new Date(monthDiff);
    const year = ageDT.getUTCFullYear();
    const age = Math.abs(year - 1970);

    return age;
  };

  const getClimberSex = () => {
      let sex = climber.climberSex;
      sex = sex.toLowerCase();
      const firstChar = sex.charAt(0);
      const remainingLetters = sex.substring(1);
      const firstCharUpper = firstChar.toUpperCase();
      const capSex = firstCharUpper + remainingLetters;
      return capSex;
  }

  if (!climber) {
    return <>Waiting on climber.</>; 
  }

  return (
        <Container>
          <Row>
            <Col sm={4}>
              {profile && (
                <Image
                  src={
                    profile.profilePicPath
                      ? profile.profilePicPath
                      : "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png"
                  }
                  rounded
                  fluid
                />
              )}
              <Container>
                <h2>
                  {climber.firstName} {climber.lastName}
                </h2>
                <h5>Email: {climber.email}</h5>
                <h5>Sex: {getClimberSex()}</h5>
                <h5>Age: {getClimberAge()}</h5>
              </Container>
              {profile && (
                <>
                  <Container>
                    <h5>Beta Credits: {climber.betaCredits}</h5>
                  </Container>
                  <hr />
                  <Container>
                    <BadgeList badges={badges} />
                  </Container>
                </>
              )}
            </Col>
            <Col sm={8}>
              {profile ? (
                <Container>
                  <ProfileInformation profile={profile} />
                </Container>
              ) : (
                <Container>
                  <h3>Profile has not been created!</h3>
                  <Row>
                    <Link className="btn btn-primary" to="/profile/create">
                      Create Profile
                    </Link>
                  </Row>
                </Container>
              )}
            </Col>
          </Row>
        </Container>
  );
}
