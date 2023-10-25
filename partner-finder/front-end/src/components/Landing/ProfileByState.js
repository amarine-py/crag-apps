import { useEffect } from 'react';
import ListGroup from 'react-bootstrap/ListGroup';


export default function ProfileByState( { profile } ) {

    useEffect(() => {
        console.log("A single profile: ", profile);
    })

    return (
            <ListGroup.Item as="li">
                {profile.username}, 
                {profile.climbingStateName}, Beta Points: 
                {profile.betaPoints}
            </ListGroup.Item>
    );
}