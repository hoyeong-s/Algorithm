package KAKAO_BLIND_RECRUITMENT_2020;

import java.io.*;
import java.util.*;

public class 기둥과_보_설치 {
	static boolean [][] g,b;
	
	public static void main(String[] args) {
		int [][] build_f = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		solution(5,build_f);
	}
	public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        
        g = new boolean [n+1][n+1];
        b = new boolean [n+1][n+1];
        
        for(int i=0; i<build_frame.length; i++) {
        	int r = build_frame[i][1];
			int c = build_frame[i][0];
			
        	if(build_frame[i][2]==0) { // 기둥
        		if(build_frame[i][3]==1) { // 설치
        			if(checkg(r,c)) g[r][c] = true;
        		}else { // 제거
        			g[r][c] = false;
        			if(!delete()) g[r][c] = true;
        		}
        	}else { // 보
        		if(build_frame[i][3]==1) { // 설치
        			if(checkb(r,c)) b[r][c] = true;
        		}else { // 제거
        			b[r][c] = false;
        			if(!delete()) b[r][c] = true;
        		}
        	}
        }
        
        return make();
    }
	
	private static boolean checkg(int r, int c) {
		if(r==0) return true;
		if(r>0 && g[r-1][c]) return true;
		if(c>0 && b[r][c] || b[r][c-1]) return true;
		return false;
	}
	
	private static boolean checkb(int r, int c) {
		if(r>0 && g[r-1][c] || g[r-1][c+1]) return true;
		if(c>0 && b[r][c-1] && b[r][c+1]) return true;
		return false;
	}
	
	private static boolean delete() {
		for(int i=0; i<g.length; i++) {
			for(int j=0; j<g.length; j++) {
				if(g[i][j] && !checkg(i,j)) return false;
				if(b[i][j] && !checkb(i,j)) return false;
			}
		}
		return true;
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
						if(o1[2]<o2[2]) return -1;
						else return 1;
					}
				}
			}
		});
		
		for(int i=0; i<g.length; i++) {
			for(int j=0; j<g.length; j++) {
				if(g[i][j]) {
					int [] arr = new int [3];
					arr[0] = j;
					arr[1] = i;
					arr[2] = 0;
					pq.add(arr);
				}
				if(b[i][j]) {
					int [] arr = new int [3];
					arr[0] = j;
					arr[1] = i;
					arr[2] = 1;
					pq.add(arr);
				}
			}
		}
		
		int size = pq.size();
		int [][] result = new int [size][3];
		int cnt = 0;
		while(!pq.isEmpty()) {
			result[cnt++] = pq.poll();
		}
		return result;
	}
	
}
