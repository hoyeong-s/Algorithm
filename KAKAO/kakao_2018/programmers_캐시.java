package kakao_2018;

import java.util.*;

public class programmers_캐시 {

	public static void main(String[] args) {		
		// TODO Auto-generated method stub
		int cacheSize = 0;
		String [] cities = {"s","a","s"};
		System.out.println(solution(cacheSize, cities));
	}
    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
                
        LinkedHashMap<String, Integer> hash = new LinkedHashMap<String, Integer>() {
        	@Override
        	protected boolean removeEldestEntry(Map.Entry<String,Integer> eldest) {
        		return size() >cacheSize;
        	}
        };
        
        answer = find(cacheSize, hash ,cities);
        return answer;
    }
	
   static int find(int size, LinkedHashMap<String, Integer> hash, String [] cities) {
	   int sum=0;
	   for(int i=0; i<cities.length; i++) {
		   String city = cities[i].toLowerCase();
		   if(hash.containsKey(city)) { // hit
			   hash.remove(city);
			   sum+=1;
		   }
		   else sum+=5;
		   
		   hash.put(city, i);
	   }
	   return sum;
   }
}
