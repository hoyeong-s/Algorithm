package week4;

import java.io.*;
import java.util.*;

class coin implements Comparable<coin>{
	int p,n;

	public coin(int p, int n) {
		super();
		this.p = p;
		this.n = n;
	}

	@Override
	public int compareTo(coin o) {
		return this.p-o.p;
	}
}
public class back_2624 {
	static int T,K;
	static long [][] dp;
	static ArrayList<coin> list = new ArrayList<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		dp = new long [K][T+1];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			list.add(new coin(p,n));
		}
		
		Collections.sort(list);
		
		int coin = list.get(0).p;
		int n = list.get(0).n;
		for(int i=coin; i<=T; i++)
			if(i%coin==0 && i/coin<=n) dp[0][i]++;
		dp[0][0]=1;
		for(int i=1; i<list.size(); i++) {
			coin = list.get(i).p;
			n = list.get(i).n;
			for(int j=0; j<coin; j++)
				dp[i][j] = dp[i-1][j];
			
			for(int j=coin; j<=T; j++) {
				for(int k=0; k<=n; k++) {
					if(j-coin*k<0) continue;
					dp[i][j] += dp[i-1][j - coin*k];
				}
			}
		}
		
		System.out.println(dp[K-1][T]);
		
	}

}
