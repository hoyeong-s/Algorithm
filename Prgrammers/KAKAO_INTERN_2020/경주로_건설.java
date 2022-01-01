package KAKAO_INTERN_2020;

import java.io.*;
import java.util.*;

public class 경주로_건설 {
	static int min = 987654321, lng;
	static int [][][] visited;
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	
	static class Dot{
		int r,c,fee,dir;

		public Dot(int r, int c, int fee, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.fee = fee;
			this.dir = dir;
		}
		
	}
	
	public static void main(String[] args) {
		int [][] board = {{0, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 1, 1, 1, 1, 1, 0}, {1, 0, 0, 1, 0, 0, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 1, 0}}
;
		solution(board);
	}
	public static int solution(int[][] board) {
        int answer = 0;
        lng = board.length;
        visited = new int[lng][lng][4];
        
        bfs(board);
        
        return min;
    }
	
	private static void bfs(int[][] board) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0,0,0,-1));
		
		for(int i=0; i<4; i++) visited[0][0][i] = -1;
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			int fee = d.fee;
			int direction = d.dir;
			
			if(r==lng - 1 && c==lng - 1) {
				min = Math.min(min, fee);
			}
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				int nfee = fee;
				if(nr<0 || nc<0 || nr>=lng || nc>=lng ||  board[nr][nc]==1) continue;
				
				if(direction==-1) nfee +=100;
				else if(direction==dir) nfee+=100;
				else nfee+=600;
				
				
				if(visited[nr][nc][dir]==0 || visited[nr][nc][dir]>=nfee) {
					visited[nr][nc][dir]=nfee;
					q.add(new Dot(nr,nc,nfee,dir));
				}
			}
		}
		
	}
}
