use partner_finder_test;

delimiter //
create procedure set_known_good_state()
begin

delete from profile_comment;
	alter table profile_comment auto_increment = 1;
delete from forum_comment;
	alter table forum_comment auto_increment = 1;
delete from climber_badge;
	alter table climber_badge auto_increment = 1;
delete from badge;
	alter table badge auto_increment = 1;
delete from climbing_gym;
	alter table climbing_gym auto_increment = 1;
delete from climber_profile;
	alter table climber_profile auto_increment = 1;
delete from climber;
	alter table climber auto_increment = 1;
delete from safety_attitude;
	alter table safety_attitude auto_increment = 1;
delete from climbing_motivation;
	alter table climbing_motivation auto_increment = 1;
delete from climbing_style;
	alter table climbing_style auto_increment = 1;
delete from location;
	alter table location auto_increment = 1;
delete from sex;
	alter table sex auto_increment = 1;
delete from country;
	alter table country auto_increment = 1;
delete from state_province;
	alter table state_province auto_increment = 1;
delete from forum;
	alter table forum auto_increment = 1;
delete from app_user_role;
	alter table app_user_role auto_increment = 1;
delete from app_role;
	alter table app_role auto_increment = 1;
delete from app_user;
	alter table app_user auto_increment = 1;

insert into app_user (app_user_id, app_user_email, password_hash, enabled) values 
	(1, 'amarine@gmail.com', 'password_hash', 1),
    (2, 'user2@user2.com', 'password_hash', 1),
    (3, 'moderator@moderator.com', 'password_hash', 1),
    (4, 'admin@admin.com', 'password_hash', 1),
    (5, 'inactive@inactive.com', 'password_hash', 0);
    
insert into app_role values
	(1, 'ADMIN'),
    (2, 'MODERATOR'),
    (3, 'USER'),
    (4, 'RESERVED');
    
insert into app_user_role values
	(1, 1),
    (2, 3),
    (3, 2),
    (4, 1),
    (5, 3);
    
insert into sex values
	(1, 'MALE'),
    (2, 'FEMALE'),
    (3, 'NONBINARY'),
    (4, 'OTHER');
    
insert into country values
	(1, 'UNITED_STATES'),
    (2, 'CANADA'),
    (3, 'MEXICO');
    
insert into state_province values
	(1, 'ALABAMA', 'AL'),
    (2, 'ALASKA', 'AK'),
    (3, 'AMERICAN_SAMOA', 'AS'),
    (4, 'INDIANA', 'IN'),
    (5, 'CALIFORNIA', 'CA');
    
insert into location (location_id, country_name, state_province_name, city, postal_code, location_code) values
	(1, 'UNITED_STATES', 'ALABAMA', 'Mobile', '55555', 1),
    (2, 'UNITED_STATES', 'ALASKA', 'Juneau', '44444', 1),
    (3, 'UNITED_STATES', 'INDIANA', 'Bloomington', '46460', 1),
    (4, 'UNITED_STATES', 'CALIFORNIA', 'San Jose', '90210', 1);
    

insert into climbing_gym (climbing_gym_id, climbing_gym_name, climbing_gym_location_id) values
	(1, 'Climbing Gym 1', 1),
    (2, 'Climbing Gym 2', 2),
    (3, 'Climbing Gym 3', 1),
    (4, 'Climbing Gym 4', 4);
    
insert into badge (badge_id, badge_name, badge_description, badge_cost, badge_icon_path, badge_supply) values
	(1, 'Expert Belayer', 'This climber has been recognized as an expert belayer', 50, null, 1000),
    (2, 'Supportive Climber', 'This climber knows how to give good support to partners', 10, null, 10000),
    (3, 'Safe Trad Leader', 'This climber knows how to safely lead trad climbs', 50, null, 1000),
    (4, 'Leave No Trace', 'This climber respects the outdoors and leaves it bettern than they found it', 35, null, 500);
    
insert into safety_attitude values
	(1, 'VERY_IMPORTANT'),
    (2, 'IMPORTANT'),
    (3, 'SOMEWHAT_IMPORTANT'),
    (4, 'SAFETY_THIRD');
    
insert into climbing_motivation values
	(1, 'ADVENTURE'),
    (2, 'NATURE'),
    (3, 'EXERCISE'),
    (4, 'COMPETITION');
    
insert into climbing_style values
	(1, 'TRAD'),
    (2, 'SPORT'),
    (3, 'BOULDERING'),
    (4, 'ALPINE'),
    (5, 'ICE'),
    (6, 'MIXED'),
    (7, 'GYM');
    
insert into climber (climber_id, app_user_id, username, first_name, last_name, birthday, climber_sex_name, beta_credits) values
	(1, 1, 'Air Alexy', 'Alex', 'Marine', '1981-03-14', 'MALE',1000),
    (2, 2, 'User #2', 'User', 'Two', '1990-01-01', 'FEMALE', 500),
    (3, 3, 'Moderator #3', 'Mod', 'Erator', '1988-01-01', 'FEMALE', 25),
    (4, 1, 'nothing climber', 'nothing', 'nada', '1981-03-14', 'OTHER', 1000);
    
insert into climber_profile (profile_id, climber_id, profile_email, profile_description, is_public, primary_safety_attitude_name, primary_climbing_motivation_name, primary_climbing_country_name, primary_climbing_state_province_name, primary_climbing_postal_code) values
	(1, 1, 'amarine@gmail.com', 'Profile of climber #1', true, 'VERY_IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'INDIANA', '46220'),
    (2, 2, 'user2@user2.com', 'Profile of climber #2', true, 'IMPORTANT', 'EXERCISE', 'CANADA', 'INDIANA', '46077'),
    (3, 3, 'moderator@moderator.com', 'Profile of climber #3', false, 'SOMEWHAT_IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'INDIANA', '46020');
    
insert into climber_badge (climber_badge_id, awardee_id, badge_id, giver_id, date_awarded) values
	(1, 1, 1, 2, '2020-01-01'),
    (2, 2, 3, 3, '2022-01-10'),
    (3, 2, 2, 1, '2023-01-01');

insert into forum (forum_id, forum_name, is_primary_forum, forum_parent_id, nest_level) values
	(1, 'Parent Forum', 1, 0, 0),
    (2, 'California Partners', 1, 1, 1),
    (3, 'Mid-Atlantic Partners', 1, 1, 1),
    (4, 'New River Gorge Partners', 0, 3, 2),
    (5, 'Bridge Climbers', 0, 3, 3);
    
insert into profile_comment (profile_comment_id, posting_climber_id, receiving_climber_id, comment_subject, comment_text, posted_date_time) values
	(1, 1, 2, 'great partner', 'User 2 is a tremendous partner!', '2020-01-01 18:24:22'),
    (2, 2, 3, 'shaky belayer', 'Use caution, this climber needs some more belay experience.', '2022-01-01 22:54:01'),
    (3, 3, 2, 'a good fit', 'We cliqued perfectly on our fist climbing trip! 10/10', '2021-01-01 09:19:33');

insert into forum_comment (forum_comment_id, posting_climber_id, receiving_forum_id, comment_subject, comment_text, posted_date_time) values
	(1, 1, 1, 'Partner for Indiana', 'Im looking for a gym partner in Indianapolis next week.', '2023-10-10 19:44:00'),
    (2, 2, 4, 'anyone up for NRG?', 'I will be there the weekend of halloween. Looking for trad experts!', '2023-10-12 15:29:09'),
    (3, 3, 3, null, 'I have no friends. Please partner me.', '2019-01-01 14:23:23');
    
end//
delimiter ;