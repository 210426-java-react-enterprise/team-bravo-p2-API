package com.revature.spring_boot.repos;


import com.revature.spring_boot.models.CollectionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * SQL interactions for CollectionType models
 */
@Repository
public interface CollectionTypeRepository extends JpaRepository<CollectionType, Integer> {
}
