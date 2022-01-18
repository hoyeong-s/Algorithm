package KAKAO_BLIND_RECRUITMENT_2022;

import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    static HashMap<Integer, Integer> map = new HashMap<>(); 
    static int [] save = new int [10000];
    static int base_t, base_f, per_t, per_f;
    
    public int[] solution(int[] fees, String[] records) {
        base_t = fees[0];       
        base_f = fees[1];
        per_t = fees[2];
        per_f = fees[3];
        
        for(int i=0; i<records.length; i++){
            StringTokenizer st = new StringTokenizer(records[i],":| ");
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            int num = Integer.parseInt(st.nextToken());
            String io = st.nextToken();
            int time = h*60 + m;
            
            set.add(num);
            
            if(io.equals("IN")){
                map.put(num,time);
            }else{
                save[num] += time-map.get(num);
                map.remove(num);
            }
        }
        
        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
			int num = m.getKey();
            save[num] += (1439 - m.getValue());
		}
        int idx = 0;
        int [] answer = new int [set.size()];
        
        for(int i=0; i<10000; i++){
            if(save[i]!=0)
                answer[idx++] = calc(save[i]);
        }
        return answer;
    }
    private static int calc (int time){
        if(time<=base_t) return base_f;
        
        int fee = base_f;
        double t = (double)(time-base_t) / (double)per_t;
        
        fee +=  Math.ceil(t) * per_f;
        
        return fee;
    }
}