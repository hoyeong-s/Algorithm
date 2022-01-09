package KAKAO_BLIND_RECRUITMENT_2019;

import java.io.*;
import java.util.*;

public class 후보키 {
	static int row,col,max;
	static String [][] r;
	static ArrayList<String> list = new ArrayList<>();
	
	public static void main(String[] args) {
		String [][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
		solution(relation);
	}
	public static int solution(String[][] relation) {
        int result = 0;
        
        row = relation.length;
        col = relation[0].length;
        
        r = relation;
        
        find();
        
        dfs(0,new ArrayList<String>());
        
        return max;
    }
	
	private static void find() {
		for (int i = 1; i < (1<<col); i++) {
			StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                if ((i & 1 << j) != 0) {
                	sb.append(j);
                }
            }
            if(unique(sb.toString()) && minimal(sb.toString(),list)) { // 유일성 만족
            	list.add(sb.toString());
            }
		}
	}
	
	private static boolean unique(String str) { // 유일성 만족
		String [] result = new String [row];
		
		for(int i=0; i<str.length(); i++) {
			int j = str.charAt(i)-'0';
			for(int k=0; k<row; k++) {
				result[k] += r[k][j];
				result[k] += ",";
			}
		}
		
		for(int i=0; i<row-1; i++) {
			for(int j=i+1; j<row; j++) {
				if(result[i].equals(result[j])) return false; 
			}
		}
		return true;
	}
	
	private static boolean minimal(String str, ArrayList<String> list) {
		for(int i=0; i<list.size(); i++) {
			String s = list.get(i);
			int cnt = 0;
			for(int j=0; j<s.length(); j++) {
				if(str.contains(String.valueOf(s.charAt(j)))) cnt++;
			}
			if(s.length() == cnt) return false;
		}
		return true;
	}
	
	private static void dfs(int idx, ArrayList<String> clist) {
		if(idx==list.size()) {
			max = Math.max(max, clist.size());
			return;
		}
		
		dfs(idx+1, clist); // 선택하지 않고 그냥
		
		if(minimal(list.get(idx),clist)) { // 선택해서 가기
			clist.add(list.get(idx));
			dfs(idx+1, clist);
			clist.remove(clist.size()-1);
		}
	}
}
