package cs1;

import java.io.*;
import java.util.*;

public class back_2346 {
	static int N;
	static int [] balloon;
	static Deque<Integer> d = new ArrayDeque<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		balloon = new int [N+1] ;
		
		if(N==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		for(int i=1; i<=N; i++)
			d.add(i);
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++) {
			balloon[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = 1;
		while(true) {
			sb.append(d.poll()+" ");
			if(d.isEmpty()) break;
			
			int k = balloon[num];
			if(k>0) {
				for(int i=0; i<k-1; i++) {
					d.add(d.poll());
				}
			}
			else {
				for(int i=0; i<Math.abs(k); i++) {
					d.addFirst(d.pollLast());
				}
			}
			
			num = d.peek();
		}
		System.out.println(sb);
	}
}
