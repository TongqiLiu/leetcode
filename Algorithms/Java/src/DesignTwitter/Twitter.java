package src.DesignTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mingqiao
 * @Date 2020/4/20
 */
public class Twitter {

    private static AtomicInteger timeStamp = new AtomicInteger(0);
    private Map<Integer, Tweet> userTweetMap = new ConcurrentHashMap<>();
    private Map<Integer, Set<Integer>> userFollowMap = new ConcurrentHashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        Tweet oldTweet = userTweetMap.get(userId);
        userTweetMap.compute(userId, (k, v) -> new Tweet(tweetId, timeStamp.incrementAndGet())).next = oldTweet;
    }

    public List<Integer> getNewsFeed(int userId) {
        //优先队列按时间倒排
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.time - t1.time);
        List<Integer> feed = new ArrayList<>();
        follow(userId, userId);
        userFollowMap.get(userId).forEach(followeeId -> Optional.ofNullable(userTweetMap.get(followeeId)).ifPresent(pq::offer));

        //多路归并排序
        int count = 0;
        while (!pq.isEmpty() && count < 10) {
            Tweet tw = pq.poll();
            feed.add(tw.id);
            if (tw.next != null) {
                pq.offer(tw.next);
            }
            count++;
        }
        return feed;
    }

    public void follow(int followerId, int followeeId) {
        userFollowMap.merge(followerId, new HashSet<Integer>() {
                {
                    add(followeeId);
                }
            }, (pre, one) -> {
                pre.addAll(one);
                return pre;
            }
        );
    }

    public void unfollow(int followerId, int followeeId) {
        Optional.ofNullable(userFollowMap.get(followerId)).ifPresent(set -> set.remove(followeeId));
    }

    /**
     * Tweet是一个有序链表，保存同一个user下的帖子
     */
    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }
}


