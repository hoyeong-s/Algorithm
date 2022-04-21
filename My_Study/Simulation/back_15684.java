package Simulation;

import java.io.*;
import java.util.*;

public class back_15684 {
	static int result = 0;
	static LinkedList<Integer> [] list;
	static boolean [] check = new boolean [4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new LinkedList[5];
		for(int i=1; i<5; i++)
			list[i] = new LinkedList<>();
		
		for(int i=1; i<5; i++) {
			String str = br.readLine();
			for(int j=0; j<8; j++) {
				list[i].add(str.charAt(j)-'0');
			}
		}
				
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			check();
			spin(n,c);
		}
		point();
		System.out.println(result);
	}
	private static void spin(int n, int c) {
		int low = n-1;
		int high = n;
		clock_func(n,c); // 최초 들어온 시계 회전
		
		int low_c = c;
		int high_c = c;
		
		while(low>=1 && check[low]) { // low
			low_c = direction(low_c);
			clock_func(low--,low_c);
		}
		
		while(high<4 && check[high]) { // high
			high_c = direction(high_c);
			clock_func(++high,high_c);
		}
	}
	
	private static void clock_func(int n, int c) {
		if(c==1)// 시계방향 회전
			list[n].addFirst(list[n].pollLast());
		else
			list[n].addLast(list[n].pollFirst());
	}
	
	private static int direction(int c) {
		if(c==1) return -1;
		else return 1;
	}
	
	private static void check() {
		if(list[1].get(2) != list[2].get(6)) check[1] = true; // 서로 영향 주면 true
		else check[1] = false;
		
		if(list[2].get(2) != list[3].get(6)) check[2] = true;
		else check[2] = false;
		
		if(list[3].get(2) != list[4].get(6)) check[3] = true;
		else check[3] = false;
	}
	
	private static void point() {
		for(int i=1; i<5; i++) {
			if(list[i].get(0)==1) result += Math.pow(2,i-1);
		}
	}
}
