package com.mbonfim.forum.repositories;

import com.mbonfim.forum.core.crud.CrudRepository;
import com.mbonfim.forum.models.entities.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
