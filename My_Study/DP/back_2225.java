package DP;

import java.util.*;
import java.io.*;

public class back_2225 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long [][] dp = new long [K][N+1];
		
		for(int i=0; i<=N; i++)
			dp[0][i] = 1;
		
		for (int i = 1; i < K; i++) {
			for (int k = 0; k <= N; k++) {
				for (int j = 0; j <= k; j++) {
					dp[i][k] += dp[i-1][j];
					dp[i][k] %= 1000000000;
				}
			}
		}
		System.out.println(dp[K-1][N]);
	}

}
