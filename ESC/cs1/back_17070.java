package cs1;

import java.io.*;
import java.util.*;

public class back_17070 {
	static int N;
	static int [][] map;
	static int [][][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int [N+1][N+1];
		dp = new int [N+1][N+1][3];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[1][2][0] = 1;
		
		for(int i=1; i<=N; i++) {
			for(int j=3; j<=N; j++) {
				if(map[i][j]==1) continue;
				pipe(i,j);
			}
		}
		int result=0;
		for(int i=0; i<3; i++) result += dp[N][N][i];
		System.out.println(result);
	}
	private static void pipe(int r, int c) {
		dp[r][c][0] += dp[r][c-1][0] + dp[r][c-1][1];
		if(map[r-1][c]!=1 && map[r][c-1]!=1) dp[r][c][1] += dp[r-1][c-1][0]+dp[r-1][c-1][1]+dp[r-1][c-1][2];
		dp[r][c][2] += dp[r-1][c][1]+dp[r-1][c][2];
	}
}
