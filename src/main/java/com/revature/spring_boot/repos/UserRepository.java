package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SQL interactions for User models
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findUserById(int id);
}

