import java.io.*;
import java.util.*;

public class september_week3 {
	static int N,result,number;
	static int [] dr = {0,0,0,-1,1}; // 좌우상하
	static int [] dc = {0,-1,1,0,0};
	static ArrayList<int []> [] list1; // table의 순서도가 들어갈 리스트
	static boolean [] check;
	static boolean [][] visited;
	static class Dot{
		int r,c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {

int[][] game_board = {{0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0}, {1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1}, {0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1}, {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0}, {1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0}, {0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0}}; 
int[][] table = {{1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1},{1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1},{1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0},{0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0},{1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0},{1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},{1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1},{1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 1}, {1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 0, 1}, {1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1}}; 

solution(game_board,table);
	}
	public static int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        N = table.length;
        visited = new boolean [N][N];
        
        table = find(table); // 도형 번호 메기기
        
        list1 = new ArrayList[number+1];
        for(int i=2; i<=number; i++)
        	list1[i] = new ArrayList<>();
        check = new boolean[number];
        
        for(int t=0; t<4; t++) {
        	for(int i=0; i<N; i++) {
        		for(int j=0; j<N; j++) {
        			if(table[i][j]!=0 && !visited[i][j]) {
        				int num = table[i][j];
        				int [] arr = make(i,j,table);
        				if(!checking(num,arr)) list1[num].add(arr);
        			}
        		}
        	}
        	
        	table = spin(table); // 테이블 회전
        	for(boolean [] r : visited)
        		Arrays.fill(r, false);
        }
        
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(game_board[i][j]==0 && !visited[i][j]) last(i,j,game_board);
        	}
        }
        
        return result;
    }
	private static int [] make(int rr, int cc, int [][] table) { // 순서도 만들기
		int cnt = 0;
		int [] load = new int[5];
		Queue<Dot> q = new LinkedList<>();
		visited[rr][cc] = true;
		q.add(new Dot(rr,cc));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			for(int dir=1; dir<=4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(table[nr][nc]!=0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					load[cnt++] = dir; 
					q.add(new Dot(nr,nc));
				}
			}
		}
		return load;
	}
	private static int [][] find(int [][] table) { // table 도형 번호 메기기
		number = 2;
		Queue<Dot> q = new LinkedList<>();
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(table[i][j]==1) {
					table[i][j] = number;
					q.add(new Dot(i,j));
					while(!q.isEmpty()) {
						Dot d = q.poll();
						int r = d.r;
						int c = d.c;
						for(int dir = 1; dir<=4; dir++) {
							int nr = r + dr[dir];
							int nc = c + dc[dir];
							if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
							if(table[nr][nc]==1) {
								table[nr][nc] = number;
								q.add(new Dot(nr,nc));
							}
						}
					}
					number++;
				}
			}
		}
		return table;
	}
	
	private static int [][] spin(int [][] table) { // table 회전
		int [][] ctable = new int [N][N];
		
		for(int j=0; j<N; j++) {
			for(int i=N-1; i>=0; i--) {
				ctable[j][N-1-i] = table[i][j];
			}
		}
		return ctable;
	}
	private static void last(int rr, int cc, int [][] game_board) { // 순서도 만들기
		int cnt = 0;
		int [] load = new int[5];
		Queue<Dot> q = new LinkedList<>();
		visited[rr][cc] = true;
		q.add(new Dot(rr,cc));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			for(int dir=1; dir<=4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(game_board[nr][nc]==0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					load[cnt++] = dir; 
					q.add(new Dot(nr,nc));
				}
			}
		}
		
		for(int i=2; i<=number; i++) {
			for(int j=0; j<list1[i].size(); j++) {
				if(Arrays.equals(load, list1[i].get(j))&& !check[i]) {
					check[i] = true;
					if(cnt==5) {
						System.out.println(i);
						for(int x:list1[i].get(j)) System.out.print(x+" ");
						System.out.println();
						for(int x:load) System.out.print(x+" ");
						System.out.println();
					}
					result += cnt+1;
					return;
				}
			}
		}
	}
    private static boolean checking(int num, int [] arr) {
		for(int i=0; i<list1[num].size(); i++) {
			if(Arrays.equals(arr, list1[num].get(i))) return true;
		}
		return false;
	}
}

/*
 * 1. game_board bfs 순서도 만들기
 * 2. table 회전하면서 4개의 순서도 만들기
 * 3. 두개 비교하며 가장 큰 것 선택
 *  
 * */