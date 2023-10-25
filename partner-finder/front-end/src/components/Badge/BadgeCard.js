import Container from "react-bootstrap/Container";

export default function BadgeCard({ badge }) {
  console.log("Badge card logging: ", badge);
  return <div>{badge.name}</div>;
}
