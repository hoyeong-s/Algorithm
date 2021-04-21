package divideNconquer;

import java.util.*;
import java.io.*;

public class back_2447 {
	static int N;
	static char [][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new char [N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				star(i, j, N/3);
			}
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	private static void star(int r, int c, int n) {
		if((r/n)%3==1 && (c/n)%3==1) map[r][c]=' ';
		else {
			if(n/3==0) map[r][c]='*';
			else star(r,c,n/3);
		}
	}

}


