package kakao_2018;

import java.util.Arrays;

public class programmers_블록 {
	
	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String [] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		System.out.println(solution(m,n,board));
	}
	public static int solution(int m, int n, String[] board) {
        int answer = 0;
        
        char [][] map = new char[m][n];
        boolean [][] check = new boolean[m][n];
        
        for(int i=0; i<m; i++) {
        	String str = board[i];
        	for(int j=0; j<n; j++) {
        		map[i][j] = str.charAt(j);
        	}
        }
		while (true) {
			boolean ch = false;
			
			for(boolean [] row:check)
				Arrays.fill(row, false);
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(map[i][j]!='.' && bfs(m,n,i,j,map,check)) ch = true; // 블록 부순적 있는지 확인
				}
			}
			if(!ch) break;
			else {
				answer += bomb(m,n,map,check);
				fall(m,n,map);
			}
		}
        return answer;
    }
		
	static void fall(int m,int n, char [][] map) { // 
		for(int i=0; i<n; i++) {
			outloop:for(int j=m-1; j>=0; j--) {
				if(map[j][i]=='.') {
					for(int k=j-1; k>=0; k--) { // '.' 찾는 for
						if(map[k][i]!='.') {
							map[j][i] = map[k][i];
							map[k][i] = '.';
							continue outloop;
						}
					}
				}
			}
		}
	}
	
	static int bomb(int m, int n, char[][]map, boolean[][] check) { // 같은 블록 부수기
		int sum=0;
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(check[i][j]) {
					map[i][j] = '.';
					sum++;
				}
			}
		}
		return sum;
	}
	
	static boolean bfs(int m, int n, int r, int c, char[][]map, boolean[][] check) {
		int [] dr = {1,0,1};
		int [] dc = {0,1,1};
		
		for(int dir=0; dir<3; dir++) { // 블록 4개 같은지 확인
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr >= m || nc >= n ||map[r][c]!=map[nr][nc]) return false; // 4개 블록 중 하나라도 같지 않을 때
		}
		for (int dir = 0; dir < 3; dir++) { // 블록 4개가 같을 때
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			check[nr][nc] = true;
		}
		check[r][c] = true;
		
		return true;
	}
}
