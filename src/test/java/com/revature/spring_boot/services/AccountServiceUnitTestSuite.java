package com.revature.spring_boot.services;

import com.revature.spring_boot.exceptions.*;
import com.revature.spring_boot.models.Account;
import com.revature.spring_boot.models.User;
import com.revature.spring_boot.repos.AccountRepository;
import com.revature.spring_boot.repos.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Transactional
public class AccountServiceUnitTestSuite {
    private AccountService sut;
    private AccountRepository mockAccountRepo;
    private UserRepository mockUserRepo;

    @Before
    public void setUp(){
        mockAccountRepo = mock(AccountRepository.class);
        mockUserRepo = mock(UserRepository.class);
        sut = new AccountService(mockAccountRepo, mockUserRepo);
    }

    @After
    public void tearDown() {
        sut = null;
        mockUserRepo = null;
        mockAccountRepo = null;

    }

    @Test
    public void test_RegisterAccountWithValidEmailAndUsername(){
        Account account = new Account();
        account.setUsername("mockman");
        account.setEmail("mockman@mock.com");
        account.setPassword("mocker");

        when(mockAccountRepo.isEmailAvailable (account.getEmail())).thenReturn (true);
        when(mockAccountRepo.isUsernameAvailable(account.getUsername())).thenReturn(true);

        sut.registerAccount(account);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void test_RegisterAccountWithValidEmailAndInvalidUsername(){
        Account account = new Account();
        account.setUsername("mockman");
        account.setEmail("mockman@mock.com");
        account.setPassword("mocker");

        when(mockAccountRepo.isEmailAvailable (account.getEmail())).thenReturn (true);
        when(mockAccountRepo.isUsernameAvailable(account.getUsername())).thenReturn(false);

        sut.registerAccount(account);
    }

    @Test(expected = ResourcePersistenceException.class)
    public void test_RegisterAccountWithInvalidValidEmailAndValidUsername(){
        Account account = new Account();
        account.setUsername("mockman");
        account.setEmail("mockman@mock.com");
        account.setPassword("mocker");

        when(mockAccountRepo.isEmailAvailable (account.getEmail())).thenReturn (false);
        when(mockAccountRepo.isUsernameAvailable(account.getUsername())).thenReturn(true);

        sut.registerAccount(account);
    }

    @Test(expected = InvalidRequestException.class)
    public void test_RegisterInvalidUser(){
        User user = new User(5, null, "Fallon", 25);
        sut.registerUser(user);

    }

    @Test
    public void test_RegisterValidUser(){
        User user = new User(5, "James", "Fallon", 25);
        sut.registerUser(user);

    }

    @Test
    public void test_AuthenticateValidAccount(){
        Account account = new Account();
        account.setPassword("mockPass");
        account.setUsername("mockUser");

        when(mockAccountRepo.findAccountByUsernameAndPassword (account.getUsername(), account.getPassword())).thenReturn(java.util.Optional.of(account));
        sut.authenticate(account.getUsername(), account.getPassword());
    }

    @Test(expected = DataSourceException.class)
    public void test_AuthenticateInvalidAccount(){
        Account account = new Account();
        account.setPassword("mockPass");
        account.setUsername("mockUser");

        when(mockAccountRepo.findAccountByUsernameAndPassword (account.getUsername(), account.getPassword())).thenReturn(null);
        sut.authenticate(account.getUsername(), account.getPassword());
    }








//    when (mockUserDAO.isEmailAvailable (anyString ())).thenReturn (true);
//
//
//
//        sut.register (new User (0, "First", "Last", 22, "valid2@gmail.com", "password"));
//
//
//    verify (mockUserDAO, times (1)).isEmailAvailable (anyString ());
//    verify (mockUserDAO, times (1)).save (any ());


}
