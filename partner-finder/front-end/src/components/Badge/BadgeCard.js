import Container from "react-bootstrap/Container";
import Card from "react-bootstrap/Card";
import Button from "react-bootstrap/Button";
import { useNavigate } from "react-router-dom";
import { useContext } from "react";
import AuthContext from "../../context/AuthContext";

export default function BadgeCard({ badge }) {
  const auth = useContext(AuthContext);
  const data = { ...badge };
  const navigate = useNavigate();

  return (
    <>
        <Card style={{ width: "14rem" }}>
          <Card.Img variant="top" src={badge.iconPath} />
          <Card.Body>
            <Card.Title>{badge.name}</Card.Title>
              <div>
                <div>Description</div>
               <div>{badge.description}</div>
              </div>
              <div>
                Cost
               {badge.cost}
              </div>
            <Button
              variant="primary"
              onClick={
                auth.user
                  ? () => navigate(`/badge/award/id=${badge.badgeId}`, { state: data } )
                  : () => navigate("/login")
              }
            >
              Award Badge!
            </Button>
          </Card.Body>
        </Card>
    </>
  );
}
