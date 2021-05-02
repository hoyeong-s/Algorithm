package week5;

import java.io.*;
import java.util.*;

public class back_1780 {
	static int N;
	static int [] result;
	static int [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int [N][N];
		result = new int [3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		devide(0,0,N);
		for(int x : result)
			sb.append(x+"\n");
		System.out.println(sb);
	}

	private static void devide(int r, int c, int size) {
		if(check(r,c,size)) {
			result[map[r][c]+1]++;
		}
		
		else{
			int ss = size/3;
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					devide(r+(i*ss),c+(j*ss),ss);
				}
			}
		}
	}
	
	private static boolean check(int r, int c, int size) {
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(map[i][j]!=map[r][c]) return false;
			}
		}
		return true;
	}
}
