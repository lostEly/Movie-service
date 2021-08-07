package com.softserveinc.illia.krasnienkov.movie.repository;

import com.softserveinc.illia.krasnienkov.movie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
