use partner_finder;
set sql_safe_updates = 0;

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

insert into app_user (app_user_id, username, password_hash, enabled) values 
	(1, 'amarine@gmail.com', 'password_hash', 1),
    (2, 'user2@user2.com', 'password_hash', 1),
    (3, 'moderator@moderator.com', 'password_hash', 1),
    (4, 'admin@admin.com', 'password_hash', 1),
    (5, 'inactive@inactive.com', 'password_hash', 0),
    (6, 'user6@example.com', 'password_hash', 1),
    (7, 'user7@example.com', 'password', 1),
    (8, 'user8@example.com', 'password', 1);
    
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
    (5, 3),
    (6, 3),
    (7, 3),
    (8, 3);
    
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
    (5, 'CALIFORNIA', 'CA'),
    (6, 'TEXAS', 'TX');
    
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
	(1, 'Expert Belayer', 'This climber has been recognized as an expert belayer', 50, '/assets/badge-icons/expert-belayer-badge.png', 1000),
    (2, 'Supportive Climber', 'This climber knows how to give good support to partners', 10, '/assets/badge-icons/supportive-partner-badge.png', 10000),
    (3, 'Safe Trad Leader', 'This climber knows how to safely lead trad climbs', 50, '/assets/badge-icons/safe-lead-climber-badge.png', 1000),
    (4, 'Leave No Trace', 'This climber respects the outdoors and leaves it bettern than they found it', 35, '/assets/badge-icons/leave-no-trace-badge.png', 500);
    
insert into safety_attitude values
	(1, 'VERY_IMPORTANT'),
    (2, 'IMPORTANT'),
    (3, 'MINIMALLY_IMPORTANT'),
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

insert into climber (climber_id, app_user_id, email, first_name, last_name, birthday, climber_sex_name, beta_credits) values
	(1, 1, 'amarine@gmail.com', 'Alex', 'Marine', '1981-03-14', 'MALE',1000),
    (2, 2, 'user2@user2.com', 'User', 'Two', '1990-01-01', 'FEMALE', 500),
    (3, 3, 'moderator@moderator.com', 'Mod', 'Erator', '1988-01-01', 'FEMALE', 25),
    (4, 4, 'admin@admin.com', 'nothing', 'nada', '1981-03-14', 'OTHER', 1000),
    (5, 5, 'inactive@inactive.com', 'User', 'Five', '1981-03-14', 'MALE', 900),
    (6, 6, 'user6@example.com', 'User', 'Six', '1981-03-14', 'MALE', 125),
    (7, 7, 'user7@example.com', 'User', 'Seven', '1981-03-14', 'FEMALE', 1200),
    (8, 8, 'user8@example.com', 'User', 'Eight', '1981-03-14', 'MALE', 435);
    
