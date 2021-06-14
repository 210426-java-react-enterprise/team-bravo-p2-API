package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.CollectionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * SQL interactions for CollectionInfo models
 */
@Repository
public interface CollectionInfoRepository extends JpaRepository<CollectionInfo, Integer> {

    /**
     *
     *  Gets collection info via account id
     *
     * @param account
     * @return
     */
    @Query("from CollectionInfo ci where ci.acctId = :account")
    List<CollectionInfo> findCollectionInfoByAccount_id(Account account);
}
