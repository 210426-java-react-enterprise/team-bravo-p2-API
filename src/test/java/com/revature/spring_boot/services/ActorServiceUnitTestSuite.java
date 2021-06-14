package com.revature.spring_boot.services;


import com.revature.spring_boot.models.Actor;
import com.revature.spring_boot.repos.ActorRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Service
@Transactional
public class ActorServiceUnitTestSuite {
    ActorService sut;
    ActorRepository mockActorRepo;

    @Before
    public void setUp(){
        mockActorRepo = mock(ActorRepository.class);
        sut = new ActorService(mockActorRepo);
    }

    @After
    public void tearDown(){
        sut = null;
        mockActorRepo = null;
    }

    @Test
    public void test_getAllActors(){
        List<Actor> actors = new ArrayList<>();
        when(mockActorRepo.findAll()).thenReturn(actors);
        sut.getAllActors();
    }

}
