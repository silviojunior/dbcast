package com.sfera.dbcast.repositories;

import com.sfera.dbcast.domain.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {

}
