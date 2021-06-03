package week3;

import java.io.*;
import java.util.*;

class b_2583{
	int r,c;

	public b_2583(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class back_2583 {
	static int N,M,K;
	static boolean [][] map;
	static Queue<b_2583> q = new LinkedList<b_2583>();
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new boolean [M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j=y1; j<y2; j++) {
				for(int k=x1; k<x2; k++) {
					map[j][k] = true;
				}
			}
		}
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(!map[i][j]) find(i,j);
			}
		}
		
		sb.append(pq.size()+"\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()+" ");
		}
		System.out.println(sb);
	}
	
	private static void find(int i, int j) {
		q.clear();
		int cnt=1;
		q.add(new b_2583(i,j));
		map[i][j] = true;
		
		while(!q.isEmpty()) {
			b_2583 b = q.poll();
			int r = b.r;
			int c = b.c;
			
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=M || nc>=N) continue;
				if(!map[nr][nc]) {
					map[nr][nc] = true;
					cnt++;
					q.add(new b_2583(nr, nc));
				}
			}
		}
		pq.add(cnt);
	}
}
