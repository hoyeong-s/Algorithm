import java.io.*;
import java.util.*;

public class september_week11 {
	static int [] dr = {0,0,-1,1};
	static int [] dc = {-1,1,0,0};
	static int [] ddr = {0,0,-1,1,-1,-1,1,1};
	static int [] ddc = {-1,1,0,0,-1,1,-1,1};
	static boolean [][] map = new boolean [101][101];
	static class Dot{
		int r, c;

		public Dot(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) {
		int [][] rectangle = {{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}};
		System.out.println(solution(rectangle,1,3,7,8));
	}
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
                
        for(int k=0; k<rectangle.length; k++) {
        	int lx = 2*rectangle[k][0];
        	int ly = 2*rectangle[k][1];
        	int hx = 2*rectangle[k][2];
        	int hy = 2*rectangle[k][3];
        	for(int i=ly; i<=hy; i++) {
        		for(int j=lx; j<=hx; j++) {
        			map[i][j] = true;
        		}
        	}
        }
        return bfs(2*characterY, 2*characterX, 2*itemY, 2*itemX)/2;
        
    }
	private static int bfs(int sr, int sc, int fr, int fc) {
		int [][] check = new int [101][101];
		for(int [] r : check)
			Arrays.fill(r, -1);
		
		Queue<Dot> q = new LinkedList<>();
		check[sr][sc] = 0;
		q.add(new Dot(sr,sc));
		
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			if(r==fr && c==fc) {
				return check[r][c];
			}
			for(int dir=0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=101 || nc>=101) continue;
				if(map[nr][nc] && find(nr,nc) && check[nr][nc]==-1) {
					check[nr][nc] = check[r][c]+1;
					q.add(new Dot(nr,nc));
				}
			}
		}
		return 0;
	}
	private static boolean find(int r, int c) { // 모서리인지 판단
		for(int dir=0; dir<8; dir++) {
			int nr = r + ddr[dir];
			int nc = c + ddc[dir];
			if(!map[nr][nc]) return true; // 가장자리라면 true return
		}
		return false;
	}
}
