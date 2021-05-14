package week7;

import java.io.*;
import java.util.*;

public class back_1715 {
	static int N;
	static PriorityQueue<Long> pq = new PriorityQueue<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++)
			pq.add(Long.parseLong(br.readLine()));
		
		long sum = 0, result=0;
		if(N>=2) {
			while(pq.size()!=1) {
			long num1 = pq.poll();
			long num2 = pq.poll();
			sum = num1 + num2;
			result += sum;
			pq.add(sum);
			}
		}
		
		System.out.println(result);
	}

}
