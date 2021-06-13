package com.revature.spring_boot.repos;


import com.revature.spring_boot.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findAccountByUsernameAndPassword(String username, String Password);

    @Query("select case when count(a) > 0 then false else true end from Account a where a.email = :email")
    boolean isEmailAvailable(String email);

    @Query("select case when count(a) > 0 then false else true end from Account a where a.username = :username")
    boolean isUsernameAvailable(String username);

}
