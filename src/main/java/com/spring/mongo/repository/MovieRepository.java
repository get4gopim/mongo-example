package com.spring.mongo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.Repository;
import com.spring.mongo.domain.Movie;

public interface MovieRepository extends Repository<Movie, BigInteger> {

	List<Movie> findByTitle(String title);
	
	List<Movie> findByMusicDirector(String musicDirector);
	
	List<Movie> findByMusicDirectorAndFlimDirector(String musicDirector, String flimDirector);
	
	List<Movie> findByTitleLike(String title);
	
}
