package controller;

import twitter4j.*;

import java.util.List;
import java.util.Scanner;

public class Twitterapp1{



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
    void sendDirectMessage(String msg, String s) throws TwitterException {
        Twitter twitter= TwitterFactory.getSingleton();
        DirectMessage message = twitter.sendDirectMessage(s, msg);
        System.out.println("Sent: " +message.getText() + " to @" + message.getRecipientId());
    }
    void getOneUserTimeline(String userId) throws TwitterException {
        Twitter twitter= TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getUserTimeline(userId);
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }


    public static void main(String[] args) throws TwitterException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message to be posted");
        String st = sc.nextLine();
        System.out.println("Enter the  message to be sent directly to the user and userId");
        String tt = sc.nextLine();
        String ht = sc.nextLine();
        System.out.println("Enter the user Id");
        String t = sc.nextLine();
        Twitterapp1 td = new Twitterapp1();


        td.postTweet(st);
        td.getTimeline();
        td.sendDirectMessage(tt,ht);
        td.getOneUserTimeline(t);
    }
}