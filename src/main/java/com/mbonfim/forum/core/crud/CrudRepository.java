package com.mbonfim.forum.core.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository<E, ID> extends JpaRepository<E, ID> {
}
