package KAKAO_INTERN_2020;

import java.io.*;
import java.util.*;

public class 수식_최대화 {
	static char [] arr = {'*','+','-'};
	static ArrayList<Long> list1 = new ArrayList<>();
	static ArrayList<Character> list2 = new ArrayList<>();
	static Long max = 0L;
	
	public static void main(String[] args) {
		String e ="100-200*300-500+20";
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
		ArrayList<Long> list = new ArrayList<>();
		for(int i=0; i<list1.size(); i++) list.add(list1.get(i));
		
		Queue<Character> q = new LinkedList<Character>();
		for(int i=0; i<list2.size(); i++) q.add(list2.get(i));
		
		for(int i=0; i<3; i++) {
			char c = save[i];
			int idx=0;
			int size = q.size();
			for(int j=0; j<size; j++) {
				char tc = q.poll();
				if(tc==c) {
					Long a = list.get(idx);
					Long b = list.get(idx+1);
					list.set(idx, cal(a,b,tc));
					list.remove(idx+1);
				}else {
					q.add(tc);
					idx++;
				}
			}
		}
		
		max = Math.max(max, Math.abs(list.get(0)));
	}
	
	private static long cal(Long a, Long b , char c) {
		if(c=='+') return a+b;
		else if(c=='-') return a-b;
		else return a*b;
	}
}
