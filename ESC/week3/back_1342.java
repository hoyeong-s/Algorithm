package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class back_1342 {
	static int N,result;
	static String str;
	static int [] visited;
	static char [] sCharArr;
	static ArrayList<Character> list = new ArrayList<>();
	static HashSet<String> hash = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str = br.readLine();
		N = str.length();
		sCharArr = str.toCharArray();
		for(int i=0; i<N; i++) list.add(str.charAt(i));
		
		make(0,new boolean[N],"");
		
		char[] alphabet = new char[26];
		for(int i = 0; i < N; i++) {
			alphabet[sCharArr[i] - 'a']++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(alphabet[i] >= 2) {
				result /= factorial(alphabet[i]);
			}
		}
		System.out.println(result);
	}
	private static void make(int cnt, boolean [] visited, String s) {
		if(cnt==N) {
			//hash.add(s);
			result++;
			return;
		}
				
		for(int i=0; i<list.size(); i++) {
			if(cnt==0) {
				visited[i]=true;
				String st = s + list.get(i).toString();
				make(1,visited,st);
				visited[i] = false;
			}
			
			else {
				if(s.charAt(cnt-1)!=list.get(i) && !visited[i]) {
					visited[i] = true;
					String st = s + list.get(i).toString();;
					make(cnt+1,visited,st);
					visited[i] = false;
				}
			}
		}
	}
	private static int factorial(int n) {
        if(n == 1)
            return 1;
        
        return n * factorial(n - 1);
    }
}
