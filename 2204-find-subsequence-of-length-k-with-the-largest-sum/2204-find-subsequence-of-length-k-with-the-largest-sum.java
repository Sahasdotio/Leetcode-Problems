class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n=nums.length;

        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);

        for(int i=0;i<n;i++)
        {
            pq.offer(new int[]{nums[i],i});
            if(pq.size()>k)
            {
                pq.poll();
            }
        }

        List<int[]> list=new ArrayList<>();
        while(!pq.isEmpty())
        {
            list.add(pq.poll());
        }

        list.sort((a, b) -> Integer.compare(a[1], b[1]));


        int []result=new int[k];
        for(int i=0;i<k;i++)
        {
            result[i]=list.get(i)[0];
        }
        return result;
    }
}