package KAKAO_INTERN_2021;

import java.util.HashMap;

public class 숫자_문자열과_영단어 {
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {

	}
	public static int solution(String s) {
        int answer = 0;
        
        StringBuilder sb = new StringBuilder();
        
        String [] digit = {"0","1","2","3","4","5","6","7","8","9"};
        String [] alpa = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        
        for(int i=0; i<10; i++)
        	s = s.replace(alpa[i], digit[i]);
        
        return Integer.parseInt(s);
    }
}

//for(int i=0; i<s.length(); i++) {
//if(Character.isDigit(s.charAt(i))) sb.append(s.charAt(i));
//else {
//	if(s.charAt(i)=='o') {
//		sb.append(1);
//		i = i+2;
//	}
//	else if(s.charAt(i)=='e') {
//		sb.append(8);
//		i = i+4;
//	}
//	else if(s.charAt(i)=='n') {
//		sb.append(9);
//		i = i+3;
//	}
//	else if(s.charAt(i)=='z') {
//		sb.append(0);
//		i = i+3;
//	}
//	else if(s.charAt(i)=='t') {
//		if(s.charAt(i+1)=='w') { // 2
//			sb.append(2);
//			i = i+2;
//		}
//		else { // 3
//			sb.append(3);
//			i = i+4;
//		}	
//	}
//	else if(s.charAt(i)=='f') {
//		if(s.charAt(i+1)=='o') { // 4
//			sb.append(4);
//			i = i+3;
//		}
//		else { // 5
//			sb.append(5);
//			i = i+3;
//		}	
//	}
//	else if(s.charAt(i)=='s') {
//		if(s.charAt(i+1)=='i') { // 6
//			sb.append(6);
//			i = i+2;
//		}
//		else { // 7
//			sb.append(7);
//			i = i+4;
//		}	
//	}
//}
//}
//return Integer.parseInt(sb.toString());