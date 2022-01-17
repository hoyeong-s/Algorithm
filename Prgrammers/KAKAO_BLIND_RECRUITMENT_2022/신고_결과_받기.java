package KAKAO_BLIND_RECRUITMENT_2022;

import java.util.*;

public class 신고_결과_받기 {
	static HashSet<String> set = new HashSet<>();
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, ArrayList<Integer>> map1 = new HashMap<>();
	public static void main(String[] args) {

	}
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int[] result = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i],i);
        }
        
        for(int i=0; i<report.length; i++){
            set.add(report[i]);
        }
        
        StringTokenizer st;
        for(String s : set){
            String r = s;
            st = new StringTokenizer(r);
            String from = st.nextToken();
            String to =  st.nextToken();
            
            int f_i = map.get(from);
            int t_i = map.get(to);
            result[t_i]++;
            
            ArrayList<Integer> list = new ArrayList<>();
            if(map1.containsKey(t_i)) list = map1.get(t_i);
            list.add(f_i);
            map1.put(t_i,list);
        }
        
        for(int i=0; i<result.length; i++){
            if(result[i]>=k){
                ArrayList<Integer> list = map1.get(i);
                for(int j=0; j<list.size(); j++){
                    answer[list.get(j)]++;
                }
            }
        }
        
        return answer;
    }
}
