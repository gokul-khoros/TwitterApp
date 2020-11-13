package com.example.Twitter;

import com.example.Twitter.controller.TwitterController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterappApplication implements CommandLineRunner{
	@Autowired
	private Config config;

	public static void main(String[] args) {
		SpringApplication.run(TwitterappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(config);
		TwitterController twitterController = new TwitterController(config.getConsumerKey(), config.getConsumerSecret(), config.getAccessToken(), config.getAccessTokenSecret());
	}
}
