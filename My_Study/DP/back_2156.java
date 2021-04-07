package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class back_2156 {
	static int N;
	static int [] arr;
	static int [] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int [N+1];
		dp = new int [N+1];
		
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = arr[1];
		if(N==1) {
			System.out.println(dp[1]);
			System.exit(0);
		}
		dp[2] = arr[1] + arr[2];
		for(int i=3; i<=N; i++) {
			int max = Math.max(dp[i-1], dp[i-2]+arr[i]);
			dp[i] = Math.max(max, dp[i-3]+arr[i]+arr[i-1]);
		}
		System.out.println(dp[N]);
	}

}
