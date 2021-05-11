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
	
	for(int i=1; i<=N; i++) {
		q.add(i);
	}
	sb.append("<");
	while(!q.isEmpty()) {
		for(int i=0; i<K-1; i++) {
			q.add(q.poll());
		}
		sb.append(q.poll());
		if(q.isEmpty()) break; 
		sb.append(", ");
	}
	sb.append(">");
	System.out.println(sb.toString());
	}
}
