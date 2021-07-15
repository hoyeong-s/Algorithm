package cs1;

import java.io.*;
import java.util.*;

class b_1662{
	int leg;
	char last;
	
	public b_1662(int leg, char last) {
		super();
		this.leg = leg;
		this.last = last;
	}
}
public class back_1662 {
	static Stack<b_1662> stack = new Stack<>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==')') {
				int cnt=0, ln=0;
				while(stack.peek().last!='(') {
					b_1662 b = stack.pop();
					if(ln==0) ln = b.last-'0';
					cnt += b.leg;
				}
				stack.pop();
				int num = stack.pop().last-'0';
				stack.push(new b_1662(cnt*num,(char)ln));
			}
			else stack.push(new b_1662(1, str.charAt(i)));
		}
		int result=0;
		while(!stack.isEmpty()) result+=stack.pop().leg;
		System.out.println(result);
	}

}
