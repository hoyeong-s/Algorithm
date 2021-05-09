package kakao_0509_intern;

import java.util.*;
import java.io.*;

public class third {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		int k = 2;
		String [] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		System.out.println(solution(n, k, cmd));
	}
	
	public static String solution(int n, int k, String[] cmd) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++)
        	list.add(i);
        
        for(int i=0; i<cmd.length; i++) {
        	String str = cmd[i];
        	if(str.length()==1) { // C Z 일때
        		if(str.charAt(0)=='C') { // 제거
        			int cur = list.get(k);
        			stack.add(cur);
        			list.remove(k);
        			if(k==list.size()) k--;
        		}
        		else {
        			int cur = stack.pop(); // 가장 최근 제거된 값
        			int idx = Collections.binarySearch(list, cur);
        			idx = -idx-1;
        			if(idx>k) k++;
        			list.add(idx, cur);
        		}
        	}
        	else { //U D 일때
        		int num = Integer.parseInt(str.substring(2,str.length()));
        		if(str.charAt(0)=='U') {
        			k -= num;
        		}
        		else {
        			k += num;
        		}
        	}
        }
        
        for(int i=0; i<n; i++) {
        	if(stack.contains(i)) sb.append("X");
        	else sb.append("O");
        }
        return sb.toString();
    }
}
