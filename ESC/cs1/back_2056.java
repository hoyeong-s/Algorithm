package cs1;

import java.io.*;
import java.util.*;

public class back_2056 {
	static int N,max;
	static int [] time;
	static ArrayList<Integer> start = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		time = new int [N+1];
			
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int num = 0, mm = 0;
			
			int n = Integer.parseInt(st.nextToken());
			for(int j=0; j<n; j++) {
				num = Integer.parseInt(st.nextToken());
				mm = Math.max(mm, time[num]);
			}

			time[i] = mm + t;
			max = Math.max(max, time[i]);
		}
		
		System.out.println(max);
		
	}

}
