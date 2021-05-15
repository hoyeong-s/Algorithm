package week7;

import java.io.*;
import java.util.*;

// 처음 풀었던 방식 : 자신에서 자신으로 가는 거리를 0으로 셋팅하고 왕복이 가능해야 하므로 dis[i][j]+dis[j][i]이 가장 작은 것 (872ms)
// 다른 방식 : 왕복이라는 것은 다른곳으로 갔다가 자기자신으로 오는 것이므로 dis[i][i] 값이 가장 작은 것 (562ms)
public class back_1956 {
	static int N,M,INF=987654321;
	static int [][] dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		 
		dis = new int [N+1][N+1];
		for(int [] row:dis)
			Arrays.fill(row, INF);
				
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			dis[f][t] = wei;
		}
		
		fluid();
		int result = find();
		if(result==INF) System.out.println(-1);
		else System.out.println(result);
	}
	private static void fluid() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				if(i==k) continue;
				for(int j=1; j<=N; j++) {
					if(dis[i][j]> dis[i][k]+dis[k][j])
						dis[i][j] = dis[i][k]+dis[k][j];
				}
			}
		}
	}
	private static int find() {
		int min=INF;
		for(int i=1; i<=N; i++) {
			min = Math.min(min, dis[i][i]);
		}
		return min;
	}
}

/*public class Main {
	static int N,M;
	static int [][] dis;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		 
		dis = new int [N+1][N+1];
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(i==j) dis[i][j]=0;
				else dis[i][j]=987654321;
			}
		}
				
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			int wei = Integer.parseInt(st.nextToken());
			dis[f][t] = wei;
		}
		
		fluid();
		int result = find();
		if(result==987654321) System.out.println(-1);
		else System.out.println(result);
	}
	private static void fluid() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(dis[i][j]> dis[i][k]+dis[k][j])
						dis[i][j] = dis[i][k]+dis[k][j];
				}
			}
		}
	}
	private static int find() {
		int min=987654321;
		for(int i=1; i<N; i++) {
			for(int j=i+1; j<=N; j++) {
				min = Math.min(min, dis[i][j]+dis[j][i]);
			}
		}
		return min;
	}
}*/
