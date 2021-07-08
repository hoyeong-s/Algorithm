package cs1;

import java.io.*;
import java.util.*;

public class back_20364 {
	static int N,Q;
	static HashSet<Integer> hash = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
								
		for(int i=0; i<Q; i++) {
			int e = Integer.parseInt(br.readLine());
			sb.append(go(e)+"\n");
		}
		System.out.println(sb);
	}
	
	private static int go(int e) {
		int dest = e;
		int tmp = 0;
		while(dest>1) {
			if(hash.contains(dest)) tmp = dest;
			dest = dest/2;
		}
		hash.add(e);
		return tmp;
	}
}
