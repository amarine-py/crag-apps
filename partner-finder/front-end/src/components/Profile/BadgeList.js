export default function BadgeList({profile}) {

    return (
        <>
            <h4>Badges</h4>
            {profile.profileId}
            {profile.badges ? "true" : "false"}
            
        </>
    );
}