package DP;

import java.io.*;
import java.util.*;

public class back_11053 {
	static int N;
	static int [] arr,dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		dp = new int [N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(LIS());
	}
	private static int LIS() {
		int max=0;
		for(int i=0; i<N; i++) {
			dp[i]=1;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i])
					dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
