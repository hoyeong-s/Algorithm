package week1;

import java.io.*;
import java.util.*;

public class back_1158 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	Queue<Integer> q = new LinkedList<>();
	StringBuilder sb = new StringBuilder();
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken());
	int K = Integer.parseInt(st.nextToken());
	
	for(int i=1; i<=N; i++) { // 1~N 까지 수를 큐에 넣음
		q.add(i);
	}
	
	sb.append("<");
	while(!q.isEmpty()) { // q가 빌때 까지
		for(int i=0; i<K-1; i++) { // K번째 사람을 제거해야 하므로 K-1까지 순환
			q.add(q.poll()); 
		}
		sb.append(q.poll()); // K번째 사람
		if(q.isEmpty()) break;  // 마지막 ,를 넣지 않기 위한 break 문
		sb.append(", ");
	}
	sb.append(">");
	System.out.println(sb.toString());
	}
}
