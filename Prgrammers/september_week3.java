import java.io.*;
import java.util.*;

// 5일 걸림
public class september_week3 {
	static int N,number,result;
	static boolean [][] visited;
	static int [] dr = {0,0,-1,1}; // 좌우상하
	static int [] dc = {-1,1,0,0};
	static int [][] board;
	static boolean [] check, check1;
	static HashMap<Integer,String> map = new HashMap<>();
	
	static class Dot{
		int r,c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		int[][] game_board = {{0,0,1,0,1,0,1,0,1,0,1,0,0,1,0,0,0,0}, {1,0,0,0,1,0,1,0,1,0,1,0,0,1,0,1,1,1}, {0,1,1,1,0,0,1,0,1,0,0,1,1,0,1,0,0,0}, {0,0,0,0,1,1,0,0,1,1,0,1,0,0,1,0,0,0}, {0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,1,1}, {1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,1,0,0}, {0,0,0,1,1,1,0,0,1,1,0,1,1,1,1,0,0,1}, {1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,1,0}, {0,0,1,0,1,1,1,0,0,1,0,1,1,1,1,0,0,0}, {1,1,0,1,1,0,1,1,1,1,0,1,0,0,0,1,1,1}, {0,0,0,0,1,0,0,0,0,1,0,1,0,0,1,0,1,0}, {1,1,1,1,0,1,1,1,1,1,0,1,0,1,0,0,1,0}, {0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,1,0,0}, {1,0,1,1,0,1,1,0,0,0,1,0,0,0,1,0,0,1}, {1,0,0,1,1,0,0,1,1,1,0,1,1,1,0,1,1,0}, {0,1,1,0,0,1,0,1,0,0,1,0,0,0,0,0,1,0}, {0,0,0,1,0,1,0,1,0,0,1,1,1,1,1,1,1,0}, {0,1,0,1,1,0,0,1,0,1,0,0,0,0,0,0,1,0}}; int[][] table = {{1,1,1,1,1,1,0,1,0,1,1,0,0,1,0,0,1,0}, {0,0,0,0,0,0,1,1,1,0,1,0,1,1,0,1,1,0}, {1,0,1,1,0,1,0,1,0,1,1,0,1,0,1,1,0,1}, {1,1,0,1,1,1,0,1,0,1,0,1,1,0,1,0,0,1}, {1,1,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,1}, {0,0,0,1,1,1,0,1,1,1,0,1,1,0,1,0,0,0}, {1,1,1,0,0,0,0,0,1,1,0,1,1,0,1,1,1,1}, {0,0,1,0,1,1,0,1,0,0,1,0,0,1,0,0,0,0}, {1,0,1,0,0,0,0,1,0,1,1,0,1,1,0,1,1,1}, {1,0,1,0,1,1,1,1,0,1,1,0,0,0,1,1,1,0}, {1,1,0,1,0,0,0,0,1,0,0,1,1,1,0,0,0,0}, {0,0,1,1,1,1,0,1,1,0,1,0,0,0,1,1,0,1}, {1,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1}, {1,1,0,0,1,1,1,0,1,1,0,1,0,1,0,1,0,1}, {0,0,1,1,0,1,1,0,1,0,1,1,0,0,0,1,0,0}, {1,1,1,0,1,0,0,1,0,1,1,0,0,1,0,1,0,1}, {0,0,0,0,1,0,1,1,1,0,0,1,0,1,1,0,1,1}, {0,1,1,1,1,0,0,1,0,0,1,1,0,1,0,0,1,1}}; 
		solution(game_board,table);
	}
	public static int solution(int[][] game_board, int[][] table) {
        int answer = -1;
        N = game_board.length;
        board = game_board;
        visited = new boolean[N][N];
                
        for(int i=0; i<N; i++) {
        	for(int j=0; j<N; j++) {
        		if(game_board[i][j]==0 && !visited[i][j]) bfs(i,j,game_board,0,0);
        	}
        }
        
        table = find(table); // table 번호 메기기
        check = new boolean[map.size()];
        check1 = new boolean[number+1];
        
        for(int t=0; t<4; t++) {
        	for(int i=0; i<N; i++) {
        		for(boolean [] r : visited)
        			Arrays.fill(r, false);
        	
        		for(int j=0; j<N; j++) {
        			if(table[i][j]!=0 && !visited[i][j] && !check1[table[i][j]]) bfs(i,j,table,table[i][j],1);
        		}
        	}
        	table = spin(table);
        }
        return result;
    }
	
	private static void bfs(int rr, int cc, int [][] game_board, int num, int tb) { // 구조도 만들기
		Queue<Dot> q = new LinkedList<>();
		visited[rr][cc] = true;
		q.add(new Dot(rr,cc));
		int cnt = 1;
		
		int lc=cc,rc=cc,tr=rr,br=rr;
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				if(game_board[nr][nc]==num && !visited[nr][nc]) {
					visited[nr][nc]=true;
					cnt++;
					
					lc = Math.min(lc, nc);
					rc = Math.max(rc, nc);
					tr = Math.min(tr, nr);
					br = Math.max(br, nr);
					
					q.add(new Dot(nr,nc));
				}
			}
		}
		box(lc,rc,tr,br,game_board,tb,num,cnt);
	}
	private static void box(int lc, int rc, int tr, int br, int [][] board, int tb, int num, int cnt) {
		int [][] arr = new int [br-tr+1][rc-lc+1];
		for(int i=tr; i<=br; i++) {
			for(int j=lc; j<=rc; j++) {
				arr[i-tr][j-lc] = board[i][j];
			}
		}
		String str = draw(arr,tb);
		
		if(tb==0) map.put(map.size(),str); // game_board 구조도 그리기
		else { // table, game_board와 비교
			if(map.containsValue(str)) { // 같은 모양 존재
				for(int i=0; i<map.size(); i++) {
					if(map.get(i).equals(str) && !check[i]) {
						check[i] = true;
						check1[num] = true;
						result+=cnt;
						return;
					}
				}
			}
		}
	}
	private static String draw(int [][] arr, int tb) {
		StringBuilder sb = new StringBuilder();
		
		if(tb==0) {
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					int num = arr[i][j];
					if(num!=0) sb.append(1);
					else sb.append(0);
				}
				sb.append("n");
			}
		}
		else {
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					int num = arr[i][j];
					if(num!=0) sb.append(0);
					else sb.append(1);
				}
				sb.append("n");
			}
		}
		return sb.toString();
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
						for(int dir = 0; dir<4; dir++) {
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
}
