package KAKAO_BLIND_RECRUITMENT_2020;

import java.io.*;
import java.util.*;

public class 블록_이동하기 {
	static class Dot{
		int r1,c1,r2,c2,cnt,vir;

		public Dot(int r1, int c1, int r2, int c2, int cnt, int vir) {
			super();
			this.r1 = r1;
			this.c1 = c1;
			this.r2 = r2;
			this.c2 = c2;
			this.cnt = cnt;
			this.vir = vir;
		}

	}
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	static int N,min=987654321;
	static int [][][] visited;
	public static void main(String[] args) {
		int [][] board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};
		solution(board);
		int [][] board1 = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 0, 0, 0}};
		//solution(board1);
		int [][] board2 = {{0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 1, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1, 0}};
		//solution(board2);
		
	}
	
	public static int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        visited = new int[N][N][2]; // 더 작은 좌표 기준으로 가로방향 0 세로방향 1
        
        move(board);
        
        return min;
    }
	
	private static void move(int [][] board) {
		Queue<Dot> q = new LinkedList<>();
		q.add(new Dot(0,0,0,1,0,0));
		visited[0][0][0] = -1;
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r1 = d.r1;
			int c1 = d.c1;
			int r2 = d.r2;
			int c2 = d.c2;
			int cnt = d.cnt;
			int vir = d.vir;
			
			if((r1==N-1 && c1==N-1)||(r2==N-1 && c2==N-1)) { // 도착했을 때
				
			}
			
			for(int dir=0; dir<4; dir++) {
				int nr1 = r1 + dr[dir];
				int nc1 = c1 + dc[dir];
				int nr2 = r2 + dr[dir];
				int nc2 = c2 + dc[dir];
				if(nr1<0 || nr2<0 || nc1<0 || nc2<0 || nr1>=N || nr2>=N || nc1>=N || nc2>=N) continue;
				
			}
		}
		
		}
	}
