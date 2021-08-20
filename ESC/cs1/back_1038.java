package cs1;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class back_1038 {
	static int N;
	static Queue<Long> q = new LinkedList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		if(N<10) System.out.println(N);
		else {
			int cnt=0;
			for(int i=1; i<10; i++) q.add((long) i); // 초기설정
			while(true) {
				long num = q.poll();
				cnt++;
				if(N<=cnt || num==-1) {
					System.out.println(num);
					break;
				}
				make(num);
			}
				
		}
	}
	private static void make(Long num) {
		Long last = num % 10;
		num = num * 10;
		if(num > 9876543210L) {
			q.add((long) -1);
			return;
		}
		for(int i=0; i<last; i++)
			q.add(num+i);
	}
}
