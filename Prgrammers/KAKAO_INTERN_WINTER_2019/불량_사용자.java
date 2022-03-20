package KAKAO_INTERN_WINTER_2019;

import java.util.*;
import java.io.*;

public class 불량_사용자 {
	static Set<List<Integer>> hash = new HashSet<>();
	static LinkedList<Integer> [] list;
	
	public static void main(String[] args) {
		String [] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String [] banned_id = {"fr*d*", "*rodo", "******", "******"};
		solution(user_id, banned_id);
	}
	
	public static int solution(String[] user_id, String[] banned_id) {
		list = new LinkedList[banned_id.length];
		for(int i=0; i<banned_id.length; i++)
			list[i] = new LinkedList<>();
		
		for(int i=0; i<banned_id.length; i++) {
			String b = banned_id[i];
			
			for(int j=0; j<user_id.length; j++) {
				String s = user_id[j];
				if(check(b,s)) list[i].add(j);
			}
		}
	    result(0,new ArrayList<Integer>());
	    
	    return hash.size();
	}
	
	private static boolean check(String s, String b) {
		if(s.length()!=b.length()) return false;
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='*') continue;
			if(s.charAt(i)!=b.charAt(i)) return false;
		}
		return true;
	}
	
	private static void  result(int idx, List<Integer> arr) {
		if(idx >= list.length) {
			List<Integer> carr = new ArrayList<Integer>();
			carr.addAll(arr);
			
			Collections.sort(carr);
			hash.add(carr);
			return;
		}
		
		for(int i=0; i<list[idx].size(); i++) {
			int num = list[idx].get(i);
			if(!checking_num(arr, num)) continue;
			arr.add(num);
			result(idx+1, arr);
			arr.remove(arr.size()-1);
		}
	}
	
	private static boolean checking_num(List<Integer> arr, int num) {
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i)==num) return false;
		}
		
		return true;
	}
}
