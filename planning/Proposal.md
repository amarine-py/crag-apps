# Alex Marine -- Capstone Proposal: Crag Apps -- Partner Finder

Crag Apps aims to be a suite of climbing-related web applications. Each individual app solves a separate problem. The overall bundle will be called "Crag Apps." I am only focusing on ONE of the individual apps for this capstone project. That individual app is called (as of now) Partner Finder.

## 1. Problem Statement

As a climber, it can be frustrating to find partners whose goals align with your own. There isn't one archetypal "climber." People climb for many reasons, including recreation, competition, exercise, solitude, and adventure. There are also many different types of climbing. This fact makes it difficult to find a partner that shares similar goals and ambitions. 

What's more, climbing is a passion that can involve inherent risks. This makes it not only convenient but sometimes essential to align yourself with others who take safety as seriously as you do. 

Partner Finder aims to help climbers find partners who share similar goals, styles, and attitudes toward their shared passion. In addition, it hopes to provide a means to verify that a particular user meets certain criteria before being "vouched for" by the app. Users can award badges to other users. These badges serve as votes of confidence attesting to another user's, say, ability to provide a safe belay. Or their ambition to climb a certain grade. Or their ability to safely climb multi-pitch rock routes. Or their desire to complete certain training goals. Or even their desire to take find a mentor or take on a mentee.

Through the use of badges from other app users, users can earn an attestation from the app itself. As a user, you will then be able to filter by any number of criteria to find a climber who, for example, lives in the Mountain West, climbs at least 5.10, has their own trad climbing gear, and takes safety seriously.

## 2. Technical Solution

Create an application that allows its users to seek out other climbers based on certain criteria. These criteria take two forms: badges that are awarded by other users (social component) and volunteered profile information (self-assessment component).

### Scenario 1

Corbin is visiting his daughter at college in Chicago. He wants to be able to boulder while he is there and is aware that there is a great bouldering gym in the neighborhood he is staying. He can use Partner Finder to search for partners that meet his desired criteria. He filters by: safety level, seriousness, climbing ability, and location. Corbin is able to find a few partners who are looking to climb with others who take safety very seriously, are laid-back and not too serious or pretentious about climbing, climb in the V3/V4 grade range, and regularly boulder at his target gym. After exchanging messages with a few of these partners, Corbin finds someone who can meet up and show him around the gym for a few hours while his daughter is in class.

### Scenario 2

Alex is interviewing for a full-stack developer job in Flagstaff, AZ. While he is in town, he decides to take a few extra days to get some multi-pitch alpine climbing in. He uses Partner Finder to search for potential partners in the area who possess at least six years of experience, are able and willing to climb a two-day objective, in alpine style, in the 5.11 difficulty range, with tolerance for moderate risk scenarios. He finds 10 other users in the area who claim to possess all of these criteria in their self-assessments, but only two of them have been awarded badges by other users that back up these claims. He decides to message the two partners with badges, as he doesn't want to take anyone's word for their level of experience and safety given the seriousness of the objective. Partner Finder, through its badging system, vouches that at least X number of other users have awarded these two climbers badges testifying to their safety and experience levels. He can also look at the profiles of the users who have awarded these badges to make sure that they themselves have adequate experience to allow for sound judgement. Alex can now feel secure in the assumption that the candidate partners have been awarded the badges in good faith.

### Scenario 3

Sarah is a beginner climber with 2 years of experience. She has climbed outdoors, but only on top rope. She wants to take the next step and start leading moderate sport routes. She would like to find a partner with more experience who is willing to take on a mentee, to some degree. Sarah uses Partner Finder to find another woman, Sophie, of similar age who has eight years of outdoor leading experience and is willing to climb with beginners. As an added bonus, Sarah sees that Sophie also has a 70-meter rope and 20 sport draws. Sarah messages Sophie and they agree to climb in the gym for a session before taking a one-day trip to their local outdoor crag to inaugurate their new partnership.

## 3. Glossary

## User

An entity who can log in to Partner Finder with a username and password and has one or more "roles." A user will be associated with a climber in a bridge table in the database once a user has set up a profile and completed the their self-assessment survey.

## Climber

