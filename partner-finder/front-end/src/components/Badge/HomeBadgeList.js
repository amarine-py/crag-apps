import Container from "react-bootstrap/Container";
import { useState, useEffect } from "react";
import { findAllBadges } from "../../services/badgeAPI";
import BadgeCard from "./BadgeCard";

export default function HomeBadgeList() {
  const [badges, setBadges] = useState([]);

  useEffect(() => {
    console.log("fetching badges");
    findAllBadges()
      .then((response) => {
        console.log("Badges!!: ", response);
        let newBadges = response;
        setBadges(newBadges);
      })
      .catch((err) => console.error);
  }, []);

  return (
    <>
        <h2>Most Popular Partner Badges</h2>
      <Container className="cards-wrapper">
        {badges.map((badge) => (
          <Container key={badge.badgeId} className="col-md-3">
            <BadgeCard badge={badge} />
          </Container>
        ))}
      </Container>
    </>
  );
}
