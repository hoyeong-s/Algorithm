package KAKAO_BLIND_RECRUITMENT_2021;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;


public class 메뉴_리뉴얼 {
	static int [] max;
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		String [] orders = {"XYZ", "XWY", "WXA"};
		int [] course = {2,3,4};
		solution(orders,course);
	}
	
	public static String[] solution(String[] orders, int[] course) {
		ArrayList<String> list = new ArrayList<>();
		
        String[] answer;
        
        max = new int [course[course.length-1]+1];
        
        outloop:for(int i=0; i<orders.length; i++) {
        	String str = orders[i];
        	char[] arr = str.toCharArray();
        	Arrays.sort(arr);
        	
        	for(int j=0; j<course.length; j++) {
        		if(str.length()<course[j]) continue outloop;
        		comb(0,new int [course[j]],0,arr);
        	}
        }
        
        for(Entry<String, Integer> m : map.entrySet()) {
        	String str = m.getKey();
        	int num = m.getValue();
        	if(num==max[str.length()]) list.add(str);
        }
        
        Collections.sort(list);
        
        answer = new String [list.size()];
        for(int i = 0; i<list.size(); i++)
        	answer[i] = list.get(i);
        
        return answer;
    }
	
	private static void comb(int start, int [] check, int cnt, char [] order) { // 조합
		if(cnt==check.length) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<check.length; i++)
				sb.append(order[check[i]]);
			
			input(sb.toString());
			return;
		}
		
		for(int i=start; i<order.length; i++) {
			check[cnt] = i;
			comb(i+1,check,cnt+1,order);
		}
	}
	
	private static void input(String str) {
		if(map.containsKey(str)) {
			map.put(str, map.get(str)+1);
			max[str.length()] = Math.max(max[str.length()],map.get(str));
		}
		else map.put(str, 1);
	}
}

// 1. order 별로 조합 만들기 (course 숫자 별로)
// 2. map에 존재한다면 ++ , 없다면 추가

