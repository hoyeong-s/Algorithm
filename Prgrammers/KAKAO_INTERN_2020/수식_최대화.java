package KAKAO_INTERN_2020;

import java.io.*;
import java.util.*;

public class 수식_최대화 {
	static char [] arr = {'*','+','-'};
	static ArrayList<Long> list1 = new ArrayList<>();
	static ArrayList<Character> list2 = new ArrayList<>();
	static Long max = 0L;
	
	public static void main(String[] args) {
		String e ="0-63";
		solution(e);
	}
	
	public static long solution(String expression) {
        long answer = 0;
        
        int idx = 0;
        for(int i=0; i<expression.length(); i++) {
        	if(!Character.isDigit(expression.charAt(i))) {
        		list2.add(expression.charAt(i));
        		
        		StringBuilder sb = new StringBuilder();
        		for(int j=idx; j<i; j++) 
            		sb.append(expression.charAt(j));
            	
        		idx = i+1;
        		list1.add(Long.parseLong(sb.toString()));
        	}
        }
        
		StringBuilder sb = new StringBuilder();
        for(int j=idx; j<expression.length(); j++) 
    		sb.append(expression.charAt(j));
		list1.add(Long.parseLong(sb.toString()));
		
		makePermutation(0, new char[3], new boolean[3]);
        
        return max;
    }
	
	private static void makePermutation(int select, char [] save, boolean[] flag) {
		if(select==3) {
			fast(save);
			return;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(!flag[i]) {
				flag[i]=true;
				save[select]=arr[i];
				makePermutation(select+1, save, flag);
				flag[i]=false;
			}
		}
	}
	
	private static void fast(char [] save) {
		Long [] number = new Long [list1.size()];
		for(int i=0; i<list1.size(); i++) number[i] = list1.get(i);
		
		Queue<Character> q = new LinkedList<Character>();
		for(int i=0; i<list2.size(); i++) q.add(list2.get(i));
		
		for(int i=0; i<3; i++) {
			char c = save[i];
			int s = 0;
			int e = 1;
			while(!q.isEmpty() && e<number.length) {
				if(number[s]==0L) while(number[s]==0L) s++;
				if(s==e) e++;
				if(number[e]==0L) while(e<number.length && number[e]==0L) e++;
				
				char tc = q.poll();
				if(tc==c) {
					Long a = number[s];
					Long b = number[e];
					number[s] = cal(a,b,c);
					number[e] = 0L;
				}else {
					q.add(tc);
					s++;
				}
				e++;
			}
		}
		
		max = Math.max(max, Math.abs(number[0]));
	}
	
	private static long cal(Long a, Long b , char c) {
		if(c=='+') return a+b;
		else if(c=='-') return a-b;
		else return a*b;
	}
}