An entity who has a user account associated with Partner Finder and who has completed their self-assessment survey. A climber is the key model instance in Partner Finder. It can have many other attributes associated with it, such as badges, certifications, routes, other partners, etc.


## Badge (still being fleshed out)

A "plaudit" or "token" awarded to a user by another user. This badge takes the form of an icon and attests to the fact that the user who awarded the badge "vouches" for the user in whatever category relates to the badge. For example, badge categories may include: "expert belayer", "attentive spotter", "5 Years Experience", "sport lead climber", "trad follower", etc.

A user will only have a certain number of badges to award in a given time period. These details still need to be worked out.

## Certification (still being fleshed out)

A user will be "certified" by Partner Finder in a given area if they receive a certain number of badges by users who meet a certain experience level. The algorithm for this has not yet been developed.

## Points (still being fleshed out)

A new user will start with a certain amount of points (credits, coins, beta?) when they create an account. Certain actions will deduct points, like awarding badges, posting comments, etc. Points can be earned with certain actions(?) (receiving badges or certifications?) and over time (montly allotment?).

## User Comment

Any comment posted by a climber about another climber. These comments will appear in the profile section for a climber and contain certain basic data, like name of poster, date/time, subject, and comment body.

## Forum Comment

Any comment posted by a climber that is in the forum section of the site. These comments will appear under the forum topic for which they are posted and contain certain basic data, like name of poster, date/time, subject, comment body, and topic name.

## Forum

Section of Partner Finder for general or specific discussion. The forum will have a number of topics. Any comments posted to the forum will need to be tagged with a topic. That comment will then be displayed under that specific forum in chrono order.

## Routes

A route is a model that will contain many fields, including "name," "type," "difficulty," "location[1-n]," "comments," "pitches," "safety level," etc. A route is an entity that will be stored in the Partner Finder database initially. It will need to be migrated to the database of the Routes app eventually. Routes will be connected to a climber with a bridge table.


## 4. High Level Requirement

    - Create a climber [USER, MODERATOR, ADMIN]
    - View climbers [anyone]
    - Edit or delete a climber [ADMIN, USER associated with that climber]
    - Create, edit, or delete a badge [ADMIN]
    - Award or retract a badge [USER, ADMIN]
    - Create, edit, delete, award certifications [ADMIN]
    - Add a user comment [USER, MODERATOR, ADMIN]
    - Edit or delete a user comment [MODERATOR, ADMIN, USER associated with comment]
    - Add a forum comment [USER, MODERATOR, ADMIN]
    - Edit or delete a forum comment [MODERATOR, ADMIN, USER associated with comment]
    

## 5. User Scenarios

### Create a Climber

Add a climber to the Partner Finder community.

Suggested data:
    - Name
    - Date joined
    - Location (Country, State, City, Zip), or perhaps data from a map integration library
    - Bio: description of oneself in a climbing sense
    - Age: perhaps an ENUM with age zones?
    - Sex: ENUM with Male, Female, Non-Binary
    - Approach to climbing: Array of ENUMs (more than one is possible) with Competitive, Serious, Laid-back, Adventurous, Daring, Passionate, Casual, etc.
    - Approach to safety: ENUM with Safety is Everything, Safety First, Safety Second, Safety Third, Safety is an afterthought
    - Public/Private account: private accounts can only be seen by other users who are logged in.

**Precondition**: User must have created an account and be logged in.

### View Climbers

Anyone can navigate to the site and view the climbers who have an account on Partner Finder if they have listed their accounts as public.

### Edit/Delete a Climber

Only an admin or the user associated with that account may edit or delete a climber.

**Precondition**: Admin or user must be logged in with the appropriate credentials and auth.

### Create/Edit/Delete a Badge

Only an admin can create a new badge or edit/delete an existing badge.

Suggested data for creating a badge:
    - Name
    - Description
    - Icon
    - Cost (in points)
    - Type?

**Precondition**: Admin must be logged in with the appropriate credentials and auth.
**Post-condition**: Any climbers who have a badge that is deleted will lose that badge(?). Any climbers who have a badge that has been edited will see their badge changed according to the edits(?).

### Award/Retract a Badge

A user or an administrator may award or retract a badge to/from another user.

