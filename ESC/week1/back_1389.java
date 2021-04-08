package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_1389 {
	static int N,M;
	static int [][] dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dis = new int[N+1][N+1];
		for(int [] row:dis) {
			Arrays.fill(row, 987654321);
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			dis[f][t] = 1;
			dis[t][f] = 1;
		}
		fluid();
		int sum=0,min=987654321,result=0;
		for(int i=1; i<=N; i++) {
			sum=0;
			for(int j=1; j<=N; j++) {
				sum+=dis[i][j];
			}
			if(min>sum) {
				min = sum;
				result = i;
			}
			else if(min==sum) {
				result = Math.min(result, i);
			}
		}
		System.out.println(result);
	}
	private static void fluid() {
		for(int k=1; k<=N; k++) { // 경
			for(int i=1; i<=N; i++) { // 출
				for(int j=1; j<=N; j++) { // 도
					if(i==j) dis[i][i] = 0;
					if(dis[i][j]>dis[i][k]+dis[k][j]) {
						dis[i][j]=dis[i][k]+dis[k][j];
					}
				}
			}
		}
	}
}
