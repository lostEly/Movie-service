package com.illia.krasnienkov.movie.repository;

import com.illia.krasnienkov.movie.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
