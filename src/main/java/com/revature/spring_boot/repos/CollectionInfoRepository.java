package com.revature.spring_boot.repos;


import com.revature.spring_boot.models.CollectionInfo;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionInfoRepository extends JpaRepository<CollectionInfo, Integer> {
}
