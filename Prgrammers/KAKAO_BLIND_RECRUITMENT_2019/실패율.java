package KAKAO_BLIND_RECRUITMENT_2019;

import java.util.*;
import java.util.Map.Entry;

public class 실패율 {
	static HashMap<Integer,Double> map = new HashMap<>();
	
	public static void main(String[] args) {
		int [] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		solution(5,stages);
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int [N];
        
        double sum = (double)stages.length;
        double [] check = new double [N+1];
        for(int k : stages) {
        	if(k<=N) check[k]++;
        }
                 
        for(int i=1; i<=N; i++) {
        	double k = check[i] / sum;
        	sum -= check[i];
        	map.put(i,k);
        }
        
        List<Map.Entry<Integer, Double>> entrylist = new LinkedList<>(map.entrySet());
        entrylist.sort(new Comparator<Map.Entry<Integer, Double>>() {
			@Override
			public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
				if(o1.getValue()>o2.getValue()) return -1;
				else if(o1.getValue()<o2.getValue()) return 1;
				else return o1.getKey()-o2.getKey();
			} 	
		});
        
        int idx=0;
        for(Map.Entry<Integer, Double> entry : entrylist) {
        	answer[idx++] =  entry.getKey();
        }
        	
        return answer;
    }
}
