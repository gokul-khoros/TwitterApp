package controller;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;

public class Twitterapp2 {
    public static void getTimeline() throws TwitterException {

        Twitter twitter= TwitterFactory.getSingleton();
        List<Status> statuses = twitter.getHomeTimeline();
        for (Status st : statuses) {
            System.out.println(st.getUser().getName() + "------" + st.getText()+"\n");
        }
    }
}
