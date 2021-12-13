package KAKAO_BLIND_RECRUITMENT_2021;

import java.util.*;
import java.util.*;

public class 순위검색 {
	static HashMap<String, ArrayList<Integer>> map = new HashMap<>(); 
	
	public static void main(String[] args) {
		String [] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
		String [] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
		solution(info,query);
	}
	
	public static int[] solution(String[] info, String[] query) {
        int[] answer = new int [query.length];
        int cnt = 0;
        
        for(int i=0; i<info.length; i++) {
        	make(split(info[i]));
        }
        
        map.forEach((str,score)->{ // score만 다르고 동일한 query가 여러번 나올 수 있으므로 전체 소팅을 하는것이 이득
        	Collections.sort(score);
        });
        
        for(int i=0; i<query.length; i++) {
        	answer[cnt++] = find(query[i]);
        }
        return answer;
    }
	
	private static void make(String [] arr) {
		for(int i=0; i<(1<<4); i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<4; j++) {
				if((i&1<<j) !=0) sb.append("-");
				else sb.append(arr[j]);
			}
			if(map.containsKey(sb.toString())) {
				map.get(sb.toString()).add(Integer.parseInt(arr[4]));
			}
			else {
				ArrayList<Integer> list = new ArrayList<>();
				list.add(Integer.parseInt(arr[4]));
				map.put(sb.toString(), list);
			}
		}
	}
	
	private static String [] split(String info) {
		StringTokenizer st = new StringTokenizer(info);
		String [] arr = new String[5];
		
		int cnt = 0;
		while(st.hasMoreElements()) {
			arr[cnt++] = st.nextToken();
		}
		
		return arr;
	}
	
	private static int find(String query) {
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(query);
		
		for(int i=0; i<7; i++) {
			String str = st.nextToken();
			if(str.equals("and")) continue;
			else sb.append(str);
		}
		
		int score = Integer.parseInt(st.nextToken());
		
		if(map.containsKey(sb.toString())) return find1(map.get(sb.toString()),score);
		else return 0;
		
	}
	
	private static int find1(ArrayList<Integer> list, int score) {
		
		//Collections.sort(list); // score만 다르고 동일한 query가 여러번 나올 수 있으므로 전체 소팅을 하는것이 이득
				
		int low = 0;
		int high = list.size()-1;
		
		while(low<=high) {
			int mid = (low+high)/2;
			if(list.get(mid)<score) {
				low = mid+1;
			}else {
				high = mid-1;
			}
		}
		
		return list.size()-low;
	}
}
