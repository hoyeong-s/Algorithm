package week2;

import java.io.*;
import java.util.*;

class b_1012{
	int r,c;

	public b_1012(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class back_1012 {
	static int N,M,K;
	static boolean [][] map;
	static Queue<b_1012> q = new LinkedList<b_1012>();
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new boolean[N][M];
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				map[r][c] = true;
			}
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb);
	}
	private static void bfs(int i, int j) {
		q.clear();
		q.add(new b_1012(i, j));
		map[i][j] = false;
		
		while(!q.isEmpty()) {
			b_1012 b = q.poll();
			int r = b.r;
			int c = b.c;
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
				if(map[nr][nc]) {
					map[nr][nc] = false;
					q.add(new b_1012(nr, nc));
				}
			}
		}
	}
}
