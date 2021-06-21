package Simulation;
import java.io.*;
import java.util.*;

public class back_14499 {
	static int N,M,X,Y,K;
	static int [][] map;
	static int [] dice = new int [7];
	static int [] dr = {0,0,0,-1,1};
	static int [] dc = {0,1,-1,0,0};
	static Queue<Integer> q = new LinkedList<Integer>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++)
			q.add(Integer.parseInt(st.nextToken()));
		
		make();
		System.out.println(sb);
		
	}
	private static void make() {
		int r = X;
		int c = Y;
		while(!q.isEmpty()) {
			int dir = q.poll();
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
			change(dir);
			
			if(map[nr][nc]==0) {
				map[nr][nc] = dice[6];
			}else {
				dice[6] = map[nr][nc];
				map[nr][nc]=0;
			}
			sb.append(dice[1]+"\n");
			r = nr;
			c = nc;
		}
	}
	private static void change(int dir) {
		int [] copy = dice.clone();
		switch(dir) {
		case 1:{
			dice[1] = copy[4];
			dice[3] = copy[1];
			dice[4] = copy[6];
			dice[6] = copy[3];
			break;
		}
		case 2:{
			dice[1] = copy[3];
			dice[3] = copy[6];
			dice[4] = copy[1];
			dice[6] = copy[4];
			break;
		}
		case 3:{
			dice[1] = copy[5];
			dice[2] = copy[1];
			dice[5] = copy[6];
			dice[6] = copy[2];
			break;
		}
		case 4:{
			dice[1] = copy[2];
			dice[2] = copy[6];
			dice[5] = copy[1];
			dice[6] = copy[5];
			break;
		}
		}
	}
}
