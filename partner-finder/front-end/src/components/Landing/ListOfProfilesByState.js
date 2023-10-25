import ListGroup from "react-bootstrap/ListGroup";
import { useEffect } from "react";

export default function ListOfProfilesByState({ profilesByState }) {
  useEffect(() => {
    console.log("Profiles by state from list: ", profilesByState);
  });

  return (
    <div>
        <ListGroup>
        {profilesByState.map( (p) => 
            <ListGroup.Item key={p.profileId}>
                <h5>{p.username}</h5><h6>State: {p.climbingStateName}</h6><span> <em>Beta Points:</em> </span>{p.betaPoints}
            </ListGroup.Item>
        )}
        </ListGroup>
    </div>
  );
}
