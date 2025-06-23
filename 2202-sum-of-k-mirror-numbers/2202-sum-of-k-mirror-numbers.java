class Solution {
    
    List<Long> nums = new ArrayList<>();
    
    public long kMirror(int k, int n) {
        int found = 0,len = 1;
        long sum = 0;

        while(found<n){
          genPalindNum(new int[len],0);
          for(long num : nums){
            if(isKPalind(num,(long)k)){
              found++;
              sum = sum + num;
              if(found>=n){
                return sum;
              }
            }
          }
          len++;
          nums.clear();
        }
        return 1l;
    }

    private boolean isKPalind(long num, long k){
      StringBuilder sbr = new StringBuilder();
      while(num > 0){
        sbr.append(""+(num%k));
        num = num/k;
      }
      char[] ch = sbr.toString().toCharArray();
      for(int i=0;i<ch.length/2;i++){
        if(ch[i] != ch[ch.length-1-i]){
          return false;
        }
      }
      return true;
    }

    private void genPalindNum(int[] ar,int index){
      int n = ar.length;
      if(index > (n/2 - (n%2==0 ? 1 : 0))){
        nums.add(getNum(ar));
        return;
      }
      for(int i=0;i<=9;i++){
        if(index == 0 && i == 0){
          continue;
        }
        ar[index] = i;
        ar[n-index-1] = i;
        genPalindNum(ar,index+1);
      }
    }

    private long getNum(int[] ar){
      long v = 0;
      for(int a : ar){
        v = v * 10 + a;
      }
      return v;
    }
}