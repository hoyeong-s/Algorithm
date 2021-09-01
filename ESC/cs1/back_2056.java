package cs1;

import java.io.*;
import java.util.*;

public class back_2056 {
	static int N;
	static int [] time;
	static ArrayList<Integer> [] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		time = new int [N+1];
	
		list = new ArrayList[N+1];
		for(int i=1; i<=N; i++)
			list[i] = new ArrayList<>();
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			for(int j=0; j<n; j++) {
				int num = Integer.parseInt(st.nextToken());
				list[i].add(num);
			}
		}
		
		
	}

}
