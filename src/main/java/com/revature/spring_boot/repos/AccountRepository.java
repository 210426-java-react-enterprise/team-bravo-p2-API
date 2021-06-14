package com.revature.spring_boot.repos;


import com.revature.spring_boot.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * SQL interactions for Account models
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    /**
     *
     *  Grabs an account from the data layer by username and password
     *
     * @param username
     * @param Password
     * @return
     */
    Optional<Account> findAccountByUsernameAndPassword(String username, String Password);

    /**
     *
     *  Checks the data layer for an email that is already in use
     *
     * @param email
     * @return
     */
    @Query("select case when count(a) > 0 then false else true end from Account a where a.email = :email")
    boolean isEmailAvailable(String email);

    /**
     *
     *  Checks the data layer for a username that is already in use
     *
     * @param username
     * @return
     */
    @Query("select case when count(a) > 0 then false else true end from Account a where a.username = :username")
    boolean isUsernameAvailable(String username);

}
