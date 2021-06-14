package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SQL interactions for Director models
 */
@Repository
public interface DirectorRepository extends JpaRepository<Director, Integer>{
}
