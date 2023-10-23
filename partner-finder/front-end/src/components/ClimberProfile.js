import Container from "react-bootstrap/esm/Container";
import ProfileImage from "././Profile/ProfileImage";
import ClimberContext from "../context/ClimberContext";
import { useEffect, useContext, useState } from "react";
import { findByClimberId } from "../services/profileAPI";

export default function ClimberProfile() {
    const climber = useContext(ClimberContext);
    const [profile, setProfile] = useState(null);
    console.log(climber);

    useEffect(() => {
        if (!profile) {
            console.log(climber);
          findByClimberId(climber.climberId)
          .then((climberProfile) => {
            setProfile(climberProfile);
            console.log(profile);
          })
          .catch((err) => {
            console.log(err);
          })}
      }, []);




    return (
        <Container>
            <ProfileImage />
        </Container>
    );
}