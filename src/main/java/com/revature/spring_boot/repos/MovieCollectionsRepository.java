package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.MovieCollections;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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

//    @Query(value = "insert into movie_collections (collection_info_id, movie_id, owned, watched, user_rating, user_comment, tradeable) values (:collItemId, :movieId, :owned, :tradeable, :userComment, :userRating, :watched)" nativeQuery = true)
//            void insertItem(int collItemId, int movieId, int owned, int tradeable, String userComment, int userRating, int watched);

    @Transactional
    @Modifying
    @Query(
            value =
                    "insert into movie_collections (owned, watched, user_rating, user_comment, tradeable, collection_info_id, movie_id) values (:owned, :watched, :userRating, :userComment, :tradeable, :collectionInfo, :movieId)",
            nativeQuery = true)
    void insertMovieCollection(@Param("owned") int owned, @Param("watched") int watched,
                    @Param("userRating") int userRating, @Param("userComment") String userComment,
                    @Param("tradeable") int tradeable, @Param("collectionInfo") int collectionInfo,
                    @Param("movieId") int movieId);

//  @Query("FROM MovieCollections mc where mc.collectionInfoId = :collectionInfoId")
//    MovieCollections findMovieCollectionsByCollectionInfoId(int collectionInfoId);

//  @Query("FROM MovieCollections)
//    List<MovieCollections> findAllMovieCollections();

}
