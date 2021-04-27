package String;

import java.util.*;
import java.io.*;

public class back_9935 {
	static int N,B;
	static String str, bomb;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		str = br.readLine();
		bomb = br.readLine();
		
		N = str.length();
		B = bomb.length();
				
		find();
		
		if(sb.length()==0) {
			System.out.println("FRULA");
		}
		else System.out.println(sb);
	}
	private static void find() {
		outloop:for(int i=0; i<N; i++) {
			sb.append(str.charAt(i));
			if(sb.charAt(sb.length()-1) == bomb.charAt(B-1)) { // 폭발 문자일 가능성
				if(sb.length()<B) continue;
				for(int j=0; j<B; j++) {
					if(sb.charAt(sb.length()-B+j)!=bomb.charAt(j)) continue outloop;
				}
				sb.delete(sb.length()-B, sb.length());
			}
		}
	}
}

