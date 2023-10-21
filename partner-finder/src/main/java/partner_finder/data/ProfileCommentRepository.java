package partner_finder.data;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.ProfileComment;

import java.util.List;

public interface ProfileCommentRepository extends JpaRepository<ProfileComment, Integer> {

    public List<ProfileComment> findByReceivingClimberId(int id);
    public List<ProfileComment> findByPostingClimberId(int id);
}