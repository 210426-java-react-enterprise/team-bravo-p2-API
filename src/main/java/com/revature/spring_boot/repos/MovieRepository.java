package com.revature.spring_boot.repos;

import com.revature.spring_boot.models.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movies, Integer> {

    @Transactional
    @Query(
            value =
                    "select * from movies where (title = :title and year = :year and mpaa_rating = :mpaaRating and length_min = :lengthMin and genre = :genre and descrip = :descrip and prod_company = :prodCompany)",
            nativeQuery = true)
    List<Movies> exists(@Param("title") String title, @Param("year") int year,
                        @Param("mpaaRating") String mpaaRating, @Param("lengthMin") int lengthMin,
                        @Param("genre") String genre, @Param("descrip") String descrip,
                        @Param("prodCompany") String prodCompany);

}
