package week3;

import java.io.*;
import java.util.*;

public class back_1937 {
	static int N;
	static int [][] map, dp;
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N];
				
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int result=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				result = Math.max(dfs(i,j),result);
			}
		}
		System.out.println(result);
	}
	
	private static int dfs(int r, int c) {
		if(dp[r][c]!=0) return dp[r][c];
		
		dp[r][c]=1;
		for(int dir=0; dir<4; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<0 || nc<0 || nr>=N || nc>=N || map[nr][nc]<map[r][c]) continue;
			dp[r][c] = Math.max(dfs(nr,nc)+1,dp[r][c]);
		}
		return dp[r][c];
	}
}
