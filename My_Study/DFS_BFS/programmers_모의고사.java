package DFS_BFS;

import java.io.*;
import java.util.*;

public class programmers_모의고사 {

	public static void main(String[] args) {

	}
	public static int[] solution(int[] answers) {
        int [] A = {1,2,3,4,5};
        int [] B = {2,1,2,3,2,4,2,5};
        int [] C = {3,3,1,1,2,2,4,4,5,5};
        
        int cnt_a=0, cnt_b=0, cnt_c=0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i]==A[i % A.length]) 
            	cnt_a++;
            if(answers[i]==B[i % B.length]) 
            	cnt_b++;
            if(answers[i]==C[i % C.length]) 
            	cnt_c++;
        }
        
        int max = Math.max(cnt_a, cnt_b);
        max = Math.max(max, cnt_c);

        int cnt = 0;
        if(max == cnt_a) cnt++;
        if(max == cnt_b) cnt++;
        if(max == cnt_c) cnt++;
        
        int idx = 0;
        int [] answer = new int [cnt];
        if(max == cnt_a) answer[idx++] = 1;
        if(max == cnt_b) answer[idx++] = 2;
        if(max == cnt_c) answer[idx++] = 3;
        
        return answer;
    }
}
