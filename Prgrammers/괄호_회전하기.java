import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = -1;
        
        
        
        return answer;
    }
    
    private static boolean check(String s){
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else if(s.charAt(i)=='}' && stack.peek()=='{'){
                stack.pop();
            }
            else if(s.charAt(i)==']' && stack.peek()=='['){
                stack.pop();
            }
            else if(s.charAt(i)==')' && stack.peek()=='('){
                stack.pop();
            }
            else{
                return false;
            }
        }
        if(stack.size()==0) return true;
        else return false;
    }
}