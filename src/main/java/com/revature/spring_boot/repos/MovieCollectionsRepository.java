package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.MovieCollections;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by IntelliJ IDEA.
 * User: Jbialon
 * Date: 6/7/2021
 * Time: 11:42 AM
 * Description: {Insert Description}
 */

@Repository
public interface MovieCollectionsRepository extends JpaRepository<MovieCollections, Integer>{

//  @Query("FROM MovieCollections mc where mc.collectionInfoId = :collectionInfoId")
    MovieCollections findMovieCollectionsByCollectionInfoId(int collectionInfoId);

//  @Query("FROM MovieCollections)
//    List<MovieCollections> findAllMovieCollections();

}
