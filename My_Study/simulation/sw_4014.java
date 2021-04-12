package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_4014 {
	static int N,X;
	static int [][] map,map2;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int [N][N]; // 한 행씩 받아오기 위해 2개 배열 설정
			map2 = new int [N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n; 
					map2[j][i] = n;
				}
			}
			
			int cnt=0;
			for(int i=0; i<N; i++) {
				if(move(map[i])) cnt++;
				if(move(map2[i])) cnt++;
			}
			sb.append("#"+t+" "+cnt+"\n");
		}
		System.out.println(sb);
	}
	private static boolean move(int [] map) {
		boolean [] visited = new boolean[N]; // 활주로 설치 배열
		
		for(int i=0; i<N-1; i++) {
			if(Math.abs(map[i]-map[i+1]) >=2) return false; // 차이가 2 이상인 경우 false
			
			else if(map[i]-map[i+1]==1) { // 내려오는것
				for(int j=i+1; j<i+X; j++) {
					if(j >= N-1) return false; // X개를 만족하지 못하는 경우
					if(map[j]!=map[j+1]) return false; // 차이가 나는 칸부터 X개 동안 모두 높이가 같이야함
				}
				for(int j=i+1; j<=i+X; j++) {
					visited[j] = true; // 활주로 설치
				}
			}
		}
		
		for(int i=N-1; i>0; i--) {
			if(map[i]-map[i-1]==1) { // 올라가는것
				for(int j=i-1; j>i-X; j--) {
					if(j <= 0) return false; // X개를 만족하지 못하는 경우
					if(map[j]!=map[j-1]) return false; // 차이가 나는 칸부터 X개 동안 모두 높이가 같이야함
				}
				for(int j=i-1; j>=i-X; j--) {
					if(visited[j]) return false; // 이미 활주로가 있는 경우는 설치 불가
				}
			}
		}
		return true; // 활주로 가능
	}
}
