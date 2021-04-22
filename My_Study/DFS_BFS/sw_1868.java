package DFS_BFS;

import java.io.*;
import java.util.*;

class s_1868{
	int r,c;

	public s_1868(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	
}
public class sw_1868 {
	static int N,result;
	static char [][] map;
	static boolean [][] visited;
	static ArrayList<s_1868> list = new ArrayList<>();
	static Queue<s_1868> q = new LinkedList<>();
	final static int [] dr = {-1,-1,-1,0,0,1,1,1};
	final static int [] dc = {-1,0,1,-1,1,-1,0,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new char [N][N];
			visited = new boolean [N][N];
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j);
					if(map[i][j]=='.') list.add(new s_1868(i, j));
				}
			}
			
			result=0;
			for(int i=0; i<list.size(); i++) {
				s_1868 s = list.get(i);
				int r = s.r;
				int c = s.c;
				if(!visited[r][c] && find(r,c)) { // 0 먼저 터뜨리기
					result++;
					visited[r][c] = true;
					q.clear();
					q.add(new s_1868(r,c));
					bfs();
				}
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]=='.' && !visited[i][j]) result ++;
				}
			}
			sb.append("#"+t+" "+result+"\n");
			list.clear();
			q.clear();
		}
		System.out.println(sb);
	}
	private static void bfs() {
		while(!q.isEmpty()) {
			s_1868 s = q.poll();
			int r = s.r;
			int c = s.c;
			for(int dir=0; dir<8; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				
				if(nr<0 || nc<0 || nr>=N || nc>=N || visited[nr][nc]) continue;
				if(map[nr][nc]=='.') {
					if(find(nr,nc)) q.add(new s_1868(nr, nc));	
					visited[nr][nc] = true;
				}
			}
		}
	}
	
	private static boolean find(int r, int c) {
		for(int dir=0; dir<8; dir++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
			if(map[nr][nc]!='.') return false;
		}
		return true;
	}
}
