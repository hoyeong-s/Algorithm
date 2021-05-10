package week1;

import java.io.*;
import java.util.*;

public class back_11279 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(pq.isEmpty()) sb.append(0+"\n");
				else sb.append(pq.poll()+"\n");
			}
			else pq.add(num);
		}
		
		System.out.println(sb);
	}

}
