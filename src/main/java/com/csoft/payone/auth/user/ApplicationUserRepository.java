package com.csoft.payone.auth.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);
    List<ApplicationUser> findByEmail(String email);
}