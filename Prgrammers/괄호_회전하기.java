import java.util.*;

public class 괄호_회전하기 {
	public static void main(String[] args) {
		solution("[](){}");
	}
    public static int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        int len = s.length();
        sb.append(s);
        
        for(int i=0; i<len; i++) {
        	char c = sb.toString().charAt(0);
        	sb.deleteCharAt(0);
        	sb.append(c);
        	if(check(sb.toString())) answer ++;
        }
        
        return answer;
    }
    
    private static boolean check(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='(')
                stack.push(s.charAt(i));
            else if(stack.size()==0 && (s.charAt(i)=='}' || s.charAt(i)==']' || s.charAt(i)==')')) {
            	return false;
            }
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