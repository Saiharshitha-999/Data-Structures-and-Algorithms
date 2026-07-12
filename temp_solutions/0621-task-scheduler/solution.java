class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        int time = 0;
        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int freq : map.values()) 
        {
            maxHeap.offer(freq);
        }
        while(!maxHeap.isEmpty())
        {
             List<Integer> temp = new ArrayList<>();
             for(int i = 0; i <= n ; i++)
             {
                  if(!maxHeap.isEmpty())
                  {
                      int freq = maxHeap.poll();
                      freq--;
                      if(freq > 0)
                      {
                        temp.add(freq);
                      }
                  }
                  time++;
                if(maxHeap.isEmpty() && temp.size() == 0)
                {
                    break;
                }
             }
             

             for(int a : temp)
             {
                maxHeap.offer(a);
             }

        }
        return time;
    }
}
