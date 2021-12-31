package KAKAO_INTERN_2020;

import java.io.*;
import java.util.*;

public class 보석_쇼핑 {
	static int min = 987654321;
	static HashMap<String, Integer> map = new HashMap<>();
	static int [] arr,result;
	public static void main(String[] args) {
		String [] gems = {"A", "B", "A", "A", "A", "C", "A", "B"};
		solution(gems);
	}
	public static int[] solution(String[] gems) {
        result = new int [2] ;
        
        int idx=0;
        for(int i=0; i<gems.length; i++) {
        	if(!map.containsKey(gems[i])) map.put(gems[i], idx++);
        }
        
        arr = new int [idx];
        
        find(gems);
        
        return result;
    }
	
	private static void find(String [] gems) {
		int j=-1;
		for(int i=0; i<gems.length; i++) {
			if(check() && min>j-i) {
				min = j-i;
				result[0] = i+1;
				result[1] = j+1;
			}
			while(!check() && j<gems.length-1) {
				arr[map.get(gems[++j])]++;
				if(check() && min>j-i) {
					min = j-i;
					result[0] = i+1;
					result[1] = j+1;
				}
			}
			arr[map.get(gems[i])]--;
		}
	}
	
	private static boolean check() {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) return false;
		}
		return true;
	}
}