insert into climber_profile (profile_id, climber_id, profile_username, profile_description, is_public, primary_safety_attitude_name, 
primary_climbing_motivation_name, primary_climbing_country_name, primary_climbing_state_province_name, primary_climbing_postal_code, 
beta_points, profile_pic_path) values
	(1, 1, 'Air Alexy', 'Profile of climber #1', true, 'VERY_IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'INDIANA', '46220', 1000, 'https://lh3.googleusercontent.com/pw/ADCreHeMKkW4Bmes2_dsWORYEaBglrv3uP9pmqty7QqhtQoTYnxN2FxL3-jHhnKd6u8SYSJoQ6b207A9sdx7-PAul6WM8zpLuhpRPPtNj3RsHc6gO9kCAnW9ConjU0E7UjCnprYNQ75ZXH3P1asr_DrY3H6IUMghN22pJpCTpZznhqSN9nt2GZuZt_8TzujOQRUSgj4QguTZ9oXptvb1vsayhWRO5L_SgV4DB2l-0o5DnWi4NbneDzeFvrp8LEd9IPdQF9YExuZvfgOJi6yh8_K6IU5scVf0vBGrCnoNDFI-49-7LK-_PYPz6gdqAwUUdK_wafPeMksUAVcA2Ht3spVR95BZIL-AN4SUhMXR1nd1Xk5s8gXP6tIcwabhotnBRkNcWD71aTx3fkO-1p1HySeib5zKiuTGOu4Q42DiCqe0vKo0Ijt0EjhOuCMOFZuEeD9u3lfEK6WqFlqGk91HW6tP48kB3FdEqGocim67Y7GCrqFhIosl3szX3f_gLXOZTw6ihwqNOBNw07GQIV55lPW2mv1DmqCuEf8RHbiD8iCbnlpax49y0cwCBjFQuLVhKXjJSA2npUOzj-HsEpRxppD6pV_Jzc0Y87HNEOc3SpabgIsmsSsIvkVdEANutxn020X6FYnLK0q6dymqnAY8QxbUmTeF7TvPoPM03LupOIzA5e0GEkNuAgiYd4xrSvCj2Z3i-nEScmzviX-uvPx4ZEFEEwl3T7zaxg43YjOZvwL9CNiiUjNTBmsch7mbr-yHvFbgzcJD0U9IAHKwiZXTHGocssxuJok9uPN6aOXKp2oXXfFIHHvAFMwxC13SobLrWyUXHZaC7Zn6RnKiUuSuhdNbOt4UMaF7fxuzg8XiDTpqHYp0iGkHhqjtumh0tzrQjLxjgZ64gywdih8D2vVGq1dLRHl2kuY=w1286-h965-s-no-gm?authuser=0'),
    (2, 2, 'VAinVA', 'Profile of climber #2', true, 'IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'TEXAS', '46077', 125, 'https://lh3.googleusercontent.com/pw/ADCreHeb_qeDYtL1S-ZMJ50fGOkKF1w6fT6bgFdY3UOWUmQVofGl50mkfaSaxwuTws3AERZPOC_2VEXX3Va5BVD-ywmqe6gPOBIaLUK-MZk1y_Cto9JHJPi0c-xF6VKe0wO61but7_XR1X8vBWH5p2mXto3ow6g7roccxzqAmGf566P4cRelDtTEB0ARhe3PCUpp-uXT6QGzeG_F2S5Ds2MiA2MTsgmkKbT0Kh9R8Uv4G3kqWiv9DX1Qe94kA5_ZUDWViZvrVy0i85AG9dhp0JLC2hGSHfglsGGfrS4oY5iEjpK1ifiXwLVg-5i-BeIDOn5yFU4ii3wnRxZ3KOhAJAq30zcPqnHlcp86c1vsdikNGXnN94JLRivuhNVap87nBww94qiOS-3TzMIKcJOHmUaqJFBB54cT9EA2BdfC6vXWdofVcdeaqiYGTja2BKRdDTOqUo8ufayimjWPsQLidh5AgsfY9ysUjW2tdDcQYCSvjcC0GPNzk91_86lLelz182PbY1z2oDWpyFHec34u83Ie6XpRMkZoQVUotKUjpFHfo4dQWEuJ6d4a5cbdBpQSinyqA_inUiImb6KXs03wFkn8bV0dQ0NRoi5Sg3AeJwNKbSx4QgqEW6sl_ltMoeJxJg8mFnrvEKN3_oKIEfi15p6syEbGmhtuCKpBb6U7JPVgvWOV9OJqFkHLqf8lyftQ24lTigsFQlP2lqaTN7Ak5j58b-mGzXgJWAAOk56ONSYd0NQVNOQi0nns1GtAaJ9T0eassYCzoDNIs_pdSqIgYOk21E-pZsnm9zXxJwiLccmjAKaTKzQUvlcWF2jMgU9edcW0s4TE4JVpf5uytKJw46WnqMRgPIJW5cBb4k2AJNIwFaadAeNk03XlggsaDY7Dqzb-DocoDSE-t1I7xJlRG4bprZarHz8=w728-h971-s-no-gm?authuser=0'),
    (3, 3, 'SmileofCali', 'Profile of climber #3', false, 'MINIMALLY_IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'INDIANA', '46020', 350, 'https://lh3.googleusercontent.com/pw/ADCreHcA3yK-Tx8zxdmqsY_hFbnlek3ZhTnXUaoxhRaG7QHEaBwS0fCwRGaPpLRdvA3j0a1O9iW0owFudLnfy7wkLoaZ1RUB2NCrhBwFWeqx__4RPtLZ9WzPhmPQ1N5A60d_AQQZksyIEHqFCqOm-xjmLDp1oTAoQyui6U-RrUoulv0tjaUlBOnXLxUFkGrQ3gleMQYCFIXFk5kau-fKNRQmsOBou9r8ASUE6t8M6c_lOfsB_BzWVx4fEacs75x-8hCEGaWLTOIIKtJydzEiGADtmc7pCAslTpSWe-VEHS_FwScMBDa7qbD-NMb6G-1e-lLhdaI9Ss671VT0vfb9XTkTu7hsK59mX1FNCGk40oDjxtn1gbaZ5MKiJYn4eJXehHkOMqeI-tS2Ric1Ym78EIQgNeFcQEAo06x5K592p_W0aTakat2-CKpTB8hFcxRTlgg8BwDO4YPUAK44_UiFOw76YJfew3PnGyqV0iypS6pUorYTsDKHnHC0XHsX9PKmnKKi5V2Lq0Ve2UQ0OkbkdGeUsUTC2FNowlrg3wBfRN4x7QTJHWBZ5kFFIsybkgT_v7L8kf5yyBToJ1aF0Kt67CT6J9r7RnjQhU4ZCJeq_dRMuY0ZxMuSj3C9hH6YV791oD8kOpnx0b9fJsXqTG4R2gD8HoVX83Zb-8PtQaMe52ohiG9bjPh7P7uVvHT-jiqZ3kLWQRrtjGYs4GbJgN3FToeyQV5O2DdMOh3StknwwVPjH65tyEvHQaRf74OuXNofhFQ2qBGPWEUbPgjGpPEaXmkVWjUmDcmvAdQYgqVp7gHGN5lR2PNKT1s3epNpGgY4kfUKpeg2sZSTCr4dZqzwjuJYEEleVPn9bkRf9JuX5dca_I8cWUvq_2ByFbSTdvuJi12jr3eB6f6h8LgnRDOj2Sw7rhFFdDQ=w728-h971-s-no-gm?authuser=0'),
    (4, 6, 'TruncelFritos', 'I climb the rocks.', true, 'IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'TEXAS', '46077', 685, 'https://lh3.googleusercontent.com/pw/ADCreHeoD2q7jr232x7tXMTO2B0wLV72fSsCtNzL62NQ1E5q7mAq8u-O05FswoGBUPbEPl1pi9wz_-wAk9LR0NCPAE4FdqDysaMuWUboyXpWZ_l4wIIH7PbvqtGHX3fCUvYaH-cQVR0thAx6UkO0C8H9XZoJa7KrgdDCF49mIP-w23mqSX2FKXFHiAG4Bi_njNl6zUncxorYGzwQQu2xZGkJusL0JNTKmVPV6jxwHW39n2giiANeKSD7V6zq7qHJmGshH_RBcyxcmNtnth01KA-auiDMzKkNy30tpB7uXbSOoSUbpAwqbWOejirQf0hXB9inJkvkGqX_Dx2WFDoQHHsbh-fNLh_79AiDTQ3eDUUcsVswEpvq7psT07-OfWBKmuy_xSP3NMCWJ9VFbxVEnS8u8bYyfeXeoCcvSjFhPOqgG0gylCB1ceU7mHsPBD8QrvGel06h8Hw7dvGW9ls-Uy0Gm0RRJsErkcMt5INdhs5Ykrw0uWEzpZh_CNykcEjTOQZB4iFDpdgSnEaTxAAkzU_TJoMtBgvCfx6hugJZHVF9ZYlY6NlsczVRQzAOd9cZn32ms69rqV5gMmC69AHAAAMZx8IfSMqP2VSt6lH6jG2qpGCrTmh0kaHH17qPRxzgnQxc3kaizszpy7QNxRERYm8iRWprmhUD-hv9Y7z8HjpTeWa1USKzT5UV12-L9RvLOwoLclle8sdH54VdoXdc_3eEdfKqn_mqOz3u1jQ7xU15Fxiu2JXFatDTCiFEMMzrA9bQnsUgDfzgfC43lEdTlM_06LQTgK9ruzWKP9tDOKCWgQpLQlfcK4qYh_u067ysB8A_pk9QRMSZYIov_gVpa-pbfzBTPH2xY1Kr3R8TGpkMVzYT-ecElb-UAp7RcyXc0WuwRcOciSNP89B25SOTOaliP8aQEQ=w728-h971-s-no-gm?authuser=0'),
    (5, 7, 'GannonDorf', 'What I cant climb, Ill try to eat.', true, 'IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'INDIANA', '46077', 440, 'https://lh3.googleusercontent.com/pw/ADCreHc8CjRstlSi2f6lZHjliheDYaqkiy36uuBot7BaseVWuVR0-eFWEFE9Cff9pRz14W-wDesQcHIML49MuQP5ofdseVByXxWMTvIu9kd5BXYKE-juCAbPa27IyGg9NTcxIk3Ozs-7m9L0KEOg_B6Ru-TZzqHMxVqXLMioWwz4kEf72sSX8QqRthyEe4MmrFiYe71Cx5uEivC46SF3zQTgj-iEXAFzAAMWUP3zteoHf0aXoLkq8_5bS07ilC7-k8BjeqeZ1oReGqikIlmScnwFhygHJq5JHlU5eqqdUDs8EQr5qO-_wCH750r8IWk9EXDvQVu6BXCNIhcTsOCY2WYXIpPIHtVYz8aTqGieGszStJR3Xk-U2tDhCOE8T0VTDgx-3g8XlrtdO2N0SRtIVR2hFF29Ls1GRV8K2K7sKq2U6p0D30DbGthiHf0m8FCrY17W6FuCt0Kz_QCub19vRWKoBh_lMmUfbJzUT5GYSQ9POqowpZ05to9Ke5h0x8x7ldlnjle8Ex9EkNRD9xa_tjDnrQrdHmKkgsrK0kosRDT1UFmGPbdzv-kBBEfTd3LKssLUT6B2Gb44i9ZTe9K3rb4wh9zBmzgrOpJ86BjBVraWxVMJ9cro_rWMl_LlBHQWHBljacaSeziRSgSBBs7fLUtywxhnGmLs3cNSjCKgE09pyoOSDgqHwTgaOAi0TfCaSScsQK7PQbz2QzdtB5EZ8zkP0sxAIRR0sdMxNZUhnxDemIPFyzyWHak1r-ELaOsVdW6DzBoZiiruYRe_pz7gCx2-MrnRoU09Ji9AvGn7RgCTDPlniipgaj0JubKm_U-9np-PbXPpJqkufvY46CDYl7zGfVp8V_pYOakkjV6VicWS_Ls0pcuUlY7fR2j0un4JWd2wPWfw5VVPl3cWg0M5DA0OMhXJjm4=w1456-h971-s-no-gm?authuser=0'),
    (6, 8, 'ThatGirl', 'Basic Climber, yeah, I like to boulder in the gym', true, 'IMPORTANT', 'EXERCISE', 'UNITED_STATES', 'INDIANA', '46077', 250, 'https://lh3.googleusercontent.com/pw/ADCreHcFRqDHZ0XL_eSPKTHL2roiizLwKRUo_erDNSo3mol3rB8AoX7YHroSIr-GJeG4vzDfoNYfHvCrizpTRVqyyi8HNVlI_sPLTJfokggiwPX2Cj8alQ10F1jfTrWlfn3h0JEf7QR3P8jCP5EqjLQCSJLJvQ5S8e4StZDCzcrJpAn_8y880X-5lZPPAGdVjPoe7-ViWS1qgHgPtIxLONLz-29ZIZ8I_mEKjoyLVJq-GHPR-FCetq1VishSRWUqqm1cHAkDRS81e5W8jfifIEAOgRxwVALB44V3_FpkW33DougBTIocGjqVe9C40OrWJUdHIGf1Yr1w-dnm1jvEO2WaxbwLtJfTu8cFSW4IAelKwQitcaaP9oW98sFDKyIOS5BI7Cyjf2bGUuLdEeTmZVjhRZu5WiL6FBopWyOyorkTSpbw4TMiv40Je2y1CfBUrU9ng1TA49m_Vd6Mek7ktmP_Wd2TxkNWs3yEWUZwlgOR9ZuNsZQSwqIlUGqfpOgJNHYzU1tEaZLnepYXBdNgdHfgApeLxgdMdxTX-1rCJ8Z3XHxgMcnMehn3gRTy4t_ycM9KwxahBVacjjxMw-RjUSziidXYKMu7UNS3IPCGxqoyzmwc01YQx9UhTtzGWXnLL8yqKYxnEBq5Zz_ItTsDCWfBIYFR2JJCMDmAdUrjlybhSi6Ql7vCCyMKKE3_FOtyjRUBAxhajXbLxVqj5m9Jqc6c-sllhLdIu9v4efgSV7cqEgxigvwxUnjh3xilJMBG0PeKWr1GaTRWWmB7xd6NSD2GzjrxdxUr_ITseNl04RBuKSS0OKweekSFRsXA4l4sl5nK5vlJysFLFhGNzNAsYHCyPGfG3f1PubtdaI1hvX5hlP2jcMJd2Fca6lB1BbCFrUE6l_MdiLhix8-1pWSV4tbduema2aE=w1280-h960-s-no-gm?authuser=0');
    
insert into climber_badge (climber_badge_id, awardee_id, badge_id, giver_id, date_awarded) values
	(1, 1, 1, 2, '2020-01-01'),
    (2, 2, 3, 3, '2022-01-10'),
    (3, 2, 2, 1, '2023-01-01'),
    (4, 1, 1, 1, '2023-01-01'),
    (5, 1, 2, 2, '2023-01-01');

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
    

set sql_safe_updates = 1;