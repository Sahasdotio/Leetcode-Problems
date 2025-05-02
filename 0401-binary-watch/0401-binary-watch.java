class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list=new ArrayList<>();
        
        for(int i=0;i<12;i++){
                int hour=bitCounter(i);
                for(int j=0;j<60;j++){
                        int minitues=bitCounter(j);
                    if(hour+minitues==turnedOn){
                     list.add( String.format("%d:%02d",i,j));
                    }
                }


        }
        return list;
    }
    public int bitCounter(int n){

        int count=0;
        while(n !=0){
            if(n%2==1){
                count++;
            }
            n/=2;
        }
        return count;
    }
}