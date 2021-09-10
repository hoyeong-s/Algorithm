import java.io.*;
import java.util.*;

public class back_16916 {
	static String S,P;
	static int [] Pi;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = br.readLine();
		P = br.readLine();
		Pi = new int [P.length()];
		
		make();
		KMP();
		
	}
	private static void make() {
		int j=0;
		for(int i=1; i<P.length(); i++) {
			while(j>0 && P.charAt(i)!=P.charAt(j)) j = Pi[j-1];
			if(P.charAt(i)==P.charAt(j)) Pi[i] = ++j;
		}
	}
	private static void KMP() {
		int j=0;
		for(int i=0; i<S.length(); i++) {
			while(j>0 && S.charAt(i)!=P.charAt(j)) j = Pi[j-1];
			if(S.charAt(i)==P.charAt(j)) {
				if(j==P.length()-1) {
					System.out.println(1);
					System.exit(0);
				}
				else j++;
			}
		}
	}
}
