package week8;

import java.io.*;
import java.util.*;

public class back_1051 {
	static int N,M,result;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		int num = Math.min(N, M);
		result = 0;
		for(int i=1; i<num; i++) {
			find(i);
		}
		System.out.println((result+1)*(result+1));
	}
	
	private static void find(int s) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(i+s>=N || j+s>=M) continue;
				if(map[i][j] == map[i+s][j] && map[i][j]==map[i+s][j+s] && map[i][j]==map[i][j+s]) {
					result=s;
					return;
				}
			}
		}
	}
}
