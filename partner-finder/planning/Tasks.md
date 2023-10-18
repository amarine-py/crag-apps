## Tasks

### Back-End

#### Models

[Time Estimate: 2 hours]
- AppUser *
- Sex (enum) *
- LocationCountry (enum) *
- StateProvince (enum) *
- Location *
- ClimbingGym *
- Badge *
- SafetyAttitude (enum) *
- ClimbingMotivation (enum) *
- DEPRECATED -- ClimbingAttitude (DEPRECATED -- enum)
- ClimbingStyle (enum) *
- ClimberProfile *
- Climber *
- Forum *
- ForumComment *
- ProfileComment *
- Map ???

#### Data Layer

[Time Estimate: 30 min] *
- AppUserRepository *
  - findByUsername
  - create
  - update
  - delete
- AppUserJdbcTemplateRepository *
- AppUserMapper *

[Time Estimate: 1 hour]
- ClimberRepository *
  - findByClimberId
  - create
  - update
  - delete
- ClimberJdbcTemplateRepository
- ClimberMapper *

[Time Estimate: 1 hour]
- LocationRepository *
  - findByLocationId
  - create
  - update
  - delete
- LocationJdbcTemplateRepository
- LocationMapper *

[Time Estimate: 1 hour]
- BadgeRepository *
  - findByBadgeId
  - findByBadgeName
  - create
  - update
  - delete
- BadgeJdbcTemplateRepository ?
- BadgeMapper *

[Time Estimate: 1.5 hours]
- ClimberProfileRepository *
  - findByProfileId
  - findBySafetyAttitude
  - findByClimbingMotivation
  - findByClimbingStyle
  - findByCountry
  - findByState
  - findByPostalCode
  - findByLocationCode
  - create
  - update
  - delete
- ClimberProfileJdbcTemplateRepository
- ClimberProfileMapper *

[Time Estimate: 1.5 hours]
- CommentRepository *
  - findByUserCommentId
  - findByClimberId
  - findByForumCommentId
  - findByForumId
  - findByReceivingClimberId
  - create
  - update
  - delete
- CommentJdbcTemplateRepository
- CommentMapper *

[Time Estimate: 1 hour]
- ForumRepository *
  - findByForumId
  - findByForumName
  - findByParentId
  - create
  - edit
  - delete
- ForumJdbcTemplateRepository ?
- ForumMapper *

[Time Estimate: 2 hours ??]
- MapDataRepository ???

#### Domain Layer

[Time Estimate: 2 hours]
- ClimberService
  - findByClimberId
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 1.5 hour] 
- LocationService
  - findByLocationId
  - findByCountryId
  - findByStateId
  - findByPostalCode
  - findByLocationCode
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 1 hour]
- BadgeService
  - findByBadgeId
  - findByBadgeName
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 2.5 hours]
- ClimberProfileService
  - findByProfileId
  - findBySafetyAttitude
  - findByClimbingMotivation
  - findByClimbingAttitude
  - findByClimbingStyle
  - findByStateId
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 2 hours]
- CommentService
  - findByUserCommentId
  - findByUserId
  - findByForumCommentId
  - findByForumId
  - findByReceivingClimberId
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 1.5 hours]
- ForumService
  - findByForumId
  - findByForumName
  - findByParentId
  - create
    - validate
  - edit
    - validate
  - delete

[Time Estimate: 0.5 hours]
- Result
- ResultType (enum)

[Time Estimate: 2 hours ???]
- MapService ???

#### Controller Level

[Time Estimate: 0.5 hours]
- ClimberController (could potentially control climber profiles, as well?)
  - "/climber"
    - GET (all climbers?)
    - GET "/{id}" 
    - POST (create)
    - PUT "/{id}" (edit)
    - DELETE "/{id}" 

[Time Estimate: 0.5 hours]
- ClimberProfileController (could also include user comments)
  - "/profile"
    - GET (all profiles?)
    - GET "/{id}"
    - POST (create)
    - PUT "/{id}" (edit)
    - DELETE "/{id}"

[Time Estimate: 0.5 hours]
- LocationController (may need to use this to render map data endpoints)
  - "/location"
    - GET (all ?)
    - GET "/{id}"
    - POST (create)
    - PUT "/{id}" (edit)
    - DELETE "/{id}"

