package com.finance.Repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.finance.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{ //the generic takes two types - the entity and the type of the primary key of that entity
    Optional<User> findByEmail(String email);
}


