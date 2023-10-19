//package partner_finder.data.mappers;
//
//import partner_finder.models.*;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class ClimberProfileMapper implements RowMapper<ClimberProfile> {
//
//    @Override
//    public ClimberProfile mapRow(ResultSet rs, int rowNum) throws SQLException {
//        ClimberProfile climberProfile = new ClimberProfile();
//        climberProfile.setProfileId(rs.getInt("profile_id"));
//        climberProfile.setClimberId(rs.getInt("climber_id"));
//        climberProfile.setEmail(rs.getString("profile_email"));
//        climberProfile.setDescription(rs.getString("profile_description"));
//        climberProfile.setPublic(rs.getBoolean("is_public"));
//        climberProfile.setTradGrade(rs.getString("hardest_trad_grade"));
//        climberProfile.setSportGrade(rs.getString("hardest_sport_grade"));
//        climberProfile.setBoulderGrade(rs.getString("hardest_boulder_grade"));
//        climberProfile.setIceGrade(rs.getString("hardest_ice_grade"));
//        climberProfile.setMixedGrade(rs.getString("hardest_mixed_grade"));
//        climberProfile.setAidGrade(rs.getString("hardest_aid_grade"));
//        climberProfile.setHasTradGear(rs.getBoolean("has_trad_gear"));
//        climberProfile.setHasSportGear(rs.getBoolean("has_sport_gear"));
//        climberProfile.setHasRope(rs.getBoolean("has_rope"));
//        climberProfile.setHasTransportation(rs.getBoolean("has_transportation"));
//        climberProfile.setOpenToMentor(rs.getBoolean("open_to_mentor"));
//        climberProfile.setOpenToMentee(rs.getBoolean("open_to_mentee"));
//        climberProfile.setNumPartners(rs.getInt("number_of_registered_partners"));
//        climberProfile.setSafetyAttitude(SafetyAttitude.valueOf(rs.getString("primary_safety_attitude_name")));
//        climberProfile.setClimbingMotivation(ClimbingMotivation.valueOf(rs.getString("primary_climbing_motivation_name")));
//        climberProfile.setClimbingStyle(ClimbingStyle.valueOf(rs.getString("favorite_climbing_style_name")));
//        climberProfile.setClimbingCountry(Country.valueOf(rs.getString("primary_climbing_country_name")));
//        climberProfile.setClimbingState(StateProvince.valueOf(rs.getString("primary_climbing_state_province_name")));
//        climberProfile.setClimbingPostalCode(rs.getString("primary_climbing_postal_code"));
//        climberProfile.setEnabled(rs.getInt("enabled") > 0);
//
//        return climberProfile;
//    }
//}
