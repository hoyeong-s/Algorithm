package KAKAO_BLIND_RECRUITMENT_2021;

import java.util.*;
import java.util.*;

public class 순위검색 {
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		String [] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String [] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		solution(info,query);
	}
	
	public static int[] solution(String[] info, String[] query) {
        int[] answer = {  };
        
        for(int i=0; i<info.length; i++) {
        	list.add(make(info[i]));
        }
        
        Collections.sort(list);
        
        for(int i=0; i<query.length; i++) {
        	find(query[i]);
        }
        return answer;
    }
	
	private static String make(String info) {
		StringTokenizer st = new StringTokenizer(info);
		StringBuilder sb = new StringBuilder();
		
		while(st.hasMoreElements()) {
			String str = st.nextToken();
			if(str.equals("cpp") || str.equals("backend") || str.equals("junior") || str.equals("chicken")) {
				sb.append("A");
			}
			else if(str.equals("java") || str.equals("frontend") || str.equals("senior") || str.equals("pizza")) {
				sb.append("B");
			}
			else if(str.equals("python")) {
				sb.append("C");
			}
			else sb.append(str);
		}
		
		return sb.toString();
	}
	
	private static void find (String query) {
		StringTokenizer st = new StringTokenizer(query);
		
		while(st.hasMoreElements()) {
			String str = st.nextToken();
			if(str.equals("and")) continue;
			
		}

	}
}
