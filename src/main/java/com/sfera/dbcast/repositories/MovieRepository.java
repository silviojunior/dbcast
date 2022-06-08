package com.sfera.dbcast.repositories;

import com.sfera.dbcast.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByCharacters_Id(Long characterId);

    List<Movie> findByTitleContainsIgnoreCase(@Param("title") String title);
}
