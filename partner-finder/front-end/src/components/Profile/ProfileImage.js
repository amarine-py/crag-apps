import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Row from 'react-bootstrap/Row';
import ClimberContext from '../../context/ClimberContext';
import ProfileContext from '../../context/ProfileContext';
import { useContext, useEffect } from 'react';

export default function ProfileImage() {
    const climber = useContext(ClimberContext);
    const profile = useContext(ProfileContext);

    console.log(profile);

    useEffect( () => {
        if (profile) {
            console.log(climber);
        }
    }, [profile]);

    if (!profile) {
        return null;
    }

    return (
            <Container>
            <Col>
                <Row>
                    <Image src="C:/Users/amari/OneDrive/Documents/Dev10-Academy/Capstone/crag-apps/partner-finder/front-end/assets/air-alexy-profile.jpg" rounded></Image>
                </Row>
                <Row>
                    <h2>{profile.username}</h2>
                </Row>
            </Col>
        </Container>
        
    )
}