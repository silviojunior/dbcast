package com.sfera.dbcast.repositories;

import com.sfera.dbcast.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
