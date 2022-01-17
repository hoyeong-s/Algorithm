package KAKAO_BLIND_RECRUITMENT_2022;

import java.util.*;

public class k진수에서_소수_개수_구하기 {
	    public int solution(int n, int k) {
	        int answer = 0;
	        
	        String s = change(n,k);
	        StringTokenizer st = new StringTokenizer(s,"0");
	        while(st.hasMoreTokens()){
	            long num = Long.parseLong(st.nextToken());
	            if(isPrime(num)) answer++;
	        }
	        
	        return answer;
	    }
	    
	    private static String change(int n, int k){
	        StringBuilder sb = new StringBuilder();
	        while(n>0){
	            sb.append(n%k);
	            n /= k;
	        }
	        return sb.reverse().toString();
	    }
	    
	    private static boolean isPrime(long num){
	        if(num==1) return false;
	        if(num==2) return true;
	        
	        long sqrt = (long)Math.sqrt(num);  
	        for(int i=2; i<sqrt+1; i++){
	            if(num%i==0) return false;
	        }
	        return true;
	    }
	}