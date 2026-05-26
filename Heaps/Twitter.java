// File: DesignTwitter.java

import java.util.*;

public class Twitter {

    private static int time = 0;

    private static class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
            this.next = null;
        }
    }

    private Map<Integer, Set<Integer>> followMap;
    private Map<Integer, Tweet> tweetMap;

    public Twitter() {
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

        time++;

        Tweet tweet = new Tweet(tweetId, time);
        tweet.next = tweetMap.get(userId);
        tweetMap.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> pq = new PriorityQueue<>(
                (a, b) -> b.time - a.time
        );

        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        for (int followee : followMap.get(userId)) {
            if (tweetMap.containsKey(followee)) {
                pq.offer(tweetMap.get(followee));
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!pq.isEmpty() && result.size() < 10) {
            Tweet t = pq.poll();
            result.add(t.id);

            if (t.next != null) {
                pq.offer(t.next);
            }
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}