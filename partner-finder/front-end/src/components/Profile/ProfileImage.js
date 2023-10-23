import Col from 'react-bootstrap/Col';
import Container from 'react-bootstrap/Container';
import Image from 'react-bootstrap/Image';
import Row from 'react-bootstrap/Row';
import ClimberContext from "C:/Users/amari/OneDrive/Documents/Dev10-Academy/Capstone/crag-apps/partner-finder/front-end/src/context/ClimberContext.js";
import { useContext } from 'react';

export default function ProfileImage() {
    const climber = useContext(ClimberContext);
    console.log(climber);

    return (
        <Container>
            <Col>
                <Row>
                    <Image src="C:\Users\amari\OneDrive\Documents\Dev10-Academy\Capstone\crag-apps\partner-finder\front-end\assets\air-alexy-profile.jpg" rounded></Image>
                </Row>
                <Row>
                    <h2></h2>
                </Row>
            </Col>
        </Container>
    )
}