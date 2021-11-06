package Dev_matching_2021;

import java.io.*;
import java.util.*;

public class 행렬_테두리_회전하기 {
	static int cnt=0;
	static int [] result;
	static int [] dr = {0,1,0,-1};
	static int [] dc = {-1,0,1,0};
	static int [][] map;
	public static void main(String[] args) {
		int [][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		solution(6,6,queries);
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
        result = new int [queries.length];
        map = new int [rows][columns];
        int cnt = 1;
        for(int i=0; i<rows; i++) {
        	for(int j=0; j<columns; j++) {
        		map[i][j] = cnt++;
        	}
        }
        
        for(int i=0; i<queries.length; i++)
        	spin(queries[i]);
        
        return result;
    }
	private static void spin(int [] queries) { // 회전
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int x1 = queries[1]-1;
		int y1 = queries[0]-1;
		int x2 = queries[3]-1;
		int y2 = queries[2]-1;
		
		int r = y1, c = x2, dir=0;
		int start = map[r][c];
		pq.add(map[r][c]);
		
		do {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<y1 || nc<x1 || nr>y2 || nc>x2) {
				dir++;
				if(dir>=4) dir=0;
				nr = r + dr[dir];
				nc = c + dc[dir];
			}
			
			map[r][c] = map[nr][nc];			
			pq.add(map[nr][nc]);
			r = nr; c = nc;
		}while(r!=y1 || c!=x2);
		map[y1+1][x2] = start;
		
		result[cnt++] = pq.peek();
	}
}
