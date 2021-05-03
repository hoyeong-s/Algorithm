package week5;

import java.io.*;
import java.util.*;

public class back_2631 {
	static int N;
	static int [] arr,dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		dp = new int [N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(N-LIS());
		
	}
	private static int LIS() {
		int max=0;
		for(int i=0; i<N; i++) {
			dp[i]=1;
			for(int j=0; j<i; j++) {
				if(arr[j]<arr[i])
				dp[i] = Math.max(dp[i], dp[j]+1);
			}
			max = Math.max(dp[i], max);
		}
		return max;
	}
}
