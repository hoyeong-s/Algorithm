package week1;

import java.io.*;
import java.util.*;

public class back_1021 {
	static int N,M;
	static int [] arr;
	static LinkedList<Integer> d = new LinkedList<>();
	//static Deque<Integer> dq = new ArrayDeque<Integer>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) 
			d.add(i);
		
		arr = new int [M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		System.out.println(cycle());
	}
	private static int cycle() {
		int cnt=0;
		
		for(int i=0; i<M; i++) {
			
			int idx = d.indexOf(arr[i]); // 현재 찾고자 하는 숫자의 위치
			
			if(idx<=d.size()/2) { // 앞쪽에서 더 가깝다면
				while(d.peek()!=arr[i]) { // peek가 찾는수가 될때까지 회전
					cnt++;
					d.addLast(d.pollFirst());
				}
			}
			else { // 뒷쪽과 더 가까울때
				while(d.peek()!=arr[i]) {
					cnt++;
					d.addFirst(d.pollLast());
				}
			}
			d.poll();
		}
		return cnt;
	}
}
