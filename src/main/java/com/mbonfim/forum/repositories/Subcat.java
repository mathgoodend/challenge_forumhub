package com.mbonfim.forum.repositories;

import com.mbonfim.forum.core.crud.CrudRepository;
import com.mbonfim.forum.models.entities.Subcategory;
import org.springframework.stereotype.Repository;

@Repository
public interface Subcat extends CrudRepository<Subcategory, Long> {
}