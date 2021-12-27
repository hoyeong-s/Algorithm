package KAKAO_BLIND_RECRUITMENT_2020;

import java.io.*;
import java.util.*;

public class 기둥과_보_설치 {
	static int [][] map;
	public static void main(String[] args) {
		int [][] build_f = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
		solution(5,build_f);
	}
	public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        map = new int [n+1][n+1];
        for(int [] row : map)
        	Arrays.fill(row, -1);
               
        for(int i=0; i<build_frame.length; i++) {
        	if(build_frame[i][3]==1) {
        		if(build_frame[i][2]==0) gidung(build_frame[i]);
            	else bo(build_frame[i]);
        	}
        }
        
        return make();
    }
	
	private static void gidung(int [] build) {
		int r = build[1];
		int c = build[0];
		
		if(r==0 || map[r-1][c]==0 || map[r-1][c]==2) {
			if(map[r][c]==-1) map[r][c] = 0;
			else map[r][c] = 2;
			return;
		}
		if((c>0 && map[r][c-1]==1 || map[r][c-1]==2) || (c<map.length-1 && map[r][c+1]==1 || map[r][c+1]==2)){
			if(map[r][c]==-1) map[r][c] = 0;
			else map[r][c] = 2;
			return;
		}
	}
	
	private static void bo(int [] build) {
		int r = build[1];
		int c = build[0];
		
		if((map[r-1][c]==0 || map[r-1][c]==2) || (c<map.length-1 && map[r-1][c+1]==0 || map[r-1][c+1]==2)) { // 한쪽 끝이 기둥
			if(map[r][c]==-1) map[r][c] = 1;
			else map[r][c] = 2;
			return;
		}
		if((c>0 && map[r][c-1]==1 || map[r][c-1]==2) && (c<map.length-1 && map[r][c+1]==1 || map[r][c+1]==2)){
			if(map[r][c]==-1) map[r][c] = 1;
			else map[r][c] = 2;
			return;
		}
	}
	
	private static int [][] make() {
		PriorityQueue<int []> pq = new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int [] o1, int [] o2) {
				if(o1[0]<o2[0]) return -1;
				else if(o1[0]>o2[0]) return 1;
				else {
					if(o1[1]<o2[1]) return -1;
					else if(o1[1]>o2[1]) return 1;
					else {
						if(o1[1]<o2[1]) return -1;
						else return 1;
					}
				}
			}
		});
		
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map.length; j++) {
				if(map[i][j]!=-1) {
					int [] arr = new int [3];
					if(map[i][j]==2) {
						arr[0] = j;
						arr[1] = i;
						arr[2] = 0;
						pq.add(arr);
						arr[2] = 1;
						pq.add(arr);
					}else {
						arr[0] = j;
						arr[1] = i;
						arr[2] = map[i][j];
						pq.add(arr);
					}
				}
			}
		}
		
		int [][] result = new int [pq.size()][3];
		int cnt = 0;
		while(!pq.isEmpty()) {
			result[cnt++] = pq.poll();
		}
		return result;
	}
}
