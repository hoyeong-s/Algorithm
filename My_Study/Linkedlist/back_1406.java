package Linkedlist;

import java.io.*;
import java.util.*;

public class back_1406 {
	static int unused; // 사용하지 않은 인덱스
	static class Node{
		char c;
		Node prev;
		Node next;
	}
	static Node [] node;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		node = new Node[600000];
		for(int i=0; i<600000; i++)
			node[i] = new Node();
		
		String str = br.readLine();
		for(int i=0; i<str.length(); i++) { // 초기 문자 설정
			insert(str.charAt(i),i);
		}
		
		Node cursor = node[str.length()];
		
		int N = Integer.parseInt(br.readLine());
		for(int x=0; x<N; x++) {
			String s = br.readLine();
			switch(s.charAt(0)) {
			case('L') : {
				
				break;
			}
			case('D') : {
				break;
			}
			case('B') : {
				break;
			}
			case('P') : {
				
				break;
			}
			}
		}
	}
	private static void insert(char c, int index) { // index 실제 들어가야하는 공간
		node[unused].c = c;
			
		Node P = node[index].prev;
		Node N = node[index].next;
		
		if(P!=null) {
			P.next = node[unused];
			node[unused].prev = P;			
		}
		if(N!=null) {
			N.prev = node[unused];
			node[unused].next = N;
		}	
		unused++;
	}

	private static void erase() {
		
	}
}
