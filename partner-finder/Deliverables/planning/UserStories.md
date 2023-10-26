## User Stories

### Lars is a lurker, aka, a potential user of Partner Finder

> As Lars, I want to view Partner Finder to see if it can help me find suitable partners.
> - Lars should be able to navigate to Partner Finder to search by username or location to find climbers, if their profiles are public

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

> As Uma, I want to search for other climbers on Partner Finder by name or location.
> - Uma should be able to search for other registered climbers on Partner Finder by username or by location

> As Uma, I want to filter my search results based on a number of characteristics.
> - Uma should be able to narrow her search results by applying filters on the search page

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