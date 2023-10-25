import Container from "react-bootstrap/Container";
import ListGroup from "react-bootstrap/ListGroup";
import BadgeCard from "./BadgeCard";
import { useEffect, useState } from "react";

export default function BadgeList({ badges }) {

  const [initiated, setInitiated] = useState(false);
  console.log("BadgeList logging: ", badges);
  console.log("Length of Badges: ", badges.length);

  return (
    <div>
      {badges.map((b) => <div key={[b.badgeId]}>{b.name}</div>)}
     </div>
  );
}
