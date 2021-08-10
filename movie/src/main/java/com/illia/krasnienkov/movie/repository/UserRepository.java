package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(nativeQuery = true)
    User namedFindUserById(@Param("id") String id);
}
