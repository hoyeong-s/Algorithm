package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2294 {
	static int N,K,INF=987654321;
	static int [] coin,dp;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		dp = new int[K+1];
		
		for(int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		Arrays.fill(dp, INF);
		
		for(int i=0; i<N; i++) {
			for(int j=coin[i]; j<=K; j++) {
				if(j%coin[i]==0) dp[j] = j/coin[i];
				else {
					if(dp[j-coin[i]]!=INF)
					dp[j] = Math.min(dp[j], dp[coin[i]]+dp[j-coin[i]]);
				}
			}
		}
		if(dp[K]==INF) System.out.println(-1);
		else System.out.println(dp[K]);
	}

}
