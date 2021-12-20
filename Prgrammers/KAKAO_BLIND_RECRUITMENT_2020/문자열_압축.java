package KAKAO_BLIND_RECRUITMENT_2020;

import java.io.*;
import java.util.*;

public class 문자열_압축 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		solution(s);
	}
	public static int solution(String s) {
        int answer = 987654321;
        
        for(int i=1; i<=s.length()/2+1; i++) {
        	answer = Math.min(find(s,i),answer);
        }
        return answer;
    }
	private static int find(String s, int num) {
		int size = 0;
		
		String [] arr = new String [s.length()/num+1];
		
		int idx = 0; // s의 인덱스
		for(int i=0; i<arr.length; i++) {
			if(idx+num<s.length()) {
				arr[i] = s.substring(idx, idx+num);
				idx+=num;
			}else {
				arr[i] = s.substring(idx, s.length());
				break;
			}
		}
		
		return compare(arr,num);
		
	}
	
	private static int compare(String [] arr,int num) {
		int sum = 0;
		int cnt = 1;
		
		String s = "";
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==null) break;
			if(i<arr.length-1) {
				if(arr[i].equals(arr[i+1])) {
					cnt++;
					continue;
				}else { // 다음것과 같지 않을 때
					if(cnt!=1) sum += (num + Integer.toString(cnt).length());
					else sum += num;
					cnt = 1;
				}
			}
			else { // 마지막
				if(cnt!=1) sum += (num + Integer.toString(cnt).length());
				else sum += arr[i].length();
				cnt = 1;
			}
		}
		
		return sum;
	}
}
