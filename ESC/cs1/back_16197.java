package cs1;

import java.io.*;
import java.util.*;

class b_16197{
	int r1,c1,r2,c2;

	public b_16197(int r1, int c1, int r2, int c2) {
		super();
		this.r1 = r1;
		this.c1 = c1;
		this.r2 = r2;
		this.c2 = c2;
	}
}
public class back_16197 {
	static int N,M,result,r1=-1,r2,c1,c2;
	static char [][] map;
	static int [][][] visited;
	final static int [] dr = {0,0,-1,1};
	final static int [] dc = {-1,1,0,0};
	static Queue<b_16197> q = new LinkedList<b_16197>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new int[N][M][2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				char a = str.charAt(j);
				map[i][j] = a;
				if(a=='o') { // 최초 o의 위치 설정
					if(r1==-1) {
						r1 = i;
						c1 = j;
					}else {
						r2=i;
						c2=j;
					}
				}
			}
		}
		
		visited[r1][c1][0] = 1; // 최초 위치 visited
		visited[r2][c2][1] = 1;
		q.add(new b_16197(r1, c1, r2, c2));
		move();
	
	}
	private static void move() {
		
		while(!q.isEmpty()) {
			b_16197 b = q.poll();
			int r1 = b.r1;
			int c1 = b.c1;
			int r2 = b.r2;
			int c2 = b.c2;
			
			for(int dir=0; dir<4; dir++) {
				int cnt = 0;
				
				int nr1 = r1 + dr[dir];
				int nc1 = c1 + dc[dir];
				int nr2 = r2 + dr[dir];
				int nc2 = c2 + dc[dir];
				
				if(nr1<0 || nc1<0 || nr1>=N || nc1>=M) cnt++; // 첫번째 동전이 떨어진 경우
				if(nr2<0 || nc2<0 || nr2>=N || nc2>=M) cnt++; // 두번째 동전이 떨어진 경우
				
				if(cnt==0 && visited[nr1][nc1][0]<0) {
					
				}
			}
		}
	}
}
