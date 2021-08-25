import java.io.*;
import java.util.*;

public class programmers_week4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] table = {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++",
				"HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", 
				"GAME C++ C# JAVASCRIPT C JAVA"};
		
		String [] languages = {"JAVA", "JAVASCRIPT"};
		int [] preference = {7,5};
		System.out.println(solution(table,languages,preference));
	}

	public static String solution(String[] table, String[] languages, int[] preference) {
		String answer = "";
		
		StringTokenizer st;
		String [][] map = new String[6][5];
		int [] cnt = new int [5];
		
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(table[i]);
			for(int j=0; j<6; j++) {
				String str = st.nextToken();
				map[j][i] = str;
				
				int lng = languages.length;
				for(int k=0; k<lng; k++) {
					if(str.equals(languages[k])) {
						cnt[i]+=preference[k]*(6-j);
					}
				}
			}
		}
		
		int max = 0;
		for(int i=0; i<5; i++) {
			if(cnt[i]>max) {
				max = cnt[i];
				answer = map[0][i];
			}
			else if(cnt[i]==max) {
				if(answer.equals("")) answer = map[0][i];
				else {
					if(answer.charAt(0) > map[0][i].charAt(0)) answer = map[0][i];
				}
			}
		}
		
		return answer;
	}
}
