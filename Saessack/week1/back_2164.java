package week1;

import java.io.*;
import java.util.*;

public class back_2164 {
	static int N;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=N; i++)
			q.add(i);
		
		while(q.size()!=1) {
			q.poll();
			q.add(q.poll());
		}
		
		System.out.println(q.poll());
	}

}