[Time Estimate: 0.5 hours]
- BadgeController (should have a badge page where users can see info about badges)
  - "/badge"
    - GET (all ?)
    - GET "/{id}"
    - POST (create)
    - PUT "/{id}" (edit)
    - DELETE "/{id}"

[Time Estimate: 0.5 hours]
- CommentController (can control both types of comments)
  - "/user/comment"
    - GET (all user comments ?)
    - GET "/{user_comment_id}" 
    - POST (create user comment)
    - PUT "/{user_comment_id}" (update user comment)
    - DELETE "/{user_comment_id}" (delete user comment)
[Time Estimate: 0.5 hours]
  - "/forum/comment"
    - GET (all forum comments ?)
    - GET "/{forum_comment_id}"
    - POST (create forum comment)
    - PUT "/{forum_comment_id}" (update forum comment)
    - DELETE "/{forum_comment_id}" (delete forum comment)

[Time Estimate: 0.5 hours]
- ForumController (forum controller could potentially also include forum comments)
  - "/forum"
    - GET (all forums?)
    - GET "/{id}"
    - POST (create new forum)
    - PUT "/{id}" (edit forum)
    - DELETE "/{id}" (delete forum)

[Time Estimate: 0.5 hours ???]
- MapController ???

[Time Estimate: 0.5 hours]
- AuthController
  - "/authenticate"
    - POST (log in)
  - "/account/create_account"
    - POST (create new account)
  - "/account/{id}"
    - DELETE (delete account)
    - PUT (edit account)
  - "/account/suspend/{id}"
    - POST (suspend account)

### Total Back-End Build Time Estimate: 29 hours

### Back-End Testing

#### Data Layer Testing

[Time Estimate: 1 hour]
- AppUserJdbcRepositoryTest *
  - findByUsername
  - create
  - update
  - delete

[Time Estimate: 0.75 hour]
-ClimberJdbcRepositoryTest
  - findByClimberId
  - create
  - update
  - delete

[Time Estimate: 1 hour]
- LocationJdbcTemplateRepositoryTest *
  - findByLocationId
  - findByCountryId
  - findByStateId
  - findByPostalCode
  - findByLocationCode
  - create
  - update
  - delete

[Time Estimate: 0.75 hour]
- BadgeRepositoryTest *
  - findByBadgeId
  - findByBadgeName
  - create
  - update
  - delete

[Time Estimate: 1.5 hours]
- ClimberProfileJdbcTemplateRepositoryTest
  - findByProfileId
  - findBySafetyAttitude
  - findByClimbingMotivation
  - findByClimbingAttitude
  - findByClimbingStyle
  - findByStateId
  - create
  - update
  - delete

[Time Estimate: 1.5 hours]
- CommentJdbcTemplateRepositoryTest
  - findByUserCommentId
  - findByUserId
  - findByForumCommentId
  - findByForumId
  - findByReceivingClimberId
  - create
  - update
  - delete

[Time Estimate: 1 hour]
- ForumRepositoryTest *
  - findByForumId
  - findByForumName
  - findByParentId
  - create
  - edit
  - delete

### Total Data-Layer Testing Time Estimate: 7 hours

#### Domain-Layer Testing

[Time Estimate: 1.5 hours]
- ClimberServiceTest
  - findByClimberId
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 1.25 hour]
- LocationServiceTest
  - findByLocationId
  - findByCountryId
  - findByStateId
  - findByPostalCode
  - findByLocationCode
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 0.75 hour]
- BadgeServiceTest
  - findByBadgeId
  - findByBadgeName
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 1.25 hours]
- ClimberProfileServiceTest
  - findByProfileId
  - findBySafetyAttitude
  - findByClimbingMotivation
  - findByClimbingAttitude
  - findByClimbingStyle
  - findByStateId
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 1.25 hours]
- CommentServiceTest
  - findByUserCommentId
  - findByUserId
  - findByForumCommentId
  - findByForumId
  - findByReceivingClimberId
  - create
    - validate
  - update
    - validate
  - delete

[Time Estimate: 0.75 hours]
- ForumService
  - findByForumId
  - findByForumName
  - findByParentId
  - create
    - validate
  - edit
    - validate
  - delete

### Total Domain-Layer Testing Time Estimate: 6.75 hours