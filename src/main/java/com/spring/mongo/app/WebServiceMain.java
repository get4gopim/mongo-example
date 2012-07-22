package com.spring.mongo.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.client.RestTemplate;;

public class WebServiceMain {
	
	/*@Autowired*/
	protected static RestTemplate restTemplate;
	
	private final static String articleServiceUrl = "http://www.deanclatworthy.com/imdb/?id={id}&q={title}&type=xml";

	private static IMDBMovie readObject() {
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("id", "tt0120689");
		vars.put("title", "Avengers");
		return restTemplate.getForObject(articleServiceUrl, IMDBMovie.class, vars);

	}

	public static void main( String[] args ) {
		System.out.println("Hello WebServiceMain");
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
		restTemplate = context.getBean(RestTemplate.class);
		
		IMDBMovie movie = readObject();
		System.out.println(movie.toString());
		
	}
}
