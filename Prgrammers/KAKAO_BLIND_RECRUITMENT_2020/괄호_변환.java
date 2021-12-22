package KAKAO_BLIND_RECRUITMENT_2020;

import java.util.Stack;

public class 괄호_변환 {

	public static void main(String[] args) {
		solution("()))((()");
	}
	public static String solution(String p) {
        String answer = "";
        if(p.length()==0) return answer;
        
        answer = devide(p);
        
        return answer;
    }
    private static String devide(String str){
    	int l=0, r=0;
    	String u="", v="";
    	
    	if(str.length()==0 || correct(str)) return str; // 올바른 괄호 문자열이라면
    	
        for(int i=0; i<str.length(); i++) {
        	if(str.charAt(i)=='(') l++;
        	else r++;
        	if(l==r) {
        		u = str.substring(0,i+1);
        		v = str.substring(i+1,str.length());
        		break;
        	}
        }
        
        if(correct(u)) return u+devide(v);
        else return four(u,v);
    }
    
    private static boolean correct(String str) {
    	Stack<Character> stack = new Stack<>();
    	stack.push(str.charAt(0));
    	
    	for(int i=1; i<str.length(); i++) {
    		if(stack.size()!=0 && str.charAt(i)==')') {
    			if(stack.peek()=='(') stack.pop();
    			continue;
    		}
    		else stack.push('(');
    	}
    	
    	if(stack.size()==0) return true;
    	else return false;
    }
    
    private static String four(String u, String v) {
    	StringBuilder sb = new StringBuilder();
    	sb.append("(");
    	sb.append(devide(v)+")");
    	sb.append(four_four(u));
    	return sb.toString();
    }
    
    private static String four_four(String u) {
    	StringBuilder sb = new StringBuilder();
    	u = u.substring(1,u.length()-1);
    	for(int i=0; i<u.length(); i++) {
    		if(u.charAt(i)=='(') sb.append(")");
    		else sb.append("(");
    	}
    	return sb.toString();
    }
}
