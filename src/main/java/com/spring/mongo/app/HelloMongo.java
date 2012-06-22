package com.spring.mongo.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import org.springframework.stereotype.Repository;

import com.spring.mongo.domain.Movie;


@Repository
public class HelloMongo {

	@Autowired
	MongoOperations mongoOperations;

	public void run() {

		if (mongoOperations.collectionExists(Movie.class)) {
			mongoOperations.dropCollection(Movie.class);
		}
		mongoOperations.createCollection(Movie.class);

		Movie m1 = new Movie("Endhiran", "BluRay", true, "Rajinikanth", "Aishwarya Rai", "AR Rahman", "Shankar");
		Movie m2 = new Movie("Ayyan", "BluRay", true, "Surya", "Aishwarya Rai", "Harris Jayaraj", "Sun");
		Movie m3 = new Movie("Roja", "BluRay", true, "Rajinikanth", "Aishwarya Rai", "AR Rahman", "Manirathnam");
		Movie m4 = new Movie("Nanban", "BluRay", true, "Vijay", "Illena", "Harris Jayaraj", "Shankar");
		Movie m5 = new Movie("Bombay", "BluRay", true, "Aravindsamy", "Manisha", "AR Rahman", "Manirathnam");
		
		mongoOperations.insert(m1);
		mongoOperations.insert(m2);
		mongoOperations.insert(m3);
		mongoOperations.insert(m4);
		mongoOperations.insert(m5);

		List<Movie> results = mongoOperations.findAll(Movie.class);
		for (Movie m:results) {
			System.out.println("===============================================");
			System.out.println("Title: " + m.getTitle());
			System.out.println("Music By: " + m.getMusicDirector());
			System.out.println("Direction By: " + m.getFlimDirector());
		}
		
		
	}

}
