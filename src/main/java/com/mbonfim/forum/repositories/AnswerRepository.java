package com.mbonfim.forum.repositories;

import com.mbonfim.forum.core.crud.CrudRepository;
import com.mbonfim.forum.models.entities.Answer;
import com.mbonfim.forum.models.projections.AnswerSlim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Page<AnswerSlim> findAllByTopicId(Long id, Pageable pageable);
}
