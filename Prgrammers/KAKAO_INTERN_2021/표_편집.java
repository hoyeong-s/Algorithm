package KAKAO_INTERN_2021;

import java.util.Stack;
import java.util.StringTokenizer;

public class 표_편집 {
	static class Node{
		int num;
		boolean removed;
		Node prev;
		Node next;
	}
	static Stack<Node> stack = new Stack<>();
	
	public static void main(String[] args) {
		String [] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		solution(8,2,cmd);
	}
	public static String solution(int n, int k, String[] cmd) {
		StringTokenizer st;
        String answer = "";
        
        Node [] node = new Node[n];
        for(int i=0; i<n; i++)
        	node[i] = new Node();
        
        node[0].num = 0;
        for(int i=1; i<n; i++) { // 초기 설정
        	node[i].num = i;
        	node[i].prev = node[i-1];
        	node[i-1].next = node[i];
        }
        
        Node cur = node[k];
        		
        for(int i=0; i<cmd.length; i++) {
        	String str = cmd[i];
        	if(str.charAt(0)=='D') {
        		st = new StringTokenizer(str,"D ");
        		int num = Integer.parseInt(st.nextToken()); 
        		for(int j=0; j<num; j++)
        			cur = cur.next;
        	}
        	else if(cmd[i].charAt(0)=='U') {
        		st = new StringTokenizer(str,"U ");
        		int num = Integer.parseInt(st.nextToken()); 
        		for(int j=0; j<num; j++)
        			cur = cur.prev;
        	}
        	else if(cmd[i].charAt(0)=='C') {
        		cur.removed = true; // 현재 노드 삭제
        		stack.push(cur);
        		
        		Node P = cur.prev;
        		Node N = cur.next;
        		
        		if(P!=null) P.next = N; // cur이 마지막인 경우
        		if(N!=null) { // cur이 헤드인 경우
        			N.prev = P;
        			cur = N; // 새로운 cur은 이전 cur의 next여야함
        		}
        		else cur = P;	
        	}
        	else {
        		Node removed = stack.pop();
        		removed.removed = false;
        		
        		Node P = removed.prev;
        		Node N = removed.next;
        		
        		if(P!=null) P.next = removed; // cur이 마지막인 경우
        		if(N!=null) { // cur이 헤드인 경우
        			N.prev = removed;
        		}
        	}
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
        	if(!node[i].removed) sb.append("O");
        	else sb.append("X");
        }
        
        return sb.toString();
    }
}
