package weekly;
import java.io.*;
import java.util.*;

public class september_week5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution("AAAAE");
	}
	public static int solution(String word) {
		ArrayList<String> list = new ArrayList<>();
		HashMap<Integer, String> map = new HashMap<>();
		map.put(0, "A");
		map.put(1, "E");
		map.put(2, "I");
		map.put(3, "O");
		map.put(4, "U");
		map.put(5, "");
		HashSet<String> set = new HashSet<>();
		
		for(int a=0; a<5; a++) {
			String A = map.get(a);
			for(int b=0; b<6; b++) {
				String B = A+map.get(b);
				for(int c=0; c<6; c++) {
					String C = B+map.get(c);
					for(int d=0; d<6; d++) {
						String D = C+map.get(d);
						for(int e=0; e<6; e++) {
							String E = D+map.get(e);
							set.add(E);
						}
					}
				}
			}
		}
		
		for(String s : set) list.add(s);
        Collections.sort(list);
        
        return list.indexOf(word);
    }
	
}
