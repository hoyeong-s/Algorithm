import java.util.*;

public class 가장_큰_수 {
	public static void main(String[] args) {
		int [] numbers = {3, 30, 34, 5, 9};
		solution(numbers);
	}
	public static String solution(int[] numbers) {
        String answer = "";
        String [] arr = new String[numbers.length];
        
        for(int i=0; i<numbers.length; i++)
        	arr[i] = Integer.toString(numbers[i]);
        	        
        Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2) ;
			}
        });
        
        StringBuilder sb = new StringBuilder();
		
        for(String s : arr)
        	sb.append(s);

        return sb.toString();
    }
}
