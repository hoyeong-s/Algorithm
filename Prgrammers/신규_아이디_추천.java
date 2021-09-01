import java.io.*;
import java.util.*;

public class 신규_아이디_추천 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String new_id = "...!@BaT#*..y.abcdefghijklm.";
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		String answer = "";
        String temp = new_id.toLowerCase();

        temp = temp.replaceAll("[^-_.a-z0-9]","");
        System.out.println(temp);
        temp = temp.replaceAll("[.]{2,}",".");
        System.out.println(temp);
        temp = temp.replaceAll("^[.]|[.]$","");
        System.out.println(temp);
        System.out.println(temp.length());
        if(temp.equals(""))
            temp+="a";
        if(temp.length() >=16){
            temp = temp.substring(0,15);
            temp=temp.replaceAll("^[.]|[.]$","");
        }
        if(temp.length()<=2)
            while(temp.length()<3)
                temp+=temp.charAt(temp.length()-1);

        answer=temp;
        return answer;
		
//        StringBuilder sb = new StringBuilder();
//        Queue<Character> q = new LinkedList<Character>();
//        
//        if(new_id.length()==0) return "aaa";
//        
//        new_id = new_id.toLowerCase(); // 1단계
//        int lng = new_id.length();
//        for(int i=0; i<lng; i++) q.add(new_id.charAt(i));
//        
//        while(sb.length()<=14 && !q.isEmpty()) {
//        	char cur = q.poll();
//        	if(Character.isAlphabetic(cur) || Character.isDigit(cur) || cur=='-' || cur=='_' || cur=='.') {
//        	if((sb.length()==0) && cur=='.') continue; // 4단계
//        	if(sb.length() >=1 && sb.charAt(sb.length()-1)=='.' && cur=='.') continue; // 3단계
//        	sb.append(cur);        	
//        	}
//        }
//        
//        if(sb.length()==0) sb.append("a");
//        if(sb.charAt(sb.length()-1)=='.') sb.deleteCharAt(sb.length()-1); // 마지막에 . 이면 삭제
//        if(sb.length()<=2) {
//        	while(sb.length()<3) sb.append(sb.charAt(sb.length()-1)); // 7단계
//        }
//        
//        return sb.toString();
    }
	
}
