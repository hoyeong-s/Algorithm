import java.util.*;

public class 가장_큰_수 {
	static int N;
    static int [] num;
    static String max = "";
	public static void main(String[] args) {
		int [] numbers = {3, 30, 34, 5, 9};
		solution(numbers);
	}
	public static String solution(int[] numbers) {
        N = numbers.length;
        num = numbers;
        
        Arrays.sort(num);
        do{
            make();
        }while(np());
        
        return max;
    }
    private static void make(){
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<N; i++)
            sb.append(num[i]);
        
        if(max.compareTo(sb.toString())<0) max = sb.toString();
        
    }
    
    private static boolean np(){
        int i = N-1;
        while(i>0 && num[i-1] >= num[i]) --i;
        if(i==0) return false;
        
        int j = N-1;
        while(num[i-1] >= num[j]) --j;
        
        swap(i-1,j);
        
        int k = N-1;
        while(i<k)
            swap(i++,k--);
        
        return true;
        
    }
    
    private static void swap(int a, int b){
        int cur = num[a];
        num[a] = num[b];
        num[b] = cur;
    }
}
