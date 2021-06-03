package week3;

import java.io.*;
import java.util.*;

class b_2468{
	int r,c;

	public b_2468(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}
public class back_2468 {
	static int N, min=987654321,max, result;
	static int [][] map;
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	static Queue<b_2468> q = new LinkedList<b_2468>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int num = Integer.parseInt(st.nextToken());
				map[i][j] = num;
				max = Math.max(max, num);
			}
		}
		
		for(int i=0; i<=max; i++) {
			result = Math.max(result, search(i));
		}
		System.out.println(result);
	}
	private static int search(int rain) {
		boolean [][] visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]<=rain) visited[i][j] = true;
			}
		}
		
		int cnt=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited[i][j]) {
					cnt++;
					visited = bfs(i,j,visited);	
				}
			}
		}
		return cnt;
	}
	
	private static boolean [][] bfs(int i, int j, boolean[][] visited) {
		q.clear();
		
		visited[i][j] = true;
		q.add(new b_2468(i, j));
		
		while (!q.isEmpty()) {
			b_2468 b = q.poll();
			int r = b.r;
			int c = b.c;
			
			for (int dir = 0; dir < 4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new b_2468(nr, nc));
				}
			}
		}
		return visited;
	}
}
