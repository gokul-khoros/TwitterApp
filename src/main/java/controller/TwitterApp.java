package controller;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;
import java.util.Scanner;

public class TwitterApp {


    public Twitter getTwitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("67svDTgdgUQNwZwgfxSBQ8iSM")
                .setOAuthConsumerSecret("qmsbwibWKD9N1OVJV0n0VI7Pi5dZ4GAIvQY7CmNRoHWfKEq3kW")
                .setOAuthAccessToken("1326754818174545920-UyZeQNw9gMDSkdFYszkB0ZPX9k43Nw")
                .setOAuthAccessTokenSecret("kTSED6Ggmr5hal761veXPIJvRXv79UexbNQdT7cGAUHGI");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }

    void getTimeline(Twitter twitter) throws TwitterException {

        List<Status> statuses = twitter.getHomeTimeline();
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }


    void postTweet(Twitter twitter, String msg) throws TwitterException {

        Status status = twitter.updateStatus(msg);
        System.out.println("POst tweeted");
    }
    void sendMessage(Twitter twitter,String msg) throws TwitterException {
        String s="***";
        DirectMessage message = twitter.sendDirectMessage(s, msg);
        System.out.println("Sent: " +message.getText() + " to @" + message.getRecipientId());
    }
    void getOneUserTimeline(Twitter twitter , String userId) throws TwitterException {

        List<Status> statuses = twitter.getUserTimeline(userId);
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }
    public static void main(String[] args) throws TwitterException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message to be posted");
        String st = sc.nextLine();
        String tt = sc.nextLine();
        String t = sc.nextLine();
        TwitterApp td = new TwitterApp();
        Twitter d = td.getTwitterInstance();

        td.postTweet(d,st);
        td.getTimeline(d);
        td.sendMessage(d,tt);
        td.getOneUserTimeline(d,t);

    }
}

