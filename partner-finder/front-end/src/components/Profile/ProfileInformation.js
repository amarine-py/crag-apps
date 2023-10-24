import Container from "react-bootstrap/esm/Container";
import Col from "react-bootstrap/Col";
import Row from "react-bootstrap/Row";


export default function ProfileInformation( {profile} ) {

    const setCase = (string) => {
        string = string.toLowerCase();
        const firstChar = string.charAt(0);
        const remainingLetters = string.substring(1);
        const firstCharUpper = firstChar.toUpperCase();
        const capString = firstCharUpper + remainingLetters;
        return capString;
    }
    

    return (
        
        <Container>
            <Container>
                <h3>{profile.username}</h3>
                <p>{profile.description}</p>
            </Container>
            <hr />
            <Container>
                <h4>Location</h4>
                <Col>
                <Row>
                    <p>{setCase(profile.climbingCountry)}</p>
                    <p>{setCase(profile.climbingState)}</p>
                    <p>{profile.climbingPostalCode}</p>
                </Row>
                </Col>
            </Container>
            <hr />
            <Container>
                <h4>Climbing Info</h4>
                <Row>
                <Col>
                    <Container>
                    <strong>How important is climbing safety?</strong>
                    <p>{setCase(profile.safetyAttitude)}</p>
                    <strong>Primary climbing motivation?</strong>
                    <p>{setCase(profile.climbingMotivation)}</p>
                    <strong>Primary climbing discipline?</strong>
                    <p>{setCase(profile.climbingStyle)}</p>
                    </Container>
                </Col>
                
                <Col>
                <Container>
                    <strong>Hardest sport climb?</strong>
                    <p>{profile.sportGrade}</p>
                    <strong>Hardest boulder?</strong>
                    <p>{setCase(profile.boulderGrade)}</p>
                    <strong>Hardest trad grade</strong>
                    <p>{setCase(profile.tradGrade)}</p>
                    </Container>
                </Col>
                </Row>
            </Container>
            <hr />
            <Container>
                <Row>
                    <Col>
                    {profile.openToMentor ? "✅ Looking for mentor" : "❌ Looking for mentor"}
                    </Col>
                    <Col>
                    {profile.openToMentee ? "✅ Open to mentoring" : "❌ Open to mentoring"}
                    </Col>
                </Row>
                <Row>
                <Col>
                    {profile.hasTransportation ? "✅ Has transportation" : "❌ Has transportation"}
                </Col>
                <Col>
                    {profile.hasTradGear ? "✅ Has trad gear" : "❌ Has trad gear"}
                </Col>
                <Col>
                    {profile.hasSportGear ? "✅ Has sport gear" : "❌ Has sport gear"}
                </Col>
                <Col>
                    {profile.hasRope ? "✅ Has a rope" : "❌ Has a rope"}
                </Col>
                </Row>
            </Container>
        </Container>

    );
    
}