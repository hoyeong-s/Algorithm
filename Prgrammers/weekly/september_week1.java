package weekly;
import java.io.*;
import java.util.*;

public class september_week1 {
	public static void main(String[] args) {
		
	}
	public static long solution(int price, int money, int count) {
        long answer = -1;
        
        long sum = 0;
        for(int i=1; i<=count; i++) sum+=i;
        long result = (long)(price * sum);
        
        if(money-result<0) return result-money;
        else return 0;
    }
}
