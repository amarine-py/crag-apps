


    
    use partner_finder;
    select * from climber;
    
    use partner_finder;
    select * from app_user;
    
    use partner_finder;
    select c1_0.profile_id,
    c1_0.hardest_aid_grade,
    c1_0.hardest_boulder_grade,
    c1_0.climber_id,
    c1_0.primary_climbing_country_name,
    c1_0.primary_climbing_motivation_name,
    c1_0.primary_climbing_postal_code,
    c1_0.primary_climbing_state_province_name,
    c1_0.favorite_climbing_style_name,c1_0.profile_description,c1_0.enabled,c1_0.has_rope,c1_0.has_sport_gear,c1_0.has_trad_gear,c1_0.has_transportation,c1_0.hardest_ice_grade,c1_0.is_public,c1_0.hardest_mixed_grade,c1_0.open_to_mentee,c1_0.open_to_mentor,c1_0.profile_pic_path,c1_0.primary_safety_attitude_name,c1_0.hardest_sport_grade,c1_0.hardest_trad_grade,c1_0.profile_username from climber_profile c1_0 where c1_0.climber_id=5;
    
select * from climber;                 
select * from climber_badge;
select * from badge;
select * from climber_profile;

use partner_finder;
set sql_safe_updates = 0;
delete from climber_badge;
alter table climber_badge auto_increment = 1;

insert into climber_badge (climber_badge_id, awardee_id, badge_id, giver_id, date_awarded) values
(1, 1, 1, 2, '2020-01-01'),
(2, 2, 3, 3, '2022-01-10'),
(3, 2, 2, 1, '2023-01-01'),
(4, 1, 3, 1, '2023-01-01'),
(5, 1, 2, 2, '2023-01-01'),
(6, 9, 1, 1, '2023-01-01'),
(7, 9, 3, 2, '2023-01-01'),
(8, 6, 1, 1, '2023-01-01'),
(9, 8, 2, 2, '2023-01-01'),
(10, 9, 4, 1, '2023-01-01'),
(11, 7, 3, 2, '2023-01-01');
set sql_safe_updates = 1;


use partner_finder;
set sql_safe_updates = 0;
delete from badge;
alter table badge auto_increment = 1;
insert into badge (badge_id, badge_name, badge_description, badge_cost, badge_icon_path, badge_supply) values
	(1, 'Expert Belayer', 'This climber has been recognized as an expert belayer', 50, '/assets/badge-icons/expert-belayer-badge.png', 1000),
    (2, 'Supportive Climber', 'This climber knows how to give good support to partners', 10, '/assets/badge-icons/supportive-partner-badge.png', 10000),
    (3, 'Safe Trad Leader', 'This climber knows how to safely lead trad climbs', 50, '/assets/badge-icons/safe-lead-climber-badge.png', 1000),
    (4, 'Leave No Trace', 'This climber respects the outdoors and leaves it bettern than they found it', 35, '/assets/badge-icons/leave-no-trace-badge.png', 500);
set sql_safe_updates = 1;