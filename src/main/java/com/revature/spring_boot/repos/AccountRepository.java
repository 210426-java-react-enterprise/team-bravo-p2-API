package com.revature.spring_boot.repos;


import com.revature.spring_boot.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

    Account findAccountByUsernameAndPassword(String username, String Password);
}
