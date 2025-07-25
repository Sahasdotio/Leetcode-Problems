class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }

        char fc = s.charAt(0),lc=s.charAt(s.length()-1);
        if(fc !='a' || lc !='c'){
            return false;
        }

        Stack<Character> stack=new Stack<Character>();

        for(char ch : s.toCharArray()){
           if(ch=='c'){
            if(!stack.empty() && stack.peek()=='b'){
                stack.pop();
            }
            else{
                return false;
            }

            if(!stack.empty()&& stack.peek()=='a'){
                stack.pop();
            }
            else{
                return false;
            }
        





           }
           else stack.push(ch);

        }
        return stack.empty();
    }
}