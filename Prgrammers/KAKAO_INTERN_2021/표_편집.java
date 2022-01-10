package KAKAO_INTERN_2021;

import java.util.Stack;
import java.util.StringTokenizer;

public class 표_편집 {
	
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) {
		String [] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		solution(8,2,cmd);
	}
	public static String solution(int n, int k, String[] cmd) {
		StringTokenizer st;
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	sb.append(i);
        }
        
        for(int i=0; i<cmd.length; i++) {
        	String str = cmd[i];
        	if(str.charAt(0)=='D') {
        		st = new StringTokenizer(str,"D");
        		k -= Integer.parseInt(st.nextToken());        		        		
        	}else if(cmd[i].charAt(0)=='U') {
        		st = new StringTokenizer(str,"U");
        		k += Integer.parseInt(st.nextToken());
        	}else if(cmd[i].charAt(0)=='C') {
        		stack.push(sb.charAt(k)-'0');
        		sb.deleteCharAt(k);
        	}else {
        		
        	}
        }
        
        return answer;
    }
}
