package com.tts.walleyworksblog.repository;

import com.tts.walleyworksblog.model.BlogPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository                        // declares this as a Repository
public interface BlogPostRepository extends CrudRepository<BlogPost, Long> {

}
