import Container from "react-bootstrap/esm/Container";
import Button from "react-bootstrap/Button";
import Card from "react-bootstrap/Card";
import ListGroup from 'react-bootstrap/ListGroup';
import { useNavigate } from "react-router-dom";


export default function PartnerCard({ partnerProfile }) {

  const navigate = useNavigate();

  return (
    <div>
      <Card style={{ width: "18rem" }}>
        <Card.Img variant="top" src={partnerProfile.profilePicPath} />
        <Card.Body>
          <Card.Title>{partnerProfile.username}</Card.Title>
          {partnerProfile.description}
            <ListGroup.Item>{partnerProfile.firstName} {partnerProfile.lastName}</ListGroup.Item>
            <ListGroup.Item>Beta Points: {partnerProfile.betaPoints}</ListGroup.Item>
          <Button variant="primary" onClick={()=>navigate(`/partner/${partnerProfile.profileId}`)}>View Profile</Button>
        </Card.Body>
      </Card>
    </div>
  );
}
