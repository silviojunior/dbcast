package com.sfera.dbcast.repositories;

import com.sfera.dbcast.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    List<Character> findAllByMovies_Id(Long movieId);

    List<Character> findByNameContainsIgnoreCase(@Param("name") String name);

    List<Character> findByAlsoKnownAsContainsIgnoreCase(@Param("name") String name);

    List<Character> findByNameContainsIgnoreCaseOrAlsoKnownAsContainsIgnoreCase(@Param("name") String name, @Param("alsoKnownAs") String alsoKnowAs);
}
