package controller;

import twitter4j.*;

import java.util.List;
import java.util.Scanner;

public class Twitterapp1{

    public static Twitter getTwitterInstance() {

        TwitterFactory tf = new TwitterFactory();
        Twitter twitter = tf.getInstance();
        return twitter;


    }

    public static void postTweet(String msg) throws TwitterException {

        Twitter twitter= TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(msg);
        System.out.println("POst tweeted");
    }


    
     public static void getTimeline() throws TwitterException {

        Twitter twitter= TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }
    public static void main(String[] args) throws TwitterException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message to be posted");
        String st = sc.nextLine();
        Twitterapp1 td = new Twitterapp1();
        Twitter d = getTwitterInstance();

        td.postTweet(st);

        td.getTimeline();


    }




}