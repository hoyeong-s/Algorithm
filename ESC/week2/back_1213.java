package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class back_1213 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Character> q = new LinkedList<>();
		Stack<Character> stack = new Stack<>();		
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		char [] save = new char[str.length()];
		int len = str.length();
		
		
		for(int i=0; i<len; i++)
			save[i] = str.charAt(i);
		
		Arrays.sort(save);
		if(len==1) {
			System.out.println(save[0]);
			System.exit(0);
		}
		if (len % 2 == 0) { // 짝수일 때 모든 글자가 짝수여야함
			for (int i = 0; i < len-1; ) {
				if(save[i] != save[i+1]) { // 팰린드롭이 안될 때
					System.out.println("I'm Sorry Hansoo");
					System.exit(0);
				}
				q.add(save[i]);
				stack.add(save[i]);
				i = i+2;
			}
			for(int i=0; i<len/2; i++) {
				sb.append(q.poll());
			}
			for(int i=0; i<len/2; i++) {
				sb.append(stack.pop());
			}
		}
		else {
			char check =  '\u0000';
			for (int i = 0; i < len-1; ) {
				if(save[i] != save[i+1]) {// 팰린드롭이 안될 때
					if(check == '\u0000') {
						check = save[i];
						i++;
						continue;
					}
					else {
					System.out.println("I'm Sorry Hansoo");
					System.exit(0);
					}
				}
				q.add(save[i]);
				stack.add(save[i]);
				if(i==len-3) check = save[len-1];
				i = i+2;
			}
			for(int i=0; i<len/2; i++) {
				sb.append(q.poll());
			}
			sb.append(check);
			for(int i=0; i<len/2; i++) {
				sb.append(stack.pop());
			}
		}
		System.out.println(sb);
	}

}
