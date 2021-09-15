import java.util.*;
import java.io.*;

public class september_week7 {
	static HashMap<Integer, Integer> hash = new HashMap<>();
	
	public static void main(String[] args) {
		int [] enter = {1,4,2,3};
		int [] leave = {2,1,3,4};
		solution(enter,leave);
	}
	public static int[] solution(int[] enter, int[] leave) {
		int[] answer = new int [enter.length];
        
		answer = find(answer,enter,leave);
		
        return answer;
    }
	
	private static int []  find(int [] answer, int [] enter, int [] leave) {
		int in=0, out=0;
		
		while (in <= enter.length) {
			if(in==enter.length && hash.size()==0) break;
			while (!hash.containsKey(leave[out])) { // 퇴실이 나올 때까지 넣어주기
				hash.put(enter[in++], 0);
			}
			hash.remove(leave[out]);
			answer[leave[out]-1] += hash.size();
			hash.forEach((key,value)->{
				answer[key-1]++;
			});
			out++;
		}
		return answer;
	}
}