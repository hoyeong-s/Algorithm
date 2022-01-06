package KAKAO_INTERN_2021;

import java.util.Stack;
import java.util.StringTokenizer;

public class 표_편집 {

	static class Node{
		int prev, tail;

		public Node(int prev, int tail) {
			super();
			this.prev = prev;
			this.tail = tail;
		}
	}
	
	static Stack<Node> stack = new Stack<>();
	
	public static void main(String[] args) {
		String [] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		solution(8,2,cmd);
	}
	public static String solution(int n, int k, String[] cmd) {
		StringTokenizer st;
        String answer = "";
        
        for(int i=0; i<cmd.length; i++) {
        	String str = cmd[i];
        	if(str.charAt(0)=='D') {
        		st = new StringTokenizer(str,"D");
        		k -= Integer.parseInt(st.nextToken());        		        		
        	}else if(cmd[i].charAt(0)=='U') {
        		st = new StringTokenizer(str,"U");
        		k += Integer.parseInt(st.nextToken());
        	}else if(cmd[i].charAt(0)=='C') {
        		
        	}else {
        		
        	}
        }
        
        return answer;
    }
}
