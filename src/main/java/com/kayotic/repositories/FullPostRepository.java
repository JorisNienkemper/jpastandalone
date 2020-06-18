package com.kayotic.repositories;

import com.kayotic.domain.FullPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FullPostRepository extends CrudRepository<FullPost,Integer> {
}
