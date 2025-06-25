class Solution {
    int n1, n2;
    long k;
    int[] nums1, nums2;
    private boolean possible(long val){
        long mul, a , count = 0l;
        for(int i = 0 ; i < n1 && count <= k ;++i ){
            int l = -1 ,r = n2 , mid;
            a = nums1[i];
            if(nums1[i] < 0   ){
                while( r > l + 1){
                    mid = (l + r ) / 2 ;
                    mul = a * nums2[mid];
                    if(mul <= val ) r = mid;
                    else l = mid;
                }
                count += ( n2 - r ); 
            }else{
                while( r > l + 1){
                    mid = ( l + r ) / 2;
                    mul = a * nums2[mid];
                    if(mul <= val )  l = mid;
                    else r = mid;
                }   
                count += l + 1 ;
            }
        }
        return count >= k;
    }
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        this.n1 = nums1.length;
        this.n2 = nums2.length;
        this.k = k;
        long l = -10000000001l , r = 10000000001l;
        while( r > l + 1){
            long mid = (l + r ) /2;
            if(possible(mid)) r = mid;
            else l = mid;
        }   
        return r;
    }
}