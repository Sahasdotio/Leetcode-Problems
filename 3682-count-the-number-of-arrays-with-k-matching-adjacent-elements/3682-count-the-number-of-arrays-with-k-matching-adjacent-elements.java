class Solution {
    static final int MOD = (int)1e9+7;
    static int max  = (int)1e5+1;
    static final long[] fact = new long[max];
    static final long[] invFact = new long[max]; 
    static {
        getFact(max-1);
        getInvFact(max-1);
    }
    private static void getFact(int n){
        fact[1] = 1;
        fact[0] = 1;
        for(int i=2;i<=n;i++)
            fact[i] = (fact[i-1]*i)%MOD;
    }
    private static void getInvFact(int n){
        for(int i=0;i<=n;i++){
            invFact[i] = findPower(fact[i], MOD-2);
        }
    }
    private static long findPower(long a, long b){
        if(b==0)
            return 1;
        long half = findPower(a, b/2);
        long result = (half*half)%MOD;
        if(b%2!=0)
            result = (result * a)%MOD;
        return result;
    }
    private long nCr(int n, int k){
        return fact[n] * invFact[n-k]%MOD * invFact[k]%MOD;
    }
    public int countGoodArrays(int n, int m, int k) {
        return (int)(nCr(n-1, k)* m%MOD * findPower(m-1, n-k-1)%MOD);
    }
}