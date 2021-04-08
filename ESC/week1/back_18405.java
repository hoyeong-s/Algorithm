package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class b_18405 implements Comparable<b_18405>{
	int num,r,c;

	public b_18405(int num, int r, int c) {
		super();
		this.num = num;
		this.r = r;
		this.c = c;
	}

	@Override
	public int compareTo(b_18405 o) {
		return this.num - o.num;
	}
}

public class back_18405 {
	static int N,K,S,X,Y;
	static int [][] map;
	static int [][] cnt;
	static PriorityQueue<b_18405> pq = new PriorityQueue<>();
	static Queue<b_18405> q = new LinkedList<>();
	final static int [] dr = {-1,1,0,0};
	final static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		cnt = new int [N][N];
		
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]!=0) pq.add(new b_18405(map[i][j], i, j));
			}
		}
		
		while(!pq.isEmpty()) {
			q.add(pq.poll());
		}
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		virus();
		System.out.println(map[X-1][Y-1]);
	}
	private static void virus() {
		while(!q.isEmpty()) {
			b_18405 b = q.poll();
			int n = b.num;
			int r = b.r;
			int c = b.c;
			
			if(cnt[r][c]>=S) break;
			
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(map[nr][nc]==0) {
					map[nr][nc]=n;
					cnt[nr][nc] = cnt[r][c]+1;
					q.add(new b_18405(n, nr, nc));
				}
			}
		}
	}
}
