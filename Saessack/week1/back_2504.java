package week1;

import java.io.*;
import java.util.*;

public class back_2504 {
	static Stack<Character> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		// 2(2+3x3)+2x3 >> (2x2 + 2x3x3) + 2x3
		// (()[[]])([]) >> (()) ([[]]) ([])
		int sum=0, save=1;
		for(int i=0; i<str.length(); i++) {
			char a = str.charAt(i);
			if(a=='(') {
				save *= 2;
				stack.add(a);
			}
			else if(a=='[') {
				save*=3;
				stack.add(a);
			}
			else if(a==')' || a==']'){
				if(stack.isEmpty()) { // stack이 비어있는 상태에서 닫는다면 틀린 괄호
					System.out.println(0);
					System.exit(0);
				}
				if(a==')') {
					if(stack.peek()=='[') { // 닫는 괄호가 다르다면 틀린 괄호
						System.out.println(0);
						System.exit(0);
					}
					if(str.charAt(i-1)=='(') { // 괄호를 처음 닫을때 모든 곱셈 결과를 다 해준다
						sum+=save;
					}
					stack.pop(); // stack을 pop
					save /= 2; // 괄호가 사라졌으므로 save 감소
				}
				else if(a==']') {
					if(stack.peek()=='(') { // 닫는 괄호가 다르다면 틀린 괄호
						System.out.println(0);
						System.exit(0);
					}
					if(str.charAt(i-1)=='[') {
						sum+=save;
					}
					stack.pop();
					save /= 3;
				}
			}
		}
		if(!stack.isEmpty()) sum=0; // 연산 후에도 stack에 남아있다면 들린 괄호
		System.out.println(sum);
			
	}

}
