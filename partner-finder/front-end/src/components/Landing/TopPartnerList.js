import Container from "react-bootstrap/esm/Container";
import { findTopTenProfiles } from "../../services/profileAPI";
import { useEffect, useState } from "react";
import PartnerCard from "../Partners/PartnerCard";

export default function TopPartnerList() {
  const [topTen, setTopTen] = useState([]);
  const [topTenInitialized, setTopTenInitialized] = useState(false);

  useEffect(() => {
    findTopTenProfiles()
      .then((response) => {
        setTopTen(response)
      })
      .catch((err) => console.error);
  }, []);

  return (
    <Container>
      <h2>Top Partners on Partner Finder</h2>
      <Container className='cards-wrapper'>
          {topTen.map((partnerProfile) => (
            <Container key={partnerProfile.profileId} className="col-md-3" fluid="md">
              <PartnerCard
                partnerProfile={partnerProfile}
              />
            </Container>
          ))}
      </Container>
    </Container>
  );
}