Suggested data for awarding a badge:
    - Reason
    - Date awarded

**Precondition**: User/admin must be logged in with appropriate credentials and auth. User must have the "points" necessary to award the badge.
**Post-condition**: A user will lose the points that the badge costs when they award the badge. If a badge is retracted by a user or admin, the points will NOT go back into their account. An admin can manually add/subtract points from a user account for cause.

### Create, Edit, Delete, Award Certifications

Only a site administrator can create, edit, delete, or award certifications. The certifications will be awarded automatically by the site if a user is awarded a certain number and type of badges.

Suggested data for creating a certification:
    - Name  
    - Description
    - Type
    - Privileges?

**Precondition**: Admin must be logged in with appropriate credentials and auth. 
**Post-condition**: Any climbers who have a certification that is deleted will lose that certification(?). Any climbers who have a certification that has been edited will see their certification changed according to the edits(?). 

### Add a User Comment

Users, moderators, and admins can add a comment to to any other user's profile. Should posting a comment cost "points"? 

Suggested data:
    - Poster name
    - Name of climber receiving the comment
    - Date posted
    - Subject?
    - Comment body

**Precondition**: Must be logged in with appropriate credentials. Possibly must have enough "points"?
**Post-condition**: Comment will show up and be associated with the climber account to which it is posted. The user who posts the comment may lose points associated with the "cost" of commenting?

### Edit a User Comment

Admins can edit a comment for cause, but this should ONLY be in rare cases. A user may choose to edit their own posted comments.

**Precondition**: Must be logged in with appropriate credentials.
**Post-condition**: Comments will be removed or changed. User will not reclaim points associated with cost of comment?

### Delete a User Comment

Admins and moderators can delete a user comment for cause. Users should be able to delete their own user comments.

### Add a Forum Comment

Users, moderators, and admins can add a comment to to the forum. Should posting a comment cost user "points"?

Suggested data:
  - Poster name
  - Date posted
  - Subject?
  - Comment body
  - Forum name

**Precondition**: Must be logged in with appropriate credentials. Possibly must have enough "points"?
**Post-condition**: Comment will show up and be associated with the forum to which it is posted. The user who posts the comment may lose points associated with the "cost" of commenting?

### Edit a Forum Comment

Admins can edit a forum comment for cause, but this should ONLY be in rare cases. A user may choose to edit their own forum comments.

**Precondition**: Must be logged in with appropriate credentials.
**Post-condition**: Comments will be removed or changed. User will not reclaim points associated with cost of comment?

### Delete a Forum Comment

Admins and moderators can delete a forum comment for cause. Users should be able to delete their own forum comments.


## 6. User Stories

### Lars is a lurker, aka, a potential user of Partner Finder

> As Lars, I want to view Partner Finder to see if it can help me find suitable partners.
> - Lars should be able to navigate to Partner Finder to view existing users and their profiles, if they are public 

> As Lars, I want to view the forums on Partner Finder to see how existing users communicate.
> - Lars should be able to navigate to Partner Finder to view the forums and see all posts

> As Lars, I want to create an account on Partner Finder to explore member-only features.
> - Lars should be able to register as a user by providing an email and password that meets requirements

> As Lars, I want to create a profile as a climber on Partner Finder so that I can view member-only features like private profiles.
> - Lars should be able to log in with his account and create a climber profile.
>   - Depends on "As Lars, I want to be able to create an account on Partner Finder to explore member-only features."

> As Lars, I want to start with enough "points" as a new user to be able to post a comment or award a badge.
> - Lars should have enough points as a new user to award a badge or post a comment in the forums or on another user's profile
>   - Depends on "As Lars, I want to be able to create an account on Partner Finder to explore member-only features."

### Uma is a user of Partner Finder with an existing climber profile

> As Uma, I want to edit my climber profile.
> - Uma should be able to make changes to her profile and have them persist.
>   - Depends on "As Lars, I want to be able to create a profile as a climber on Partner Finder so that I can view member-only features like private profiles."
>   - Which depends on "As Lars, I want to be able to create an account on Partner Finder to explore member-only features."

> As Uma, I want to delete my existing Partner Finder climber profile.
> - Uma should be able to delete her climber profile, which will also delete her login credentials and log her out

