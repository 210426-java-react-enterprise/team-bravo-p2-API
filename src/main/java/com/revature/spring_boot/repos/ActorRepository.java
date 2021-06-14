package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/10/2021
 * Time: 8:32 AM
 * Description: {Insert Description}
 */
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
