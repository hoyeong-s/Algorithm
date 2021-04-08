package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class back_2503 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int [][] num = new int [N][3];
		int [][] arr = new int [N][2];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			num[i][0] = s/100;
			s = s%100;
			num[i][1] = s/10;
			s = s%10;
			num[i][2] = s;
			
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int result=0;
		int [] save = new int [3];
		outloop:for (int i = 123; i < 1000; i++) {
			int check = 0;
			for (int j = 0; j < N; j++) { // 스트라이크와 볼 판단해줄 for
				int s = i;
				
				for(int k=2; k>=0; k--) { // 숫자 나눠줌
					save[k] = s%10;
					s = s/10;
				}
				if(save[0]==save[1] || save[0]==save[2] || save[1]==save[2]) // 같은 수가 있으면 continue
					continue;
				if(save[0]==0 || save[1]==0 || save[2]==0) continue;
				
				int [] cnt = new int [2]; // 0 스트라이크 1 볼
				
				for(int r=0; r<3; r++) { // save
					for(int c=0; c<3; c++) { // num
						if(num[j][c]==save[r]) {
							if(c==r) cnt[0]++;
							else cnt[1]++;
						}
					}
				}
				
				if(arr[j][0]!=cnt[0] || arr[j][1]!=cnt[1]) continue outloop;
				else check++;
			}
			if(check==N) {
				result++;
			}
		}
		System.out.println(result);
	}
}
