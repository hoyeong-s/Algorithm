package Simulation;

import java.io.*;
import java.util.*;

public class back_3190 {
	static class Dot{
		int time;
		int Dir;
		public Dot(int time, int dir) {
			super();
			this.time = time;
			Dir = dir;
		}
	}
	static class S{
		int r, c;

		public S(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	static int [] dr = {0,-1,0,1};
	static int [] dc = {1,0,-1,0};
	static int N;
	static int [][] map;
	static Queue<Dot> q = new LinkedList<>();
	static Deque<S> d = new ArrayDeque<>();
	static int dir = 0;
	static int time = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) { // 사과
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			
			map[r][c] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		for(int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			if(d.equals("L")) q.add(new Dot(t,1));
			else q.add(new Dot(t,-1));
		}
		
		System.out.println(snake());
	}

	private static int snake() {
		d.add(new S(0,0));
		
		int t = 0;
		while(true) {
			// 움직임
			int hr = d.peekFirst().r + dr[dir];
			int hc = d.peekFirst().c + dc[dir];
			
			if(hr<0 || hc<0 || hr>=N || hc>=N) break; // 뱀이 벽에 닿
			if(!check_snake(hr,hc)) break; // 뱀이 자기 몸에 닿
			
			d.addFirst(new S(hr,hc));
			if(map[hr][hc]!=1) d.pollLast();
			else map[hr][hc] = 0;
			
			// 방향 전환
			t++;
			if(!q.isEmpty() && t == q.peek().time) {
				change(q.peek().Dir);
				q.poll();
			}
		}
		
		return t+1;
	}
	
	private static void change(int direction) {
		dir += direction;
		
		if(dir>=4) dir = 0;
		if(dir<0) dir = 3;
	}
	
	private static boolean check_snake(int hr, int hc) {
		for(S ss : d) {
			int r = ss.r;
			int c = ss.c;
			if(r == hr && c==hc) return false;
		}
		
		return true;
	}
}
