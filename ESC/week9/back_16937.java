package week9;

import java.io.*;
import java.util.*;

public class back_16937 {
	static int H,W,N;
	static int [][] sticker;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		N = Integer.parseInt(br.readLine());
		
		sticker = new int [N*2][3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			sticker[i*2][0] = h;
			sticker[i*2][1] = w;
			sticker[i*2][2] = i;

			sticker[i*2+1][0] = w;
			sticker[i*2+1][1] = h;
			sticker[i*2+1][2] = i;
		}
		
		int result =0;
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				result = Math.max(result,find(i,j));
			}
		}
		
		System.out.println(result);
	}
	private static int find(int s1, int s2) {
		int size = 0;
		
		for(int i=0; i<2; i++) {
			for(int j=0; j<2; j++) {
				if(((sticker[2*s1+i][0] + sticker[2*s2+j][0] <= H) && 
						(sticker[2*s1+i][1] <=W && sticker[2*s2+j][1] <= W))
						||
						((sticker[2*s1+i][1] + sticker[2*s2+j][1] <= W) && 
								(sticker[2*s1+i][0] <=H && sticker[2*s2+j][0] <= H))) {
					int a = sticker[2*s1][0]*sticker[2*s1][1];
					int b = sticker[2*s2][0]*sticker[2*s2][1];
					size = Math.max(size, a+b);
				}
					
			}
		}
		return size;
	}
}
