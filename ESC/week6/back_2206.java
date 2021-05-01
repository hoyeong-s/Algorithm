package week6;

import java.io.*;
import java.util.*;

class b_2206{
	int r,c,bomb,cnt;

	public b_2206(int r, int c, int bomb, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.bomb = bomb;
		this.cnt = cnt;
	}

}
public class back_2206 {
	static int N,M,result=987654321;
	static int [][] map;
	static boolean [][][] visited;
	static Queue<b_2206> q = new LinkedList<b_2206>();
	final static int [] dr = {-1,1,0,0};
	final static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean [N][M][2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		move();
		if(result==987654321) System.out.println(-1);
		else System.out.println(result);
	}
	
	private static void move() {
		q.add(new b_2206(0, 0, 1, 1));
		visited[0][0][1] = true;
		
		while(!q.isEmpty()) {
			b_2206 b = q.poll();
			int r = b.r;
			int c = b.c;
			int bomb = b.bomb;
			int cnt = b.cnt;
			
			if(r==N-1 && c==M-1) {
				result = Math.min(cnt, result);
				continue;
			}
			
			for(int dir=0; dir<4; dir++) {
				int bombc = bomb;
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=M) continue; // map 범위 벗어났을 때
				if(map[nr][nc]==1) {
					if(bomb==1) bombc--;
					else continue;
				}
				
				if(!visited[nr][nc][bombc]) {
					visited[nr][nc][bombc] = true;
					q.add(new b_2206(nr, nc, bombc, cnt+1));
				}
			}
		}
		
	}
}
