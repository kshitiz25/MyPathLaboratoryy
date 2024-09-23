package com.MyPathology.SwasthLaabh.Repository;

import com.MyPathology.SwasthLaabh.Entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

