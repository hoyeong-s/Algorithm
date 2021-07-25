package cs1;

import java.io.*;
import java.util.*;

public class back_1062{
	static int N,K,result,ll;
	static String [] save;
	static boolean [] check = new boolean[26];
	static ArrayList<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		save = new String[N];
		
		if(K<5) {
			System.out.println(0);
			System.exit(0);
		}else if(K==26) {
			System.out.println(N);
			System.exit(0);
		}else {
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				save[i] = str.substring(4,str.length()-4);
				for(int j=0; j<str.length(); j++) {
					int num = str.charAt(j)-'a';
					if(num!=0 && num!=2 && num!=8 && num!=13 && num!=19 && !list.contains(num)) list.add(num);
				}
			}
		}
		ll = list.size();
		
		check[0] = true;
		check[2] = true;
		check[8] = true;
		check[13] = true;
		check[19] = true;
		
		combi(0,0);
		System.out.println(result);
		
	}
	private static void combi(int start, int select) { // 조합 생성
		if(start>= ll || select==K-5) {
			find();
			return;
		}
		
		for(int i=start; i<ll; i++) {
			int num = list.get(i);
			check[num] = true;
			combi(i+1,select+1);
			check[num] = false;
		}
	}
	
	private static void find() {// 글자 비교
		int cnt=0;
		outloop:for(int i=0; i<N; i++) {
			String str = save[i];
			for(int j=0; j<str.length(); j++) {
				char a = str.charAt(j);
				if(!check[a-'a']) continue outloop;
			}
			cnt++;
		}
		
		result = Math.max(result, cnt);
	}
}

/*public class Main {
	static int N,K,result;
	static String [] save;
	static boolean [] check = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		save = new String[N];
		
		if(K<5) {
			System.out.println(0);
			return;
		}else if(K==26) {
			System.out.println(N);
			return;
		}else {
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				save[i] = str.substring(4,str.length()-4);
			}
		}
		
		check[0] = true;
		check[2] = true;
		check[8] = true;
		check[13] = true;
		check[19] = true;
		
		combi(0,0);
		System.out.println(result);
		
	}
	private static void combi(int start, int select) { // 조합 생성
		if(select==K-5) {
			int cnt=0;
		outloop:for(int i=0; i<N; i++) {
			String str = save[i];
			for(int j=0; j<str.length(); j++) {
				int num = str.charAt(j)-'a';
				if(!check[num]) continue outloop;
			}
			cnt++;
		}
		
		result = Math.max(result, cnt);
			return;
		}
		
		for(int i=start; i<26; i++) {
			if (!check[i]) {
				check[i] = true;
				combi(i + 1, select + 1);
				check[i] = false;
			}
		}
	}
	
}*/