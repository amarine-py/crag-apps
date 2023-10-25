import { findByProfileId } from "../../services/profileAPI";
import { findClimberBadgesByAwardeeId, findAllBadgesById} from "../../services/badgeAPI";
import { findClimberByClimberId } from "../../services/climberAPI";
import Container from "react-bootstrap/esm/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import ProfileInformation from "./ProfileInformation";
import BadgeList from "../Badge/BadgeList";
import { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function PartnerProfile() {
  const [profile, setProfile] = useState(null);
  const [climber, setClimber] = useState(null);
  const [climberBadges, setClimberBadges] = useState([]);
  const [badges, setBadges] = useState([]);
  const [initiated, setInitiated] = useState(false);
  const { profileId } = useParams();

  useEffect(() => {
    findByProfileId(profileId)
    .then((profileData) => {
        let newProfile = profileData;
        newProfile.badges = [];
        setProfile(newProfile);
        findClimberByClimberId(newProfile.climberId)
        .then((climberData) => {
            let newClimber = climberData;
            setClimber(newClimber);
            findClimberBadgesByAwardeeId(newClimber.climberId)
            .then((climberBadgeData) => {
                let newClimberBadges = [...climberBadgeData ];
                setClimberBadges(newClimberBadges);
                findAllBadgesById(newClimberBadges)
                .then((badgeData) => {
                    let newBadges = [...badgeData];
                    setBadges(newBadges);
                })
            })
        })
    })
    // const data = findByProfileId(profileId);
    // let newProfile = {...data};
    // newProfile.badges = [];
    // setProfile(newProfile);

    // if (climber) {
    //   // Find the Profile by climberId
    //   findByClimberId(climber.climberId)
    //     .then((climberProfile) => {
    //       let newProfile = climberProfile;
    //       newProfile.badges = [];
    //       setProfile(newProfile);
    //     })
    //     .catch((err) => {
    //       console.log(err);
    //     });
    // }
  }, []);

//   useEffect(() => {
//     const data = findClimberByClimberId(profile.climberId);
//     let newClimber = {...data};
//     setClimber(newClimber);

//   }, [profile]);

//   useEffect(() => {
//     if (profile) {
//       findClimberBadgesByAwardeeId(profile.climberId)
//         .then((climberBadges) => {
//           let newClimberBadges = climberBadges;
//           setClimberBadges(newClimberBadges);
//         })
//         .catch((err) => console.error);
//     }
//   }, [profile]);

//   useEffect(() => {
//     if (climberBadges) {
//       findAllBadgesById(climberBadges).then((incomingBadges) => {
//         let newBadges = incomingBadges;
//         console.log("Logging badges: ", incomingBadges);
//         setBadges(newBadges);
//       });
//     }
//   }, [climberBadges]);

  const getClimberAge = () => {
    let dob = new Date(climber.dob);
    const monthDiff = Date.now() - dob.getTime();
    const ageDT = new Date(monthDiff);
    const year = ageDT.getUTCFullYear();
    const age = Math.abs(year - 1970);

    return age;
  };

  const getClimberSex = () => {
      let sex = climber.climberSex;
      sex = sex.toLowerCase();
      const firstChar = sex.charAt(0);
      const remainingLetters = sex.substring(1);
      const firstCharUpper = firstChar.toUpperCase();
      const capSex = firstCharUpper + remainingLetters;
      return capSex;
  }

  return (
        <Container>
          <Row>
            <Col sm={4}>
              {profile && (
                <Image
                  src={
                    profile.profilePicPath
                      ? profile.profilePicPath
                      : "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png"
                  }
                  rounded
                  fluid
                />
              )}
              {climber && (
                <Container>
                <h2>
                  {climber.firstName} {climber.lastName}
                </h2>
                <h5>Email: {climber.email}</h5>
                <h5>Sex: {getClimberSex()}</h5>
                <h5>Age: {getClimberAge()}</h5>
              </Container>
              )}
              
              {profile && (
                <>
                  <Container>
                    <h5>Beta Points: {profile.betaPoints}</h5>
                  </Container>
                  <hr />
                  <Container>
                    <BadgeList badges={badges} />
                  </Container>
                </>
              )}
            </Col>
            <Col sm={8}>
              {profile ? (
                <Container>
                  <ProfileInformation profile={profile} />
                </Container>
              ) : (
                <Container>
                  <h3>Profile has not been created!</h3>
                </Container>
              )}
            </Col>
          </Row>
        </Container>
  );
}

// import { useEffect, useState } from "react";
// import { useParams, Link } from "react-router-dom";
// import { findByProfileId } from "../../services/profileAPI";
// import {
//   findClimberBadgesByAwardeeId,
//   findAllBadgesById,
// } from "../../services/badgeAPI";
// import { findClimberByClimberId } from "../../services/climberAPI";
// import BadgeList from "../Badge/BadgeList";
// import ProfileInformation from "./ProfileInformation";
// import Row from "react-bootstrap/Row";
// import Col from "react-bootstrap/Col";
// import Image from "react-bootstrap/esm/Image";

// export default function PartnerProfile({ profileId }) {
//   const [profile, setProfile] = useState(null);
//   const [climber, setClimber] = useState(null);
//   const [climberBadges, setClimberBadges] = useState([]);
//   const [badges, setBadges] = useState([]);

//   const { id } = useParams();

//   useEffect(() => {
//     console.log("Starting useEffect for getting profile")
//     findByProfileId(id)
//       .then((climberProfile) => {
//         let newProfile = climberProfile;
//         newProfile.badges = [];
//         console.log("Got profile by profileID: ", newProfile)
//         setProfile(newProfile);
//       })
//       .catch((err) => {
//         console.log(err);
//       });
//   }, []);

//   useEffect(() => {
//     console.log("getting the climber now")
//     findClimberByClimberId(profile.climberId)
//         .then((climber) => {
//             let newClimber = climber;
//             console.log("Got climber by climberID: ", newClimber)
//             setClimber({...newClimber });
//         })
//         .catch((err) => {
//             console.log(err);
//         });
//   }, [profile]);

//   useEffect(() => {
//     if (profile) {
//       findClimberBadgesByAwardeeId(profile.climberId)
//         .then((climberBadges) => {
//           let newClimberBadges = [...climberBadges];
//           setClimberBadges([...newClimberBadges]);
//         })
//         .catch((err) => console.error);
//     }
//   }, [profile]);

//   useEffect(() => {
//     if (climberBadges) {
//       findAllBadgesById(climberBadges).then((incomingBadges) => {
//         let newBadges = [...incomingBadges];
//         setBadges([...newBadges]);
//       });
//     }
//   }, [climberBadges]);

//   const getClimberAge = () => {
//     if (climber) {
//         let dob = new Date(climber.dob);
//     const monthDiff = Date.now() - dob.getTime();
//     const ageDT = new Date(monthDiff);
//     const year = ageDT.getUTCFullYear();
//     const age = Math.abs(year - 1970);
//     return age;
//     }
//     return null;
//   };

//   const getClimberSex = () => {
//     console.log(climber);
//     if (climber) {
//       let sex = climber.climberSex;
//       sex = sex.toLowerCase();
//       const firstChar = sex.charAt(0);
//       const remainingLetters = sex.substring(1);
//       const firstCharUpper = firstChar.toUpperCase();
//       const capSex = firstCharUpper + remainingLetters;
//       return capSex;
//     }
//     return null;
//   }

//   return (
//     <div>
//       <Row>
//         <Col sm={4}>
//           {profile && (
//             <Image
//               src={
//                 profile.profilePicPath
//                   ? profile.profilePicPath
//                   : "https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png"
//               }
//               rounded
//               fluid
//             />
//           )}
//           <div>
//             <h2>
//               {climber?.firstName} {climber?.lastName}
//             </h2>
//             <h5>Email: {climber?.email}</h5>
//             <h5>Sex: {getClimberSex()}</h5>
//             <h5>Age: {getClimberAge()}</h5>
//           </div>
//           {profile && (
//             <>
//               <div>
//                 <h5>Beta Credits: {climber.betaCredits}</h5>
//               </div>
//               <hr />
//               <div>
//                 <BadgeList badges={badges} />
//               </div>
//             </>
//           )}
//         </Col>
//         <Col sm={8}>
//           {profile ? (
//             <div>
//               <ProfileInformation profile={profile} />
//             </div>
//           ) : (
//             <div>
//               <h3>Profile has not been created!</h3>
//               <Row>
//                 <Link className="btn btn-primary" to="/profile/create">
//                   Create Profile
//                 </Link>
//               </Row>
//             </div>
//           )}
//         </Col>
//       </Row>
//     </div>
//   );
// }
