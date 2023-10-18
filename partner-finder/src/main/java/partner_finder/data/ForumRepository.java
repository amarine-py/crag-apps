package partner_finder.data;

import org.springframework.data.jpa.repository.JpaRepository;
import partner_finder.models.Forum;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ForumRepository extends JpaRepository<Forum, Integer> {

    Forum findById(int forumId);
    List<Forum> findByForumParentId(int forumParentId);
    Forum findByName(String forumName);
    List<Forum> findAll();

    // creates new Badge, if given Badge w/ no ID or new ID
    // updates existing Badge if given Badge w/ existing Id
    Forum save(Forum forum);

    // REMEMBER: deleteById() does not return anything
    @Transactional
    void deleteById(int forumId);

}
