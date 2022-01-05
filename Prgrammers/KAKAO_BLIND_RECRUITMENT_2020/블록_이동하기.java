package KAKAO_BLIND_RECRUITMENT_2020;

import java.io.*;
import java.util.*;

// 그냥 일반적인 카운팅 개념이기 때문에 intern_2020_경주로건설 과는 다르게 visited를 dp로 풀지 않고 boolean형식으로 해도됨
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
		int [][] board3 = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
		//solution(board3);

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
			
			if(r2==N-1 && c2==N-1) { // 도착했을 때
				min = Math.min(min, cnt);
				continue;
			}
			
			for(int dir=0; dir<4; dir++) {
				int nr1 = r1 + dr[dir];
				int nc1 = c1 + dc[dir];
				int nr2 = r2 + dr[dir];
				int nc2 = c2 + dc[dir];
				if(nr1<0 || nr2<0 || nc1<0 || nc2<0 || nr1>=N || nr2>=N || nc1>=N || nc2>=N) continue;
				if(board[nr1][nc1]==1 || board[nr2][nc2]==1) continue;
				if(visited[nr1][nc1][vir]==0) {
					visited[nr1][nc1][vir]=cnt+1;
					q.add(new Dot(nr1,nc1,nr2,nc2,cnt+1,vir));				
				}
			}	
			
			if(vir==0) { // 가로
				if(r1>=1 && board[r1-1][c2]!=1 && board[r1-1][c1]!=1 && (visited[r1-1][c1][1]==0)) { // r1기준 위로
					visited[r1-1][c1][1]=cnt+1;
					q.add(new Dot(r1-1,c1,r1,c1,cnt+1,1));
				}
				if(r1<board.length-1 && board[r1+1][c2]!=1 && board[r1+1][c1]!=1 && (visited[r1][c1][1]==0)) { // r1기준 아래로
					visited[r1][c1][1]=cnt+1;
					q.add(new Dot(r1,c1,r1+1,c1,cnt+1,1));				
				}
				if(r2>=1 && board[r2-1][c1]!=1 && board[r2-1][c2]!=1 && (visited[r2-1][c2][1]==0)) { // r2 기준 위로
					visited[r2-1][c2][1]=cnt+1;
					q.add(new Dot(r2-1,c2,r2,c2,cnt+1,1));
				}
				if(r2<board.length-1 && board[r2+1][c1]!=1 && board[r2+1][c2]!=1 && (visited[r2][c2][1]==0)) { // r2 기준 아래로
					 visited[r2][c2][1]=cnt+1;
					 q.add(new Dot(r2,c2,r2+1,c2,cnt+1,1));
				}
			}else { // 세로
				if(c1>=1 && board[r2][c1-1]!=1 && board[r1][c1-1]!=1 && (visited[r1][c1-1][0]==0)) { // c1기준 좌측
					visited[r1][c1-1][0]=cnt+1;
					q.add(new Dot(r1,c1-1,r1,c1,cnt+1,0));
				}
				if(c1<board.length-1 && board[r2][c1+1]!=1 && board[r1][c1+1]!=1 && (visited[r1][c1][0]==0)) { //c1기준 우측
					visited[r1][c1][0]=cnt+1;
					q.add(new Dot(r1,c1,r1,c1+1,cnt+1,0));
				}
				if(c2>=1 && board[r1][c2-1]!=1 && board[r2][c2-1]!=1 && (visited[r2][c2-1][0]==0)) { // c2기준 좌측
					visited[r2][c2-1][0]=cnt+1;
					q.add(new Dot(r2,c2-1,r2,c2,cnt+1,0));
				}
				if(c2<board.length-1 && board[r1][c2+1]!=1 && board[r2][c2+1]!=1 && visited[r2][c2][0]==0) {
					visited[r2][c2][0] = cnt+1;
					q.add(new Dot(r2,c2,r2,c2+1,cnt+1,0));
				}
			}
		}
		}
	
	}
