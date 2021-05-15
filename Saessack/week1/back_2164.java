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
		
		while(q.size()!=1) { // 1장 남을 때 까지
			q.poll(); // 맨 윗 카드 버림
			q.add(q.poll()); // 맨 윗카드 아래로 옮김
		}
		
		System.out.println(q.poll());
	}

}
