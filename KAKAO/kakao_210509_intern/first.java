package kakao_210509_intern;

import java.util.*;
import java.io.*;

public class first {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2three45sixseven";
		System.out.println(solution(s));
	}
	
	 public static int solution(String s) {
	        int answer = 0;
	        StringBuilder sb = new StringBuilder();
	        
	        int idx=0;
	        while(idx!=s.length()) {
	        	char a = s.charAt(idx);
			if (Character.isAlphabetic(a)) {
				switch (a) {
				case 'z': {
					sb.append(0);
					idx += 4;
					break;
				}
				case 'o': {
					sb.append(1);
					idx+=3;
					break;
				}
				case 't': {
					if(s.charAt(idx+1)=='w') {
						sb.append(2);
						idx+=3;
					}
					else if(s.charAt(idx+1)=='h') {
						sb.append(3);
						idx+=5;
					}
					break;
				}
				case 'f': {
					if(s.charAt(idx+1)=='o') {
						sb.append(4);
					}
					else if(s.charAt(idx+1)=='i') {
						sb.append(5);
					}
					idx+=4;
					break;
				}
				case 's': {
					if(s.charAt(idx+1)=='i') {
						sb.append(6);
						idx+=3;
					}
					else if(s.charAt(idx+1)=='e') {
						sb.append(7);
						idx+=5;
					}
					break;
				}
				case 'e': {
					sb.append(8);
					idx+=5;
					break;
				}
				case 'n': {
					sb.append(9);
					idx+=4;
					break;
				}
				}
			}
			else {
				sb.append(a);
				idx++;
			}
	     }
	     answer = Integer.parseInt(sb.toString());
	        return answer;
	 }
		 
}
