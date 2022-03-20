package KAKAO_INTERN_WINTER_2019;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class 튜플 {
	
	public static void main(String[] args) {
		String s = "{{20,111},{111}}";
		solution(s);
	}
	
	public static int[] solution(String s) {
		HashMap<Integer,Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(s,"{}");
		
        while(st.hasMoreTokens()) {
        	String ele = st.nextToken();
        	if(ele.equals(",")) continue;
        	
        	StringTokenizer stt = new StringTokenizer(ele,",");
        	
        	while(stt.hasMoreTokens()) {
        		int c = Integer.parseInt(stt.nextToken());
        		if(map.containsKey(c)) map.put(c, map.get(c)+1);
        		else map.put(c, 1);
        	}
        }
        
        List<Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Entry<Integer,Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue()-o1.getValue();
			}
		});
        
        int [] answer = new int [map.size()];
        for(int i=0; i<list.size(); i++)
        	answer[i] = list.get(i).getKey();
        
        return answer;
    }
}
