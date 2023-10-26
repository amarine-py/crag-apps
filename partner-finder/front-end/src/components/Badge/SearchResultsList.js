import Container from "react-bootstrap/Container";
import Table from "react-bootstrap/Table";
import Image from "react-bootstrap/Image";
import Button from "react-bootstrap/Button";

export default function SearchResultsList( {searchResults, awardBadge} ) {

    
    return (
        <Container>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Award?</th>
                        <th>Image</th>
                        <th>Username</th>
                        <th>State</th>
                    </tr>
                </thead>
                <tbody>
                {searchResults.map((profile) => 
                    <tr key={profile.profileId}>
                        <td><Button variant="success" onClick={()=> awardBadge(profile.climberId)}>Award!</Button></td>
                        <td><Image src={profile.profilePicPath} alt="profile pic" thumbnail fluid/></td>
                        <td>{profile.username}</td>
                        <td>{profile.climbingStateName}</td>
                    </tr>
                )}
                </tbody>
            </Table>
        </Container>
    );
}