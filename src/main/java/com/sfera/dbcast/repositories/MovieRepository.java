package com.sfera.dbcast.repositories;

import com.sfera.dbcast.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
