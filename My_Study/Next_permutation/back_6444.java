package Next_permutation;

import java.util.*;
import java.io.*;

public class back_6444 {
	static int N;
    static int [] n;
	static PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [] numbers = {6,10,2};
		solution(numbers);
	}
	public static String solution(int[] numbers) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        n = numbers;
        
        do{
            sb = new StringBuilder();
            for(int i=0; i<n.length; i++) sb.append(n[i]);
            pq.add(sb.toString());
        }while(np());
        
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
        return answer;
    }
    private static boolean np(){
        int i = n.length-1;
        while(i>0 && n[i-1]>=n[i]) --i;
        if(i==0) return false;
        
        int j = n.length-1;
        while(n[i-1]>=n[j]) --j;
        
        swap(i-1,j);
        
        int k = n.length-1;
        while(i<k){
            swap(i++,k--);
        }
        return true;
    }
    
    private static void swap(int i, int j){
        int cur = n[i];
        n[i] = n[j];
        n[j] = cur;
    }
}
