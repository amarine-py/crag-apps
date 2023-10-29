package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.ProfileComment;

import java.util.List;

public interface ProfileCommentRepository extends JpaRepository<ProfileComment, Integer> {

    List<ProfileComment> findByReceivingClimberId(int id);
    List<ProfileComment> findByPostingClimberId(int id);
}