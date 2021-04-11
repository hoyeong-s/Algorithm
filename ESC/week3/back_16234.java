package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Dot{
	int r,c;

	public Dot(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class back_16234 {
	static int N,L,R;
	static int [][] map;
	static boolean [][] visited;
	static Queue<Dot> q = new LinkedList<>();
	static ArrayList<Dot> list = new ArrayList<>();
	final static int [] dr = {-1,1,0,0};
	final static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int [N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt=0;
		while(true) {
			boolean check = false; // 인구 이동이 있었는지 체크
			
			for(boolean [] row : visited)
				Arrays.fill(row, false);
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(visited[i][j]) continue; // 가본곳은 가지 않음
					if(bfs(i,j)) {
						check = true; 
					}
				}
			}
			if(!check) break;
			else cnt++;
		}
		System.out.println(cnt);
	}
	private static boolean bfs(int i, int j) {
		list.clear();
		q.clear();
				
		int sum=0;
		visited[i][j] = true;
		q.add(new Dot(i,j));
		
		while(!q.isEmpty()) { 
			Dot d = q.poll();
			int r = d.r;
			int c = d.c;
			for(int dir =0; dir<4; dir++) {
				int nr = r + dr[dir];
				int nc = c + dc[dir];
				if(nr<0 || nc<0 || nr>=N || nc>=N) continue;
				int cur = map[r][c];
				int next = map[nr][nc];
				if(!visited[nr][nc] && Math.abs(cur-next)>=L && Math.abs(cur-next)<=R) {
					sum += map[nr][nc];
					visited[nr][nc] = true;
					q.add(new Dot(nr,nc));
					list.add(new Dot(nr,nc));
				}
			}
		}
		
		if(sum!=0) {
			sum += map[i][j]; // 최초 들어온 위치 값을 더해줌
			int man = sum / (list.size()+1); // 리스트에는 최초 들어온 값이 안들어있으므로 갯수를 하나 더해줌
			map[i][j] = man;
			for(Dot d : list)
				map[d.r][d.c] = man;
			return true;
		}
		return false;
	}
}
