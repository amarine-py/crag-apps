drop database if exists partner_finder;
create database partner_finder;
use partner_finder;

create table app_user (
	app_user_id int primary key auto_increment,
    app_user_email varchar(75) not null unique,
    password_hash varchar (2048) not null,
    enabled bit not null default(1)
);

create table app_role (
	app_role_id int primary key auto_increment,
    app_role_name varchar(50) not null unique
);

create table app_user_role (
	app_user_id int not null,
    app_role_id int not null,
    constraint pk_app_user_role
		primary key (app_user_id, app_role_id),
	constraint fk_app_user_role_user_id
		foreign key (app_user_id)
        references app_user(app_user_id),
	constraint fk_app_user_role_role_id
		foreign key (app_role_id)
        references app_role(app_role_id)
);

create table sex (
	sex_id tinyint primary key auto_increment,
    sex_name varchar(50) not null unique
);

create table location_country (
	country_id int primary key auto_increment,
    country_name varchar(75) not null unique
);

create table state_province (
	state_province_id int primary key auto_increment,
    state_province_name varchar(75) not null,
    state_province_print_name varchar(75) not null,
    state_province_abbr varchar(10) not null
);

create table location (
	location_id int primary key auto_increment,
    location_country_id int not null,
	location_state_province_id int not null,
    city varchar(75) not null,
    postal_code varchar(12) not null,
    location_code int not null,
    constraint fk_location_location_country_id
		foreign key (location_country_id)
		references location_country(country_id),
	constraint fk_location_state_province_id
		foreign key (location_state_province_id)
        references state_province(state_province_id)
);

create table climbing_gym (
	climbing_gym_id int primary key auto_increment,
    climbing_gym_name varchar(75) not null,
    climbing_gym_location_id int null,
    constraint fk_climbing_gym_location_id
		foreign key (climbing_gym_location_id)
        references location(location_id)
);

create table badge (
	badge_id int primary key auto_increment,
    badge_name varchar(75) not null unique,
    badge_description text(1024) not null,
    badge_cost int not null,
    badge_icon blob null,
    badge_supply int null
);

create table safety_attitude (
	safety_attitude_id int primary key auto_increment,
    safety_attitude_name varchar(50) not null
);

create table climbing_motivation (
	climbing_motivation_id int primary key auto_increment,
    climbing_motivation_name varchar(50) not null
);
        
create table climbing_attitude (
	climbing_attitude_id int primary key auto_increment,
    climbing_attitude_name varchar(50) not null
);

create table climbing_style (
	climbing_style_id int primary key auto_increment,
    climbing_style_name varchar(50) not null
);


create table climber_profile (
	profile_id int primary key auto_increment,
    profile_description text(2048) not null,
    is_public bool not null,
    hardest_trad_grade varchar(25) null,
    hardest_sport_grade varchar(25) null,
    hardest_boulder_grade varchar(25) null,
    hardest_ice_grade varchar(25) null,
    hardest_mixed_grade varchar(25) null,
    hardest_aid_grade varchar(25) null,
    has_trad_gear bool null,
    has_sport_gear bool null,
    has_rope bool null,
    has_transportation bool null,
    looking_for_mentor bool null,
    open_to_mentoring bool null,
    number_of_registered_partners int null,
    primary_safety_attitude_id int not null,
    primary_climbing_motivation_id int not null,
    primary_climbing_attitude_id int not null,
    favorite_climbing_style_id int null,
    primary_climbing_country_id int not null,
    primary_climbing_state_province_id int not null,
    primary_climbing_gym_id int null,
    
    constraint fk_primary_safety_attitude_id
		foreign key (primary_safety_attitude_id)
        references safety_attitude(safety_attitude_id),
	constraint fk_primary_climbing_motivation_id
		foreign key (primary_climbing_motivation_id)
        references climbing_motivation(climbing_motivation_id),
	constraint fk_primary_climbing_attitude_id
		foreign key (primary_climbing_attitude_id)
        references climbing_attitude(climbing_attitude_id),
	constraint fk_favorite_climbing_style_id
		foreign key (favorite_climbing_style_id)
        references climbing_style(climbing_style_id),
	constraint fk_primary_climbing_country_id
		foreign key (primary_climbing_country_id)
        references location_country(country_id),
	constraint fk_primary_climbing_state_province_id
		foreign key (primary_climbing_state_province_id)
        references state_province(state_province_id),
	constraint fk_primary_climbing_gym_id
		foreign key (primary_climbing_gym_id)
        references climbing_gym(climbing_gym_id)
);

create table climber (
	climber_id int primary key auto_increment,
    app_user_id int not null,
    username varchar(50) not null unique,
    first_name varchar(75) not null,
    last_name varchar(75) not null,
    birthday date not null,
    climber_sex_id tinyint not null,
    climber_description text(1024) null,
    climber_primary_location_id int not null,
    climber_profile_id int null,
    beta_credits int null,
    constraint fk_app_user_id
		foreign key (app_user_id)
        references app_user(app_user_id),
    constraint fk_climber_sex_id
        foreign key (climber_sex_id)
        references sex(sex_id),
	constraint fk_climber_primary_location_id
		foreign key (climber_primary_location_id)
        references location(location_id),
	constraint fk_climber_profile_id
		foreign key (climber_profile_id)
        references climber_profile(profile_id)
);

create table climber_badge (
	awardee_id int not null,
    badge_id int not null,
    giver_id int not null,
    date_awarded date not null,
    constraint pk_awardee_badge
		primary key (awardee_id, badge_id),
	constraint fk_climber_giver_id
		foreign key (giver_id)
        references climber(climber_id),
	constraint fk_climber_awardee_id
		foreign key (awardee_id)
        references climber(climber_id),
	constraint fk_climber_badge_id
		foreign key (badge_id)
        references badge(badge_id)
);

create table forum (
	forum_id int primary key auto_increment,
    forum_name varchar(128) not null,
    is_primary_forum bool not null,
    forum_parent_id int null,
    nest_level int null,  -- 0=primary, 1=secondary, 2=tertiary, etc.
    constraint fk_forum_parent_id
		foreign key (forum_parent_id)
        references forum(forum_id)
);

create table user_comment (
	user_comment_id int primary key auto_increment,
    posting_climber_id int not null,
    receiving_climber_id int not null,
    comment_subject varchar(256) null,
    comment_text text not null,
    posted_date_time datetime not null,
    constraint fk_user_posting_climber_id
		foreign key(posting_climber_id)
        references climber(climber_id),
	constraint fk_receiving_climber_id
		foreign key(receiving_climber_id)
        references climber(climber_id)
);

create table forum_comment (
	forum_comment_id int primary key auto_increment,
    posting_climber_id int not null,
    receiving_forum_id int not null,
    comment_subject varchar(256) null,
    comment_text text not null,
    posted_date_time datetime not null,
    constraint fk_forum_comment_posting_climber_id
		foreign key (posting_climber_id)
        references climber(climber_id),
	constraint fk_receiving_forum_id
		foreign key(receiving_forum_id)
        references forum(forum_id)
);

