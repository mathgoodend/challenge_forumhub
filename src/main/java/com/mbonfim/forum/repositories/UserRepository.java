package com.mbonfim.forum.repositories;

import com.mbonfim.forum.core.crud.CrudRepository;
import com.mbonfim.forum.models.entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    UserDetails findByLogin(String login);
}
