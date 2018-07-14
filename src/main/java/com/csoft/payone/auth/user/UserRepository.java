package com.csoft.payone.auth.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface UserRepository extends JpaRepository<ApplicationUser, Long> {
	ApplicationUser findByUsername(String username);
    List<ApplicationUser> findByEmail(String email);
    List<ApplicationUser> findAll();
}