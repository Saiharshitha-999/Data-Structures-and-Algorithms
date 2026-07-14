class Twitter {
    class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    int timestamp;
    HashMap<Integer, HashSet<Integer>> followMap;
    HashMap<Integer, List<Tweet>> tweetMap;

    public Twitter() {
        timestamp = 0;
        followMap = new HashMap<>();
        tweetMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new Tweet(tweetId, timestamp++));
    }

    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);

        if (tweetMap.containsKey(userId)) {
            for (Tweet tweet : tweetMap.get(userId)) {
                maxHeap.offer(tweet);
            }
        }

        if (followMap.containsKey(userId)) {
            for (int followee : followMap.get(userId)) {
                if (tweetMap.containsKey(followee)) {
                    for (Tweet tweet : tweetMap.get(followee)) {
                        maxHeap.offer(tweet);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        while (!maxHeap.isEmpty() && ans.size() < 10) {
            ans.add(maxHeap.poll().tweetId);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followMap.containsKey(followerId)) {
            followMap.get(followerId).remove(followeeId);
        }
    }
}
