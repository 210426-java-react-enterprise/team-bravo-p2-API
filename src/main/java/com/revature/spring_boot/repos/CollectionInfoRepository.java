package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.CollectionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionInfoRepository extends JpaRepository<CollectionInfo, Integer> {
}
