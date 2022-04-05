package Simulation;

import java.io.*;
import java.util.*;

public class back_14500 {
	static int [][] map;
	static boolean [][] check;
	static int N,M;
	static int max = 0;
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int [N][M];
		check = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int num = Integer.parseInt(st.nextToken());
				
				map[i][j] = num;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				check[i][j] = true;
				dfs(i,j,0,0);
				check[i][j] = false;
				oh(i,j);
			}
		}
		System.out.println(max);
	}
	
	private static void dfs(int r, int c, int cnt, int sum) {
		if(cnt>=4) {
			max = Math.max(max, sum);
			return;
		}
		
		
		for(int dir=0; dir<4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<0 || nc<0 || nr>=N || nc>=M || check[nr][nc]) continue;
			
			check[nr][nc] = true;
			dfs(nr,nc,cnt+1,sum+map[nr][nc]);
			check[nr][nc] = false;
		}
	}
	
	private static void oh(int r, int c) {
		if(r+2 < N && c+1 < M) max = Math.max(max, map[r][c]+map[r+1][c]+map[r+2][c]+map[r+1][c+1]);
		if(r-1 >=0 && c+2 < M) max = Math.max(max, map[r][c]+map[r-1][c+1]+map[r][c+1]+map[r][c+2]);
		if(r-1 >=0 && r+1 < N && c+1 < M) max = Math.max(max, map[r][c]+map[r+1][c+1]+map[r][c+1]+map[r-1][c+1]);
		if(r+1 < N && c+2 < M) max = Math.max(max, map[r][c]+map[r][c+1]+map[r+1][c+1]+map[r][c+2]);
	}
}
