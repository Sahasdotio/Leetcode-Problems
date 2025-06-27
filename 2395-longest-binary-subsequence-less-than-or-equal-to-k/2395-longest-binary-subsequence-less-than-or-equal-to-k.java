class Solution {
    public int longestSubsequence(String s, int k) 
    {
        int c=0,l=0;
        int b=(int) (Math.log(k) / Math.log(2)) + 1;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(n-1-i)=='1')
            {
                if(i<b && c+(1<<i) <= k)
                {
                    c+=1<<i;
                    l++;
                }
            }
            else
             l++;
        }
        return l;
    }
}