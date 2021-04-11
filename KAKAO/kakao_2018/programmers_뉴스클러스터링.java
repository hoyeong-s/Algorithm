package kakao_2018;

import java.util.ArrayList;

public class programmers_뉴스클러스터링 {

	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		
		System.out.println(solution(str1,str2));
	}
	
	public static int solution(String str1, String str2) {
		ArrayList<String> list1; 
		ArrayList<String> list2; 
		ArrayList<String> intersection = new ArrayList<>();
		ArrayList<String> union = new ArrayList<>();
		
		list1 = makelist(str1);
		list2 = makelist(str2);

		for(String s : list1) {
			if(list2.remove(s)) { // 집합1에 집합2가 포함된다면 삭제후, 교집합에 추가 
				intersection.add(s);
			}
			union.add(s);
		}
		
		// 합집합 구하기 
		for(String s : list2) { // 교집합에서 제외된 것 뺀 나머지 합집합에 추가 
			union.add(s);
		}
		
		double result=0;
		if(list1.size()==0 && list2.size()==0) result = 1;
		
		else{
			result = (double)intersection.size() / (double)union.size();
		}
		
		return (int)(result * 65536);
	}
	
	static ArrayList<String> makelist(String str1) {
		ArrayList<String> list = new ArrayList<>();
		
		for(int i=0; i<str1.length()-1; i++) {
			
			if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))) {
				list.add(str1.substring(i,i+2).toLowerCase());
			}
		}
		return list;
	}
}
