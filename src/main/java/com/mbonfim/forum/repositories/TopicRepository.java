package com.mbonfim.forum.repositories;

import com.mbonfim.forum.core.crud.CrudRepository;
import com.mbonfim.forum.models.entities.Topic;
import com.mbonfim.forum.models.projections.TopicCompleteDTO;
import com.mbonfim.forum.models.projections.TopicSlimDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    Page<TopicSlimDTO> findAllBy(Pageable pageable);

    Optional<TopicCompleteDTO> findTopicCompleteById(Long aLong);

    @Query("SELECT t.status FROM Topic t WHERE t.id = :id")
    Integer findStatusById(Long id);

    List<TopicSlimDTO> findAllTopicSlimByCategoryId(Long id);

    List<TopicSlimDTO> findAllByAuthor(UserDetails user);

    @Override
    Optional<Topic> findById(Long aLong);

}

