package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Role;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, String> {

    @Cacheable("roles")
    List<Role> findAll();
    Set<Role> findByNameIn(Set<String> names);
    Optional<Role> findByName(String name);
}
