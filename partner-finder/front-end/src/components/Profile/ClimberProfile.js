import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import Button from "react-bootstrap/Button";
import ProfileInformation from "./ProfileInformation";
import DeleteProfileConfirmModal from "./DeleteProfileConfirmModal";
import ProfileBadgeList from "../Badge/ProfileBadgeList";
import { useEffect, useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import {
  findByClimberId,
  disableByProfileId,
  enableByProfileId,
} from "../../services/profileAPI";
import {
  findClimberBadgesByAwardeeId,
  findAllBadgesById,
} from "../../services/badgeAPI";
import EnableProfileConfirmModal from "./EnableProfileConfirmModal";

export default function ClimberProfile({ climber }) {
  const [profile, setProfile] = useState(null);
  const [climberBadges, setClimberBadges] = useState([]);
  const [badges, setBadges] = useState([]);
  const [initiated, setInitiated] = useState(false);
  const [showDelete, setShowDelete] = useState(false);
  const [showEnable, setShowEnable] = useState(false);
  const navigate = useNavigate();
  const data = { ...profile };

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
  };

  const handleEdit = () => {
    navigate("/profile/edit", { state: data });
  };

  const onConfirmDelete = () => {
    console.log("Show delete: ", showDelete);
    const success = disableByProfileId(profile.profileId);
    if (!success) {
      console.log("Disable was unsuccessful.");
    } else {
      console.log("Your profile has been deleted.");
      navigate("/");
    }
  };

  const onConfirmEnable = () => {
    console.log("Show enable: ", showEnable);
    const success = enableByProfileId(profile.profileId);
    if (!success) {
      console.log("Enable was unsuccessful.");
    } else {
      console.log("Your profile has been enabled.");
      navigate("/");
    }
  };
  
  return (
    <Container>
      <DeleteProfileConfirmModal
        show={showDelete}
        onHide={() => setShowDelete(false)}
        onConfirmDelete={onConfirmDelete}
      />
      <EnableProfileConfirmModal
        show={showEnable}
        onEnableHide={() => setShowEnable(false)}
        onConfirmEnable={onConfirmEnable}
      />
      <Row>
        <Col sm={5}>
          <Row>
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
          </Row>
          <Row>
            <Col>
              <Container>
                <h2>
                  {climber.firstName} {climber.lastName}
                </h2>
                <h5>Email: {climber.email}</h5>
                <h5>Sex: {getClimberSex()}</h5>
                <h5>Age: {getClimberAge()}</h5>
              </Container>

              <Container>
                {profile ? <h5>Beta Points: {profile.betaPoints}</h5> : null}
              </Container>
            </Col>
            <Col id="outer-div">
              <Container id="inner-div">
                <Button variant="primary" onClick={handleEdit} size="lg">
                  Edit Profile
                </Button>
              </Container>
              <Container>
                <Button variant="warning" size="sm">
                  Make Private
                </Button>
              </Container>
              {profile && (
                <Container>
                  {profile?.enabled ? (
                    <Button
                      variant="danger"
                      size="sm"
                      onClick={() => setShowDelete(true)}
                    >
                      Disable Profile
                    </Button>
                  ) : (
                    <Button
                      variant="success"
                      size="sm"
                      onClick={() => setShowEnable(true)}
                    >
                      Enable Profile
                    </Button>
                  )}
                </Container>
              )}
            </Col>
          </Row>

          <hr />
          <Container>
            <ProfileBadgeList badges={badges} />
          </Container>
        </Col>
        <Col sm={6}>
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
