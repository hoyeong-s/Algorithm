import java.io.*;
import java.util.*;

public class 로또의_최고_순위와_최저_순위 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] lottos = {45, 4, 35, 20, 3, 9};
		int [] win_nums = {20, 9, 3, 45, 4, 35};
		System.out.println(solution(lottos, win_nums).toString());
		
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0, cnt=0;
        
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i]==0) {
        		zero++;
        		continue;
        	}
        	else {
        		for(int x: win_nums) 
        			if(x == lottos[i]) cnt++;
        	}
        }
        
        int max = 7-(cnt + zero);
        int min = 7-cnt;
        if(max>=6) max = 6;
        if(min>=6) min = 6;
        int [] answer = {max,min};
        
        return answer;
    }

}