> As Uma, I want to search for partners with certain characteristics.
> - Uma should be able to use the search function to filter results based on any available characteristic in a climber's profile
>   - Depends on "As Lars, I want to be able to create a profile as a climber on Partner Finder so that I can view member-only features like private profiles."

> As Uma, I want to post a comment on another user's profile.
> - Uma should be able to post a comment on a registered user's climber profile
>   - Depends on "As Lars, I want to be able to create a profile as a climber on Partner Finder so that I can view member-only features like private profiles."

> As Uma, I want to edit/delete a comment from another user's profile.
> - Uma should be able to edit/delete her own comments from any climber profile

> As Uma, I want to post a comment in the forums.
> - Uma should be able to post a comment in the forums
>   - Depends on, "As Lars, I want to start with enough "points" as a new user to be able to post a comment or award a badge."
>   - Which depends on, "As Lars, I want to be able to create a profile as a climber on Partner Finder so that I can view member-only features like private profiles."

> As Uma, I want to edit/delete a comment in the forums.
> - Uma should be able to edit/delete her own comments from the forums

> As Uma, I want to award a badge to another climber.
> - Uma should be able to award a badge to another climber, assuming she has enough points to cover the cost of the badge
>   - Depends on, "As Lars, I want to start with enough "points" as a new user to be able to post a comment or award a badge."
>   - Which depends on, "As Lars, I want to be able to create a profile as a climber on Partner Finder so that I can view member-only features like private profiles."

> As Uma, I want to retract a badge that I have previously awarded to another climber.
> - Uma should be able to retract a badge that she previously awarded to another user
>   - Depends on, "As Uma, I want to be able to award a badge to another climber."

### Mindy is a moderator on Partner Finder

> As Mindy, I want to log in as a moderator and have the appropriate authorizations.
> - Mindy should be able to use her existing credentials to log in as a moderator, assuming she has been given a moderator role by an admin
>   - Depends on, "As Alfie, I want to grant the moderator role to another user."
>   - Which depends on, "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Mindy, I want to delete a user comment for cause.
> - Mindy should be able to delete a user comment, if justified
>   - Depends on, "As Mindy, I want to log in as a moderator and have the appropriate authorizations."

> As Mindy, I want to delete a forum comment for cause.
> - Mindy should be able to delete a user comment, if justified
>   - Depends on, "As Mindy, I want to log in as a moderator and have the appropriate authorizations."

> As Mindy, I want to move a forum comment to a different topic area.
> - Mindy should be able to move a forum comment to a more appropriate forum topic area
>   - Depends on, "As Mindy, I want to log in as a moderator and have the appropriate authorizations."

> As Mindy, I want to take any actions a regular user can take on Partner Finder.
> - Mindy should be able to take any actions a regular user can take on the site by signing in with her moderator credentials

### Alfie is an administrator on Partner Finder

> As Alfie, I want to log in as an admin and have the appropriate authorizations.
> - Alfie should be able to use his existing credentials to log in as an admin, assuming he has been given the admin role by another admin

> As Alfie, I want to grant the moderator role to another user. 
> - Alfie should be able to grant the moderator role to another user
>   - Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to change a user's available point balance.
> - Alfie should be able to manually change a user's point balance for cause
>   - Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to add or delete users on Partner Finder.
> - Alfie should be able to add new users to Partner Finder and delete existing users for cause
>   - "Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to edit a user comment for cause.
> - Alfie should be able to edit a user comment, but only for good cause and in rare cases.
>   - Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to edit a forum comment for cause.
> - Alfie should be able to edit a forum comment, but only for good cause and in rare cases.
>   - Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to perform all CRUD operations on a badge.
> - Alfie should be able to create, edit, and delete badges on Partner Finder
>   - Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to perform all CRUD operations on a certificate.
> - Alfie should be able to create, edit, and delete certificates on Partner Finder
>   - Depends on "As Alfie, I want to log in as an admin and have the appropriate authorizations."

> As Alfie, I want to have authorizations to perform any actions a moderator or regular user can perform.
> - Alfie should be able to take any actions that a user or moderator can take by signing in with his admin credentials