package BruteForce;
import java.io.*;
import java.util.*;

public class back_19942 {
	static int N,result=987654321;
	static int [] fin;
	static boolean [] visitedr;
	static int [][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		fin = new int [4];
		visitedr = new boolean[N];
		arr = new int [N][5];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<4; i++)
			fin[i] = Integer.parseInt(st.nextToken());
			
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		diet(0, new int [4], 0, new boolean[N]);
		
		if(result==987654321) System.out.println(-1); // 불가능할때
		else {
			System.out.println(result);
			for(int i=0; i<N; i++) {
				if(visitedr[i]) sb.append(i+1+" ");
			}
			System.out.println(sb);
		}
	}

	private static void diet(int idx, int[] nut, int money, boolean [] visited) {
		if (check(nut)) { // 현재 만족했다면 이후에 오는 경우는 money가 커지는 경우 / 사전순으로 뒤에 오는 경우 이므로 return 
				if(result>money) {
					result = money;
					visitedr = visited.clone();
				}
				else if(result==money) {
					fast(visited);
				}
				return;
			}
			
		if(idx==N) return; // 인덱스가 넘어가면 return
		
		int [] nutc = new int [4];
		for (int i = 0; i < 4; i++)
			nutc[i] = nut[i]+arr[idx][i];
		int moneyc = money+arr[idx][4];
		
		visited[idx] = true;
		diet(idx + 1, nutc, moneyc,visited); // 현재 영양분 추가
		visited[idx] = false;
		diet(idx + 1, nut, money,visited); // 현재 영양분 추가 x
	}

	private static boolean check(int[] nut) { // 최소 영양소를 만족하는지
		for (int i = 0; i < 4; i++) {
			if (nut[i] < fin[i]) {
				return false;
			}
		}
		return true;
	}
	
	private static void fast(boolean [] visited) { // 들어가는 영양소의 개수가 같을 때 사전순으로 오게 만듦
		for(int i=0; i<N; i++) {
				if (visited[i] && !visitedr[i]) {
					visitedr = visited.clone();
					return;
				} else if (!visited[i] && visitedr[i])
					return;
		}
	}
}


