package data;

import models.Forum;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ForumRepository {

    Forum findById(int forumId);
    Forum findByName(String forumName);
    List<Forum> findAll();
    Forum create(Forum forum);
    Forum update(Forum forum);

    // Must delete children before deleting parent
    @Transactional
    boolean deleteById(int forumId);
}
