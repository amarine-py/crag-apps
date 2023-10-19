package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.ProfileComment;

public interface ProfileCommentRepository extends JpaRepository<ProfileComment, Integer> {

}
