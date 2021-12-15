package KAKAO_BLIND_RECRUITMENT_2021;

import java.io.*;
import java.util.*;

public class 합승_택시_요금 {
	static int [][] dis;
	
	public static void main(String[] args) {
		int [][] fares = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12}, {5,3,20}, {2,4,8}, {4,3,9}};
		solution(6,4,5,6,fares);
	}
	public static int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int INF = 987654321;
        
        dis = new int [n+1][n+1];
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(i==j) dis[i][j] = 0;
        		else dis[i][j] = INF;
        	}
        }
        
        for(int i=0; i<fares.length; i++) {
        	int start = fares[i][0];
        	int end = fares[i][1];
        	int fee = fares[i][2];
        	
        	dis[start][end] = dis[end][start] = fee; 
        }
        
        fluid(n);
        
        return find(n,s,a,b);
    }
	
	private static void fluid(int n) {
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(dis[i][j] > dis[i][k] + dis[k][j]) dis[i][j] = dis[i][k] + dis[k][j];
				}
			}
		}
		
	}
	
	private static int find(int n, int s, int a, int b) {
		int INF = 987654321;
		int min = dis[s][a] + dis[s][b];
		
		for(int i=1; i<=n; i++) {
			if(dis[s][i] != INF && dis[i][a] !=INF && dis[i][b] !=INF)
			min = Math.min(min, dis[s][i] + dis[i][a] + dis[i][b]);
		}
		
		return min;
	}
}
