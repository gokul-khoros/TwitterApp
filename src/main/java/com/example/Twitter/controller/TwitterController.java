package com.example.Twitter.controller;
import com.example.Twitter.Config;
import com.example.Twitter.service.TwitterService;
import com.example.Twitter.service.TwitterServiceInterface;
import org.springframework.web.bind.annotation.*;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@RestController
@RequestMapping("/twitter")
public class TwitterController {
    public TwitterController() {
    }
    String consumerKey;
    String consumerSecret;
    String accessToken;
    String accessTokenSecret;
    Twitter twitter;
    public TwitterController(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(this.consumerKey)
                .setOAuthConsumerSecret(this.consumerSecret)
                .setOAuthAccessToken(this.accessToken)
                .setOAuthAccessTokenSecret(this.accessTokenSecret);
        //loggerApp.warn("WARNING LOGGGG");
        TwitterFactory twitterFactory = new TwitterFactory(cb.build());
        twitter = twitterFactory.getInstance();
    }

   TwitterService twitterService =  new TwitterService();
    //Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping("/gettimeline")
    public List<String> getFeed(Twitter twitter) throws TwitterException
    {
        return twitterService.getTimeLineMessage(this.twitter);
    }
    @PostMapping( "/postMessage/{postMessage}")
    public String postTweet(@PathVariable(value = "postMessage") String postMessage) {
        return twitterService.postMessage(twitter,postMessage);

    }

}
