package week3;

import java.io.*;
import java.util.*;

class b_2573{
	int r,c;

	public b_2573(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class back_2573 {
	static int N,M;
	static int [][] map;
	static Queue<b_2573> q = new LinkedList<b_2573>();
	static Queue<b_2573> q2 = new LinkedList<b_2573>();
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				if(num!=0) q.add(new b_2573(i,j));
			}
		}
		
		int result=0;
		while(find()<2) {
			melt();
			result++;
			if(q.size()==0) {
				result=0;
				break;
			}
		}
		System.out.println(result);
	}
	
	private static void melt() {
		int [][] copymap = COPY();
		
		int s = q.size();
		for(int i=0; i<s; i++) {
			b_2573 b = q.poll();
			int r = b.r;
			int c = b.c;
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(copymap[nr][nc]==0 && map[r][c]>0) map[r][c]--;
			}
			if(map[r][c]>0) q.add(new b_2573(r, c));
		}
	}
	
	private static int find() {
		q2.clear();
		boolean [][] visited = new boolean[N][M];
		int cnt =0;
		int s = q.size();
		for(int i=0; i<s; i++) {
			b_2573 b = q.poll();
			int r = b.r;
			int c = b.c;
			if(!visited[r][c]) {
				cnt++;
				visited[r][c] = true;
				q2.add(new b_2573(r, c));
				while(!q2.isEmpty()) {
					b_2573 bb = q2.poll();
					int rr = bb.r;
					int cc = bb.c;
					for (int dir = 0; dir < 4; dir++) {
						int nr = rr + dr[dir];
						int nc = cc + dc[dir];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M)
							continue;
						if (map[nr][nc] > 0 && !visited[nr][nc]) {
							visited[nr][nc] = true;
							q2.add(new b_2573(nr, nc));
						}
					}
				}
			}
			q.add(new b_2573(r,c));
		}
		return cnt;
	}
	
	private static int [][] COPY() {
		int [][] c = new int [N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				c[i][j] = map[i][j];
			}
		}
		return c;
	}
}
